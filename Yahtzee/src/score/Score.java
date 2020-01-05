package score;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Score extends JLabel {

	private int score;
	public boolean scoreConfirmed;

	public Score() {

		scoreConfirmed = false;
		setForeground(Color.red);
		setFont(new Font("Consolas", Font.PLAIN, 18));
		setPreferredSize(new Dimension(110, 22));
		setOpaque(true);
		setBackground(Color.WHITE);
		setText(null);

	}

	public void setScore(int score) {

		this.score = score;
		this.setText("    " + this.score + "    ");

	}

	public int getScore() {

		return score;

	}

	public void resetScore() {

		this.score = 0;
		this.setText(null);

	}

	public void yahtzeeBonusScore() {

		this.score = score + 100;
		this.setText("    " + this.score + "    ");

	}

}
