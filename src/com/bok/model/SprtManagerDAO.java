package com.bok.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


public class SprtManagerDAO {
	//�����ڰ� ������ �������� ���� ��ư Ŭ�� �� select (-sprtPerson ��)
	public SprtPersonVO getSprtPerson(SqlSession session,int sprtpNum){
		return session.selectOne("bokMapper.getSprtPersonOne", sprtpNum);
	}
	//�����ڰ� ������ �������� ���� ��ư Ŭ�� �� select (-sprtContent ��)
	public List<SprtContentVO> getSprtContent(SqlSession session,int sprtpNum){
		return session.selectList("bokMapper.getSprtContents",sprtpNum);
	}	

	//������ ���� �߰� �� ���� ��ư(person & content - insert)
	//Ư�� ������ ���� ���� �����ϱ� ���� �� �߰� ��ư(insert)
	public boolean setAddSprt(SqlSession session, SprtPersonVO sp, List<SprtContentVO> scList) {
		int personInsertResult = session.insert("bokMapper.addSprtPerson", sp);

		Integer generatedKey = sp.getSprtpNum();
		int successCount = 0;

		for (SprtContentVO sc : scList) {
			sc.setFkSprtpNum(generatedKey);
			successCount += session.insert("bokMapper.addSprtContent", sc);
		}

		return personInsertResult == 1 && successCount == scList.size();
	}

	//Ư�� ������ ���� ���� ���� ���� ��ư(update)
	public boolean setSprt(SqlSession session, SprtPersonVO sp, List<SprtContentVO> scList) {
		int personResult = session.update("bokMapper.setSprtPerson", sp);
		int contentSuccessCount = 0;

		for (SprtContentVO sc : scList) {
			contentSuccessCount += session.update("bokMapper.setSprtContent", sc);
		}

		return personResult == 1 && contentSuccessCount == scList.size();
	}

	//������ ���� ������ ���� ���� ������ư ������ ���â �� �� ��¥ ���� 
	//Ư�� ������ ���� ��ü(person&content) ���� ��ư(delete)
	public boolean removeSprt(SqlSession session, int sprtpNum) {
		int contentDelete = session.delete("bokMapper.removeSprtContent", sprtpNum);
		int personDelete = session.delete("bokMapper.removeSprtPerson", sprtpNum);
		System.out.println("dao��contetn;"+contentDelete);
		System.out.println("dao��persohn;"+personDelete);
		return personDelete == 1 && contentDelete >= 0;
	}

	//������ �з� �߰� �� ���� ��ư(ī�װ� insert)
	public boolean addSprtCategory(SqlSession session, String category) {
		int result = session.insert("bokMapper.addSprtCategory", category);
		return result == 1;
	}


	//���� ������ ���� ������ ī�װ� ����(û��, ����, �ູ���� ��)
	//����ڿ��� ���� ������ ���� ����(������ ��������)
	public List<SprtPersonVO> getBfSprtPerson(SqlSession session, int fkSprtNum) {
		return session.selectList("bokMapper.getBfSprtPersonM", fkSprtNum);
	}

	//ī�װ��� �ش��ϴ� ���� ������ ���� ����(������ ��������, Pagination)
	public List<SprtPersonVO> getPagedBfSprtPersonM(SqlSession session, int fkSprtNum, PagingVO paging) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("fkSprtNum", fkSprtNum);
	    params.put("startRow", paging.getStartRow() + 1);
	    params.put("endRow", paging.getEndRow());
	    return session.selectList("bokMapper.getPagedBfSprtPersonM", params);
	}



}
