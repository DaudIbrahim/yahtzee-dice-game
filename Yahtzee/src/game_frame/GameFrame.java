package game_frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import player.Player;
import scoreboard.ScoreBoard;
import selection_panel.DiceRollAndSelection;
import yahtzee_engine.GameEngine;

public class GameFrame extends JFrame {

	public static boolean singlePlayer;
	public static boolean multiPlayer;

	ScoreBoard scoreBoardPanel;

	JLabel lbldiceRollCount;
	public static JTextField textDiceRollCount;

	JLabel lblMultiPlayer;
	public static JTextField textMultiPlayerField;

	public static DiceRollAndSelection diceRollPanel;

	public static Player player_1;
	public static Player player_2;
	public static Player currentPlayer;

	static int multiPlayerRoundCount;

	public GameFrame(int numberOfPLayers) {

		if (numberOfPLayers == 1) {

			singlePlayer = true;
			singlePlayer();

		} else if (numberOfPLayers == 2) {

			multiPlayer = true;
			multiPlayer();

		} else
			System.out.println("ERROR");
	}

	public void singlePlayer() {

		scoreBoardPanel = new ScoreBoard();
		lbldiceRollCount = new JLabel("Times Dice Rolled : ");
		textDiceRollCount = new JTextField(" 0");
		//
		//

		diceRollPanel = new DiceRollAndSelection();

		currentPlayer = new Player("SinglePlayer");
		currentPlayer.playerDiceRollPanel = diceRollPanel;

		//
		singlePlayerFrameConfig();
		diceRollPanelButtonControl(); // simply adds action listener

	}

	public void multiPlayer() {

		scoreBoardPanel = new ScoreBoard();
		lbldiceRollCount = new JLabel("Times Dice Rolled : ");
		textDiceRollCount = new JTextField(" 0");
		lblMultiPlayer = new JLabel("Turn -");
		textMultiPlayerField = new JTextField("");
		//
		//

		diceRollPanel = new DiceRollAndSelection();

		player_1 = new Player("Player One");
		player_1.playerDiceRollPanel = diceRollPanel;

		player_2 = new Player("Player Two");
		player_2.playerDiceRollPanel = diceRollPanel;

		currentPlayer = player_1;

		//
		multiPlayerFrameConfig();
		diceRollPanelButtonControl(); // simply adds action listener

	}

	public void diceRollPanelButtonControl() {

		diceRollPanel.btnRoll.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				GameEngine.willRollAllDices();

				diceRollPanel.myDefaultListModel.set(0, new ImageIcon(GameEngine.diceResults[0] + ".png")); // 0
				diceRollPanel.myDefaultListModel.set(1, new ImageIcon(GameEngine.diceResults[1] + ".png")); // 1
				diceRollPanel.myDefaultListModel.set(2, new ImageIcon(GameEngine.diceResults[2] + ".png")); // 2
				diceRollPanel.myDefaultListModel.set(3, new ImageIcon(GameEngine.diceResults[3] + ".png")); // 3
				diceRollPanel.myDefaultListModel.set(4, new ImageIcon(GameEngine.diceResults[4] + ".png")); // 4

				diceRollPanel.btnRoll.setVisible(false);
				diceRollPanel.btnReRoll.setEnabled(true);// FUTURE
				diceRollPanel.btnReRoll.setVisible(true);

				diceRollPanel.diceRollCount++;
				textDiceRollCount.setText(" " + Integer.toString(diceRollPanel.diceRollCount));

				currentPlayer.giveScore();

			}
		});

		diceRollPanel.btnReRoll.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (diceRollPanel.diceRollCount == 3) {

					JOptionPane.showMessageDialog(GameFrame.this,
							"Please Select Your Score From The Given Categories To Continue", "Error",
							JOptionPane.ERROR_MESSAGE, null);

				}

				if (diceRollPanel.diceRollCount < 3) {

					if (diceRollPanel.myJList.getSelectedIndex() >= 0) {

						diceRollPanel.diceRollCount++;
						textDiceRollCount.setText(" " + Integer.toString(diceRollPanel.diceRollCount));

						//
						//
						// this List will store the indexes I have selected from the Gui JList
						int[] JListSelectedIndicesList = diceRollPanel.myJList.getSelectedIndices();
						////// /\ /\ /\ /\ /\ /\ /\ /\

						// Getting "Value" from JListSelectedIndicesList
						for (int i = 0; i < JListSelectedIndicesList.length; i++) {

							// "Value" i.e the indexes we select from JListSelectedIndicesList
							// Will be stored in x
							int x = JListSelectedIndicesList[i];
							GameEngine.willRollDiceAtSpecifiedIndex(x);
							diceRollPanel.myDefaultListModel.set(x, new ImageIcon(GameEngine.diceResults[x] + ".png"));
							currentPlayer.giveScore();
							diceRollPanel.myJList.clearSelection();
						}

					} else {

						// System.out.println("Please Select Dice to be rerolled");

						JOptionPane.showMessageDialog(GameFrame.this, "Please Select Dice To Be Re-Rolled", "Error",
								JOptionPane.ERROR_MESSAGE, null);

					}

				} // if (diceRollPanel.diceRollCount < 3) End

			}
		});

	}

	// FRAME SET UP

	public void singlePlayerFrameConfig() {

		setLayout(null);

		diceRollPanel.setBounds(10, 10, 820, 180);

		scoreBoardPanel.setBounds(10, 200, 206, 434);

		currentPlayer.setBounds(216, 200, 110, 434);
		currentPlayer.diceResults = GameEngine.diceResults;

		lbldiceRollCount.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lbldiceRollCount.setFont(new Font("Consolas", Font.PLAIN, 22));
		lbldiceRollCount.setSize(new Dimension(250, 22));
		lbldiceRollCount.setLocation(450, 220);

		textDiceRollCount.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		textDiceRollCount.setFont(new Font("Consolas", Font.PLAIN, 22));
		textDiceRollCount.setEditable(false);
		textDiceRollCount.setSize(new Dimension(40, 22));
		textDiceRollCount.setLocation(700, 220);

		// Adding Components
		add(diceRollPanel);
		add(scoreBoardPanel);
		add(currentPlayer);
		add(lbldiceRollCount);
		add(textDiceRollCount);

		//

		setMinimumSize(new Dimension(850, 690));
		setSize(850, 690);
		setTitle("Single Player Yahtzee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void multiPlayerFrameConfig() {

		setLayout(null);

		diceRollPanel.setBounds(10, 10, 820, 180);

		scoreBoardPanel.setBounds(10, 200, 206, 434);

		player_1.setBounds(216, 200, 110, 434);
		player_1.diceResults = GameEngine.diceResults;

		player_2.setBounds(326, 200, 110, 434);
		player_2.diceResults = GameEngine.diceResults;

		lbldiceRollCount.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lbldiceRollCount.setFont(new Font("Consolas", Font.PLAIN, 22));
		lbldiceRollCount.setSize(new Dimension(250, 22));
		lbldiceRollCount.setLocation(450, 220);

		textDiceRollCount.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		textDiceRollCount.setFont(new Font("Consolas", Font.PLAIN, 22));
		textDiceRollCount.setEditable(false);
		textDiceRollCount.setSize(new Dimension(40, 22));
		textDiceRollCount.setLocation(700, 220);

		lblMultiPlayer.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblMultiPlayer.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblMultiPlayer.setSize(new Dimension(100, 22));
		lblMultiPlayer.setLocation(450, 250);

		textMultiPlayerField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		textMultiPlayerField.setFont(new Font("Consolas", Font.PLAIN, 22));
		textMultiPlayerField.setEditable(false);
		textMultiPlayerField.setForeground(Color.RED);
		textMultiPlayerField.setLocation(550, 250);
		textMultiPlayerField.setSize(new Dimension(240, 22));
		textMultiPlayerField.setText("  " + currentPlayer.getName());

		// Adding Components
		add(diceRollPanel);
		add(scoreBoardPanel);
		add(player_1);
		add(player_2);
		add(lbldiceRollCount);
		add(textDiceRollCount);
		add(lblMultiPlayer);
		add(textMultiPlayerField);

		//

		setMinimumSize(new Dimension(850, 690));
		setSize(850, 690);
		setTitle("Multi Player Yahtzee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
