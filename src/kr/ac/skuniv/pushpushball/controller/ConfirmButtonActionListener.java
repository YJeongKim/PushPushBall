package kr.ac.skuniv.pushpushball.controller;

import javax.swing.JFrame;

import kr.ac.skuniv.pushpushball.model.LoadingThread;
import kr.ac.skuniv.pushpushball.model.MapData;
import kr.ac.skuniv.pushpushball.model.PlayerData;
import kr.ac.skuniv.pushpushball.view.BilliardTable;
import kr.ac.skuniv.pushpushball.view.Board;
import kr.ac.skuniv.pushpushball.view.Intro;
import kr.ac.skuniv.pushpushball.view.Loading;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConfirmButtonActionListener implements ActionListener {
	PlayerData playerdata;
	MapData mapdata;
	Intro intro;
	JFrame frame, inputframe;
	JTextField name1, name2;
	String name1p, name2p;
	Loading loading;
	Board board;
	Container contentPane;
	BilliardTable billiard;
	public ConfirmButtonActionListener(JTextField name1, JTextField name2, JFrame frame, MapData mapdata, Intro intro, Board board, Container contentPane, PlayerData playerdata, BilliardTable billiard, JFrame inputframe) {
		this.frame = frame;
		this.name1 = name1;
		this.name2 = name2;
		this.mapdata = mapdata;
		this.intro = intro;
		this.board = board;
		this.contentPane = contentPane;
		this.playerdata = playerdata;
		this.billiard = billiard;
		this.inputframe = inputframe;
	}

	public void actionPerformed(ActionEvent e) {
		playerdata.setPlayer1(name1.getText());
		playerdata.setPlayer2(name2.getText());
		mapdata.setInput_check(true);
		inputframe.setVisible(false);
		inputframe.dispose();
		if(mapdata.isInput_check() == true){
			 loading = new Loading(mapdata, intro, board, contentPane, frame, playerdata, billiard);
		}
	}
}
