package com.hsbc.dao;

import java.util.Set;
import java.util.TreeSet;

import com.hsbc.beans.Player;
import com.hsbc.exception.TeamNotFoundException;
import com.hsbc.util.Category;

public class PlayerDaoImpl implements PlayerDao {
	private static Set<Player> cricketTeam = new TreeSet<Player>();
	private static int batsman = 0;
	private static int bowler = 0;
	private static int wicketKeeper = 0;
	private static int allRounder = 0;

	@Override
	public void addPlayer(Player player) {
		cricketTeam.add(player);
		System.out.println("Size of the team: "+cricketTeam.size());
		if(player.getCategory() == Category.Batsman)
			batsman++;
		if(player.getCategory() == Category.Bowler)
			bowler++;
		if(player.getCategory() == Category.WicketKeeper)
			wicketKeeper++;
		if(player.getCategory() == Category.AllRounder)
			allRounder++;
		
	}

	@Override
	public Set<Player> formTeam() throws TeamNotFoundException {
		// check whether the size of the team is 11
				if(cricketTeam.size() != 11)
					throw new TeamNotFoundException("To form a team you need 11 players, currently the team size is: "+cricketTeam.size());
				if(batsman < 3 || bowler < 3 || wicketKeeper < 1 || allRounder > 4)
					throw new TeamNotFoundException("To form a team, proper comination is required with "
							+ "3-3-1: Batsman-Bowler-WicketKeeper, but Batsman: "+batsman
							+", Bowler: "+bowler+", WicketKeeper: "+wicketKeeper
							+", All Rounder: "+allRounder);
				return cricketTeam;
		
		
	}

}
