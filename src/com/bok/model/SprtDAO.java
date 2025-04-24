package com.bok.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class SprtDAO {

	//ī�װ� ��������
	public List<SprtInfoVO> getSprtInfo() {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			return conn.selectList("bokMapper.getSprtInfo");
		}catch (Exception e) {
			return null;
		}
	}

	//����ڿ��� ���� �������� ��ȿ�� ������ ���� ����
	public List<SprtPersonVO> getSprtPerson(int fkSprtNum) {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			return conn.selectList("bokMapper.getSprtPerson", fkSprtNum);
		}catch (Exception e) {
			return null;
		}
	}

	//���� ���ڵ�� ��ư Ŭ�� �� ���� ���� ����
	public List<SprtContentVO> getSprtContent(int fkSprtpNum) {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			return conn.selectList("bokMapper.getSprtContent", fkSprtpNum);
		}catch (Exception e) {
			return null;
		}
	}

	//����ڿ��� ���� ������ ���� ����(������ ��������)
	public List<SprtPersonVO> getBfSprtPerson(int fkSprtNum) {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			return conn.selectList("bokMapper.getBfSprtPerson", fkSprtNum);
		}catch (Exception e) {
			return null;
		}
	}

	//����ڿ��� ī�װ��� �ش��ϴ� ���� ������ ���� ����(������ ��������, Pagination)
	public List<SprtPersonVO> getPagedBfSprtPerson(int fkSprtNum, PagingVO paging) {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			Map<String, Object> params = new HashMap<>();
			params.put("fkSprtNum", fkSprtNum);
			params.put("startRow", paging.getStartRow()+1);
			params.put("endRow", paging.getEndRow());
			return conn.selectList("bokMapper.getPagedBfSprtPerson", params);
		}catch (Exception e) {
			return null;
		}
	}

	//ī�װ��� �ش��ϴ� ��ü �Խù� �� ��ȸ
	public int getBfSprtPersonCount(int fkSprtNum) {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			return conn.selectOne("bokMapper.getBfSprtPersonCount", fkSprtNum);
		}catch (Exception e) {
			return 0;
		}
	}

}
