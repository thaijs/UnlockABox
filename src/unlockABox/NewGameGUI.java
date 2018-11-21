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
import java.awt.event.ActionEvent;

public class NewGameGUI extends JFrame
{

	private JPanel contentPane;
	private JTextField txtBoxName;

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

		JMenuItem mntmHelp = new JMenuItem("Help");
		mnMenu.add(mntmHelp);

		JMenuItem mntmBack = new JMenuItem("Back");
		mnMenu.add(mntmBack);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnMenu.add(mntmExit);

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
				LevelGUI newLevel = new LevelGUI();
				newLevel.setVisible(true);
			}
		});
	}

}
