package com.hanbit.board.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CommonDAO {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			init();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private CommonDAO() {
		
	}

	private static void init() throws IOException {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSession openSession() {
		return sqlSessionFactory.openSession();
	}

}









