package kr.ac.skuniv.pushpushball.model;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MapData extends JPanel {
	Toolkit toolkit = getToolkit();
	public int checkEntered = 0;
	public int ball = 0;
	private boolean input_check = false; // false -> no , true -> yes 
	public int loading_screen = 0; // 0 -> 메뉴, 1 -> 로딩 , 2 -> 게임실행
	public boolean creators_screen = false; // false -> 메뉴 , true -> 화면실행
	public boolean manual_screen = false; // false -> 메뉴 , true -> 화면실행
	public boolean rank_screen = false; // false -> 메뉴 , true -> 화면실행
	public boolean threadrunning = true;
	public boolean isInput_check() {
		return input_check;
	}
	public void setInput_check(boolean input_check) {
		this.input_check = input_check;
	}
	
	public int player1[] = { 0, 0, 0, 0, 0, 0, 0 }; // 공이 안들어간 상태
	public int player2[] = { 0, 0, 0, 0, 0, 0, 0 }; // 공이 안들어간 상태
	private int count1;
	private int count2;
	
	public int getCount1() {
		count1=0;
		for(int i=0; i<7; ++i)
			this.count1 += player1[i];
		return count1;
	}

	public int getCount2() {
		count2=0;
		for(int i=0; i<7; ++i)
			this.count2 += player2[i];
		return count2;
	}
	// game finish
	public int judgment() {
		if(getCount1()==7 || getCount2()==7){
			return count1 > count2 ? 1 : 2;
		} 
		else return 0;
	}
	/************** Time Data ***************/
	private int minutes = 3;
	private int seconds = 30;

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	private int player1seconds = 10;

	public int getPlayer1Seconds() {
		return player1seconds;
	}

	public void setPlayer1Seconds(int player1seconds) {
		this.player1seconds = player1seconds;
	}

	private int player2seconds = 10;

	public int getPlayer2Seconds() {
		return player2seconds;
	}

	public void setPlayer2Seconds(int player2seconds) {
		this.player2seconds = player2seconds;
	}

	/***************************************/

	/************** turn data ****************/
	private boolean turn = true; // true -> 1P , false -> 2P

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	private boolean dice_turn = false; // false -> 안굴림 , true -> 굴림

	public boolean isDice_turn() {
		return dice_turn;
	}

	public void setDice_turn(boolean dice_turn) {
		this.dice_turn = dice_turn;
	}

	/**************************************/

	/************* move count data ***************/
	private int diceresult = 0;

	public int getDiceresult() {
		return diceresult;
	}

	public void setDiceresult(int diceresult) {
		this.diceresult = diceresult;
	}

	// 주사위 랜덤
	public int[] dice = new int[2];

	public int Rolldice() {
		for (int i = 0; i < 2; i++) {
			dice[i] = (int) ((Math.random() * 6 + 1));
			diceresult += dice[i];
		}
		return diceresult;
	}

	/*********************************************/

	public MapData() {
	}

	public int map[][] = { { 8, 0, 12, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 8 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 13, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 16, 0, 0, 17, 0, 15, 0, 0, 0, 0 },
			{ 0, 0, 0, 5, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 4, 0, 3, 0, 0, 9, 2, 0 },
			{ 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 8, 0, 0, 0, 0, 14, 0, 8, 0, 0, 10, 0, 0, 0, 8 } };

//	public int map[][] = { 
//			{ 8, 0, 12, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 8 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
//			{ 0, 13, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0 }, 
//			{ 0, 0, 0, 0, 0, 0, 0, 4, 1, 0, 0, 0, 0, 0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
//			{ 8, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 8 } 
//			};
//	
	
	public void setMap(int x, int y, int value) {
		this.map[x][y] = value;
	}

	public int getMap(int x, int y) {
		return this.map[x][y];
	}

	private int user_x, user_y;

	public void setUser1() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (this.map[i][j] == 16) {
					this.user_x = i;
					this.user_y = j;
					break;
				}
			}
		}
	}

	public void setUser2() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (this.map[i][j] == 17) {
					this.user_x = i;
					this.user_y = j;
					break;
				}
			}
		}
	}

	public int getUserX() {
		return this.user_x;
	}

	public int getUserY() {
		return this.user_y;
	}

	private String panImage_path[] = { "image/table.png", "image/ball/1.png", "image/ball/2.png", "image/ball/3.png",
			"image/ball/4.png", "image/ball/5.png", "image/ball/6.png", "image/ball/7.png", "image/hole.png",
			"image/ball/9.png", "image/ball/10.png", "image/ball/11.png", "image/ball/12.png", "image/ball/13.png",
			"image/ball/14.png", "image/ball/15.png", "image/player/1p.png", "image/player/2p.png" };
	public Image panImage[] = new Image[panImage_path.length];

	public void setPanImage() {
		for (int i = 0; i < panImage_path.length; i++) {
			panImage[i] = toolkit.getImage(panImage_path[i]);
		}
	}
}