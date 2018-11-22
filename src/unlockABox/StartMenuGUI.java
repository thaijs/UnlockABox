package unlockABox;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartMenuGUI extends JFrame
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
					StartMenuGUI frame = new StartMenuGUI();
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
	public StartMenuGUI()
	{
		setTitle("Unlock A Box");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Start Menu Items
		JPanel pnlMenu = new JPanel();
		contentPane.add(pnlMenu, BorderLayout.NORTH);

		JMenuBar menuBar = new JMenuBar();
		pnlMenu.add(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnMenu.add(mntmExit);

		JPanel pnlStartMenu = new JPanel();
		contentPane.add(pnlStartMenu, BorderLayout.CENTER);
		pnlStartMenu.setLayout(new GridLayout(5, 0, 0, 0));

		JLabel lblTitle = new JLabel("Unlock A Box");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pnlStartMenu.add(lblTitle);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFocusable(false);
		pnlStartMenu.add(btnNewGame);

		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setFocusable(false);
		pnlStartMenu.add(btnLoadGame);
		
		JButton btnHelp = new JButton("Help");
		
		Help help = new Help("Directions", 
				"Unlock A Box is a game of brain teasers and logic puzzles.\r\n" + 
				"\r\n" + 
				"Creating a New Game!\r\n" + 
				"Create a new game by selecting New Game\r\n" + 
				"Choose a difficulty level with the dropdown menu\r\n" + 
				"Input your username\r\n" + 
				"Click Play\r\n" + 
				"\r\n" + 
				"Loading a Saved Game!\r\n" + 
				"Load a new game by selecting Load Game\r\n" + 
				"Select your saved game by your Username\r\n" + 
				"Click Load\r\n" + 
				"\r\n" + 
				"In Game!\r\n" + 
				"You will be presented with a challenge that includes a puzzle that needs to be solved\r\n" + 
				"Once you have solved all three challenges the level will be complete");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				help.setVisible(true);
			}
		});
		btnHelp.setFocusable(false);
		pnlStartMenu.add(btnHelp);		
		
		btnNewGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/**
				 * Create an instance of newGame, this allows the NewGameGUI to pop up when new
				 * is selected in the start menu
				 */
				NewGameGUI newGame = new NewGameGUI();
				newGame.setVisible(true);
				
				/**
				 * setVisible without object name (newGame.setVisible...) will use Class (StartMenuGUI.java) that the command was coded in
				 * dispose() will free up memory in program by removing the instantiation of StartMenuGUI
				 */
				setVisible(false);
				dispose();				
			}
		});

	}
}
