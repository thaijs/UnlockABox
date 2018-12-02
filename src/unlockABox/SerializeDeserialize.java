package unlockABox;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Final Project: Unlock A Box Game
 * @author Tyler Smith
 * @author Brad Rohbock
 *CS 1410
 */
public class SerializeDeserialize
{
	 //to get the player name
	private static NewGameGUI ng = new NewGameGUI();
	private ArrayList<Challenge> easy;
	private ArrayList<Challenge> med;
	private ArrayList<Challenge> hard;
	private List<Challenge> all;
	
	public SerializeDeserialize(ArrayList<Challenge> easy, ArrayList<Challenge> med, ArrayList<Challenge> hard)
	{
		this.easy = easy;
		this.med = med;
		this.hard = hard;
		this.all = new ArrayList<Challenge>();
		
		all.addAll(easy);
		all.addAll(med);
		all.addAll(hard);
	}

	
	public void serialize(List<Challenge> all, String loadName)
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ng.getTxtBoxName())))
		{
			oos.writeObject(all);
			//for testing purposes
			System.out.println("Object Successfully Serialized");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static List<Challenge> deserialize(String loadName)
	{
		List<Challenge> chal = null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ng.getTxtBoxName())))
		{
			chal = (List<Challenge>) ois.readObject();
		} 
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return chal;
	}
}
