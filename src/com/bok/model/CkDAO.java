package com.bok.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class CkDAO {

	// 체크리스트 카테고리 전체 가져오기
	public List<CkVO> getCkCategory(SqlSession session) {
		return session.selectList("bokMapper.getCkCategory");
	}

	// 특정 카테고리 이름으로 최신 카테고리 정보 가져오기
	public CkVO getLatestCk(SqlSession session, String category) {
		return session.selectOne("bokMapper.getLatestCk", category);
	}

	// 특정 ck_num에 해당하는 체크리스트 항목 가져오기
	public List<CkContentVO> getCkContent(SqlSession session, int ckNum) {
		return session.selectList("bokMapper.getCkContent", ckNum);
	}

	// 카테고리 추가
	public int addckCategory(SqlSession session, CkVO vo) {
		return session.insert("bokMapper.addckCategory", vo);
	}
	
	// TIP 수정
	public int setTip(SqlSession session, CkVO vo) {
	    return session.update("setTip", vo);
	}
	
	// 체크리스트 제목/본문 추가
	public int addCkContent(SqlSession session, CkContentVO vo) {
	    return session.insert("addCkContent", vo);
	}
	
	// 특정 ck_num에 연결된 체크리스트 항목 전체 삭제
	public int deleteCkContents(SqlSession session, int ckNum) {
	    return session.delete("deleteCkContents", ckNum);
	}
	
	// 특정 ck_num 카테고리 삭제
	public int deleteCk(SqlSession session, int ckNum) {
	    return session.delete("deleteCk", ckNum);
	}

	//    // 체크리스트 전체 조회
	//    public Collection<CkVO> ckListInfo(String category) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            return session.selectList("bokMapper.ckListInfo", category);
	//        }
	//    }
	//
	//    // 체크리스트 최신순 조회
	//    public Collection<CkVO> ckListRecentInfo(String category) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            return session.selectList("bokMapper.ckListRecentInfo", category);
	//        }
	//    }
	//
	//    // 체크리스트 제목, 내용 수정
	//    public int setCkList(CkVO vo) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            int result = session.update("bokMapper.setCkList", vo);
	//            session.commit();
	//            return result;
	//        }
	//    }
	//
	//    // 체크리스트 추가
	//    public int addCkList(CkVO vo) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            int result = session.insert("bokMapper.addCkList", vo);
	//            session.commit();
	//            return result;
	//        }
	//    }
	//
	//    // 체크리스트 삭제
	//    public int deleteCkList(int ckContentNum) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            int result = session.delete("bokMapper.deleteCkList", ckContentNum);
	//            session.commit();
	//            return result;
	//        }
	//    }
	//
	//    // 카테고리 추가
	//    public int addckCategory(CkVO vo) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            int result = session.insert("bokMapper.addckCategory", vo);
	//            session.commit();
	//            return result;
	//        }
	//    }
	//
	//    // 팁 수정
	//    public int setTip(CkVO vo) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            int result = session.update("bokMapper.setTip", vo);
	//            session.commit();
	//            return result;
	//        }
	//    }
	//
	//    // 팁 추가
	//    public int addTip(CkVO vo) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            int result = session.insert("bokMapper.addTip", vo);
	//            session.commit();
	//            return result;
	//        }
	//    }
	//
	//    // 팁 삭제
	//    public int deleteTip(int ckNum) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            int result = session.delete("bokMapper.deleteTip", ckNum);
	//            session.commit();
	//            return result;
	//        }
	//    }
	//
	//    // 팁 전체 삭제
	//    public int allDeleteTip(int ckNum) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            int result = session.delete("bokMapper.allDeleteTip", ckNum);
	//            session.commit();
	//            return result;
	//        }
	//    }
	//
	//    // 팁 최신 조회
	//    public Collection<CkVO> tipRecentSearch(String ckCategory) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            return session.selectList("bokMapper.TipRecentSearch", ckCategory);
	//        }
	//    }
	//
	//    // 팁 조회
	//    public Collection<CkVO> tipSearch(String ckCategory) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            return session.selectList("bokMapper.TipSearch", ckCategory);
	//        }
	//    }
	//
	//    // 이전 카테고리 목록 조회
	//    public Collection<String> backCkCategoryList() {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            return session.selectList("bokMapper.BackCkCategoryList");
	//        }
	//    }
	//
	//    // 이전 제목/날짜 목록
	//    public Collection<CkVO> backCkTitleList(String ckCategory) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            return session.selectList("bokMapper.BackCkTitleList", ckCategory);
	//        }
	//    }
	//
	//    // 이전 제목/내용 목록
	//    public Collection<CkVO> backCkListSearch() {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            return session.selectList("bokMapper.BackCkListSearch");
	//        }
	//    }
	//
	//    // 이전 체크리스트 삭제
	//    public int backCkListDelete(int ckContentNum) {
	//        try (SqlSession session = sqlSessionFactory.openSession()) {
	//            int result = session.delete("bokMapper.backCkListDelete", ckContentNum);
	//            session.commit();
	//            return result;
	//        }
	//    }
}