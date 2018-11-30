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
	// maybe create a list for each difficulty that includes the 3 challenges
	// would we use LinkedList or ArrayList?
	static ArrayList<Challenge> easyChallenges = new ArrayList<>();
	static ArrayList<Challenge> mediumChallenges = new ArrayList<>();
	static ArrayList<Challenge> hardChallenges = new ArrayList<>();

	public static void main(String[] args)
	{


		StartMenuGUI startMenu = new StartMenuGUI();
		startMenu.setVisible(true);
		
		
		
		
		
		
		
		
		/* ADDING CHALLENGES */
		
		//creating medium challenges
		Challenge lockPuzzle = new Challenge("Lock", 
				"Can you crack the unlock code for the lock using the 5 clues below?\r\n" +
						"Clue #1: 682 – One number is correct and well placed\r\n" + 
						"    Clue #2: 614 – One number is correct but wrongly placed\r\n" + 
						"    Clue #3: 206 – Two numbers are correct but both are wrongly placed\r\n" + 
						"    Clue #4: 738 – None of the numbers are correct\r\n" + 
						"    Clue #5: 780 – One number is correct but wrongly placed",
						"042",
						false,
						"/images/challengePic.png",
						"Use Clues, we ain't tellin'");

		// creating a medium challenge
		Challenge Lock = new Challenge("Lock",
				"Can you crack the unlock code for the lock using the 5 clues below?\r\n"
						+ "Clue #1: 682 – One number is correct and well placed\r\n"
						+ "    Clue #2: 614 – One number is correct but wrongly placed\r\n"
						+ "    Clue #3: 206 – Two numbers are correct but both are wrongly placed\r\n"
						+ "    Clue #4: 738 – None of the numbers are correct\r\n"
						+ "    Clue #5: 780 – One number is correct but wrongly placed",
				"The code is 042", false, "/images/challengePic.png", "Use Clues, we ain't tellin'");

		Challenge WhatAmI = new Challenge("WhatAmI", "If you have me, you want to share me. If you share me, "
				+ "you haven't got me. What am I?", "secret", false, "image", "Shhhh... I can't tell");
		

		Collections.addAll(mediumChallenges, Lock, WhatAmI);
		
		
		//mediumChallenges.get(0).setAnswerFlag(true);

		StartMenuGUI startMenu = new StartMenuGUI();
		startMenu.setVisible(true);

		//creating easy challenge
		Challenge heavierChallenge = new Challenge("Heavier", "Which is heavier: 1 lb of Feathers or 1 lb of Rocks?",
				"neither", false, "image", "Think of how much each item weighs");
		
		Challenge PastPresentFuture = new Challenge("PastPresentFuture", "You will always find me in the past. "
				+ "I can be created in the present, But the future can never taint me. What am I?", "history",
				false,  "image", "Related to Elementary School");
				
		//Hard Challenge
				Challenge Teapot = new Challenge("3Ts", "What begins with T, ends with T and has T in it?\r\n",	"teapot",
						false, "image", "Crumpits anyone?");
				
				Challenge Fire = new Challenge("LiveNDie", "Feed me and I live, yet give me a drink and I die","fire",
						false, "image", "You are getting hotter!");

		//Challenge = new Challenge();

		// this is just adding the challenges we've created to the Lists
		// create a method to do this maybe?
//		Collections.addAll(easyChallenges, heavierChallenge);

		// SERIALIZATION STUFF

		Challenge tPuzzle = new Challenge("T Puzzle",
				"What doesn't belong?",
				"t",
				false,
				"image",
				"Look closely at all objects on screen");
		
		//creating easy challenges
		Challenge heavierChallenge = new Challenge("Heavier", 
				"Which is heavier: 1 lb of Feathers or 1 lb of Rocks?", 
				"neither", 
				false, 
				"image", 
				"Think of how much each item weighs");
		
		Challenge soapRiddle = new Challenge("Covers Your Body",
				"I'm not clothes but I cover your body;\r\n" + 
				"\r\n" + 
				"The more I'm used, the thinner I grow.\r\n" + 
				"\r\n" + 
				"What am I?",
				"bar of soap",
				false,
				"image",
				"What would you use in the shower");		
		
		//creating hard challenges
		Challenge hairRiddle = new Challenge("I Accompy Life",
				"I move very slowly at an imperceptible rate, although I take my time, I am never late. I accompany life, and survive past demise, I am viewed with esteem in many women's eyes.\r\n" + 
				"\r\n" + 
				"What am I?",
				"hair",
				false,
				"image",
				"Synonymous with Style");
				
		//this is just adding the challenges we've created to the Lists
		Collections.addAll(easyChallenges, heavierChallenge, soapRiddle);	
		Collections.addAll(hardChallenges, hairRiddle);
		
		
		//SERIALIZATION STUFF

//		//to get the player name
//		NewGameGUI ng = new NewGameGUI();
//		
//		SerializeDeserialize sd = new SerializeDeserialize(easyChallenges, mediumChallenges, hardChallenges);
//		sd.serialize(mediumChallenges, ng.getTxtBoxName().toString());

	}
}
