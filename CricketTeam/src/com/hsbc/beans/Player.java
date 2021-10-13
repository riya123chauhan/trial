package com.hsbc.beans;

import com.hsbc.util.Category;

public class Player implements Comparable<Player> {
	private String name;
	private Category category;
	private int rank;
	
	
	

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (rank != other.rank)
			return false;
		return true;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", category=" + category + ", rank=" + rank + "]";
	}



	public Player(String name, Category category, int rank) {
		super();
		this.name = name;
		this.category = category;
		this.rank = rank;
	}



	@Override
	public int compareTo(Player o) {
		
		
		return Integer.compare(getRank(), o.getRank());
	}

}
