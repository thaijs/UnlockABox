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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadGameGUI extends JFrame
{
	static JPanel pnlGameButtons;
	private JPanel contentPane;
	List<String> challengeList = new ArrayList<String>();

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
		mntmNewGame.addActionListener(new ActionListener()
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
		mnMenu.add(mntmNewGame);

		JMenuItem mntmHelp = new JMenuItem("Help");
		// Creates help menu
		Help help = new Help("Loading a Game", "To load a game click on your Game Name then click Load");
		mntmHelp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				help.setVisible(true);
			}
		});
		mnMenu.add(mntmHelp);

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
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		mnMenu.add(mntmExit);

		JPanel pnlSavedGames = new JPanel();
		contentPane.add(pnlSavedGames, BorderLayout.CENTER);
		pnlSavedGames.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblSavedGames = new JLabel("Saved Games");
		lblSavedGames.setHorizontalAlignment(SwingConstants.CENTER);
		pnlSavedGames.add(lblSavedGames);

		JPanel pnlFiller = new JPanel();
		pnlSavedGames.add(pnlFiller);

		JScrollPane scrollPane = new JScrollPane();
		pnlSavedGames.add(scrollPane);

		pnlGameButtons = new JPanel();
		scrollPane.setViewportView(pnlGameButtons);
		// created buttons, added buttons to arraylist in main
		mergeArrayLists(addGameBtn(pnlGameButtons, Main.gameList), Main.buttonList);
		//added event handlers and returns name of game clicked
		String buttonClickedPath = createEventHandlers(Main.buttonList) + ".txt";
		//read files and merge to array
		readingFileForChallenges("src/SavedGames/" + buttonClickedPath, Main.challengeList);

	}

	/**
	 * Creates a new radio button Takes Name of player and applies to new radio
	 * button saveName should be file path
	 * 
	 * @param panel
	 * @param saveName
	 * @return
	 */
	public static ArrayList<JButton> addGameBtn(JPanel panel, ArrayList<String> saveName)
	{
		ArrayList<JButton> buttons = new ArrayList<>();
		int count = saveName.size();
		pnlGameButtons.setLayout(new GridLayout(count, 0, 0, 0));
		for (String el : saveName)
		{
			JButton button = new JButton(el.substring(0, el.length() - 4));
			button.setFocusable(false);
			pnlGameButtons.add(button);
			buttons.add(button);
		}
		return buttons;
	}

	static String name = "";
	/**
	 * 
	 * @param buttons
	 * @return
	 */
	public static String createEventHandlers(ArrayList<JButton> buttons)
	{
		for (JButton el: buttons)
		{
			el.addActionListener(new ActionListener()
			{
				public  void actionPerformed(ActionEvent e)
				{
					name = el.getText();
				}
			});
		}		
		return name;
	}

	/**
	 * Merges buttons created in addGameBtn method into arraylist to be instantiated
	 * in main method
	 * 
	 * @param input
	 * @param output
	 */
	public static void mergeArrayLists(ArrayList<JButton> input, ArrayList<JButton> output)
	{
		for (JButton el : input)
		{
			output.add(el);
		}
	}
	
	/**
	 * Reads txt files for challenges that are completed
	 * @param filePath
	 * @param challengeList
	 */
	public static void readingFileForChallenges(String filePath, ArrayList<String> challengeList)
	{
		try (Scanner sc = new Scanner(LoadGameGUI.class.getResourceAsStream(filePath)))
		{

			while (sc.hasNextLine())
			{
				challengeList.add(sc.nextLine());
			}
		}
	}
}
