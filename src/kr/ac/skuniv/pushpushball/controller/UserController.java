package kr.ac.skuniv.pushpushball.controller;

import kr.ac.skuniv.pushpushball.model.MapData;
import kr.ac.skuniv.pushpushball.view.BilliardTable;
import kr.ac.skuniv.pushpushball.view.Board;

public class UserController {
	MapData mapdata;
	BilliardTable billiard;
	Board board;

	public UserController(MapData mapdata, BilliardTable billiard, Board board) {
		this.mapdata = mapdata;
		this.billiard = billiard;
		this.board = board;
	}

	public int current_player;

	public void rightSwap() {
		boolean turn = mapdata.isTurn();
		if (current_player == 16) {
			if (turn == false) // turn이 2p면 x
				return;
			mapdata.setUser1();
		} else if (current_player == 17) {
			if (turn) // turn이 1p면 x
				return;
			mapdata.setUser2();
		}
		int x = mapdata.getUserX();
		int y = mapdata.getUserY();
		if (y + 1 >= 15)
			return;
		int current_value = mapdata.getMap(x, y + 1);
		if (current_value == 0) {
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				mapdata.setMap(x, y + 1, current_player);
				mapdata.setMap(x, y, current_value);
				board.pushsound();
			} else
				return;
		} else if (current_value > 0 && current_value < 8) {
			if (y + 2 >= 15)
				return;
			else if (current_player == 17)
				return;
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				if (mapdata.getMap(x, y + 2) == 8) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x, y + 1, current_player);
					mapdata.setMap(x, y + 2, 8);
					mapdata.player1[current_value - 1] = 1; // 공을 구멍에 넣으면 1 사라짐
					board.pushsound();
				} else if (mapdata.getMap(x, y + 2) == 0) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x, y + 1, current_player);
					mapdata.setMap(x, y + 2, current_value);
					board.pushsound();
				} else
					return;
			} else
				return;
		} else if (current_value > 8 && current_value < 16) {
			if (y + 2 >= 15)
				return;
			else if (current_player == 16)
				return;
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				if (mapdata.getMap(x, y + 2) == 8) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x, y + 1, current_player);
					mapdata.setMap(x, y + 2, 8);
					mapdata.player2[current_value - 9] = 1; // 공을 구멍에 넣으면 1 사라짐
					board.pushsound();
				} else if (mapdata.getMap(x, y + 2) == 0) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x, y + 1, current_player);
					mapdata.setMap(x, y + 2, current_value);
					board.pushsound();
				} else
					return;
			} else
				return;
		}
	}

	public void leftSwap() {
		boolean turn = mapdata.isTurn();
		if (current_player == 16) {
			if (turn == false) // turn이 2p면 x
				return;
			mapdata.setUser1();
		} else if (current_player == 17) {
			if (turn) // turn이 1p면 x
				return;
			mapdata.setUser2();
		}
		int x = mapdata.getUserX();
		int y = mapdata.getUserY();
		if (y - 1 < 0)
			return;
		int current_value = mapdata.getMap(x, y - 1);
		if (current_value == 0) {
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				mapdata.setMap(x, y - 1, current_player);
				mapdata.setMap(x, y, current_value);
				board.pushsound();
			} else
				return;
		} else if (current_value > 0 && current_value < 8) {
			if (y - 2 < 0)
				return;
			else if (current_player == 17)
				return;
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				if (mapdata.getMap(x, y - 2) == 8) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x, y - 1, current_player);
					mapdata.setMap(x, y - 2, 8);
					mapdata.player1[current_value - 1] = 1; // 공을 구멍에 넣으면 1 사라짐
					board.pushsound();
				} else if (mapdata.getMap(x, y - 2) == 0) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x, y - 1, current_player);
					mapdata.setMap(x, y - 2, current_value);
					board.pushsound();
				} else
					return;
			} else
				return;
		} else if (current_value > 8 && current_value < 16) {
			if (y - 2 < 0)
				return;
			else if (current_player == 16)
				return;
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				if (mapdata.getMap(x, y - 2) == 8) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x, y - 1, current_player);
					mapdata.setMap(x, y - 2, 8);
					mapdata.player2[current_value - 9] = 1; // 공을 구멍에 넣으면 1 사라짐
					board.pushsound();
				} else if (mapdata.getMap(x, y - 2) == 0) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x, y - 1, current_player);
					mapdata.setMap(x, y - 2, current_value);
					board.pushsound();
				} else
					return;
			} else
				return;
		}
	}

	public void upSwap() {
		boolean turn = mapdata.isTurn();
		if (current_player == 16) {
			if (turn == false) // turn이 2p면 x
				return;
			mapdata.setUser1();
		} else if (current_player == 17) {
			if (turn) // turn이 1p면 x
				return;
			mapdata.setUser2();
		}
		int x = mapdata.getUserX();
		int y = mapdata.getUserY();
		if (x - 1 < 0)
			return;
		int current_value = mapdata.getMap(x - 1, y);
		if (current_value == 0) {
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				mapdata.setMap(x - 1, y, current_player);
				mapdata.setMap(x, y, current_value);
				board.pushsound();
			} else
				return;
		} else if (current_value > 0 && current_value < 8) {
			if (x - 2 < 0)
				return;
			else if (current_player == 17)
				return;
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				if (mapdata.getMap(x - 2, y) == 8) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x - 1, y, current_player);
					mapdata.setMap(x - 2, y, 8);
					mapdata.player1[current_value - 1] = 1; // 공을 구멍에 넣으면 1 사라짐
					board.pushsound();
				} else if (mapdata.getMap(x - 2, y) == 0) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x - 1, y, current_player);
					mapdata.setMap(x - 2, y, current_value);
					board.pushsound();
				} else
					return;
			} else
				return;
		} else if (current_value > 8 && current_value < 16) {
			if (x - 2 < 0)
				return;
			else if (current_player == 16)
				return;
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				if (mapdata.getMap(x - 2, y) == 8) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x - 1, y, current_player);
					mapdata.setMap(x - 2, y, 8);
					mapdata.player2[current_value - 9] = 1; // 공을 구멍에 넣으면 1 사라짐
					board.pushsound();
				} else if (mapdata.getMap(x - 2, y) == 0) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x - 1, y, current_player);
					mapdata.setMap(x - 2, y, current_value);
					board.pushsound();
				} else
					return;
			} else
				return;
		}
	}

	public void downSwap() {
		boolean turn = mapdata.isTurn();
		if (current_player == 16) {
			if (turn == false) // turn이 2p면 x
				return;
			mapdata.setUser1();
		} else if (current_player == 17) {
			if (turn) // turn이 1p면 x
				return;
			mapdata.setUser2();
		}
		int x = mapdata.getUserX();
		int y = mapdata.getUserY();
		if (x + 1 >= 9)
			return;
		int current_value = mapdata.getMap(x + 1, y);
		if (current_value == 0) {
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				mapdata.setMap(x + 1, y, current_player);
				mapdata.setMap(x, y, current_value);
				board.pushsound();
			} else
				return;
		} else if (current_value > 0 && current_value < 8) {
			if (x + 2 >= 9)
				return;
			else if (current_player == 17)
				return;
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				if (mapdata.getMap(x + 2, y) == 8) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x + 1, y, current_player);
					mapdata.setMap(x + 2, y, 8);
					mapdata.player1[current_value - 1] = 1; // 공을 구멍에 넣으면 1 사라짐
					board.pushsound();
				} else if (mapdata.getMap(x + 2, y) == 0) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x + 1, y, current_player);
					mapdata.setMap(x + 2, y, current_value);
					board.pushsound();
				} else
					return;
			} else
				return;
		} else if (current_value > 8 && current_value < 16) {
			if (x + 2 >= 9)
				return;
			else if (current_player == 16)
				return;
			if (mapdata.getDiceresult() > 0) {
				mapdata.setDiceresult(mapdata.getDiceresult() - 1);
				if (mapdata.getMap(x + 2, y) == 8) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x + 1, y, current_player);
					mapdata.setMap(x + 2, y, 8);
					mapdata.player2[current_value - 9] = 1; // 공을 구멍에 넣으면 1 사라짐
					board.pushsound();
				} else if (mapdata.getMap(x + 2, y) == 0) {
					mapdata.setMap(x, y, 0);
					mapdata.setMap(x + 1, y, current_player);
					mapdata.setMap(x + 2, y, current_value);
					board.pushsound();
				} else
					return;
			} else
				return;
		}
	}
}
