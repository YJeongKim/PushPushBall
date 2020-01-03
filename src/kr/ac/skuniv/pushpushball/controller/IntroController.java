package kr.ac.skuniv.pushpushball.controller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import kr.ac.skuniv.pushpushball.model.MapData;
import kr.ac.skuniv.pushpushball.model.PlayerData;
import kr.ac.skuniv.pushpushball.view.BilliardTable;
import kr.ac.skuniv.pushpushball.view.Board;
import kr.ac.skuniv.pushpushball.view.Creators;
import kr.ac.skuniv.pushpushball.view.InputName;
import kr.ac.skuniv.pushpushball.view.Intro;
import kr.ac.skuniv.pushpushball.view.Manual;
import kr.ac.skuniv.pushpushball.view.Rank;

public class IntroController implements MouseListener, MouseMotionListener {
	Board board;
	MapData mapdata;
	PlayerData playerdata;
	BilliardTable billiard;
	Intro intro;
	Container contentPane;
	JFrame frame;
	Manual manual = new Manual();
	Creators creators = new Creators();
	
	public IntroController(Intro intro, Board board, MapData mapdata, BilliardTable billiard, Container contentPane,
			JFrame frame, PlayerData playerdata) {
		this.intro = intro;
		this.board = board;
		this.mapdata = mapdata;
		this.billiard = billiard;
		this.contentPane = contentPane;
		this.frame = frame;
		this.playerdata = playerdata;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// start button
		if ((e.getX() > 360 && e.getX() < 580) && (e.getY() > 400 && e.getY() < 462)) {
			new InputName(intro, mapdata, board, contentPane, frame, playerdata, billiard);
		}

		// manual button
		else if ((e.getX() > 360 && e.getX() < 580) && (e.getY() > 500 && e.getY() < 562)) {
			contentPane.removeAll();
			manual.addMouseListener(new ManualController(manual, contentPane, frame, board, mapdata, intro, billiard, playerdata));
			contentPane.add(manual);
			frame.setPreferredSize(new Dimension(950, 1000));
			frame.setLocation(500, 20);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		}
		// rank button
		else if ((e.getX() > 360 && e.getX() < 580) && (e.getY() > 600 && e.getY() < 662)) {
			Rank rank = new Rank(playerdata);
			contentPane.removeAll();
			rank.addMouseListener(new RankController(rank, contentPane, frame, board, mapdata, intro, billiard, playerdata));
			contentPane.add(rank);
			frame.setPreferredSize(new Dimension(950, 1000));
			frame.setLocation(500, 20);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		}
		// creators button
		else if ((e.getX() > 360 && e.getX() < 580) && (e.getY() > 700 && e.getY() < 762)) {
			contentPane.removeAll();
			creators.addMouseListener(new CreatorsController(creators, contentPane, frame, board, mapdata, intro, billiard,playerdata));
			contentPane.add(creators);
			frame.setPreferredSize(new Dimension(950, 1000));
			frame.setLocation(500, 20);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		}
		// exit button
		else if ((e.getX() > 360 && e.getX() < 580) && (e.getY() > 800 && e.getY() < 862)) {
			System.exit(0);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// start button
		if ((e.getX() > 360 && e.getX() < 580) && (e.getY() > 400 && e.getY() < 462)) {
			mapdata.checkEntered = 1;
		}
		// manual button
		else if ((e.getX() > 360 && e.getX() < 580) && (e.getY() > 500 && e.getY() < 562)) {
			mapdata.checkEntered = 2;
		}
		// rank button
		else if ((e.getX() > 360 && e.getX() < 580) && (e.getY() > 600 && e.getY() < 662)) {
			mapdata.checkEntered = 3;
		}
		// creators button
		else if ((e.getX() > 360 && e.getX() < 580) && (e.getY() > 700 && e.getY() < 762)) {
			mapdata.checkEntered = 4;
		}
		// exit button
		else if ((e.getX() > 360 && e.getX() < 580) && (e.getY() > 800 && e.getY() < 862)) {
			mapdata.checkEntered = 5;
		}
		if ((e.getX() > 360 && e.getX() < 580) && (e.getY() > 400 && e.getY() < 462)
				|| (e.getX() > 360 && e.getX() < 580) && (e.getY() > 500 && e.getY() < 562)
				|| (e.getX() > 360 && e.getX() < 580) && (e.getY() > 600 && e.getY() < 662)
				|| (e.getX() > 360 && e.getX() < 580) && (e.getY() > 700 && e.getY() < 762)
				|| (e.getX() > 360 && e.getX() < 580) && (e.getY() > 800 && e.getY() < 862))
			;
		else {
			mapdata.checkEntered = 0;
		}
		intro.repaint();
	}
}
