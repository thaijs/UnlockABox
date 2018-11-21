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
		
		JMenuItem mntmNewGame = new JMenuItem("Load Game");
		mnMenu.add(mntmNewGame);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnMenu.add(mntmHelp);
		
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
		
		JPanel pnlLevels = new JPanel();
		contentPane.add(pnlLevels, BorderLayout.CENTER);
		pnlLevels.setLayout(new GridLayout(2, 0, 0, 0));
		
		/*
		 * May or may not use this
		 */
//		JLabel lblDifficultyTitle = new JLabel("Selected Difficulty (Easy...Medium...Hard...)");
//		lblDifficultyTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		//This needs to somehow get the selected difficulty from user selection
//		pnlLevels.add(lblDifficultyTitle);
		
		JPanel pnlGameLevels = new JPanel();
		pnlLevels.add(pnlGameLevels);
		pnlGameLevels.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnLvl1 = new JButton("1");
		btnLvl1.setFocusable(false);
		pnlGameLevels.add(btnLvl1);
		
		JButton btnLvl2 = new JButton("2");
		btnLvl2.setFocusable(false);
		pnlGameLevels.add(btnLvl2);
		
		JButton btnLvl3 = new JButton("3");
		btnLvl3.setFocusable(false);
		pnlGameLevels.add(btnLvl3);
		
		JButton btnLvl4 = new JButton("4");
		btnLvl4.setFocusable(false);
		pnlGameLevels.add(btnLvl4);
		
		JButton btnLvl5 = new JButton("5");
		btnLvl5.setFocusable(false);
		pnlGameLevels.add(btnLvl5);
		
		JButton btnLvl6 = new JButton("6");
		btnLvl6.setFocusable(false);
		pnlGameLevels.add(btnLvl6);
		
		JButton btnLvl7 = new JButton("7");
		btnLvl7.setFocusable(false);
		pnlGameLevels.add(btnLvl7);
		
		JButton btnLvl8 = new JButton("8");
		btnLvl8.setFocusable(false);
		pnlGameLevels.add(btnLvl8);
		
		JButton btnLvl9 = new JButton("9");
		btnLvl9.setFocusable(false);
		pnlGameLevels.add(btnLvl9);
		
		
	}

}
