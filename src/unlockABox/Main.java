package unlockABox;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main
{
	//maybe create a list for each difficulty that includes the 3 challenges
	//would we use LinkedList or ArrayList?
	static List<Challenge> easyChallenges = new ArrayList<>();
	static List<Challenge> mediumChallenges = new ArrayList<>();
	static List<Challenge> hardChallenges = new ArrayList<>();
	
	public static void main(String[] args)
	{
		StartMenuGUI startMenu = new StartMenuGUI();
		startMenu.setVisible(true);
		
		//creating a medium challenge
		Challenge lockChallenge;
		mediumChallenges.add(lockChallenge = new Challenge("Lock", 
				"Can you crack the unlock code for the lock using the 5 clues below?\r\n" +
						"Clue #1: 682 – One number is correct and well placed\r\n" + 
						"    Clue #2: 614 – One number is correct but wrongly placed\r\n" + 
						"    Clue #3: 206 – Two numbers are correct but both are wrongly placed\r\n" + 
						"    Clue #4: 738 – None of the numbers are correct\r\n" + 
						"    Clue #5: 780 – One number is correct but wrongly placed",
						"The code is 042",
						false,
						"/images/challengePic.png",
						"Use Clues, we ain't tellin'"));
		
		//this is just adding the challenges we've created to the Lists
		//create a method to do this maybe?
//		Collections.addAll(easyChallenges, new Challenge("Heavier", 
//				"Which is heavier: 1 lb of Feathers or 1 lb of Rocks?", 
//				"Feathers", 
//				false, 
//				"image", 
//				"Think of how much each item weighs"), 
//				new Challenge());

	}
	//we probably need methods to get information from the challenges

	/**
	 * This will get the challenge difficulty for other jframes to use
	 * Specifically this is for SelectedLevelGUI so that it can display which difficulty was selected
	 * @return
	 */
//	public static String getChalDifficulty()
//	{
//		
//	}
	
	/**
	 * This get's the name for the specified challenge
	 * @param challenges
	 * @return
	 */
	public static String getChalName(List<Challenge> challenges)
	{
		return ((Component) challenges).getName();
	}
	
	/**
	 * This is allowing us to get the easy challenges list
	 * @return
	 */
	public static List<Challenge> getEasyChallenge()
	{
		return easyChallenges;
	}
}
