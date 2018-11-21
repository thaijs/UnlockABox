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
		
		JMenuItem mntmHelp = new JMenuItem("Help");
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
		txtBoxGetUserInput = new JTextField();
		txtBoxGetUserInput.setActionCommand("");
		txtBoxGetUserInput.setName("");
		txtBoxGetUserInput.setToolTipText("Input Answer");
		pnlAnswer.add(txtBoxGetUserInput);
		txtBoxGetUserInput.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFocusable(false);
		pnlAnswer.add(btnSubmit);
		
		JPanel pnlChallenge = new JPanel();
		contentPane.add(pnlChallenge, BorderLayout.CENTER);
		pnlChallenge.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblQuestion = new JLabel("Question for the challenge");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		//hardcoded
		pnlChallenge.add(lblQuestion);
		
		JLabel lblPicture = new JLabel("Picture for challenge");
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
		//hardcoded
		pnlChallenge.add(lblPicture);
	}

}
