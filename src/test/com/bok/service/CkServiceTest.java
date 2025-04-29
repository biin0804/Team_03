package test.com.bok.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

	// ī�װ� �߰�
	@Test
	public void addCkCategory() {
		String categoryName = "JUnit�׽�Ʈī�װ�V2"; // �׽�Ʈ�� ������ �̸�

		String result = cs.addCkCategory(categoryName);

		assertNotNull("ī�װ� �߰��� �����ؾ� �Ѵ�.", result);
		assertEquals("���ϵ� ī�װ����� �Է��� ���� ��ġ�ؾ� �Ѵ�.", categoryName, result);
	}

	// ī�װ� �߰� ����(null �Է�)
	@Test
	public void addCkCategory_fail_null() {
		String result = cs.addCkCategory(null);

		assertNull("null �Է� �� ����� null�̾�� �Ѵ�.", result);
	}

	// ī�װ� �߰� ����(�� ���ڿ� �Է�)
	@Test
	public void addCkCategory_fail_blank() {
		String result = cs.addCkCategory("");

		assertNull("�� ���ڿ� �Է� �� ����� null�̾�� �Ѵ�.", result);
	}
	
	// TIP+����/���� ����
	@Test
	public void saveCkContents() {
	    CkService service = new CkService();

	    int ckNum = 76; // �׽�Ʈ�� �ӽ� ī�װ� ��ȣ (�̸� DB�� �����ϱ�)
	    String tip = "JUnit ���� �׽�Ʈ�� TIP";

	    List<CkContentVO> contentList = new ArrayList<>();
	    CkContentVO content1 = new CkContentVO();
	    content1.setTitle("JUnit �׽�Ʈ ����1");
	    content1.setContent("JUnit �׽�Ʈ ����1");

	    CkContentVO content2 = new CkContentVO();
	    content2.setTitle("JUnit �׽�Ʈ ����2");
	    content2.setContent("JUnit �׽�Ʈ ����2");

	    contentList.add(content1);
	    contentList.add(content2);

	    boolean result = service.saveCkContents(ckNum, tip, contentList);

	    assertTrue("TIP ���� �� üũ����Ʈ �߰��� �����ؾ� �Ѵ�.", result);
	}
	
	@Test
	public void saveCkContents_fail() {
	    CkService service = new CkService();

	    int invalidCkNum = -1; // ���� ������ �� ���� ��ȣ
	    String tip = "JUnit ���� �׽�Ʈ�� TIP";

	    List<CkContentVO> contentList = new ArrayList<>();
	    CkContentVO content1 = new CkContentVO();
	    content1.setTitle("JUnit ���� ����");
	    content1.setContent("JUnit ���� ����");

	    contentList.add(content1);

	    boolean result = service.saveCkContents(invalidCkNum, tip, contentList);

	    assertFalse("�������� �ʴ� ck_num�̹Ƿ� ������ �����ؾ� �Ѵ�.", result);
	}
	
	// ī�װ� ����(���õ� ���뵵 ����)
	@Test
	public void cancelCkCategory() {
	    CkService service = new CkService();

	    int ckNum = 77; // �׽�Ʈ������ �̸� �����ص� ck_num

	    boolean result = service.cancelCkCategory(ckNum);

	    assertTrue("ī�װ� ������ �����ؾ� �Ѵ�.", result);
	}
	
	@Test
	public void cancelCkCategory_fail() {
	    CkService service = new CkService();

	    int invalidCkNum = -1; // ���� ������ �� ���� ��ȣ

	    boolean result = service.cancelCkCategory(invalidCkNum);

	    assertFalse("�������� �ʴ� ck_num�̹Ƿ� ������ �����ؾ� �Ѵ�.", result);
	}

}