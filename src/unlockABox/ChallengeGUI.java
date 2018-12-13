package unlockABox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


/**
 * Final Project: Unlock A Box Game
 * @author Tyler Smith
 * @author Brad Rohbock 
 * CS 1410
 */
public class ChallengeGUI extends JFrame
{

	private JPanel contentPane;
	private JTextField txtBoxGetUserInput;
	private int arraySelected = SelectedLevelGUI.switchVariable;
	private int indexArray;
	private int indexChallenge = SelectedLevelGUI.challengeSelected;

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
					ChallengeGUI frame = new ChallengeGUI();
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
	public ChallengeGUI() {
		setTitle("Unlock A Box - Challenge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 530);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
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
		// Allows to open LoadGameGUI
		mntmLoadGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/**
				 * Create an instance of newGame, this allows the NewGameGUI to pop up when new
				 * is selected in the start menu

				 * Create an instance of loadGame, this allows the LoadGameGUI to pop up when
				 * new is selected in the start menu
				 */
				LoadGameGUI loadGame = new LoadGameGUI();
				loadGame.setVisible(true);

				/**
				 * setVisible without object name (newGame.setVisible...) will use Class
				 * (StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of StartMenuGUI
				 * setVisible without object name (ie newGame.setVisible...) will use Class (ie
				 * StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of LevelGUI
				 */
				setVisible(false);
				dispose();
			}
		});
		mnMenu.add(mntmLoadGame);

		/**
		 * Switch to go through arrays and use user selected for ChallengeGUI
		 */
		switch (arraySelected)
		{
		case 1:
			indexArray = 0;
			break;
		case 2:
			indexArray = 1;
			break;
		case 3:
			indexArray = 2;
			break;
		}

		// Creates a hint for user
		Help help = new Help("Extra Help",
				((Challenge) Main.challengeArrays.get(indexArray).get(indexChallenge)).getHint());
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				help.setVisible(true);
			}
		});
		mnMenu.add(mntmHelp);

		JMenuItem mntmBack = new JMenuItem("Back");
		// Select Back and you will go back to the Selected Level Menu
		mntmBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SelectedLevelGUI slvlFrame = new SelectedLevelGUI();
				slvlFrame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		mnMenu.add(mntmBack);

		JMenuItem mntmExit = new JMenuItem("Exit");

		// Allows to close program
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		mnMenu.add(mntmExit);

		JPanel pnlAnswer = new JPanel();
		contentPane.add(pnlAnswer, BorderLayout.SOUTH);

		JPanel pnlChallenge = new JPanel();
		contentPane.add(pnlChallenge, BorderLayout.CENTER);
		pnlChallenge.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel pnlInfo = new JPanel();
		pnlChallenge.add(pnlInfo);
		pnlInfo.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnlQuestionDescription = new JPanel();
		pnlInfo.add(pnlQuestionDescription);

		JTextArea textArea = new JTextArea();
		textArea.setText(((Challenge) Main.challengeArrays.get(indexArray).get(indexChallenge)).getDescription());
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setBackground(null);
		pnlQuestionDescription.add(textArea);

		JLabel lblPicture = new JLabel("");
		lblPicture.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPicture.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblPicture.setIcon(new ImageIcon(Challenge.class
				.getResource(((Challenge) Main.challengeArrays.get(indexArray).get(indexChallenge)).getImage())));
//		lblPicture.setText("");
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
		pnlChallenge.add(lblPicture);

		// button action on bottom of code
		JPanel pnlTxtSubmit = new JPanel();
		pnlInfo.add(pnlTxtSubmit);
		txtBoxGetUserInput = new JTextField();
		pnlTxtSubmit.add(txtBoxGetUserInput);

		txtBoxGetUserInput.setActionCommand("");
		txtBoxGetUserInput.setName("");
		txtBoxGetUserInput.setToolTipText("Input Answer");
		txtBoxGetUserInput.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		pnlTxtSubmit.add(btnSubmit);
		btnSubmit.setFocusable(false);

		// answer txtbox action
		JLabel valid = new JLabel();
		pnlTxtSubmit.add(valid);

		JButton btnBack = new JButton("Back");
		btnBack.setEnabled(false);
		pnlTxtSubmit.add(btnBack);

		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// variable that takes in correct Answer
				String answer = ((Challenge) Main.challengeArrays.get(indexArray).get(indexChallenge)).getAnswer();
				boolean flag = true;

				if (txtBoxGetUserInput.getText().equals(answer))
				{
					// changes challenge image to victory image
					lblPicture.setIcon(new ImageIcon(Challenge.class.getResource("/images/sharkThumbsUp.png")));
					valid.setText("Correct");
					btnBack.setEnabled(true);
				} else
				{
					if (flag)
						valid.setText("Incorrect");
//					incorrect.setHorizontalAlignment(0);
					lblPicture.setIcon(new ImageIcon(Challenge.class.getResource("/images/redX.png")));
					flag = false;
					btnBack.setEnabled(true);
				}
			}
		});

		// Back button will return to SelectedLevelGUI when clicked
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				SelectedLevelGUI selectedGUI = new SelectedLevelGUI();
				selectedGUI.setVisible(true);
				/**
				 * setVisible without object name (newGame.setVisible...) will use Class
				 * (StartMenuGUI.java) that the command was coded in dispose() will free up
				 * memory in program by removing the instantiation of StartMenuGUI
				 */
				setVisible(false);
				dispose();
			}
		});

		/**
		 * When user clicks on textbox after inputting data, textbox will clear previous
		 * input Picture will default to original image for the challenge
		 * Incorrect/Correct text will default to no text
		 */
		txtBoxGetUserInput.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				txtBoxGetUserInput.setText("");
				valid.setText("");
				lblPicture.setIcon(new ImageIcon(Challenge.class.getResource(
						((Challenge) Main.challengeArrays.get(indexArray).get(indexChallenge)).getImage())));
				pnlChallenge.add(lblPicture);
			}
		});

	}
}