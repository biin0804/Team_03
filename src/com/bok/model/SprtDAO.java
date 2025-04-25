package com.bok.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class SprtDAO {

	//ī�װ� ��������
	public List<SprtInfoVO> getSprtInfo(SqlSession session) {
		return session.selectList("bokMapper.getSprtInfo");
	}

	//����ڿ��� ���� �������� ��ȿ�� ������ ���� ����
	public List<SprtPersonVO> getSprtPerson(SqlSession session, int fkSprtNum) {
		return session.selectList("bokMapper.getSprtPerson", fkSprtNum);
	}

	//���� ���ڵ�� ��ư Ŭ�� �� ���� ���� ����
	public List<SprtContentVO> getSprtContent(SqlSession session, int fkSprtpNum) {
		return session.selectList("bokMapper.getSprtContent", fkSprtpNum);
	}

	//����ڿ��� ���� ������ ���� ����(������ ��������)
	public List<SprtPersonVO> getBfSprtPerson(SqlSession session, int fkSprtNum) {
		return session.selectList("bokMapper.getBfSprtPerson", fkSprtNum);
	}

	//����ڿ��� ī�װ��� �ش��ϴ� ���� ������ ���� ����(������ ��������, Pagination)
	public List<SprtPersonVO> getPagedBfSprtPerson(SqlSession session, int fkSprtNum, PagingVO paging) {
		Map<String, Object> params = new HashMap<>();
		params.put("fkSprtNum", fkSprtNum);
		params.put("startRow", paging.getStartRow()+1);
		params.put("endRow", paging.getEndRow());
		return session.selectList("bokMapper.getPagedBfSprtPerson", params);
	}

	//ī�װ��� �ش��ϴ� ��ü �Խù� �� ��ȸ
	public int getBfSprtPersonCount(SqlSession session, int fkSprtNum) {
		return session.selectOne("bokMapper.getBfSprtPersonCount", fkSprtNum);
	}

}
