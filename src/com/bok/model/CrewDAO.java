package com.bok.model;

//import org.apache.ibatis.session.SqlSession;

public class CrewDAO {
	
	// �α���
	public String loginCrew(CrewVO vo) {
//		 NullPointException
		String name = "";
		try {
//			name = conn.selectOne("bokMapper.selectLogin", vo);
			if (name == null) {
				name = "�ٽ� Ȯ���ϼ���.";
			} 
//			return name;
			//conn.commit(); insert, update, delete�� ��� / ��ȸ�� X
		} catch (Exception e) {
//			conn.rollback();
		} finally {
//			conn.close();
		}
		return name;
	}
}
