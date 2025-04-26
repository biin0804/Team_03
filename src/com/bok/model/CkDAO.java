package com.bok.model;

import java.util.Collection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;




public class CkDAO {

static SqlSessionFactory sqlSessionFactory = DBCP.getSqlSessionFactory();

    // üũ����Ʈ ��ü ��ȸ
    public Collection<CkVO> ckListInfo(String category) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.ckListInfo", category);
        }
    }

    // üũ����Ʈ �ֽż� ��ȸ
    public Collection<CkVO> ckListRecentInfo(String category) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.ckListRecentInfo", category);
        }
    }

    // üũ����Ʈ ����, ���� ����
    public int setCkList(CkVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.update("bokMapper.setCkList", vo);
            session.commit();
            return result;
        }
    }

    // üũ����Ʈ �߰�
    public int addCkList(CkVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.insert("bokMapper.addCkList", vo);
            session.commit();
            return result;
        }
    }

    // üũ����Ʈ ����
    public int deleteCkList(int ckContentNum) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.delete("bokMapper.deleteCkList", ckContentNum);
            session.commit();
            return result;
        }
    }

    // ī�װ� �߰�
    public int addckCategory(CkVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.insert("bokMapper.addckCategory", vo);
            session.commit();
            return result;
        }
    }

    // �� ����
    public int setTip(CkVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.update("bokMapper.setTip", vo);
            session.commit();
            return result;
        }
    }

    // �� �߰�
    public int addTip(CkVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.insert("bokMapper.addTip", vo);
            session.commit();
            return result;
        }
    }

    // �� ����
    public int deleteTip(int ckNum) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.delete("bokMapper.deleteTip", ckNum);
            session.commit();
            return result;
        }
    }

    // �� ��ü ����
    public int allDeleteTip(int ckNum) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.delete("bokMapper.allDeleteTip", ckNum);
            session.commit();
            return result;
        }
    }

    // �� �ֽ� ��ȸ
    public Collection<CkVO> tipRecentSearch(String ckCategory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.TipRecentSearch", ckCategory);
        }
    }

    // �� ��ȸ
    public Collection<CkVO> tipSearch(String ckCategory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.TipSearch", ckCategory);
        }
    }

    // ���� ī�װ� ��� ��ȸ
    public Collection<String> backCkCategoryList() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.BackCkCategoryList");
        }
    }

    // ���� ����/��¥ ���
    public Collection<CkVO> backCkTitleList(String ckCategory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.BackCkTitleList", ckCategory);
        }
    }

    // ���� ����/���� ���
    public Collection<CkVO> backCkListSearch() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.BackCkListSearch");
        }
    }

    // ���� üũ����Ʈ ����
    public int backCkListDelete(int ckContentNum) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.delete("bokMapper.backCkListDelete", ckContentNum);
            session.commit();
            return result;
        }
    }
}