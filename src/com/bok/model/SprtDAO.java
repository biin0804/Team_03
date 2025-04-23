package com.bok.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.DBCP;

public class SprtDAO {
	//����ڿ��� ���� �������� ��ȿ�� ������ ����(����, ��ũ, ���, ���� ������, ���� ������)�� ī�װ����� ����
	public List<SprtPersonVO> getSprtPerson(int fkSprtNum) {
		List<SprtPersonVO> list = null;
		SqlSession conn=DBCP.getSqlSessionFactory().openSession();
		list=conn.selectList("bokMapper.getSprtPerson", fkSprtNum);
		conn.close();
		return list;
	}
	
}
