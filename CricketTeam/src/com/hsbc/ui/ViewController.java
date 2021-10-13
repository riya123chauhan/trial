package com.hsbc.ui;

import java.util.Scanner;
import java.util.Set;

import com.hsbc.beans.Player;
import com.hsbc.dao.PlayerDao;
import com.hsbc.exception.TeamNotFoundException;
import com.hsbc.util.Category;
import com.hsbc.util.ObjectFactory;

public class ViewController {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int menuOption = 0;
		PlayerDao dao = ObjectFactory.getPlayerDao();
		do {
			System.out.println("Welcome! Please select the action you want to perform");
			System.out.println("1: Add Players to the repository\n2: Form Team\n3: Exit");
			menuOption = scan.nextInt();
			switch (menuOption) {
			case 1:
				System.out.println("Enter the number of players you want to add");
				int playersInTeam = scan.nextInt();
				for (int i = 1; i <= playersInTeam; i++) {
					System.out.println("Enter name");
					String name = scan.next();
					System.out.println("Enter category option 1: Batsman 2: Bowler 3: Wicket Keeper 4: All Rounder");
					Category category = null;
					int categoryOption = scan.nextInt();
					if (categoryOption == 1)
						category = Category.Batsman;
					else if (categoryOption == 2)
						category = Category.Bowler;
					else if (categoryOption == 3)
						category = Category.WicketKeeper;
					else if (categoryOption == 4)
						category = Category.AllRounder;
					else
						category = Category.AllRounder;
					System.out.println("Enter rank");
					int rank = scan.nextInt();
					Player player = new Player(name, category, rank);
					dao.addPlayer(player);
					System.out.println("--------------------------------------------------");
				}
				break;
			case 2:
				try {
					Set<Player> players = dao.formTeam();
					int counter = 0;
					System.out.println("Sl\t\tPlayer Name\t\tCategory\t\tRank\t\t");
					for (Player play : players) {
						counter++;
						System.out.println(counter + "\t\t" + play.getName() + "\t\t" + play.getCategory() + "\t\t"
								+ play.getRank());
					}
				} catch (TeamNotFoundException e) {
					System.err.println(e.getMessage());
				}
				break;
			}
		} while (menuOption != 3);
		scan.close();
	}

}
