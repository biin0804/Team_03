package com.bok.model;

import java.util.Collection;

import org.apache.ibatis.session.SqlSession;

public class SoloAskDAO {

	// 1 : 1 �����ϱ� ���
	public Collection<SoloAskVO> getSoloAsk() {

		Collection<SoloAskVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();

		try {
			list = conn.selectList("bokMapper.getSoloAsk");
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		return list;
	}

	// 1 : 1 �����ϱ� �̸��� �˻�
	public Collection<SoloAskVO> searchEmail(String email) {

		Collection<SoloAskVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();

		try {
			list = conn.selectList("bokMapper.searchEmail", email);
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
		return list;
	}
	
	// 1 : 1 �����ϱ� �۾���
	public boolean addSoloAsk (SoloAskVO vo) {
		
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		boolean result = false;
		try {
			int i = conn.insert("bokMapper.addSoloAsk", vo);
			if (i == 1) {
				conn.commit();
				result = true;
			}
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
		return result;
	}
	
	// 1 : 1 �����ϱ� �󼼺���
	public SoloAskVO soloAskDetail(SoloAskVO vo) {

		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		SoloAskVO sav = null;
		try {
			sav = conn.selectOne("bokMapper.askDetail", vo);
			
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
		return sav;
	}
	
	// title, content, answer�� ��������
//	public String soloAskDetail(SoloAskVO vo) {
//
//		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
//		SoloAskVO sav = null;
//		try {
//			sav = conn.selectOne("bokMapper.askDetail", vo);
//			
//		} catch (Exception e) {
//			conn.rollback();
//		} finally {
//			conn.close();
//		}
//		return sav.getAskTitle() + sav.getSoloContent() + sav.getSoloAnswer();
//	}
}
