package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class BallAppMainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BallAppMainFrame frame = new BallAppMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BallAppMainFrame() {
		initGUI();
	}

	private void initGUI() {
		setTitle("Bouncy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// initializing ball
		Ball ball = new Ball();
		contentPane.add(ball);
		ball.setLayout(null);

	}
}
