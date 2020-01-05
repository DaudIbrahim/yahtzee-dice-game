package player;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import game_frame.GameFrame;
import score.Score;
import selection_panel.DiceRollAndSelection;
import yahtzee_engine.GameEngine;

public class Player extends JPanel implements MouseListener {

	public DiceRollAndSelection playerDiceRollPanel; // Initialize this in Main, refer to Main's DiceRollPanel

	public int numberOfRounds;
	int totalScore;
	private String name;

	Score ones; // 1
	Score twos; // 2
	Score threes; // 3
	Score fours; // 4
	Score fives; // 5
	Score sixes; // 6
	Score threeOfAKind; // 7
	Score fourOfAKind; // 8
	Score smallStraight; // 9
	Score largeStraight; // 10
	Score fullHouse; // 11
	Score chance; // 12
	Score yahtzee; // 13

	JLabel lblName; // 14
	JLabel lblTotalScore; // 15

	Box horizontalBox;
	Box horizontalBox_14;

	int bonus;

	public int[] diceResults;

	public Player(String name) {

		///////// Make sure all you Initialization is done
		// Or else FATALITY
		////////////// Initialization of all the components

		numberOfRounds = 0;
		totalScore = 0;
		this.name = name;

		ones = new Score(); // 1
		ones.addMouseListener(this);

		twos = new Score(); // 2
		twos.addMouseListener(this);

		threes = new Score(); // 3
		threes.addMouseListener(this);

		fours = new Score(); // 4
		fours.addMouseListener(this);

		fives = new Score(); // 5
		fives.addMouseListener(this);

		sixes = new Score(); // 6
		sixes.addMouseListener(this);

		threeOfAKind = new Score(); // 7
		threeOfAKind.addMouseListener(this);

		fourOfAKind = new Score(); // 8
		fourOfAKind.addMouseListener(this);

		smallStraight = new Score(); // 9
		smallStraight.addMouseListener(this);

		largeStraight = new Score(); // 10
		largeStraight.addMouseListener(this);

		fullHouse = new Score(); // 11
		fullHouse.addMouseListener(this);

		chance = new Score(); // 12
		chance.addMouseListener(this);

		yahtzee = new Score(); // 13
		yahtzee.addMouseListener(this);

		lblName = new JLabel(this.name); // 14
		lblTotalScore = new JLabel("    " + Integer.toString(totalScore) + "    "); // 15

		bonus = 0;

		////////////////////////
		////// End of Initialization
		//////////////

		settingUpThePanel();

	}

	public String getName() {

		return this.name;

	}

	public void settingUpThePanel() {

		////////////////////////
		////// START : Setting up the panel
		//////////////

		// setPreferredSize(new Dimension(206, 434));

		setBackground(Color.WHITE);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);

		// Box 0
		horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(0, 0, 206, 30);
		add(horizontalBox);
		// lblName
		lblName.setFont(new Font("Consolas", Font.PLAIN, 16));
		horizontalBox.add(lblName);

		// Box 1
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_1.setBounds(0, 29, 206, 30);
		add(horizontalBox_1);
		horizontalBox_1.add(ones);

		// Box 2
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_2.setBounds(0, 58, 206, 30);
		add(horizontalBox_2);
		horizontalBox_2.add(twos);

		// Box 3
		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_3.setBounds(0, 87, 206, 30);
		add(horizontalBox_3);
		horizontalBox_3.add(threes);

		// Box 4
		Box horizontalBox_4 = Box.createHorizontalBox();
		horizontalBox_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_4.setBounds(0, 116, 206, 30);
		add(horizontalBox_4);
		horizontalBox_4.add(fours);

		// Box 5
		Box horizontalBox_5 = Box.createHorizontalBox();
		horizontalBox_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_5.setBounds(0, 145, 206, 30);
		add(horizontalBox_5);
		horizontalBox_5.add(fives);

		// Box 6
		Box horizontalBox_6 = Box.createHorizontalBox();
		horizontalBox_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_6.setBounds(0, 174, 206, 30);
		add(horizontalBox_6);
		horizontalBox_6.add(sixes);

		// Box 7
		Box horizontalBox_7 = Box.createHorizontalBox();
		horizontalBox_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_7.setBounds(0, 203, 206, 30);
		add(horizontalBox_7);
		horizontalBox_7.add(threeOfAKind);

		// Box 8
		Box horizontalBox_8 = Box.createHorizontalBox();
		horizontalBox_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_8.setBounds(0, 232, 206, 30);
		add(horizontalBox_8);
		horizontalBox_8.add(fourOfAKind);

		// Box 9
		Box horizontalBox_9 = Box.createHorizontalBox();
		horizontalBox_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_9.setBounds(0, 261, 206, 30);
		add(horizontalBox_9);
		horizontalBox_9.add(smallStraight);

		// Box 10
		Box horizontalBox_10 = Box.createHorizontalBox();
		horizontalBox_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_10.setBounds(0, 290, 206, 30);
		add(horizontalBox_10);
		horizontalBox_10.add(largeStraight);

		// Box 11
		Box horizontalBox_11 = Box.createHorizontalBox();
		horizontalBox_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_11.setBounds(0, 319, 206, 30);
		add(horizontalBox_11);
		horizontalBox_11.add(fullHouse);

		// Box 12
		Box horizontalBox_12 = Box.createHorizontalBox();
		horizontalBox_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_12.setBounds(0, 348, 206, 30);
		add(horizontalBox_12);
		horizontalBox_12.add(chance);

		// Box 13
		Box horizontalBox_13 = Box.createHorizontalBox();
		horizontalBox_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_13.setBounds(0, 377, 206, 30);
		add(horizontalBox_13);
		horizontalBox_13.add(yahtzee);

		// Box 14
		horizontalBox_14 = Box.createHorizontalBox();
		horizontalBox_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_14.setBounds(0, 407, 206, 30);
		add(horizontalBox_14);
		// lblTotalScore
		lblTotalScore.setFont(new Font("Consolas", Font.PLAIN, 18));
		horizontalBox_14.add(lblTotalScore);

		// System.out.println("There ?");

		////////////////////////
		////// END : Setting up the panel
		//////////////

	}

	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == ones) { // 1

			numberOfRounds++;
			ones.scoreConfirmed = true;
			ones.setScore(GameEngine.upperScores(1, GameEngine.diceResults));
			incrementtotalScore(ones.getScore());
			//
			ones.setForeground(Color.BLACK);
			ones.setBackground(Color.GREEN);
			ones.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == twos) { // 2

			numberOfRounds++;
			twos.scoreConfirmed = true;
			twos.setScore(GameEngine.upperScores(2, GameEngine.diceResults));
			incrementtotalScore(twos.getScore());
			//
			twos.setForeground(Color.BLACK);
			twos.setBackground(Color.GREEN);
			twos.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == threes) { // 3

			numberOfRounds++;
			threes.scoreConfirmed = true;
			threes.setScore(GameEngine.upperScores(3, GameEngine.diceResults));
			incrementtotalScore(threes.getScore());
			//
			threes.setForeground(Color.BLACK);
			threes.setBackground(Color.GREEN);
			threes.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == fours) { // 4

			numberOfRounds++;
			fours.scoreConfirmed = true;
			fours.setScore(GameEngine.upperScores(4, GameEngine.diceResults));
			incrementtotalScore(fours.getScore());
			//
			fours.setForeground(Color.BLACK);
			fours.setBackground(Color.GREEN);
			fours.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == fives) { // 5

			numberOfRounds++;
			fives.scoreConfirmed = true;
			fives.setScore(GameEngine.upperScores(5, GameEngine.diceResults));
			incrementtotalScore(fives.getScore());
			//
			fives.setForeground(Color.BLACK);
			fives.setBackground(Color.GREEN);
			fives.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == sixes) { // 6

			numberOfRounds++;
			sixes.scoreConfirmed = true;
			sixes.setScore(GameEngine.upperScores(6, GameEngine.diceResults));
			incrementtotalScore(sixes.getScore());
			//
			sixes.setForeground(Color.BLACK);
			sixes.setBackground(Color.GREEN);
			sixes.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == threeOfAKind) { // 7

			numberOfRounds++;
			threeOfAKind.scoreConfirmed = true;
			threeOfAKind.setScore(GameEngine.ofAKind(3, GameEngine.diceResults));
			incrementtotalScore(threeOfAKind.getScore());
			//
			threeOfAKind.setForeground(Color.BLACK);
			threeOfAKind.setBackground(Color.GREEN);
			threeOfAKind.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == fourOfAKind) { // 8

			numberOfRounds++;
			fourOfAKind.scoreConfirmed = true;
			fourOfAKind.setScore(GameEngine.ofAKind(4, GameEngine.diceResults));
			incrementtotalScore(fourOfAKind.getScore());
			//
			fourOfAKind.setForeground(Color.BLACK);
			fourOfAKind.setBackground(Color.GREEN);
			fourOfAKind.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == smallStraight) { // 9

			numberOfRounds++;
			smallStraight.scoreConfirmed = true;
			smallStraight.setScore(GameEngine.straightScore(4, diceResults));
			incrementtotalScore(smallStraight.getScore());
			//
			smallStraight.setForeground(Color.BLACK);
			smallStraight.setBackground(Color.GREEN);
			smallStraight.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == largeStraight) { // 10

			numberOfRounds++;
			largeStraight.scoreConfirmed = true;
			largeStraight.setScore(GameEngine.straightScore(5, GameEngine.diceResults));
			incrementtotalScore(largeStraight.getScore());
			//
			largeStraight.setForeground(Color.BLACK);
			largeStraight.setBackground(Color.GREEN);
			largeStraight.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == fullHouse) { // 11

			numberOfRounds++;
			fullHouse.scoreConfirmed = true;
			fullHouse.setScore(GameEngine.fullHouse(diceResults));
			incrementtotalScore(fullHouse.getScore());
			//
			fullHouse.setForeground(Color.BLACK);
			fullHouse.setBackground(Color.GREEN);
			fullHouse.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == chance) { // 12

			numberOfRounds++;
			chance.scoreConfirmed = true;
			chance.setScore(GameEngine.chance(diceResults));
			incrementtotalScore(chance.getScore());
			//
			chance.setForeground(Color.BLACK);
			chance.setBackground(Color.GREEN);
			chance.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		} else if (e.getSource() == yahtzee) { // 13

			numberOfRounds++;
			yahtzee.scoreConfirmed = true;
			yahtzee.setScore(GameEngine.yahtzee(diceResults));
			incrementtotalScore(yahtzee.getScore());
			//
			yahtzee.setForeground(Color.BLACK);
			yahtzee.setBackground(Color.GREEN);
			yahtzee.removeMouseListener(this);
			//
			playerDiceRollPanel.refresh();
			checkGame();

		}

	}

	public void mouseEntered(MouseEvent e) {

		if (e.getSource() == ones) { // 1

			ones.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			ones.setForeground(Color.BLACK);
			ones.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == twos) { // 2

			twos.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			twos.setForeground(Color.BLACK);
			twos.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == threes) { // 3

			threes.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			threes.setForeground(Color.BLACK);
			threes.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == fours) { // 4

			fours.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			fours.setForeground(Color.BLACK);
			fours.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == fives) { // 5

			fives.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			fives.setForeground(Color.BLACK);
			fives.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == sixes) { // 6

			sixes.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			sixes.setForeground(Color.BLACK);
			sixes.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == threeOfAKind) { // 7

			threeOfAKind.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			threeOfAKind.setForeground(Color.BLACK);
			threeOfAKind.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == fourOfAKind) { // 8

			fourOfAKind.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			fourOfAKind.setForeground(Color.BLACK);
			fourOfAKind.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == smallStraight) { // 9

			smallStraight.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			smallStraight.setForeground(Color.BLACK);
			smallStraight.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == largeStraight) { // 10

			largeStraight.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			largeStraight.setForeground(Color.BLACK);
			largeStraight.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == fullHouse) { // 11

			fullHouse.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			fullHouse.setForeground(Color.BLACK);
			fullHouse.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == chance) { // 12

			chance.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			chance.setForeground(Color.BLACK);
			chance.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} else if (e.getSource() == yahtzee) { // 13

			yahtzee.setBorder(BorderFactory.createLineBorder(Color.green, 3));
			yahtzee.setForeground(Color.BLACK);
			yahtzee.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

	}

	public void mouseExited(MouseEvent e) {

		if (e.getSource() == ones) { // 1

			ones.setForeground(Color.red);
			ones.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == twos) { // 2

			twos.setForeground(Color.red);
			twos.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == threes) { // 3

			threes.setForeground(Color.red);
			threes.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == fours) { // 4

			fours.setForeground(Color.red);
			fours.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == fives) { // 5

			fives.setForeground(Color.red);
			fives.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == sixes) { // 6

			sixes.setForeground(Color.red);
			sixes.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == threeOfAKind) { // 7

			threeOfAKind.setForeground(Color.red);
			threeOfAKind.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == fourOfAKind) { // 8

			fourOfAKind.setForeground(Color.red);
			fourOfAKind.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == smallStraight) { // 9

			smallStraight.setForeground(Color.red);
			smallStraight.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == largeStraight) { // 10

			largeStraight.setForeground(Color.red);
			largeStraight.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == fullHouse) { // 11

			fullHouse.setForeground(Color.red);
			fullHouse.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == chance) { // 12

			chance.setForeground(Color.red);
			chance.setBorder(BorderFactory.createEmptyBorder());

		} else if (e.getSource() == yahtzee) { // 13

			yahtzee.setForeground(Color.red);
			yahtzee.setBorder(BorderFactory.createEmptyBorder());
		}

	}

	// @Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// @Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void giveScore() {

		if ((ones.scoreConfirmed) == false) {

			ones.setScore(GameEngine.upperScores(1, GameEngine.diceResults));

		}

		if ((twos.scoreConfirmed) == false) {

			twos.setScore(GameEngine.upperScores(2, GameEngine.diceResults));

		}
		if ((threes.scoreConfirmed) == false) {

			threes.setScore(GameEngine.upperScores(3, GameEngine.diceResults));

		}
		if ((fours.scoreConfirmed) == false) {

			fours.setScore(GameEngine.upperScores(4, GameEngine.diceResults));

		}
		if ((fives.scoreConfirmed) == false) {

			fives.setScore(GameEngine.upperScores(5, GameEngine.diceResults));

		}
		if ((sixes.scoreConfirmed) == false) {

			sixes.setScore(GameEngine.upperScores(6, GameEngine.diceResults));

		}
		if ((threeOfAKind.scoreConfirmed) == false) {

			threeOfAKind.setScore(GameEngine.ofAKind(3, GameEngine.diceResults));

		}
		if ((fourOfAKind.scoreConfirmed) == false) {

			fourOfAKind.setScore(GameEngine.ofAKind(4, GameEngine.diceResults));

		}
		if ((smallStraight.scoreConfirmed) == false) {

			smallStraight.setScore(GameEngine.straightScore(4, GameEngine.diceResults));

		}
		if ((largeStraight.scoreConfirmed) == false) {

			largeStraight.setScore(GameEngine.straightScore(5, GameEngine.diceResults));

		}
		if ((fullHouse.scoreConfirmed) == false) {

			fullHouse.setScore(GameEngine.fullHouse(diceResults));

		}
		if ((chance.scoreConfirmed) == false) {

			chance.setScore(GameEngine.chance(diceResults));

		}
		if ((yahtzee.scoreConfirmed) == false) {

			yahtzee.setScore(GameEngine.yahtzee(diceResults));

		} else if (yahtzee.scoreConfirmed == true) {

			// Bonus

			if (yahtzee.getScore() >= 50) {

				if (GameEngine.yahtzee(diceResults) == 50) {

					bonus++;

					JOptionPane.showMessageDialog(this,
							"You have received a bouns of 100 points for additional Yahtzee thus\n In this round the Yahtzee Category has been scored for you \n With additional 100 points",
							"Additional Yahtzee Bonus", JOptionPane.ERROR_MESSAGE, null);

					numberOfRounds++;
					yahtzee.scoreConfirmed = true;
					yahtzee.yahtzeeBonusScore();
					incrementtotalScore(yahtzee.getScore());
					//
					yahtzee.setBorder(BorderFactory.createTitledBorder("Bonus      +" + 100 * bonus));
					//
					playerDiceRollPanel.refresh();
					checkGame();

				}
			}

		}

	}

	public void resetScore() {

		if ((ones.scoreConfirmed) == false) {

			ones.resetScore();

		}

		if ((twos.scoreConfirmed) == false) {

			twos.resetScore();

		}
		if ((threes.scoreConfirmed) == false) {

			threes.resetScore();

		}
		if ((fours.scoreConfirmed) == false) {

			fours.resetScore();

		}
		if ((fives.scoreConfirmed) == false) {

			fives.resetScore();

		}
		if ((sixes.scoreConfirmed) == false) {

			sixes.resetScore();

		}
		if ((threeOfAKind.scoreConfirmed) == false) {

			threeOfAKind.resetScore();

		}
		if ((fourOfAKind.scoreConfirmed) == false) {

			fourOfAKind.resetScore();

		}
		if ((smallStraight.scoreConfirmed) == false) {

			smallStraight.resetScore();

		}
		if ((largeStraight.scoreConfirmed) == false) {

			largeStraight.resetScore();

		}
		if ((fullHouse.scoreConfirmed) == false) {

			fullHouse.resetScore();

		}
		if ((chance.scoreConfirmed) == false) {

			chance.resetScore();

		}
		if ((yahtzee.scoreConfirmed) == false) {

			yahtzee.resetScore();

		} else if (yahtzee.scoreConfirmed == true) {

			// Do not Reset

		}

	}

	public void incrementtotalScore(int x) {

		totalScore = totalScore + x;
		lblTotalScore.setText("    " + Integer.toString(totalScore) + "    ");

	}

	public void checkGame() {

		if (GameFrame.singlePlayer == true) {

			if (GameFrame.currentPlayer.numberOfRounds == 13) {

				JOptionPane.showMessageDialog(this, "Thankyou for playing \n You scored - " + totalScore + " points",
						"Game Over", JOptionPane.DEFAULT_OPTION, null);

				System.exit(0);

			}

		} else if (GameFrame.multiPlayer == true) {

			if (GameFrame.player_1.numberOfRounds + GameFrame.player_2.numberOfRounds == 26) {

				if (GameFrame.player_1.totalScore > GameFrame.player_2.totalScore) {

					JOptionPane.showMessageDialog(this,
							"Thankyou for playing\n" + "Player One scored - " + GameFrame.player_1.totalScore
									+ " points\n" + "Player Two Scored - " + GameFrame.player_2.totalScore + " points\n"
									+ "The winner is Player One",
							"Game Over", JOptionPane.DEFAULT_OPTION, null);

					System.exit(0);

				} else {

					JOptionPane.showMessageDialog(this,
							"Thankyou for playing\n" + "Player One scored - " + GameFrame.player_1.totalScore
									+ " points\n" + "Player Two Scored - " + GameFrame.player_2.totalScore + " points\n"
									+ "The winner is Player Two",
							"Game Over", JOptionPane.DEFAULT_OPTION, null);

					System.exit(0);

				}

			} //// if
				// game
				// not over

			else {

				if (GameFrame.currentPlayer == GameFrame.player_1) {

					GameFrame.currentPlayer = GameFrame.player_2;
					GameFrame.textMultiPlayerField.setText("  " + GameFrame.currentPlayer.getName());

				} else if (GameFrame.currentPlayer == GameFrame.player_2) {

					GameFrame.currentPlayer = GameFrame.player_1;
					GameFrame.textMultiPlayerField.setText("  " + GameFrame.currentPlayer.getName());

				}

			}

		}

	}

}
