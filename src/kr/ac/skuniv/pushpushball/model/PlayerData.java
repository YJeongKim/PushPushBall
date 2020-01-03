package kr.ac.skuniv.pushpushball.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PlayerData {
	ArrayList<String> name = new ArrayList<String>();
	HashMap<String, ArrayList<Integer>> data = new HashMap<String, ArrayList<Integer>>();

	private String player1, player2;

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public void sort() {
		FileWriter namefile = null;
		FileWriter ratefile = null;

		BufferedWriter namebuffer = null;
		BufferedWriter ratebuffer = null;
		try {
			namefile = new FileWriter("playdata/UserData.txt", false);
			namebuffer = new BufferedWriter(namefile);
			ratefile = new FileWriter("playdata/UserRate.txt", false);
			ratebuffer = new BufferedWriter(ratefile);
			Iterator it = sortByValue(data).iterator();
			name.clear();
			while (it.hasNext()) {
				String temp = (String) it.next();
				namebuffer.write(temp);
				namebuffer.newLine();
				Iterator<Integer> value = data.get(temp).iterator();
				while (value.hasNext()) {
					ratebuffer.write(value.next() + " ");
				}
				ratebuffer.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// BufferedWriter FileWriter¸¦ ´Ý¾ÆÁØ´Ù.
			if (namebuffer != null)
				try {
					namebuffer.close();
					ratebuffer.close();
				} catch (IOException e) {
				}
			if (namefile != null)
				try {
					namefile.close();
					ratefile.close();
				} catch (IOException e) {
				}
		}
	}
	
	public static List sortByValue(final HashMap<String, ArrayList<Integer>> map) {
		List<String> list = new ArrayList();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1).get(2);
				Object v2 = map.get(o2).get(2);
				return ((Comparable) v2).compareTo(v1);
			}
		});
		return list;
	}

	// ranking µî·Ï
	public void rankingEnrollment(int state) {
		nameRead();
		rateRead();
		// state== 1 -> 1p win
		if (state == 1) {
			boolean key = data.containsKey(player1);
			if (key) {
				int win = data.get(player1).get(0) + 1;
				int lose = data.get(player1).get(1);
				int rate = win * 100 / (win + lose);
				ArrayList<Integer> re_arr = new ArrayList<Integer>();
				re_arr.add(win);
				re_arr.add(lose);
				re_arr.add(rate);
				data.put(player1, re_arr);
			} else {
				int win = 1;
				int lose = 0;
				int rate = win * 100 / (win + lose);
				ArrayList<Integer> re_arr = new ArrayList<Integer>();
				re_arr.add(win);
				re_arr.add(lose);
				re_arr.add(rate);
				data.put(player1, re_arr);
			}
			key = data.containsKey(player2);
			if (key) {
				int win = data.get(player2).get(0);
				int lose = data.get(player2).get(1) + 1;
				int rate = win * 100 / (win + lose);
				ArrayList<Integer> re_arr = new ArrayList<Integer>();
				re_arr.add(win);
				re_arr.add(lose);
				re_arr.add(rate);
				data.put(player2, re_arr);
			} else {
				int win = 0;
				int lose = 1;
				int rate = win * 100 / (win + lose);
				ArrayList<Integer> re_arr = new ArrayList<Integer>();
				re_arr.add(win);
				re_arr.add(lose);
				re_arr.add(rate);
				data.put(player2, re_arr);
			}
		}
		// state== 2 -> 2p win
		else if (state == 2) {
			boolean key = data.containsKey(player1);
			if (key) {
				int win = data.get(player1).get(0);
				int lose = data.get(player1).get(1) + 1;
				int rate = win * 100 / (win + lose);
				ArrayList<Integer> re_arr = new ArrayList<Integer>();
				re_arr.add(win);
				re_arr.add(lose);
				re_arr.add(rate);
				data.put(player1, re_arr);
			} else {
				int win = 0;
				int lose = 1;
				int rate = win * 100 / (win + lose);
				ArrayList<Integer> re_arr = new ArrayList<Integer>();
				re_arr.add(win);
				re_arr.add(lose);
				re_arr.add(rate);
				data.put(player1, re_arr);
			}
			key = data.containsKey(player2);
			if (key) {
				int win = data.get(player2).get(0) + 1;
				int lose = data.get(player2).get(1);
				int rate = win * 100 / (win + lose);
				ArrayList<Integer> re_arr = new ArrayList<Integer>();
				re_arr.add(win);
				re_arr.add(lose);
				re_arr.add(rate);
				data.put(player2, re_arr);
			} else {
				int win = 1;
				int lose = 0;
				int rate = win * 100 / (win + lose);
				ArrayList<Integer> re_arr = new ArrayList<Integer>();
				re_arr.add(win);
				re_arr.add(lose);
				re_arr.add(rate);
				data.put(player2, re_arr);
			}
		}
	}

	public void dataClear() {
		data.clear();
		name.clear();
	}

	/*****************************************************************/
	// ÀÐ¾î¿È
	public ArrayList<String> nameRead() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("playdata/UserData.txt");
			br = new BufferedReader(fr);
			String s = null;
			int count = 0;
			
			while ((s = br.readLine()) != null) {
				name.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// BufferedReader FileReader¸¦ ´Ý¾ÆÁØ´Ù.
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
				}
		}
		return name;
	}

	public HashMap<String, ArrayList<Integer>> rateRead() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("playdata/UserRate.txt");
			br = new BufferedReader(fr);
			String s = null;
			int count = 0;
			
			while ((s = br.readLine()) != null) {
				String input[] = s.split(" ");

				ArrayList<Integer> arr = new ArrayList<Integer>();
				for (int i = 0; i < 3; i++) {
					arr.add(Integer.parseInt(input[i]));
				}
				data.put(name.get(count++), arr);
				

			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// BufferedReader FileReader¸¦ ´Ý¾ÆÁØ´Ù.
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
				}
		}
		return data;
	}

	public PlayerData() {
	}
}
