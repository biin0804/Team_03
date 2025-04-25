package com.bok.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.DBCP;
import com.bok.model.SprtDAO;
import com.bok.model.SprtInfoVO;
import com.bok.model.SprtPersonVO;
import com.bok.model.SprtContentVO;
import com.bok.model.PagingVO;

public class SprtService {

	private SprtDAO dao;

	public SprtService() {
		dao = new SprtDAO();
	}

	// ī�װ� ��������
	public List<SprtInfoVO> getSprtInfo() {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getSprtInfo(session);
		} catch (Exception e) {
			return null;
		}
	}

	// ����ڿ��� ���� �������� ��ȿ�� ������ ���� ����
	public List<SprtPersonVO> getSprtPerson(int fkSprtNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getSprtPerson(session, fkSprtNum);
		} catch (Exception e) {
			return null;
		}
	}

	// ���� ���ڵ�� ��ư Ŭ�� �� ���� ���� ����
	public List<SprtContentVO> getSprtContent(int fkSprtpNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getSprtContent(session, fkSprtpNum);
		} catch (Exception e) {
			return null;
		}
	}

	// ����ڿ��� ���� ������ ���� ����(������ ��������)
	public List<SprtPersonVO> getBfSprtPerson(int fkSprtNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getBfSprtPerson(session, fkSprtNum);
		} catch (Exception e) {
			return null;
		}
	}

	// ����ڿ��� ī�װ��� �ش��ϴ� ���� ������ ���� ����(������ ��������, Pagination)
	public List<SprtPersonVO> getPagedBfSprtPerson(int fkSprtNum, PagingVO paging) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getPagedBfSprtPerson(session, fkSprtNum, paging);
		} catch (Exception e) {
			return null;
		}
	}

	// ī�װ��� �ش��ϴ� ��ü �Խù� �� ��ȸ
	public int getBfSprtPersonCount(int fkSprtNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getBfSprtPersonCount(session, fkSprtNum);
		} catch (Exception e) {
			return 0;
		}
	}
}
