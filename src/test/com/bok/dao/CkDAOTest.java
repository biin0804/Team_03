//package test.com.bok.dao;
//
//import static org.junit.Assert.*;
//
//import java.sql.Date;
//import java.util.Collection;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.bok.model.CkDAO;
//import com.bok.model.CkVO;
//
//public class CkDAOTest {
//
//    private CkDAO dao;
//    private CkVO vo;
//
//    @Before
//    public void before() {
//        dao = new CkDAO();
//        vo = new CkVO();
//        System.out.println("�׽�Ʈ ����");
//    }
//
//    // üũ����Ʈ ����, ���� ��ȸ ����
//    @Test
//    public void testCkListInfo() {
//        Collection<CkVO> list = dao.ckListInfo("������");
//        assertTrue(list.size()==0);
//        System.out.println(list);
//    }
//
//    // üũ����Ʈ �ֽż� ��ȸ
//    @Test
//    public void testCkListRecentInfo() {
//        Collection<CkVO> list = dao.ckListRecentInfo("������");
//        assertFalse("������ ����� �����ϴ�.", list.isEmpty());
//        System.out.println(list);
//    }
//
//    // üũ����Ʈ ����
//    @Test
//    public void testSetCkList() {
//        vo.setCkContentNum(3);
//        vo.setCkContent("���� ����");
//        vo.setCkTitle("����");
//        int result = dao.setCkList(vo);
//        assertEquals(1, result);
//        System.out.println("���� ���: " + result);
//    }
//
//    // üũ����Ʈ �� �߰�
//    @Test
//    public void testAddCkList() {
//        vo.setCkTitle("�߰�");
//        vo.setCkContent("�߰�");
//        vo.setCkNum(5);
//        int result = dao.addCkList(vo);
//        assertEquals(1, result);
//        System.out.println("�߰� ����!");
//    }
//
//    // üũ����Ʈ ����
//    @Test
//    public void testDeleteCkList() {
//        vo.setCkContentNum(1);
//        int result = dao.deleteCkList(vo.getCkContentNum());
//        assertEquals(1, result);
//        System.out.println("���� ����: " + result);
//    }
//
//    // ī�װ� �߰�
//    @Test
//    public void testAddCategory() {
//        vo.setckCategory("����");
//        vo.setCkDate(new Date(System.currentTimeMillis()));
//        int result = dao.addckCategory(vo);
//        assertEquals(1, result);
//        System.out.println("ī�װ� �߰� ����: " + result);
//    }
//
//    // �� �ֽ� ��ȸ
//    @Test
//    public void testTipRecentSearch() {
//        Collection<CkVO> list = dao.TipRecentSearch("������");
//        assertTrue(list.size() == 0);
//        System.out.println(list);
//    }
//
//    // �� ��ȸ
//    @Test
//    public void testTipSearch() {
//        Collection<CkVO> list = dao.TipSearch("������");
//        assertTrue(list.size() == 0);
//        System.out.println(list);
//    }
//
//    // �� ����
//    @Test
//    public void testSetTip() {
//        vo.setCkNum(35);
//        vo.setTip("����");
//        int result = dao.setTip(vo);
//        assertEquals(1, result);
//        System.out.println("�� ���� ���: " + result);
//    }
//
//    // �� ����
//    @Test
//    public void testDeleteTip() {
//        vo.setCkNum(1);
//        int result = dao.deleteTip(vo.getCkNum());
//        assertEquals(1, result);
//        System.out.println("�� ���� ����: " + result);
//    }
//
//    // ���� ī�װ� ���
//    @Test
//    public void testBackCategoryList() {
//        Collection<String> list = dao.BackCkCategoryList();
//        assertTrue(list.size()==0);
//       System.out.println(list);
//    }
//
//    // ���� ����/��¥ ��ȸ
//    @Test
//    public void testBackCkTitleList() {
//        Collection<CkVO> list = dao.BackCkTitleList("������");
//        assertTrue(list.size() == 0);
//        System.out.println(list);
//    }
//
//    // ���� ����/���� ����
//    @Test
//    public void testBackCkListDelete() {
//        int result = dao.backCkListDelete(38);
//        assertEquals(1, result);
//        System.out.println("���� ���: " + result);
//    }
//
//    // ���� ���� Ŭ�� �� ������, ���� ��ȸ
//    @Test
//    public void testBackCkListSearch() {
//        Collection<CkVO> list = dao.BackCkListSearch();
//        assertTrue(list.size() == 0);
//        System.out.println(list);
//    }
//
//    @After
//    public void after() {
//        System.out.println("�׽�Ʈ ����");
//    }
//}
