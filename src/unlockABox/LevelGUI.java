package unlockABox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;

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
	public LevelGUI() {
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

		JMenuItem mntmSaveGame = new JMenuItem("Save Game");
		mnMenu.add(mntmSaveGame);

		JMenuItem mntmNewGame = new JMenuItem("Load Game");
		mnMenu.add(mntmNewGame);

//		JMenuItem mntmHelp = new JMenuItem("Help");
//		mnMenu.add(mntmHelp);

		JMenuItem mntmEasy = new JMenuItem("Easy Levels");
		mnMenu.add(mntmEasy);

		JMenuItem mntmMedium = new JMenuItem("Medium Levels");
		mnMenu.add(mntmMedium);

		JMenuItem mntmHard = new JMenuItem("Hard Levels");
		mnMenu.add(mntmHard);

		JMenuItem mntmBack = new JMenuItem("Back");
		mnMenu.add(mntmBack);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnMenu.add(mntmExit);

		// Select Back and you will go back to the New Game Menu
		mntmBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				NewGameGUI ngFrame1 = new NewGameGUI();
				ngFrame1.setVisible(true);
				setVisible(false);
				dispose();
			}
		});

		JPanel pnlLevels = new JPanel();
		contentPane.add(pnlLevels, BorderLayout.CENTER);
		pnlLevels.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 170));
		// JLabel lblDifficultyTitle = new JLabel("Selected Difficulty
		// (Easy...Medium...Hard...)");
		// lblDifficultyTitle.setHorizontalAlignment(SwingConstants.CENTER);
		// //This needs to somehow get the selected difficulty from user selection
		// pnlLevels.add(lblDifficultyTitle);

		// JPanel pnlGameLevels = new JPanel();
		// pnlLevels.add(pnlGameLevels);
		// pnlGameLevels.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnEasy = new JButton("Easy");
		pnlLevels.add(btnEasy);
		btnEasy.setPreferredSize(new Dimension(200, 50));
		btnEasy.setFocusable(false);

		JButton btnMedium = new JButton("Medium");
		pnlLevels.add(btnMedium);
		btnMedium.setPreferredSize(new Dimension(200, 50));
		btnMedium.setFocusable(false);
//		btnMedium.setEnabled(false);

		JButton btnHard = new JButton("Hard");
		pnlLevels.add(btnHard);
		btnHard.setPreferredSize(new Dimension(200, 50));
		btnHard.setFocusable(false);
//		btnHard.setEnabled(false);

		/*
		 * Button Easy creates an instance of SelectedLevelGUI allowing the GUI to
		 * pop up
		 */
		btnEasy.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/**
				 * Create an instance of selectedLevel, this allows the SelectedLevelGUI to pop
				 * up when new is selected in the start menu
				 */
				SelectedLevelGUI selectedLevel = new SelectedLevelGUI();
				selectedLevel.setVisible(true);

				/**
				 * setVisible without object name (newGame.setVisible...) will use Class
				 * (StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of StartMenuGUI
				 */
				setVisible(false);
				dispose();
			}
		});
		
		/*
		 * Button Medium creates an instance of SelectedLevelGUI allowing the GUI to
		 * pop up
		 */
		btnMedium.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/**
				 * Create an instance of selectedLevel, this allows the SelectedLevelGUI to pop
				 * up when new is selected in the start menu
				 */
				SelectedLevelGUI selectedLevel = new SelectedLevelGUI();
				selectedLevel.setVisible(true);
//				selectedLevel

				/**
				 * setVisible without object name (newGame.setVisible...) will use Class
				 * (StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of StartMenuGUI
				 */
				setVisible(false);
				dispose();
			}
		});
		
		/*
		 * Button Hard creates an instance of SelectedLevelGUI allowing the GUI to
		 * pop up
		 */
		btnHard.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/**
				 * Create an instance of selectedLevel, this allows the SelectedLevelGUI to pop
				 * up when new is selected in the start menu
				 */
				SelectedLevelGUI selectedLevel = new SelectedLevelGUI();
				selectedLevel.setVisible(true);

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
}

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
