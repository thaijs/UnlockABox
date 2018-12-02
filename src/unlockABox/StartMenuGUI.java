package unlockABox;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

/**
 * Final Project: Unlock A Box Game
 * @author Tyler Smith
 * @author Brad Rohbock
 *CS 1410
 */
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
		createFrame();

		createMenu();

		createLogoPanel();

		createButtons();
	}

	/**
	 * Creates panel for buttons
	 * Creates New Game button with functionality
	 * Creates Load Game button with functionality
	 * Creates Help button with functionality
	 */
	private void createButtons()
	{
		JPanel pnlStartButtons = new JPanel();
		contentPane.add(pnlStartButtons, BorderLayout.SOUTH);
		pnlStartButtons.setLayout(new GridLayout(3, 1, 0, 0));

		JButton btnNewGame = new JButton("New Game");
		//Directs to New Game on button click
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
				 * setVisible without object name (newGame.setVisible...) will use Class
				 * (StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of StartMenuGUI
				 */
				setVisible(false);
				dispose();
			}
		});
		pnlStartButtons.add(btnNewGame);
		btnNewGame.setFocusable(false);

		JButton btnLoadGame = new JButton("Load Game");
		//Directs to Load Game on button click
		btnLoadGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/**
				 * Create an instance of loadGame, this allows the LoadGameGUI to pop up when load
				 * is selected in the start menu
				 */
				LoadGameGUI loadGame = new LoadGameGUI();
				loadGame.setVisible(true);

				/**
				 * setVisible without object name (ie newGame.setVisible...) will use Class
				 * (ie StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of StartMenuGUI
				 */
				setVisible(false);
				dispose();
			}
		});
		pnlStartButtons.add(btnLoadGame);
		btnLoadGame.setFocusable(false);

		JButton btnHelp = new JButton("Help");
		//Wrote instructions for start menu HELP button
		Help help = new Help("Directions", "Unlock A Box is a game of brain teasers and logic puzzles.\r\n" + "\r\n"
				+ "Creating a New Game!\r\n" + "Create a new game by selecting New Game\r\n"
				+ "Choose a difficulty level with the dropdown menu\r\n" + "Input your username\r\n" + "Click Play\r\n"
				+ "\r\n" + "Loading a Saved Game!\r\n" + "Load a new game by selecting Load Game\r\n"
				+ "Select your saved game by your Username\r\n" + "Click Load\r\n" + "\r\n" + "In Game!\r\n"
				+ "You will be presented with a challenge that includes a puzzle that needs to be solved\r\n"
				+ "Once you have solved all three challenges the level will be complete");
		//Allows button to show HELP menu
		btnHelp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				help.setVisible(true);
			}
		});
		btnHelp.setFocusable(false);
		help.setBounds(100, 100, 650, 600);
		pnlStartButtons.add(btnHelp);
	}

	/**
	 * Creates panel for logo
	 * Input logo into program
	 */
	private void createLogoPanel()
	{
		JPanel pnlStartMenu = new JPanel();
		contentPane.add(pnlStartMenu, BorderLayout.CENTER);
		pnlStartMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(StartMenuGUI.class.getResource("/images/UnlockABoxLogo.png")));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pnlStartMenu.add(lblTitle);
	}

	/**
	 * Creates the Menu for GUI
	 * Creates functional Menu Items
	 */
	private void createMenu()
	{
		// Start Menu Items
		JPanel pnlMenu = new JPanel();
		contentPane.add(pnlMenu, BorderLayout.NORTH);

		JMenuBar menuBar = new JMenuBar();
		pnlMenu.add(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmExit = new JMenuItem("Exit");
		//Allows user to close entire program
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		mnMenu.add(mntmExit);
	}

	/**
	 * Creates the frame for the GUI
	 */
	private void createFrame()
	{
		setTitle("Unlock A Box - Start Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}
