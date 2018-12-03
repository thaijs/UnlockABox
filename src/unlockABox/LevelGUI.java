package unlockABox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Dimension;

/**
 * Final Project: Unlock A Box Game
 * @author Tyler Smith
 * @author Brad Rohbock
 *CS 1410
 */
public class LevelGUI extends JFrame
{

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
					LevelGUI frame = new LevelGUI();
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
	public LevelGUI()
	{
		setTitle("Unlock A Box - Level");
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
		//Allows to open LoadGameGUI
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
		// Selecting Back will go to StartMenuGUI
		mntmBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				StartMenuGUI smFrame1 = new StartMenuGUI();
				smFrame1.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		mnMenu.add(mntmBack);

		JMenuItem mntmExit = new JMenuItem("Exit");
		//Allows to close the program
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		mnMenu.add(mntmExit);

		JPanel pnlLevels = new JPanel();
		contentPane.add(pnlLevels, BorderLayout.CENTER);
		pnlLevels.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 170));

		JButton btnEasy = new JButton("Easy");
		/*
		 * Button Easy creates an instance of SelectedLevelGUI allowing the GUI to pop
		 * up
		 */
		btnEasy.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/**
				 * Create an instance of selectedLevel, this allows the SelectedLevelGUI to pop
				 * up when new is selected in the start menu
				 */
				//Update button SwitchVariable in SelectedLevelGUI that controls switch statement for button names
				SelectedLevelGUI.switchVariable = 1;
				SelectedLevelGUI selectedLevel = new SelectedLevelGUI();
				selectedLevel.setVisible(true);

				/**
				 * setVisible without object name (ie newGame.setVisible...) will use Class
				 * (ie StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of LevelGUI
				 */
				setVisible(false);
				dispose();
			}
		});
		pnlLevels.add(btnEasy);
		btnEasy.setPreferredSize(new Dimension(200, 50));
		btnEasy.setFocusable(false);

		JButton btnMedium = new JButton("Medium");
		/*
		 * Button Medium creates an instance of SelectedLevelGUI allowing the GUI to pop
		 * up
		 */
		btnMedium.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				/**
				 * Create an instance of selectedLevel, this allows the SelectedLevelGUI to pop
				 * up when new is selected in the start menu
				 */
				
				//Update button SwitchVariable in SelectedLevelGUI that controls switch statement for button names
				SelectedLevelGUI.switchVariable = 2;
				SelectedLevelGUI selectedLevel = new SelectedLevelGUI();
				selectedLevel.setVisible(true);			

				/**
				 * setVisible without object name (ie newGame.setVisible...) will use Class
				 * (ie StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of LevelGUI
				 */
				setVisible(false);
				dispose();

			}
		});
		pnlLevels.add(btnMedium);
		btnMedium.setPreferredSize(new Dimension(200, 50));
		btnMedium.setFocusable(false);

		JButton btnHard = new JButton("Hard");
		/*
		 * Button Hard creates an instance of SelectedLevelGUI allowing the GUI to pop
		 * up
		 */
		btnHard.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/**
				 * Create an instance of selectedLevel, this allows the SelectedLevelGUI to pop
				 * up when new is selected in the start menu
				 */
				//Update button SwitchVariable in SelectedLevelGUI that controls switch statement for button names
				SelectedLevelGUI.switchVariable = 3;
				SelectedLevelGUI selectedLevel = new SelectedLevelGUI();
				selectedLevel.setVisible(true);

				/**
				 * setVisible without object name (ie newGame.setVisible...) will use Class
				 * (ie StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of LevelGUI
				 */
				setVisible(false);
				dispose();
			}
		});
		pnlLevels.add(btnHard);
		btnHard.setPreferredSize(new Dimension(200, 50));
		btnHard.setFocusable(false);
	}
}

//CODE THAT WILL BE LOOKED AT IN LATER VERSIONS

//these are for when we put levels inside of difficulties
//JButton btnLvl4 = new JButton("4");
//btnLvl4.setFocusable(false);
//btnLvl4.setEnabled(false);
//pnlGameLevels.add(btnLvl4);
//
//JButton btnLvl5 = new JButton("5");
//btnLvl5.setFocusable(false);
//btnLvl5.setEnabled(false);
//pnlGameLevels.add(btnLvl5);
//
//JButton btnLvl6 = new JButton("6");
//btnLvl6.setFocusable(false);
//btnLvl6.setEnabled(false);
//pnlGameLevels.add(btnLvl6);
//
//JButton btnLvl7 = new JButton("7");
//btnLvl7.setFocusable(false);
//btnLvl7.setEnabled(false);
//pnlGameLevels.add(btnLvl7);
//
//JButton btnLvl8 = new JButton("8");
//btnLvl8.setFocusable(false);
//btnLvl8.setEnabled(false);
//pnlGameLevels.add(btnLvl8);
//
//JButton btnLvl9 = new JButton("9");
//btnLvl9.setFocusable(false);
//btnLvl9.setEnabled(false);
//pnlGameLevels.add(btnLvl9);

//LABELS WHAT DIFFICULTY WHEN WE ADD MORE LEVELS
// JLabel lblDifficultyTitle = new JLabel("Selected Difficulty
// (Easy...Medium...Hard...)");
// lblDifficultyTitle.setHorizontalAlignment(SwingConstants.CENTER);
// //This needs to somehow get the selected difficulty from user selection
// pnlLevels.add(lblDifficultyTitle);

// JPanel pnlGameLevels = new JPanel();
// pnlLevels.add(pnlGameLevels);
// pnlGameLevels.setLayout(new GridLayout(0, 3, 0, 0));

//MENU ITEMS
//JMenuItem mntmEasy = new JMenuItem("Easy Levels");
//mnMenu.add(mntmEasy);
//
//JMenuItem mntmMedium = new JMenuItem("Medium Levels");
//mnMenu.add(mntmMedium);
//
//JMenuItem mntmHard = new JMenuItem("Hard Levels");
//mnMenu.add(mntmHard);
