package kr.ac.skuniv.pushpushball.view;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import kr.ac.skuniv.pushpushball.model.PlayerData;

public class Rank extends JPanel {
	ImageIcon rank, back;
	private Font font;
	private PlayerData playerdata;
	private HashMap<String, ArrayList<Integer>> data = new HashMap<String, ArrayList<Integer>>();
	private ArrayList<String> name = new ArrayList<String>();
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(rank.getImage(), 0, 0, getWidth(), getHeight(), null);
		g.drawImage(back.getImage(), 15, 30, 55, 55, null);
		font = new Font("À±°íµñ", Font.BOLD, 50);
		g.setFont(font);
		//name
		for (int i = 0 ; i < name.size(); i++) {
			if (i == 5) break;
			g.drawString(name.get(i), 190, (i*95)+190);
		}
		//rate
		for (int i = 0 ; i < name.size(); i++) {
			if (i == 5) break;
			String name_str = name.get(i);
			g.drawString(String.valueOf(data.get(name_str).get(0)), 430, (i*95)+190);
			g.drawString(String.valueOf(data.get(name_str).get(1)), 540, (i*95)+190);
			g.drawString(String.valueOf(data.get(name_str).get(2))+"%", 650, (i*95)+190);
		}
		setOpaque(false);
	}

	public Rank(PlayerData playerdata) {
		this.playerdata = playerdata;
		playerdata.dataClear();
		name = playerdata.nameRead();
		data = playerdata.rateRead();
		rank = new ImageIcon("image/rank.png");
		back = new ImageIcon("image/back.png");
	}
}
