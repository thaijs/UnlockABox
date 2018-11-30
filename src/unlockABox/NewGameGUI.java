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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class NewGameGUI extends JFrame
{

	private JPanel contentPane;
	private JTextField txtBoxName;

	public JTextField getTxtBoxName()
	{
		return txtBoxName;
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
	public NewGameGUI()
	{
		setTitle("Unlock A Box - New Game");
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

		JMenuItem mntmLoadGame = new JMenuItem("Load Game");
		mnMenu.add(mntmLoadGame);

//		JMenuItem mntmHelp = new JMenuItem("Help");
//		mnMenu.add(mntmHelp);

		JMenuItem mntmBack = new JMenuItem("Back");
		mnMenu.add(mntmBack);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnMenu.add(mntmExit);
		
		//Select Back and you will go back to the Start Menu
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
		
		JPanel pnlNewGame = new JPanel();
		contentPane.add(pnlNewGame, BorderLayout.CENTER);
		pnlNewGame.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel pnlDifficulty = new JPanel();
		pnlNewGame.add(pnlDifficulty);

		JLabel lblSelectDifficulty = new JLabel("Select Difficulty");
		pnlDifficulty.add(lblSelectDifficulty);

		JComboBox comboBoxDifficulty = new JComboBox();
		comboBoxDifficulty.setModel(new DefaultComboBoxModel(new String[]
		{ "Select One", "Easy", "Medium", "Hard" }));
		pnlDifficulty.add(comboBoxDifficulty);

		JPanel pnlName = new JPanel();
		pnlNewGame.add(pnlName);

		JLabel lblName = new JLabel("Name:");
		pnlName.add(lblName);

		txtBoxName = new JTextField();
		pnlName.add(txtBoxName);
		txtBoxName.setColumns(10);

		JButton btnPlay = new JButton("PLAY");
		btnPlay.setFocusable(false);
		pnlNewGame.add(btnPlay);

		btnPlay.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String name = txtBoxName.getText(); 
				String filename ="src/SavedGames/" + name + ".txt";
				
				/**
				 * So these are placements to input the Main easy med hard arrays because our constructor hates us
				 */
				ArrayList<Challenge> chal = new ArrayList<>();
				chal.addAll(Main.easyChallenges);
				ArrayList<Challenge> chal2 = new ArrayList<>();
				chal2.addAll(Main.mediumChallenges);
				ArrayList<Challenge> chal3 = new ArrayList<>();
				chal3.addAll(Main.hardChallenges);
				
				//using the class to write stuff
				SaveLoad sl = new SaveLoad(chal, chal2, chal3);
				sl.printNameToFile(filename, name);
				
				//input popup saying SAVED UR DANG FILE
				
				/**
				 * Create an instance of newLevel, this allows the LevelGUI to pop up when new
				 * is selected in the start menu
				 */
				LevelGUI newLevel = new LevelGUI();
				newLevel.setVisible(true);

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
