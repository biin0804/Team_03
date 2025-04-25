package com.bok.service;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.CrewDAO;
import com.bok.model.CrewVO;
import com.bok.model.DBCP;

public class CrewService {

	private CrewDAO cdao;
	
	public CrewService() {
		cdao = new CrewDAO();
	}
	
	public String loginCrew(CrewVO vo) {
		// NullPointException
		try {
			SqlSession session = DBCP.getSqlSessionFactory().openSession(); // try �ȿ� �־������ mybatis�� �ڵ����� conn.close() ����
			return cdao.loginCrew(session, vo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
