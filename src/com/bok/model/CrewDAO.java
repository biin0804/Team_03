package com.bok.model;

import org.apache.ibatis.session.SqlSession;

public class CrewDAO {
	
	// �α���
	public String loginCrew(CrewVO vo) {
		// NullPointException
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		String name = "";
		try {
			name = conn.selectOne("bokMapper.selectLogin", vo);
			if (name == null) {
				name = "�ٽ� Ȯ���ϼ���.";
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
		return name;
	}
}
