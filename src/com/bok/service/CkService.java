package com.bok.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.CkContentVO;
import com.bok.model.CkDAO;
import com.bok.model.CkVO;
import com.bok.model.DBCP;

public class CkService {

	private CkDAO dao;

	public CkService() {
		dao = new CkDAO();
	}

	// üũ����Ʈ ī�װ� ��ü ��������
	public List<CkVO> getCkCategory() {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getCkCategory(session);
		} catch (Exception e) {
			return null;
		}
	}

	// Ư�� ī�װ� �̸����� �ֽ� ī�װ� ���� ��������
	public CkVO getLatestCk(String category) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getLatestCk(session, category);
		} catch (Exception e) {
			return null;
		}
	}

	// Ư�� ck_num�� �ش��ϴ� üũ����Ʈ �׸� ��������
	public List<CkContentVO> getCkContent(int ckNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getCkContent(session, ckNum);
		} catch (Exception e) {
			return null;
		}
	}

	// ī�װ� �߰�(categoryName�� �޾Ƽ� ���� VO ����� DB insert)
	public String addCkCategory(String categoryName) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			CkVO vo = new CkVO();
			vo.setCategory(categoryName);
			vo.setTip(null); // tip�� null
			vo.setDate(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

			int result = dao.addckCategory(session, vo);
			session.commit();

			if (result > 0) {
				return categoryName;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	// ī�װ� �߰��ϰ� �Ѿ ȭ�鿡�� ���� ��ư
	public boolean saveCkContents(int ckNum, String tip, List<CkContentVO> contentList) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {

			// TIP ������Ʈ
			CkVO ckVo = new CkVO();
			ckVo.setCkNum(ckNum);
			ckVo.setTip(tip);
			int tipResult = dao.setTip(session, ckVo);

			// ����/���� insert
			int contentResult = 0;
			for (CkContentVO contentVo : contentList) {
				contentVo.setFkCkNum(ckNum); // fk ����
				contentResult += dao.addCkContent(session, contentVo);
			}

			// ��ü Ŀ��
			session.commit();

			// TIP ������ ���� �߰��� �� �� �����ߴ��� üũ
			return tipResult > 0 && contentResult == contentList.size();
		} catch (Exception e) {
			return false;
		}
	}

	// ī�װ� �߰��ϰ� �Ѿ ȭ�鿡�� ��� ��ư
	public boolean cancelCkCategory(int ckNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {

			// üũ����Ʈ ���� ���� ����
			dao.deleteCkContents(session, ckNum);

			// ī�װ� ����
			int result = dao.deleteCk(session, ckNum);

			session.commit();

			return result > 0;
		} catch (Exception e) {
			return false;
		}
	}
}