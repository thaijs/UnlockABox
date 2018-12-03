package unlockABox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

/**
 * Final Project: Unlock A Box Game
 * @author Tyler Smith
 * @author Brad Rohbock
 *CS 1410
 */
public class SelectedLevelGUI extends JFrame
{
	static int switchVariable;
	static String challengeButton1;
	static String challengeButton2;
	static String challengeButton3;
	static int challengeSelected;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					SelectedLevelGUI frame = new SelectedLevelGUI();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectedLevelGUI() {
		setTitle("Unlock A Box - Selected Level");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlMenu = new JPanel();
		contentPane.add(pnlMenu, BorderLayout.NORTH);

		JMenuBar menuBar = new JMenuBar();
		pnlMenu.add(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		//saves the game
		JMenuItem mntmSaveGame = new JMenuItem("Save Game");
		mntmSaveGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SaveLoad sl = new SaveLoad(Main.easyChallenges, Main.mediumChallenges, Main.hardChallenges);
				sl.printNameToFile("src/SavedGames/" + , loadName);
			}
		});
		mnMenu.add(mntmSaveGame);

		JMenuItem mntmLoadGame = new JMenuItem("Load Game");
		//Allow to open LoadGameGUI
		mntmLoadGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/**
				 * Create an instance of loadGame, this allows the LoadGameGUI to pop up when new
				 * is selected in the start menu
				 */
				LoadGameGUI loadGame = new LoadGameGUI();
				loadGame.setVisible(true);

				/**
				 * setVisible without object name (ie newGame.setVisible...) will use Class
				 * (ie StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of LevelGUI
				 */
				setVisible(false);
				dispose();
			}
		});
		mnMenu.add(mntmLoadGame);

		JMenuItem mntmBack = new JMenuItem("Back");
		//Selecting Back will go to LevelGUI
		mntmBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LevelGUI lvlFrame = new LevelGUI();
				lvlFrame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		mnMenu.add(mntmBack);

		JMenuItem mntmExit = new JMenuItem("Exit");
		//Allows to close program
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		mnMenu.add(mntmExit);

		JPanel pnlLevelSelected = new JPanel();
		contentPane.add(pnlLevelSelected, BorderLayout.CENTER);

		/*
		 * Switch case to direct user input to correct challenge groups
		 */
		switch (switchVariable)
		{
		case 1:
			challengeButton1 = Main.easyChallenges.get(0).getName();
			challengeButton2 = Main.easyChallenges.get(1).getName();
			challengeButton3 = Main.easyChallenges.get(2).getName();
			break;
		case 2:
			challengeButton1 = Main.mediumChallenges.get(0).getName();
			challengeButton2 = Main.mediumChallenges.get(1).getName();
			challengeButton3 = Main.mediumChallenges.get(2).getName();
			break;
		case 3:
			challengeButton1 = Main.hardChallenges.get(0).getName();
			challengeButton2 = Main.hardChallenges.get(1).getName();
			challengeButton3 = Main.hardChallenges.get(2).getName();
			break;
		}

		String name = "";
		pnlLevelSelected.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 200));
		JButton btnChallenge1 = new JButton(challengeButton1);
		pnlLevelSelected.add(btnChallenge1);
		btnChallenge1.setFocusable(false);
		
				JButton btnChallenge2 = new JButton(challengeButton2);
				pnlLevelSelected.add(btnChallenge2);
				btnChallenge2.setFocusable(false);
				
						JButton btnChallenge3 = new JButton(challengeButton3);
						pnlLevelSelected.add(btnChallenge3);
						btnChallenge3.setFocusable(false);
						btnChallenge3.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								challengeSelected = 2;
								/**
								 * Create an instance of challenge, this allows the ChallengeGUI to pop up when
								 * new is selected in the start menu
								 */
								ChallengeGUI challenge = new ChallengeGUI();
								challenge.setVisible(true);

								/**
								 * setVisible without object name (ie newGame.setVisible...) will use Class
								 * (ie StartMenuGUI.java) that the command was coded in dispose() will free up
								 * memory in program by removing the instantiation of LevelGUI
								 */
								setVisible(false);
								dispose();
							}
						});
				btnChallenge2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						challengeSelected = 1;
						/**
						 * Create an instance of challenge, this allows the ChallengeGUI to pop up when
						 * new is selected in the start menu
						 */
						ChallengeGUI challenge = new ChallengeGUI();
						challenge.setVisible(true);

						/**
						 * setVisible without object name (ie newGame.setVisible...) will use Class
						 * (ie StartMenuGUI.java) that the command was coded in dispose() will free up
						 * memory in program by removing the instantiation of LevelGUI
						 */
						setVisible(false);
						dispose();
					}
				});

		/*
		 * Button Challenge 1 creates an instance of ChallengeGUI allowing the GUI to
		 * pop up
		 */
		btnChallenge1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				challengeSelected = 0;
				/**
				 * Create an instance of challenge, this allows the ChallengeGUI to pop up when
				 * new is selected in the start menu
				 */
				ChallengeGUI challenge = new ChallengeGUI();
				challenge.setVisible(true);

				/**
				 * setVisible without object name (ie newGame.setVisible...) will use Class
				 * (ie StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of LevelGUI
				 */
				setVisible(false);
				dispose();
			}
		});
		
		/*
		 * Button Challenge 2 creates an instance of ChallengeGUI allowing the GUI to
		 * pop up
		 */
		
		/*
		 * Button Challenge 3 creates an instance of ChallengeGUI allowing the GUI to
		 * pop up
		 */
	}
}


//CODE THAT WILL BE LOOKED AT IN LATER VERSIONS

//// somehow get the challenge name and input into this label
//JLabel lblLevelSelected = new JLabel("Level that was selected");
//lblLevelSelected.setHorizontalAlignment(SwingConstants.CENTER);
//// Needs to get which level was selected (1,2,3,4...)
//pnlLevelSelected.add(lblLevelSelected);
