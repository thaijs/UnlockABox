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

public class SelectedLevelGUI extends JFrame
{
	static int switchVariable;
	static String challengeButton1;
	static String challengeButton2;
	static String challengeButton3;

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

		JMenuItem mntmSaveGame = new JMenuItem("Save Game");
		mnMenu.add(mntmSaveGame);

		JMenuItem mntmLoadGame = new JMenuItem("Load Game");
		mntmLoadGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/**
				 * Create an instance of newGame, this allows the NewGameGUI to pop up when new
				 * is selected in the start menu
				 */
				LoadGameGUI loadGame = new LoadGameGUI();
				loadGame.setVisible(true);

				/**
				 * setVisible without object name (newGame.setVisible...) will use Class
				 * (StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of StartMenuGUI
				 */
				setVisible(false);
				dispose();
			}
		});
		mnMenu.add(mntmLoadGame);

		JMenuItem mntmBack = new JMenuItem("Back");
		// Select Back and you will go back to the Level Menu
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
		mnMenu.add(mntmExit);

		JPanel pnlLevelSelected = new JPanel();
		contentPane.add(pnlLevelSelected, BorderLayout.CENTER);
		pnlLevelSelected.setLayout(new GridLayout(2, 0, 0, 0));

		// somehow get the challenge name and input into this label
		JLabel lblLevelSelected = new JLabel("Level that was selected");
		lblLevelSelected.setHorizontalAlignment(SwingConstants.CENTER);
		// Needs to get which level was selected (1,2,3,4...)
		pnlLevelSelected.add(lblLevelSelected);

		JPanel pnlChallenges = new JPanel();
		pnlLevelSelected.add(pnlChallenges);

		/*
		 * For final project, need to make these buttons images with label on top Need
		 * to get Main class to input for btn's
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
		JButton btnChallenge1 = new JButton(challengeButton1);
		btnChallenge1.setFocusable(false);
		pnlChallenges.add(btnChallenge1);

		JButton btnChallenge2 = new JButton(challengeButton2);
		btnChallenge2.setFocusable(false);
		pnlChallenges.add(btnChallenge2);

		JButton btnChallenge3 = new JButton(challengeButton3);
		btnChallenge3.setFocusable(false);
		pnlChallenges.add(btnChallenge3);

		/*
		 * Button Challenge 1 creates an instance of ChallengeGUI allowing the GUI to
		 * pop up
		 */
		btnChallenge1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				/**
				 * Create an instance of challenge, this allows the ChallengeGUI to pop up when
				 * new is selected in the start menu
				 */
				ChallengeGUI challenge = new ChallengeGUI();
				challenge.setVisible(true);

				/**
				 * setVisible without object name (newGame.setVisible...) will use Class
				 * (StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of StartMenuGUI
				 */
				setVisible(false);
				dispose();
			}
		});
	}

	/**
	 * Allows Main class to hard code name for challenge
	 * 
	 * @param name
	 * @return
	 */
	public String nameForChallenge(String name)
	{
		return name;
	}

}
