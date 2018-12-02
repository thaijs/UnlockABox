package unlockABox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Final Project: Unlock A Box Game
 * @author Tyler Smith
 * @author Brad Rohbock
 *CS 1410
 */
public class Help extends JFrame
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
					Help frame = new Help("", "");
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	// Public variables to be used to create the frame
	String title;
	String infoText;

	/**
	 * Create the frame.
	 */
	public Help(String title, String infoText) 
	{
		createFrame(title, infoText);
	}

	/**
	 * Creates the frame for Help Menu
	 * @param title
	 * @param infoText
	 */
	private void createFrame(String title, String infoText)
	{
		this.title = title;
		this.infoText = infoText;

		setTitle("Help");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblHelpTitle = new JLabel("Help");
		lblHelpTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHelpTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHelpTitle, BorderLayout.NORTH);

		JTextArea textAreaInfoText = new JTextArea();
		textAreaInfoText.setText(infoText);
		textAreaInfoText.setLineWrap(true);
		textAreaInfoText.setWrapStyleWord(true);
		textAreaInfoText.setEditable(false);
		textAreaInfoText.setFont(new Font("Monospaced", Font.BOLD, 20));
		contentPane.add(textAreaInfoText, BorderLayout.CENTER);
	}
}
