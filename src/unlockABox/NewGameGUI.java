package unlockABox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Final Project: Unlock A Box Game
 * @author Tyler Smith
 * @author Brad Rohbock
 *CS 1410
 */
public class NewGameGUI extends JFrame
{

	private JPanel contentPane;
	private JTextField txtBoxName;
	
	public String getTxtBoxName()
	{
		return txtBoxName.getText();
	}
	
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
					NewGameGUI frame = new NewGameGUI();
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
	public NewGameGUI() {
		createFrame();

		createMenu();

		JPanel pnlNewGame = getGameName();

		playButton(pnlNewGame);
	}

	/**
	 * Creates button to begin new game
	 * @param pnlNewGame
	 */
	private void playButton(JPanel pnlNewGame)
	{
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setFocusable(false);
		btnPlay.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//User can choose not to input name for the game. The game will not save if this happens
				if (txtBoxName.getText().isEmpty())
				{
					LevelGUI level = new LevelGUI();
					level.setVisible(true);
					setVisible(false);
					dispose();
				} 
				else
				{
					String name = txtBoxName.getText();
					String filename = "src/SavedGames/" + name + ".txt";

					/**
					 * So these are placements to input the Main easy med hard arrays because our
					 * constructor hates us
					 */
					ArrayList<Challenge> chal = new ArrayList<>();
					chal.addAll(Main.easyChallenges);
					ArrayList<Challenge> chal2 = new ArrayList<>();
					chal2.addAll(Main.mediumChallenges);
					ArrayList<Challenge> chal3 = new ArrayList<>();
					chal3.addAll(Main.hardChallenges);

					// using the class to write stuff
					SaveLoad sl = new SaveLoad(chal, chal2, chal3);
					sl.printNameToFile(filename, name);

					/**
					 * Create an instance of newLevel, this allows the LevelGUI to pop up when new
					 * is selected in the start menu
					 */
					LevelGUI newLevel = new LevelGUI();
					newLevel.setVisible(true);

					/**
					 * setVisible without object name (ie newGame.setVisible...) will use Class
					 * (ie StartMenuGUI.java) that the command was coded in dispose() will free up
					 * memory in program by removing the instantiation of NewGameGUI
					 */
					setVisible(false);
					dispose();
				}
			}
		});
		pnlNewGame.add(btnPlay);
	}

	/**
	 * Creates txtbox to get user input for game name
	 * @return
	 */
	private JPanel getGameName()
	{
		JPanel pnlNewGame = new JPanel();
		contentPane.add(pnlNewGame, BorderLayout.CENTER);
		pnlNewGame.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel pnlName = new JPanel();
		pnlNewGame.add(pnlName);

		JLabel lblName = new JLabel("Name:");
		pnlName.add(lblName);

		txtBoxName = new JTextField();
		pnlName.add(txtBoxName);
		txtBoxName.setColumns(10);
		return pnlNewGame;
	}

	/**
	 * Creates the Menu for GUI
	 * Creates functional Menu Items
	 */
	private void createMenu()
	{
		JPanel pnlMenu = new JPanel();
		contentPane.add(pnlMenu, BorderLayout.NORTH);

		JMenuBar menuBar = new JMenuBar();
		pnlMenu.add(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmLoadGame = new JMenuItem("Load Game");
		//Directs to LoadGameGUI
		mntmLoadGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/**
				 * Create an instance of loadGame, this allows the LoadGameGUI to pop up when new
				 * is selected in the menu
				 */
				LoadGameGUI loadGame = new LoadGameGUI();
				loadGame.setVisible(true);

				/**
				 * setVisible without object name (ie newGame.setVisible...) will use Class
				 * (ie StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of NewGameGUI
				 */
				setVisible(false);
				dispose();
			}
		});
		mnMenu.add(mntmLoadGame);

		JMenuItem mntmBack = new JMenuItem("Back");
		// Select Back and you will go back to the Start Menu
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
	}

	/**
	 * Creates the frame
	 */
	private void createFrame()
	{
		setTitle("Unlock A Box - New Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

//CODE THAT WILL BE LOOKED AT IN LATER VERSIONS

// input popup saying SAVED UR DANG FILE

//THIS IS FOR WHEN WE NEED TO SELECT DIFFICULTY
//JPanel pnlDifficulty = new JPanel();
//pnlNewGame.add(pnlDifficulty);
//
//JLabel lblSelectDifficulty = new JLabel("Select Difficulty");
//pnlDifficulty.add(lblSelectDifficulty);
//
//JComboBox comboBoxDifficulty = new JComboBox();
//comboBoxDifficulty.setModel(new DefaultComboBoxModel(new String[]
//{ "Select One", "Easy", "Medium", "Hard" }));
//pnlDifficulty.add(comboBoxDifficulty);
