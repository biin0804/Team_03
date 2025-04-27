package com.bok.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.DBCP;
import com.bok.model.PagingVO;
import com.bok.model.SprtContentVO;
import com.bok.model.SprtDAO;
import com.bok.model.SprtManagerDAO;
import com.bok.model.SprtPersonVO;

public class SprtManagerService {

	private SprtManagerDAO dao;
	private SprtDAO sprtDao;

	public SprtManagerService() {
		dao = new SprtManagerDAO();
		sprtDao = new SprtDAO();
	}

	//������ ���� ������ư - ���� ������ ���� �ҷ�����
	public SprtPersonVO getSprtPerson(int sprtpNum){
		try(SqlSession session = DBCP.getSqlSessionFactory().openSession()){
			return dao.getSprtPerson(session, sprtpNum);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}

	//������ ���� ������ư - �� ������ ���� �ҷ�����
	public List<SprtContentVO> getSprtContent(int sprtpNum){
		try(SqlSession session = DBCP.getSqlSessionFactory().openSession()){
			return dao.getSprtContent(session, sprtpNum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//������ ���� �߰�(pulus ��ư) �� ���� ��ư(person & content - insert)
	//Ư�� ������ ���� ���� �����ϱ� ���� �� �߰� ��ư(insert)
	public boolean setAddSprt(SprtPersonVO sp, List<SprtContentVO> scList) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			boolean result = dao.setAddSprt(session, sp, scList);
			if (result) {
				session.commit();   // ���������� Ŀ��
			} else {
				session.rollback(); // ���������� �ѹ�
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//Ư�� ������ ���� ���� ���� ���� ��ư(update)
	public boolean setSprt(SprtPersonVO sp, List<SprtContentVO> scList) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			boolean result = dao.setSprt(session, sp, scList);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//������ ���� ������ ���� ���� ������ư ������ ���â �� �� ��¥ ���� 
	//Ư�� ������ ���� ��ü(person&content) ���� ��ư(delete)
	public boolean removeSprt(int sprtpNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			boolean result = dao.removeSprt(session, sprtpNum);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//������ �з� �߰� �� ���� ��ư(ī�װ� insert)
	public boolean addSprtCategory(String category) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			boolean result = dao.addSprtCategory(session, category);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//���� ������ ���� ������ ī�װ� ����(û��, ����, �ູ���� ��)
	//����ڿ��� ���� ������ ���� ����(������ ��������)
	public List<SprtPersonVO> getBfSprtPerson(int fkSprtNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getBfSprtPerson(session, fkSprtNum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ����¡ ���� - Ư�� ī�װ��� ������ ����Ʈ ��������
	public List<SprtPersonVO> getBfSprtPerson(int fkSprtNum, PagingVO paging) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getPagedBfSprtPersonM(session, fkSprtNum, paging);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Ư�� ī�װ��� ��ü �� �� ��������
	public int getBfSprtPersonCount(int fkSprtNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return sprtDao.getBfSprtPersonCount(session, fkSprtNum);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
