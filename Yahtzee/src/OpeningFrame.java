import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game_frame.GameFrame;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpeningFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpeningFrame frame = new OpeningFrame();
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
	public OpeningFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setTitle("Yahtzee");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Play Yahtzee");
		lblNewLabel.setFocusable(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(73, 27, 283, 67);
		contentPane.add(lblNewLabel);

		JButton btnSingle = new JButton("Single Player");
		btnSingle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSingle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GameFrame(1);
				dispose();
			}
		});
		btnSingle.setBounds(10, 144, 170, 58);
		contentPane.add(btnSingle);

		JButton btnMulti = new JButton("Multi Player");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameFrame(2);
				dispose();
			}
		});
		btnMulti.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMulti.setBounds(253, 144, 181, 58);
		contentPane.add(btnMulti);

		//
		setLocationRelativeTo(null);
	}
}
