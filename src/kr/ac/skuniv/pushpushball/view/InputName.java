package kr.ac.skuniv.pushpushball.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.ac.skuniv.pushpushball.controller.ConfirmButtonActionListener;
import kr.ac.skuniv.pushpushball.model.MapData;
import kr.ac.skuniv.pushpushball.model.PlayerData;

public class InputName extends JPanel {
	public JTextField name1p, name2p;
	private Intro intro;
	private MapData mapdata;
	private Board board;
	private Container contentPane;
	private JFrame frame;
	BilliardTable billiard;
	PlayerData playerdata;
	public InputName(Intro intro, MapData mapdata ,Board board, Container contentPane, JFrame frame, PlayerData playerdata, BilliardTable billiard) {
		this.intro = intro;
		this.mapdata = mapdata;
		this.board = board;
		this.contentPane = contentPane;
		this.frame = frame;
		this.playerdata = playerdata;
		this.billiard = billiard;
		JFrame inputframe = new JFrame("Input Name");
		inputframe.setPreferredSize(new Dimension(600, 350));
		inputframe.setLocation(675, 400);
		inputframe.setLayout(null);
		Font font = new Font("¿±∞ÌµÒ", Font.PLAIN, 40);
		JButton button = new JButton("»Æ¿Œ");
		JLabel label = new JLabel("1P Name          2P Name");
		name1p = new JTextField("");
		name2p = new JTextField("");
		label.setLocation(75, 0);
		label.setSize(450, 130);
		label.setFont(font);
		name1p.setSize(240, 80);
		name1p.setLocation(40, 100);
		name1p.setFont(font);
		name2p.setSize(240, 80);
		name2p.setLocation(310, 100);
		name2p.setFont(font);
		button.setLocation(195, 210);
		button.setSize(200, 70);
		ActionListener listener = new ConfirmButtonActionListener(name1p, name2p, frame, mapdata, intro,board, contentPane, playerdata, billiard, inputframe);
		button.addActionListener(listener);
		inputframe.add(name1p);
		inputframe.add(name2p);
		inputframe.add(label);
		inputframe.add(button);
		inputframe.pack();
		inputframe.setVisible(true);
	}
}


