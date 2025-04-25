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
    public int updateCkList(CkVO vo) {
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
    public int updateTip(CkVO vo) {
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
    public Collection<CkVO> getRecentTips(String ckCategory) {
        return dao.TipRecentSearch(ckCategory);
    }

    // �� ��ȸ
    public Collection<CkVO> getTips(String ckCategory) {
        return dao.TipSearch(ckCategory);
    }

    // ���� ī�װ� ��� ��ȸ
    public Collection<String> getBackCkCategoryList() {
        return dao.BackCkCategoryList();
    }

    // ���� ����/��¥ ���
    public Collection<CkVO> getBackCkTitleList(String ckCategory) {
        return dao.BackCkTitleList(ckCategory);
    }

    // ���� ����/���� ���
    public Collection<CkVO> getBackCkListSearch() {
        return dao.BackCkListSearch();
    }

    // ���� üũ����Ʈ ����
    public int deleteBackCkList(int ckContentNum) {
        return dao.backCkListDelete(ckContentNum);
    }
}