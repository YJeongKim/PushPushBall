package kr.ac.skuniv.pushpushball.controller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import kr.ac.skuniv.pushpushball.model.MapData;
import kr.ac.skuniv.pushpushball.model.PlayerData;
import kr.ac.skuniv.pushpushball.view.BilliardTable;
import kr.ac.skuniv.pushpushball.view.Board;
import kr.ac.skuniv.pushpushball.view.Creators;
import kr.ac.skuniv.pushpushball.view.Intro;

public class CreatorsController implements MouseListener {
	Creators creators = new Creators();
	Container contentPane;
	JFrame frame;
	Board board;
	MapData mapdata;
	Intro intro;
	BilliardTable billiard;
	PlayerData playerdata;

	public CreatorsController(Creators creators, Container contentPane, JFrame frame, Board board, MapData mapdata,	Intro intro, BilliardTable billiard, PlayerData playerdata) {
		this.creators = creators;
		this.contentPane = contentPane;
		this.frame = frame;
		this.board = board;
		this.mapdata = mapdata;
		this.intro = intro;
		this.billiard = billiard;
		this.playerdata = playerdata;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if ((e.getX() > 15 && e.getX() < 70) && (e.getY() > 225 && e.getY() < 280)) {
			contentPane.remove(creators);
			intro.addMouseListener(new IntroController(intro, board, mapdata, billiard, contentPane, frame, playerdata));
			intro.addMouseMotionListener(new IntroController(intro, board, mapdata, billiard, contentPane, frame, playerdata));
			contentPane.add(intro);
			frame.setPreferredSize(new Dimension(950, 1000));
			frame.setLocation(500, 20);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼을 눌렀을 때
			frame.pack();
			frame.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
