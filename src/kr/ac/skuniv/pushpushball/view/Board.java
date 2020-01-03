package kr.ac.skuniv.pushpushball.view;

import java.awt.Container;
import java.awt.Dimension;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import kr.ac.skuniv.pushpushball.controller.IntroController;
import kr.ac.skuniv.pushpushball.model.MapData;
import kr.ac.skuniv.pushpushball.model.PlayerData;

public class Board {
	JFrame frame = new JFrame("PUSH PUSH BALL");
	Container contentPane = frame.getContentPane();
	MapData mapdata = new MapData();
	BilliardTable billiard = new BilliardTable(mapdata);
	Intro intro = new Intro(mapdata);
	AudioInputStream ais;
	Clip clip;
	PlayerData playerdata = new PlayerData();

	public Board() {
		intro.introbgmplay();
		intro.addMouseListener(new IntroController(intro, this, mapdata, billiard, contentPane, frame, playerdata));
		intro.addMouseMotionListener(
				new IntroController(intro, this, mapdata, billiard, contentPane, frame, playerdata));
		contentPane.add(intro);
		frame.setLocation(500, 20);
		frame.setPreferredSize(new Dimension(950, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public void pushsound() {
		try {
			ais = AudioSystem.getAudioInputStream(new File("push.wav"));
			clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (Exception e) {
			System.out.println("에러");
		}
	}

	public void spacebarsound() {
		try {
			ais = AudioSystem.getAudioInputStream(new File("spacebar.wav"));
			clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (Exception e) {
			System.out.println("에러");
		}
	}

	public void startsound() {
		try {
			ais = AudioSystem.getAudioInputStream(new File("start.wav"));
			clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (Exception e) {
			System.out.println("에러");
		}
	}
}