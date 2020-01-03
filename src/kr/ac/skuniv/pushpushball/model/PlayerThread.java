package kr.ac.skuniv.pushpushball.model;

import kr.ac.skuniv.pushpushball.view.BilliardTable;

public class PlayerThread extends Thread implements Runnable {
	MapData mapData;
	BilliardTable billiard;

	public PlayerThread(MapData mapData, BilliardTable billiard) {
		this.mapData = mapData;
		this.billiard = billiard;
	}

	/************* Thread Start *********************/
	public void run() {
		boolean turn = mapData.isTurn();
		
		if (turn == true && mapData.threadrunning) { // 1p
			mapData.setPlayer2Seconds(10);
			while (mapData.getPlayer1Seconds() > 0) {
				try {
					int seconds = mapData.getPlayer1Seconds();
					Thread.sleep(1000); // sleep(1000) -> 1√ 
					mapData.setPlayer1Seconds(--seconds);
					if (mapData.getDiceresult() == 0) {
						if (mapData.dice[0] == mapData.dice[1]) {
							mapData.Rolldice();
							mapData.setPlayer1Seconds(10);
							mapData.setDice_turn(true);
						} else {
							mapData.setPlayer1Seconds(0);
							mapData.setTurn(false);
							mapData.setDice_turn(false);
						}
					} else if (mapData.getPlayer1Seconds() == 0) {
						if (mapData.dice[0] == mapData.dice[1]) {
							mapData.setDiceresult(0);
							mapData.Rolldice();
							mapData.setPlayer1Seconds(10);
							mapData.setDice_turn(true);
						} else {
							mapData.setPlayer1Seconds(0);
							mapData.setDiceresult(0);
							mapData.setTurn(false);
							mapData.setDice_turn(false);
						}
					}
					billiard.repaint();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		} else if (turn == false && mapData.threadrunning) { // 2p
			mapData.setPlayer1Seconds(10);
			while (mapData.getPlayer2Seconds() > 0) {
				try {
					int seconds = mapData.getPlayer2Seconds();
					Thread.sleep(1000); // sleep(1000) -> 1√ 
					mapData.setPlayer2Seconds(--seconds);
					if (mapData.getDiceresult() == 0) {
						if (mapData.dice[0] == mapData.dice[1]) {
							mapData.Rolldice();
							mapData.setPlayer2Seconds(10);
							mapData.setDice_turn(true);
						} else {
							mapData.setPlayer2Seconds(0);
							mapData.setTurn(true);
							mapData.setDice_turn(false);
						}
					} else if (mapData.getPlayer2Seconds() == 0) {
						if (mapData.dice[0] == mapData.dice[1]) {
							mapData.setDiceresult(0);
							mapData.Rolldice();
							mapData.setPlayer2Seconds(10);
							mapData.setDice_turn(true);
						} else {
							mapData.setDiceresult(0);
							mapData.setTurn(true);
							mapData.setDice_turn(false);
						}
					}
					billiard.repaint();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
