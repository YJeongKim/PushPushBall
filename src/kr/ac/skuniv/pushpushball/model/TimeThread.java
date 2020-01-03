package kr.ac.skuniv.pushpushball.model;

import kr.ac.skuniv.pushpushball.view.BilliardTable;

public class TimeThread extends Thread implements Runnable {
	MapData mapData;
	BilliardTable billiard;

	public TimeThread(MapData mapData, BilliardTable billiard) {
		this.mapData = mapData;
		this.billiard = billiard;
	}

	/************* Thread Start *********************/
	public void run() {
		while (mapData.getMinutes() != 0 || mapData.getSeconds() != 0) {
			try {
				int minutes = mapData.getMinutes();
				int seconds = mapData.getSeconds();
				Thread.sleep(1000); // sleep(1000) -> 1√ 
				if (seconds == 0 && minutes != 0) {
					seconds = 59;
					minutes -= 1;
				} else {
					seconds--;
				}
				mapData.setSeconds(seconds);
				mapData.setMinutes(minutes);
				if (mapData.threadrunning == false) return;
				billiard.repaint();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
