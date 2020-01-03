package kr.ac.skuniv.pushpushball.view;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import kr.ac.skuniv.pushpushball.model.MapData;

public class Intro extends JPanel {
	Board board;
	MapData mapData = new MapData();
	ImageIcon background, logo, startbutton1, manualbutton1, rankbutton1, creatorsbutton1, exitbutton1, startbutton2,
			manualbutton2, rankbutton2, creatorsbutton2, exitbutton2;
	JPanel buttonpanel;
	AudioInputStream ais;
	Clip clip;

	public void paintComponent(Graphics g) {
		if (mapData.checkEntered == 0) {
			g.drawImage(background.getImage(), 0, 0, 950, 1070, null);
			g.drawImage(logo.getImage(), 160, -30, 700, 400, null);
			g.drawImage(startbutton1.getImage(), 360, 400, 220, 66, null);
			g.drawImage(manualbutton1.getImage(), 360, 500, 220, 66, null);
			g.drawImage(rankbutton1.getImage(), 360, 600, 220, 66, null);
			g.drawImage(creatorsbutton1.getImage(), 360, 700, 220, 66, null);
			g.drawImage(exitbutton1.getImage(), 360, 800, 220, 66, null);
		} else if (mapData.checkEntered == 1) {
			g.drawImage(background.getImage(), 0, 0, 950, 1070, null);
			g.drawImage(logo.getImage(), 160, -30, 700, 400, null);
			g.drawImage(startbutton2.getImage(), 360, 400, 220, 66, null);
			g.drawImage(manualbutton1.getImage(), 360, 500, 220, 66, null);
			g.drawImage(rankbutton1.getImage(), 360, 600, 220, 66, null);
			g.drawImage(creatorsbutton1.getImage(), 360, 700, 220, 66, null);
			g.drawImage(exitbutton1.getImage(), 360, 800, 220, 66, null);
		} else if (mapData.checkEntered == 2) {
			g.drawImage(background.getImage(), 0, 0, 950, 1070, null);
			g.drawImage(logo.getImage(), 160, -30, 700, 400, null);
			g.drawImage(startbutton1.getImage(), 360, 400, 220, 66, null);
			g.drawImage(manualbutton2.getImage(), 360, 500, 220, 66, null);
			g.drawImage(rankbutton1.getImage(), 360, 600, 220, 66, null);
			g.drawImage(creatorsbutton1.getImage(), 360, 700, 220, 66, null);
			g.drawImage(exitbutton1.getImage(), 360, 800, 220, 66, null);
		} else if (mapData.checkEntered == 3) {
			g.drawImage(background.getImage(), 0, 0, 950, 1070, null);
			g.drawImage(logo.getImage(), 160, -30, 700, 400, null);
			g.drawImage(startbutton1.getImage(), 360, 400, 220, 66, null);
			g.drawImage(manualbutton1.getImage(), 360, 500, 220, 66, null);
			g.drawImage(rankbutton2.getImage(), 360, 600, 220, 66, null);
			g.drawImage(creatorsbutton1.getImage(), 360, 700, 220, 66, null);
			g.drawImage(exitbutton1.getImage(), 360, 800, 220, 66, null);
		} else if (mapData.checkEntered == 4) {
			g.drawImage(background.getImage(), 0, 0, 950, 1070, null);
			g.drawImage(logo.getImage(), 160, -30, 700, 400, null);
			g.drawImage(startbutton1.getImage(), 360, 400, 220, 66, null);
			g.drawImage(manualbutton1.getImage(), 360, 500, 220, 66, null);
			g.drawImage(rankbutton1.getImage(), 360, 600, 220, 66, null);
			g.drawImage(creatorsbutton2.getImage(), 360, 700, 220, 66, null);
			g.drawImage(exitbutton1.getImage(), 360, 800, 220, 66, null);
		} else if (mapData.checkEntered == 5) {
			g.drawImage(background.getImage(), 0, 0, 950, 1070, null);
			g.drawImage(logo.getImage(), 160, -30, 700, 400, null);
			g.drawImage(startbutton1.getImage(), 360, 400, 220, 66, null);
			g.drawImage(manualbutton1.getImage(), 360, 500, 220, 66, null);
			g.drawImage(rankbutton1.getImage(), 360, 600, 220, 66, null);
			g.drawImage(creatorsbutton1.getImage(), 360, 700, 220, 66, null);
			g.drawImage(exitbutton2.getImage(), 360, 800, 220, 66, null);
		}
		setOpaque(false);
	}

	public void introbgmplay() {
		try {
			ais = AudioSystem.getAudioInputStream(new File("introbgm.wav"));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			clip.loop(-1);
		} catch (Exception e) {
			System.out.println("에러");
		}
	}

	public void gamebgmplay() {
		try {
			ais = AudioSystem.getAudioInputStream(new File("boardbgm.wav"));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
			clip.loop(-1);
		} catch (Exception e) {
			System.out.println("에러");
		}
	}
	
	public void stopbgm() {
		clip.stop();
	}

	public Intro(MapData mapData) {
		setLayout(null);
		this.mapData = mapData;

		background = new ImageIcon("image/intro/introBackground.jpg");
		logo = new ImageIcon("image/intro/logo.png");
		startbutton1 = new ImageIcon("image/intro/startbutton1.png");
		manualbutton1 = new ImageIcon("image/intro/manualbutton1.png");
		rankbutton1 = new ImageIcon("image/intro/rankbutton1.png");
		creatorsbutton1 = new ImageIcon("image/intro/creatorsbutton1.png");
		exitbutton1 = new ImageIcon("image/intro/exitbutton1.png");
		startbutton2 = new ImageIcon("image/intro/startbutton2.png");
		manualbutton2 = new ImageIcon("image/intro/manualbutton2.png");
		rankbutton2 = new ImageIcon("image/intro/rankbutton2.png");
		creatorsbutton2 = new ImageIcon("image/intro/creatorsbutton2.png");
		exitbutton2 = new ImageIcon("image/intro/exitbutton2.png");
	}
}
