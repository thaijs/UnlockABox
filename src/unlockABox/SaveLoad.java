package unlockABox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SaveLoad
{
	private ArrayList<Challenge> easy;
	private ArrayList<Challenge> med;
	private ArrayList<Challenge> hard;
	private List<Challenge> allOfThem;
	
	public SaveLoad(ArrayList<Challenge> easy, ArrayList<Challenge> med, ArrayList<Challenge> hard) 
	{
		this.easy = easy;
		this.med = med;
		this.hard = hard;
		this.allOfThem = new ArrayList<Challenge>();
		
		allOfThem.addAll(easy);
		allOfThem.addAll(med);
		allOfThem.addAll(hard);
	}
	
	public boolean printNameToFile(String fileLocation, String loadName)
	{
		boolean confirmFlag = false;
		
		try (PrintWriter writer = new PrintWriter(fileLocation))
		{
			for (Challenge el: allOfThem)
			{
				if (el.getAnswerFlag() == true)
				{
					writer.println(el.getName());
				}
				el.getName();
			}		
			confirmFlag = true;
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return confirmFlag;
	}
}
