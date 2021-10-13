package com.hsbc.dao;

import java.util.Set;

import com.hsbc.beans.Player;
import com.hsbc.exception.TeamNotFoundException;

public interface PlayerDao {
	
	public void addPlayer(Player player);
	public Set<Player> formTeam() throws TeamNotFoundException;

}
