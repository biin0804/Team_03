package test.com.bok.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bok.model.CkVO;
import com.bok.service.CkService;

public class CkServiceTest {

    private CkService service;
    private CkVO vo;

    @Before
    public void before() {
        service = new CkService();
        vo = new CkVO();
        System.out.println("Service �׽�Ʈ ����");
    }

    @Test
    public void testCkListInfo() {
        Collection<CkVO> list = service.getCkListInfo("������");
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testCkListRecentInfo() {
        Collection<CkVO> list = service.getCkListRecentInfo("������");
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testSetCkList() {
        vo.setCkContentNum(3);
        vo.setCkContent("���� ����");
        vo.setCkTitle("���� ����");
        int result = service.updateCkList(vo);
        assertEquals(1, result);
        System.out.println("���� ���� ���: " + result);
    }

    @Test
    public void testAddCkList() {
        vo.setCkTitle("���� �߰� ����");
        vo.setCkContent("���� �߰� ����");
        vo.setCkNum(1);
        int result = service.addCkList(vo);
        assertEquals(1, result);
        System.out.println("���� �߰� ����!");
    }

    @Test
    public void testDeleteCkList() {
        int result = service.deleteCkList(1);
        assertTrue(result >= 0);
        System.out.println("���� ���� ����: " + result);
    }

    @Test
    public void testAddCkCategory() {
        vo.setckCategory("����ī�װ�");
        vo.setCkDate(new Date(System.currentTimeMillis()));
        int result = service.addCkCategory(vo);
        assertEquals(1, result);
        System.out.println("ī�װ� �߰� ����");
    }

    @Test
    public void testSetTip() {
        vo.setCkNum(35);
        vo.setTip("������ ��");
        int result = service.updateTip(vo);
        assertEquals(1, result);
        System.out.println("�� ���� ����");
    }

    @Test
    public void testAddTip() {
        vo.setckCategory("������");
        vo.setTip("�߰��� ��");
        vo.setCkDate(new Date(System.currentTimeMillis()));
        int result = service.addTip(vo);
        assertEquals(1, result);
        System.out.println("�� �߰� ����");
    }

    @Test
    public void testDeleteTip() {
        int result = service.deleteTip(1);
        assertTrue(result >= 0);
        System.out.println("�� ���� ����: " + result);
    }

    @Test
    public void testDeleteAllTips() {
        int result = service.deleteAllTips(1);
        assertTrue(result >= 0);
        System.out.println("��ü �� ���� ����: " + result);
    }

    @Test
    public void testGetRecentTips() {
        Collection<CkVO> list = service.getRecentTips("������");
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testTips() {
        Collection<CkVO> list = service.getTips("������");
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testBackCkCategoryList() {
        Collection<String> list = service.getBackCkCategoryList();
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testBackCkTitleList() {
        Collection<CkVO> list = service.getBackCkTitleList("������");
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testBackCkListSearch() {
        Collection<CkVO> list = service.getBackCkListSearch();
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testDeleteBackCkList() {
        int result = service.deleteBackCkList(38);
        assertTrue(result >= 0);
        System.out.println("���� ����Ʈ ���� ����: " + result);
    }

    @After
    public void after() {
        System.out.println("Service �׽�Ʈ ����");
    }
}