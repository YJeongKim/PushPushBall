package kr.ac.skuniv.pushpushball.view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.ac.skuniv.pushpushball.controller.UserController;
import kr.ac.skuniv.pushpushball.controller.UserKeyboardInput;
import kr.ac.skuniv.pushpushball.model.LoadingThread;
import kr.ac.skuniv.pushpushball.model.MapData;
import kr.ac.skuniv.pushpushball.model.PlayerData;

public class Loading extends JPanel {
	MapData mapdata;
	Intro intro;
	Board board;
	Container contentPane;
	BilliardTable billiard;
	JFrame frame;
	PlayerData playerdata;

	public Loading(MapData mapdata, Intro intro, Board board, Container contentPane, JFrame frame,
			PlayerData playerdata, BilliardTable billiard) {
		this.mapdata = mapdata;
		this.intro = intro;
		this.playerdata = playerdata;
		this.billiard = billiard;
		mapdata.loading_screen = 1;
		intro.stopbgm();
		new LoadingThread(mapdata, billiard).start();
		contentPane.removeAll();
		board.startsound();
		intro.gamebgmplay();
		contentPane.add(billiard);
		UserController userController = new UserController(mapdata, billiard, board);
		frame.addKeyListener(new UserKeyboardInput(mapdata, userController, billiard, board, playerdata, intro, contentPane, frame));
		frame.setLocation(500, 20);
		frame.setPreferredSize(new Dimension(950, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
