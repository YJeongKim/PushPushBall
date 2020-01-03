package kr.ac.skuniv.pushpushball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import kr.ac.skuniv.pushpushball.model.MapData;

@SuppressWarnings("serial")
public class BilliardTable extends JPanel {
	MapData mapData;
	ImageIcon base, roll, mario, luigi, background, ballpan1p, ballpan2p, clock, loading, creators;
	ImageIcon b1, b2, b3, b4, b5, b6, b7, b9, b10, b11, b12, b13, b14, b15; // ball
	ImageIcon dice1, dice2, d1, d2, d3, d4, d5, d6; // dice

	public BilliardTable(MapData mapData) {
		mapData.setPanImage();
		this.mapData = mapData;
		background = new ImageIcon("image/background.jpg");
		base = new ImageIcon("image/base.jpg");
		roll = new ImageIcon("image/roll.png");
		mario = new ImageIcon("image/player/mario.png");
		luigi = new ImageIcon("image/player/luigi.png");
		ballpan1p = new ImageIcon("image/ballpan.png");
		ballpan2p = new ImageIcon("image/ballpan.png");
		clock = new ImageIcon("image/clock.png");
		loading = new ImageIcon("image/loading.png");
		creators = new ImageIcon("image/creators.jpg");
		// Ball Image
		b1 = new ImageIcon("image/ball/1.png");
		b2 = new ImageIcon("image/ball/2.png");
		b3 = new ImageIcon("image/ball/3.png");
		b4 = new ImageIcon("image/ball/4.png");
		b5 = new ImageIcon("image/ball/5.png");
		b6 = new ImageIcon("image/ball/6.png");
		b7 = new ImageIcon("image/ball/7.png");
		b9 = new ImageIcon("image/ball/9.png");
		b10 = new ImageIcon("image/ball/10.png");
		b11 = new ImageIcon("image/ball/11.png");
		b12 = new ImageIcon("image/ball/12.png");
		b13 = new ImageIcon("image/ball/13.png");
		b14 = new ImageIcon("image/ball/14.png");
		b15 = new ImageIcon("image/ball/15.png");
		// Dice Image
		d1 = new ImageIcon("image/dice/1.png");
		d2 = new ImageIcon("image/dice/2.png");
		d3 = new ImageIcon("image/dice/3.png");
		d4 = new ImageIcon("image/dice/4.png");
		d5 = new ImageIcon("image/dice/5.png");
		d6 = new ImageIcon("image/dice/6.png");
	}

	// Image draw Method
	public void paintComponent(Graphics g) {
		if (mapData.loading_screen == 1) {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawImage(loading.getImage(), 0, 0, getWidth(), getHeight(), null);
		} else if (mapData.creators_screen) {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawImage(creators.getImage(), 0, 0, getWidth(), getHeight(), null);
		} else {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawImage(background.getImage(), 0, 0, 950, 1000, null);
			g.drawImage(base.getImage(), 60, 100, 810, 510, null);
			g.drawImage(roll.getImage(), 360, 875, 220, 66, null);
			g.drawImage(mario.getImage(), 55, 600, 220, 220, null);
			g.drawImage(luigi.getImage(), 670, 600, 200, 220, null);
			g.drawImage(ballpan1p.getImage(), 15, 873, 300, 67, null);
			g.drawImage(ballpan2p.getImage(), 620, 873, 300, 67, null);
			// 1Player
			if (mapData.player1[0] == 0)
				g.drawImage(b1.getImage(), 25, 885, 40, 40, null);
			if (mapData.player1[1] == 0)
				g.drawImage(b2.getImage(), 65, 885, 40, 40, null);
			if (mapData.player1[2] == 0)
				g.drawImage(b3.getImage(), 105, 885, 40, 40, null);
			if (mapData.player1[3] == 0)
				g.drawImage(b4.getImage(), 145, 885, 40, 40, null);
			if (mapData.player1[4] == 0)
				g.drawImage(b5.getImage(), 185, 885, 40, 40, null);
			if (mapData.player1[5] == 0)
				g.drawImage(b6.getImage(), 225, 885, 40, 40, null);
			if (mapData.player1[6] == 0)
				g.drawImage(b7.getImage(), 265, 885, 40, 40, null);
			// 2Player
			if (mapData.player2[0] == 0)
				g.drawImage(b9.getImage(), 630, 885, 40, 40, null);
			if (mapData.player2[1] == 0)
				g.drawImage(b10.getImage(), 670, 885, 40, 40, null);
			if (mapData.player2[2] == 0)
				g.drawImage(b11.getImage(), 710, 885, 40, 40, null);
			if (mapData.player2[3] == 0)
				g.drawImage(b12.getImage(), 750, 885, 40, 40, null);
			if (mapData.player2[4] == 0)
				g.drawImage(b13.getImage(), 790, 885, 40, 40, null);
			if (mapData.player2[5] == 0)
				g.drawImage(b14.getImage(), 830, 885, 40, 40, null);
			if (mapData.player2[6] == 0)
				g.drawImage(b15.getImage(), 870, 885, 40, 40, null);

			switch (mapData.dice[0]) {
			case 0:
			case 1:
				g.drawImage(d1.getImage(), 310, 650, 150, 150, null);
				break;
			case 2:
				g.drawImage(d2.getImage(), 310, 650, 150, 150, null);
				break;
			case 3:
				g.drawImage(d3.getImage(), 310, 650, 150, 150, null);
				break;
			case 4:
				g.drawImage(d4.getImage(), 310, 650, 150, 150, null);
				break;
			case 5:
				g.drawImage(d5.getImage(), 310, 650, 150, 150, null);
				break;
			case 6:
				g.drawImage(d6.getImage(), 310, 650, 150, 150, null);
				break;
			}
			switch (mapData.dice[1]) {
			case 0:
			case 1:
				g.drawImage(d1.getImage(), 480, 650, 150, 150, null);
				break;
			case 2:
				g.drawImage(d2.getImage(), 480, 650, 150, 150, null);
				break;
			case 3:
				g.drawImage(d3.getImage(), 480, 650, 150, 150, null);
				break;
			case 4:
				g.drawImage(d4.getImage(), 480, 650, 150, 150, null);
				break;
			case 5:
				g.drawImage(d5.getImage(), 480, 650, 150, 150, null);
				break;
			case 6:
				g.drawImage(d6.getImage(), 480, 650, 150, 150, null);
				break;
			}

			g.drawImage(clock.getImage(), 120, 10, 700, 80, null);
			g.setColor(Color.black);
			g.setFont(new Font("Lithos Pro Regular", Font.BOLD, 70));
			String totaltime = "";
			int minutes = mapData.getMinutes();
			totaltime += minutes < 10 ? "0" + minutes : minutes;
			totaltime += " : ";
			int seconds = mapData.getSeconds();
			totaltime += seconds < 10 ? "0" + seconds : seconds;

			g.drawString(" Time  " + totaltime, 260, 75);
			g.setFont(new Font("Lithos Pro Regular", Font.BOLD, 30));
			String play1time = "00 : ";
			int play1seconds = mapData.getPlayer1Seconds();
			play1time += play1seconds < 10 ? "0" + play1seconds : play1seconds;
			g.drawString(" Time  " + play1time, 55, 850);
			String play2time = "00 : ";
			int play2seconds = mapData.getPlayer2Seconds();
			play2time += play2seconds < 10 ? "0" + play2seconds : play2seconds;
			g.drawString(" Time  " + play2time, 670, 850);

			g.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
			g.drawString("" + mapData.getDiceresult(), 455, 850);	
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 15; j++) {
					g.drawImage(mapData.panImage[mapData.map[i][j]], j * 50 + 90, i * 50 + 130, 50, 50, this);
				}
			}
		}
	}
}
