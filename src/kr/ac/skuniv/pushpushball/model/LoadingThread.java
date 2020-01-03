package kr.ac.skuniv.pushpushball.model;

import kr.ac.skuniv.pushpushball.view.BilliardTable;

public class LoadingThread extends Thread implements Runnable {
	MapData mapData;
	BilliardTable billiard;
	PlayerData playerdata;

	public LoadingThread(MapData mapData, BilliardTable billiard) {
		this.mapData = mapData;
		this.billiard = billiard;
	}

	/************* Thread Start *********************/
	public void run() {
		int count = 2;
		while (count-- > 0) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		TimeThread t = new TimeThread(mapData, billiard);
		t.start();
		mapData.loading_screen = 2;
		billiard.repaint();
	}
}
