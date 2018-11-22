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

public class ChallengeGUI extends JFrame
{

	private JPanel contentPane;
	private JTextField txtBoxGetUserInput;

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
		/**
		 * Hardcoding challenge object for testing until we figure out
		 */
		Challenge lock = new Challenge("Lock", 
				"Can you crack the unlock code for the lock using the 5 clues below?\r\n" +
				"Clue #1: 682 – One number is correct and well placed\r\n" + 
				"Clue #2: 614 – One number is correct but wrongly placed\r\n" + 
				"Clue #3: 206 – Two numbers are correct but both are wrongly placed\r\n" + 
				"Clue #4: 738 – None of the numbers are correct\r\n" + 
				"Clue #5: 780 – One number is correct but wrongly placed",
				"042",
				false,
				"/images/challengePic.png",
				"Use Clues, we ain't tellin'");
		
		setTitle("Unlock A Box");
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
		
		JMenuItem mntmNewGame = new JMenuItem("Save Game");
		mnMenu.add(mntmNewGame);

		JMenuItem mntmLoadGame = new JMenuItem("Load Game");
		mnMenu.add(mntmLoadGame);
		
		Help help = new Help("Extra Help", lock.getHint());
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				help.setVisible(true);
			}
		});
		mnMenu.add(mntmHelp);
		
		JMenuItem mntmBack = new JMenuItem("Back");
		mnMenu.add(mntmBack);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnMenu.add(mntmExit);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel pnlAnswer = new JPanel();
		contentPane.add(pnlAnswer, BorderLayout.SOUTH);
		
		/*
		 * These will be hardcoded and changed according to the challenge
		 */
		
		JPanel pnlChallenge = new JPanel();
		contentPane.add(pnlChallenge, BorderLayout.CENTER);
		pnlChallenge.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pnlInfo = new JPanel();
		pnlChallenge.add(pnlInfo);
		pnlInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnlQuestionDescription = new JPanel();
		pnlInfo.add(pnlQuestionDescription);
			
		JTextArea textArea = new JTextArea();
		textArea.setText(lock.getDescription());
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		pnlQuestionDescription.add(textArea);

		JLabel lblPicture = new JLabel("");
		lblPicture.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPicture.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblPicture.setIcon(new ImageIcon(Challenge.class.getResource(lock.getImage())));
		lblPicture.setText("where we got this image");
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
		pnlChallenge.add(lblPicture);
		
		//button action on bottom of code
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
		
		//answer txtbox action
		JLabel valid = new JLabel();
		pnlTxtSubmit.add(valid);
		
		JButton btnBack = new JButton("Back");
		btnBack.setEnabled(false);
		pnlTxtSubmit.add(btnBack);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//variable that takes in correct Answer
				String answer = lock.getAnswer();
				boolean flag = true;
				
				
				if (txtBoxGetUserInput.getText().equals(answer))
				{
					//changes challenge image to victory image				
					lblPicture.setIcon(new ImageIcon(Challenge.class.getResource("/images/sharkThumbsUp.png")));
					valid.setText("Correct");
					btnBack.setEnabled(true);
				}
				else
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
		
		//Back button will return to SelectedLevelGUI when clicked
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SelectedLevelGUI selectedGUI = new SelectedLevelGUI();
				selectedGUI.setVisible(true);
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