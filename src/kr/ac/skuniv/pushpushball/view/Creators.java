package kr.ac.skuniv.pushpushball.view;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Creators extends JPanel {
	ImageIcon creators, back;

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(creators.getImage(), 0, 0, getWidth(), getHeight(), null);
		g.drawImage(back.getImage(), 15, 225, 55, 55, null);
		setOpaque(false);
	}

	public Creators() {
		creators = new ImageIcon("image/creators.jpg");
		back = new ImageIcon("image/back.png");
	}
}
