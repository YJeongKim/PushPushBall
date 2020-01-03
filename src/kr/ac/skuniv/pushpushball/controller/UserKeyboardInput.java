package kr.ac.skuniv.pushpushball.controller;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kr.ac.skuniv.pushpushball.model.MapData;
import kr.ac.skuniv.pushpushball.model.PlayerData;
import kr.ac.skuniv.pushpushball.model.PlayerThread;
import kr.ac.skuniv.pushpushball.view.BilliardTable;
import kr.ac.skuniv.pushpushball.view.Board;
import kr.ac.skuniv.pushpushball.view.Intro;

public class UserKeyboardInput implements KeyListener {
	public MapData mapData;
	public UserController userController;
	public BilliardTable billiardTable;
	public Board board;
	private PlayerData playerdata;
	private Intro intro;
	private Container contentPane;
	private JFrame frame;
	public UserKeyboardInput(MapData mapData, UserController userController, BilliardTable billiardTable, Board board,PlayerData playerdata, Intro intro, Container contentPane, JFrame frame) {
		this.mapData = mapData;
		this.userController = userController;
		this.billiardTable = billiardTable;
		this.board = board;
		this.playerdata = playerdata;
		this.intro = intro;
		this.contentPane = contentPane;
		this.frame = frame;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if (keycode == KeyEvent.VK_SPACE) {
			if (mapData.getDiceresult() != 0)
				return;
			else if (mapData.isDice_turn() == true)
				return;
			PlayerThread t = new PlayerThread(mapData, billiardTable);
			t.start();
			mapData.Rolldice();
			mapData.setDice_turn(true);
			board.spacebarsound();
		}
		if (mapData.isDice_turn() == false)
			return;
		switch (keycode) {
		case KeyEvent.VK_D:
			userController.current_player = 16;
			userController.rightSwap();
			break;
		case KeyEvent.VK_A:
			userController.current_player = 16;
			userController.leftSwap();
			break;
		case KeyEvent.VK_W:
			userController.current_player = 16;
			userController.upSwap();
			break;
		case KeyEvent.VK_S:
			userController.current_player = 16;
			userController.downSwap();
			break;
		case KeyEvent.VK_RIGHT:
			userController.current_player = 17;
			userController.rightSwap();
			break;
		case KeyEvent.VK_LEFT:
			userController.current_player = 17;
			userController.leftSwap();
			break;
		case KeyEvent.VK_UP:
			userController.current_player = 17;
			userController.upSwap();
			break;
		case KeyEvent.VK_DOWN:
			userController.current_player = 17;
			userController.downSwap();
			break;
		}
		billiardTable.repaint();
		int state = mapData.judgment();
		if (state != 0) {
			// ∑©≈∑ µÓ∑œ
			playerdata.rankingEnrollment(state);
			playerdata.sort();
			JOptionPane.showMessageDialog(null, state==1 ? "["+playerdata.getPlayer1()+ "] 1Player∞° ¿Ã∞ÂΩ¿¥œ¥Ÿ :)" : "["+playerdata.getPlayer2() + "] 2Player∞° ¿Ã∞ÂΩ¿¥œ¥Ÿ :)");
			mapData.setMinutes(0);
			mapData.setSeconds(0);
			mapData.threadrunning = false;			
			intro.stopbgm();
			frame.dispose();
			frame.setVisible(false);
			new Board();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
