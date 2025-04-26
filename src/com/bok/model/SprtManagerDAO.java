package com.bok.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class SprtManagerDAO {
	//�����ڰ� ������ �������� ���� ��ư Ŭ�� �� select (-sprtPerson ��)
	public SprtPersonVO getSprtPerson(SqlSession session,int sprtpNum){
		return session.selectOne("bokMapper.getSprtPersonOne", sprtpNum);
	}
	//�����ڰ� ������ �������� ���� ��ư Ŭ�� �� select (-sprtContent ��)
	public List<SprtContentVO> getSprtContent(int sprtpNum){
		List<SprtContentVO> scList = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		try{
			scList = conn.selectList("bokMapper.getSprtContents",sprtpNum);
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return scList;
	}	

	//������ ���� �߰� �� ���� ��ư(person & content - insert)
	//Ư�� ������ ���� ���� �����ϱ� ���� �� �߰� ��ư(insert)
	public boolean setAddSprt(SprtPersonVO sp, List<SprtContentVO> scList){
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		boolean result = false;
		try {
			int p = conn.insert("bokMapper.addSprtPerson", sp);
			int successCount = 0;

			Integer generatedKey = sp.getSprtpNum(); // MyBatis���� selectKey�� �����;� ��

			for (SprtContentVO sc : scList) {
				sc.setFkSprtpNum(generatedKey);
				successCount += conn.insert("bokMapper.addSprtContent", sc);
			}

			if (p == 1 && successCount == scList.size()) {
				conn.commit();
				result = true;
			} else {
				conn.rollback(); // �κ� ������ ���з� ó��
			}

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		return result;
	}


	//Ư�� ������ ���� ���� ���� ���� ��ư(update)
	public boolean setSprt(SprtPersonVO sp, List<SprtContentVO> scList) {
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		boolean result = false;

		try {
			int p = conn.update("bokMapper.setSprtPerson", sp);
			int successCount = 0;

			for (SprtContentVO sc : scList) {
				successCount += conn.update("bokMapper.setSprtContent", sc);
			}

			if (p == 1 && successCount == scList.size()) {
				conn.commit();
				result = true;
			} else {
				conn.rollback(); // �κ� ������ ���з� ó��
			}

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		return result;
	}
	//������ ���� ������ ���� ���� ������ư ������ ���â �� �� ��¥ ���� 
	//Ư�� ������ ���� ��ü(person&content) ���� ��ư(delete)
	public boolean removeSprt(int sprtpNum){
		SqlSession conn= DBCP.getSqlSessionFactory().openSession();
		boolean result = false;
		try{
			int i = conn.delete("bokMapper.removeSprtContent",sprtpNum);
			int j = conn.delete("bokMapper.removeSprtPerson",sprtpNum);

			if(j==1 && i>=0){
				conn.commit();
				result= true;
			}
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
		return result;
	}
	//������ �з� �߰� �� ���� ��ư(ī�װ� insert)
	public boolean addSprtCategory(String category){
		SqlSession conn= DBCP.getSqlSessionFactory().openSession();
		boolean result = false;
		try{
			conn.insert("bokMapper.addSprtCategory",category);
			conn.commit();
			result=true;
		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
		return result;
	}

	//���� ������ ���� ������ ī�װ� ����(û��, ����, �ູ���� ��)
	//����ڿ��� ���� ������ ���� ����(������ ��������)
	public List<SprtPersonVO> getBfSprtPerson(int fkSprtNum) {
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		List<SprtPersonVO> list = null;
		try{
			list = conn.selectList("bokMapper.getBfSprtPersonM", fkSprtNum);
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}

		return list;
	}


}
