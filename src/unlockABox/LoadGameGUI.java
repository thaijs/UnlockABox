package unlockABox;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class LoadGameGUI extends JFrame
{

	private JPanel contentPane;
	private final static ButtonGroup buttonGroup = new ButtonGroup();

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
					LoadGameGUI frame = new LoadGameGUI();
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
	public LoadGameGUI() {
		setTitle("Unlock A Box - Load Game");
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
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mnMenu.add(mntmNewGame);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnMenu.add(mntmHelp);
		
		JMenuItem mntmBack = new JMenuItem("Back");
		mnMenu.add(mntmBack);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnMenu.add(mntmExit);
		
		JPanel pnlSavedGames = new JPanel();
		contentPane.add(pnlSavedGames, BorderLayout.CENTER);
		pnlSavedGames.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblSavedGames = new JLabel("Saved Games");
		lblSavedGames.setHorizontalAlignment(SwingConstants.CENTER);
		pnlSavedGames.add(lblSavedGames);
		
		JPanel pnlSelectGames = new JPanel();
		pnlSavedGames.add(pnlSelectGames);
		pnlSelectGames.setLayout(new GridLayout(1, 0, 0, 0));
		
		/*
		 * takes in player name?
		 * need to somehow link name from New Game jFrame
		 */
		System.out.println("Type Name: ");
		Scanner sc = new Scanner(System.in);
		String saveName = sc.nextLine();
		
//		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
//		pnlSelectGames.add(rdbtnNewRadioButton);
		
		JScrollPane scrollPane = new JScrollPane(addGameBtn(pnlSelectGames, saveName));	
		pnlSelectGames.add(scrollPane);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setFocusable(false);
		pnlSavedGames.add(btnLoad);
	}

	/**
	 *Creates a new radio button
	 *Takes Name of player and applies to new radio button
	 * @param panel
	 * @param saveName
	 * @return
	 */
	public static Component addGameBtn(JPanel panel, String saveName)
	{
		JRadioButton radioButton = new JRadioButton("Game: " + saveName);
		buttonGroup.add(radioButton);
		return panel.add(radioButton);		
	}
	
}
