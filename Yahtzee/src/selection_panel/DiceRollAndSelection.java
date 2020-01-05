package selection_panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import game_frame.GameFrame;

public class DiceRollAndSelection extends JPanel {

	public JList myJList;
	public DefaultListModel myDefaultListModel;

	public JButton btnRoll, btnReRoll;

	public int diceRollCount;

	public DiceRollAndSelection() {

		LayoutManager layout = new FlowLayout(FlowLayout.CENTER, 30, 30);
		setBorder(BorderFactory.createLineBorder(Color.RED, 3));

		// Component Initialization
		//
		myDefaultListModel = new DefaultListModel<JLabel>();
		myJList = new JList<ImageIcon>(myDefaultListModel);

		btnRoll = new JButton("Roll Dice");
		btnReRoll = new JButton("Re Roll Dice");

		diceRollCount = 0;

		//

		myJList.setPreferredSize(new Dimension(600, 100));
		add(myJList);

		btnRoll.setPreferredSize(new Dimension(250, 50));
		btnRoll.setFont(new Font("Consolas", Font.PLAIN, 19));
		btnRoll.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		add(btnRoll);

		btnReRoll.setPreferredSize(new Dimension(250, 50));
		btnReRoll.setFont(new Font("Consolas", Font.PLAIN, 19));
		btnReRoll.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		add(btnReRoll);

		// Component Manipulation

		myJList.setVisibleRowCount(-1);
		myJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		myJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		myJList.setFixedCellHeight(100);
		myJList.setFixedCellWidth(120);

		myDefaultListModel.addElement(""); // 0
		myDefaultListModel.addElement(""); // 1
		myDefaultListModel.addElement(""); // 2
		myDefaultListModel.addElement(""); // 3
		myDefaultListModel.addElement(""); // 4

		btnReRoll.setVisible(false); // STAR

		//
	}

	public void refresh() {

		btnReRoll.setVisible(false);
		btnRoll.setVisible(true);
		//
		GameFrame.currentPlayer.resetScore();
		diceRollCount = 0;
		GameFrame.textDiceRollCount.setText(" 0");
		myDefaultListModel.clear();
		myDefaultListModel.addElement(""); // 0
		myDefaultListModel.addElement(""); // 1
		myDefaultListModel.addElement(""); // 2
		myDefaultListModel.addElement(""); // 3
		myDefaultListModel.addElement(""); // 4

	}

}
