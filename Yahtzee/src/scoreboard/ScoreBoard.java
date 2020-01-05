package scoreboard;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class ScoreBoard extends JPanel {

	/**
	 * Create the panel.
	 */
	public ScoreBoard() {

		setPreferredSize(new Dimension(206, 434));

		setBackground(Color.WHITE);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(0, 0, 206, 30);
		add(horizontalBox);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_1.setBounds(0, 28, 206, 30);
		add(horizontalBox_1);

		JLabel lblOnes = new JLabel("Ones");
		horizontalBox_1.add(lblOnes);
		lblOnes.setFont(new Font("Consolas", Font.PLAIN, 18));

		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_2.setBounds(0, 57, 206, 30);
		add(horizontalBox_2);

		JLabel lblTwos = new JLabel("Twos");
		horizontalBox_2.add(lblTwos);
		lblTwos.setFont(new Font("Consolas", Font.PLAIN, 18));

		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_3.setBounds(0, 87, 206, 30);
		add(horizontalBox_3);

		JLabel lblThrees = new JLabel("Threes");
		horizontalBox_3.add(lblThrees);
		lblThrees.setFont(new Font("Consolas", Font.PLAIN, 18));

		Box horizontalBox_4 = Box.createHorizontalBox();
		horizontalBox_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_4.setBounds(0, 116, 206, 30);
		add(horizontalBox_4);

		JLabel lblFours = new JLabel("Fours");
		horizontalBox_4.add(lblFours);
		lblFours.setFont(new Font("Consolas", Font.PLAIN, 18));

		Box horizontalBox_5 = Box.createHorizontalBox();
		horizontalBox_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_5.setBounds(0, 146, 206, 30);
		add(horizontalBox_5);

		JLabel lblFives = new JLabel("Fives");
		horizontalBox_5.add(lblFives);
		lblFives.setFont(new Font("Consolas", Font.PLAIN, 18));

		Box horizontalBox_6 = Box.createHorizontalBox();
		horizontalBox_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_6.setBounds(0, 176, 206, 30);
		add(horizontalBox_6);

		JLabel lblSixes = new JLabel("Sixes");
		horizontalBox_6.add(lblSixes);
		lblSixes.setFont(new Font("Consolas", Font.PLAIN, 18));

		Box horizontalBox_7 = Box.createHorizontalBox();
		horizontalBox_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_7.setBounds(0, 205, 206, 30);
		add(horizontalBox_7);

		JLabel lblThreeOfA = new JLabel("Three Of a Kind");
		lblThreeOfA.setFont(new Font("Consolas", Font.PLAIN, 18));
		horizontalBox_7.add(lblThreeOfA);

		Box horizontalBox_8 = Box.createHorizontalBox();
		horizontalBox_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_8.setBounds(0, 234, 206, 30);
		add(horizontalBox_8);

		JLabel lblFourOfA = new JLabel("Four Of a Kind");
		horizontalBox_8.add(lblFourOfA);
		lblFourOfA.setFont(new Font("Consolas", Font.PLAIN, 18));

		Box horizontalBox_9 = Box.createHorizontalBox();
		horizontalBox_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_9.setBounds(0, 263, 206, 30);
		add(horizontalBox_9);

		JLabel lblSmallStraight = new JLabel("Small Straight");
		lblSmallStraight.setFont(new Font("Consolas", Font.PLAIN, 18));
		horizontalBox_9.add(lblSmallStraight);

		Box horizontalBox_10 = Box.createHorizontalBox();
		horizontalBox_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_10.setBounds(0, 291, 206, 30);
		add(horizontalBox_10);

		JLabel lblLargeStraight = new JLabel("Large Straight");
		horizontalBox_10.add(lblLargeStraight);
		lblLargeStraight.setFont(new Font("Consolas", Font.PLAIN, 18));

		Box horizontalBox_11 = Box.createHorizontalBox();
		horizontalBox_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_11.setBounds(0, 319, 206, 30);
		add(horizontalBox_11);

		JLabel lblFullHouse = new JLabel("Full House");
		lblFullHouse.setFont(new Font("Consolas", Font.PLAIN, 18));
		horizontalBox_11.add(lblFullHouse);

		Box horizontalBox_12 = Box.createHorizontalBox();
		horizontalBox_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_12.setBounds(0, 347, 206, 30);
		add(horizontalBox_12);

		JLabel lblChance = new JLabel("Chance");
		lblChance.setFont(new Font("Consolas", Font.PLAIN, 18));
		horizontalBox_12.add(lblChance);

		Box horizontalBox_13 = Box.createHorizontalBox();
		horizontalBox_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_13.setBounds(0, 375, 206, 30);
		add(horizontalBox_13);

		JLabel lblYahtzee = new JLabel("Yahtzee");
		lblYahtzee.setFont(new Font("Consolas", Font.PLAIN, 18));
		horizontalBox_13.add(lblYahtzee);

		Box horizontalBox_14 = Box.createHorizontalBox();
		horizontalBox_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_14.setBounds(0, 403, 206, 30);
		add(horizontalBox_14);

		JLabel lblTotalScore = new JLabel("TOTAL SCORE");
		lblTotalScore.setFont(new Font("Consolas", Font.PLAIN, 18));
		horizontalBox_14.add(lblTotalScore);

		// System.out.println(lblTotalScore.getPreferredSize());
		// System.out.println(this.getPreferredSize());

	}
}
