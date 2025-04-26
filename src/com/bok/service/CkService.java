package com.bok.service;

import java.sql.Date;
import java.util.Collection;
import com.bok.model.CkDAO;
import com.bok.model.CkVO;

public class CkService {
	 private CkDAO dao = new CkDAO();
	
	// üũ����Ʈ ��ü ��ȸ
    public Collection<CkVO> getCkListInfo(String category) {
        return dao.ckListInfo(category);
    }

    // üũ����Ʈ �ֽż� ��ȸ
    public Collection<CkVO> getCkListRecentInfo(String category) {
        return dao.ckListRecentInfo(category);
    }

    // üũ����Ʈ ����/���� ����
    public int setCkList(CkVO vo) {
        return dao.setCkList(vo);
    }

    // üũ����Ʈ �߰�
    public int addCkList(CkVO vo) {
        return dao.addCkList(vo);
    }

    // üũ����Ʈ ����
    public int deleteCkList(int ckContentNum) {
        return dao.deleteCkList(ckContentNum);
    }

    // ī�װ� �߰�
    public int addCkCategory(CkVO vo) {
        return dao.addckCategory(vo);
    }

    // �� ����
    public int setTip(CkVO vo) {
        return dao.setTip(vo);
    }

    // �� �߰�
    public int addTip(CkVO vo) {
        return dao.addTip(vo);
    }

    // �� ����
    public int deleteTip(int ckNum) {
        return dao.deleteTip(ckNum);
    }

    // �� ��ü ����
    public int deleteAllTips(int ckNum) {
        return dao.allDeleteTip(ckNum);
    }

    // �� �ֽ� ��ȸ
    public Collection<CkVO> tipRecentSearch(String ckCategory) {
        return dao.tipRecentSearch(ckCategory);
    }

    // �� ��ȸ
    public Collection<CkVO> tipSearch(String ckCategory) {
        return dao.tipSearch(ckCategory);
    }

    // ���� ī�װ� ��� ��ȸ
    public Collection<String> backCkCategoryList() {
        return dao.backCkCategoryList();
    }

    // ���� ����/��¥ ���
    public Collection<CkVO> backCkTitleList(String ckCategory) {
        return dao.backCkTitleList(ckCategory);
    }

    // ���� ����/���� ���
    public Collection<CkVO> backCkListSearch() {
        return dao.backCkListSearch();
    }

    // ���� üũ����Ʈ ����
    public int deleteBackCkList(int ckContentNum) {
        return dao.backCkListDelete(ckContentNum);
    }


}