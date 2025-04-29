package test.com.bok.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bok.model.CkContentVO;
import com.bok.model.CkVO;
import com.bok.service.CkService;

public class CkServiceTest {

    private CkService cs;

    @Before
    public void setUp() {
        cs = new CkService();
    }
    
    // üũ����Ʈ ī�װ� ��ü ��������
    @Test
    public void getCkCategory() {
        List<CkVO> categories = cs.getCkCategory();
        assertNotNull("ī�װ� ����Ʈ�� null�̸� �ȵ�", categories);
        assertTrue("ī�װ� ����Ʈ�� ������� ���� ������, null�̸� �ȵ�", categories.size() >= 0);
    }

    @Test
    public void getCkCategory_fail() {
        List<CkVO> categories = cs.getCkCategory();
        assertNotNull("ī�װ� ����Ʈ�� null�̸� �ȵ�", categories);
        assertFalse("ī�װ� ����Ʈ�� ����־�� �� (fail test)", categories.isEmpty());
    }

    // Ư�� ī�װ� �̸����� �ֽ� ī�װ� ���� ��������
    @Test
    public void getLatestCk() {
        String category = "������"; // ���� �����ϴ� ī�װ�
        CkVO ckInfo = cs.getLatestCk(category);
        assertNotNull("�ֽ� ī�װ� ��Ÿ ������ null�̸� �ȵ�", ckInfo);
        assertEquals("ī�װ� �̸��� ��ġ�ؾ� ��", "������", ckInfo.getCategory());
    }

    @Test
    public void getLatestCk_fail() {
        String category = "����ī�װ�"; // �������� �ʴ� �̸�
        CkVO ckInfo = cs.getLatestCk(category);
        assertNull("�������� �ʴ� ī�װ� ��ȸ�� null�̾�� ��", ckInfo);
    }

    // Ư�� ck_num�� �ش��ϴ� üũ����Ʈ �׸� ��������
    @Test
    public void getCkContent() {
        int ckNum = 1; // ���� �����ϴ� ck_num
        List<CkContentVO> contents = cs.getCkContent(ckNum);
        assertNotNull("üũ����Ʈ �׸� ����Ʈ�� null�̸� �ȵ�", contents);
        assertTrue("üũ����Ʈ �׸� ����Ʈ�� ������� ���� ������, null�̸� �ȵ�", contents.size() >= 0);
    }

    @Test
    public void getCkContent_fail() {
        int ckNum = -1; // ���� ������ �� ���� ��ȣ
        List<CkContentVO> contents = cs.getCkContent(ckNum);
        assertNotNull("����Ʈ ��ü�� null�� �ƴϾ�� ��", contents);
        assertEquals("�������� �ʴ� ck_num ��ȸ�� ����Ʈ ũ�Ⱑ 0�̾�� ��", 0, contents.size());
    }

//	@Test
//	public void testCkListInfo() {
//		Collection<CkVO> list = service.getCkListInfo("������");
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testCkListRecentInfo() {
//		Collection<CkVO> list = service.getCkListRecentInfo("������");
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testSetCkList() {
//		vo.setCkContentNum(3);
//		vo.setCkContent("���� ����");
//		vo.setCkTitle("���� ����");
//		int result = service.setCkList(vo);
//		assertEquals(1, result);
//		System.out.println("���� ���� ���: " + result);
//	}
//
//	@Test
//	public void testAddCkList() {
//		vo.setCkTitle("���� �߰� ����");
//		vo.setCkContent("���� �߰� ����");
//		vo.setCkNum(1);
//		int result = service.addCkList(vo);
//		assertEquals(1, result);
//		System.out.println("���� �߰� ����!");
//	}
//
//	@Test
//	public void testDeleteCkList() {
//		int result = service.deleteCkList(1);
//		assertTrue(result >= 0);
//		System.out.println("���� ���� ����: " + result);
//	}
//
//	@Test
//	public void testAddCkCategory() {
//		vo.setckCategory("����ī�װ�");
//		vo.setCkDate(new Date(System.currentTimeMillis()));
//		int result = service.addCkCategory(vo);
//		assertEquals(1, result);
//		System.out.println("ī�װ� �߰� ����");
//	}
//
//	@Test
//	public void testSetTip() {
//		vo.setCkNum(35);
//		vo.setTip("������ ��");
//		int result = service.setTip(vo);
//		assertEquals(1, result);
//		System.out.println("�� ���� ����");
//	}
//
//	@Test
//	public void testAddTip() {
//		vo.setckCategory("������");
//		vo.setTip("�߰��� ��");
//		vo.setCkDate(new Date(System.currentTimeMillis()));
//		int result = service.addTip(vo);
//		assertEquals(1, result);
//		System.out.println("�� �߰� ����");
//	}
//
//	@Test
//	public void testDeleteTip() {
//		int result = service.deleteTip(1);
//		assertTrue(result >= 0);
//		System.out.println("�� ���� ����: " + result);
//	}
//
//	@Test
//	public void testDeleteAllTips() {
//		int result = service.deleteAllTips(1);
//		assertTrue(result >= 0);
//		System.out.println("��ü �� ���� ����: " + result);
//	}
//
//	@Test
//	public void testGetRecentTips() {
//		Collection<CkVO> list = service.tipRecentSearch("������");
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testTips() {
//		Collection<CkVO> list = service.tipSearch("������");
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testBackCkCategoryList() {
//		Collection<String> list = service.backCkCategoryList();
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testBackCkTitleList() {
//		Collection<CkVO> list = service.backCkTitleList("������");
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testBackCkListSearch() {
//		Collection<CkVO> list = service.backCkListSearch();
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testDeleteBackCkList() {
//		int result = service.deleteBackCkList(38);
//		assertTrue(result >= 0);
//		System.out.println("���� ����Ʈ ���� ����: " + result);
//	}
//
//	@After
//	public void after() {
//		System.out.println("Service �׽�Ʈ ����");
//	}
}