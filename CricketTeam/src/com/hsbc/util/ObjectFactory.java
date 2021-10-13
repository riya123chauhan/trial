package com.hsbc.util;

import com.hsbc.dao.PlayerDao;
import com.hsbc.dao.PlayerDaoImpl;

public class ObjectFactory {
	public static PlayerDao getPlayerDao() {
		return new PlayerDaoImpl();
	}

}
