package test.com.bok.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bok.model.PagingVO;
import com.bok.model.SprtPersonVO;
import com.bok.service.SprtService;

public class SprtServiceTest {
	static SprtService ss;

	@Before
	public void setUp() throws Exception {
		ss = new SprtService();
	}

	@Test	//ī�װ� ��������
	public void getSprtInfo() {
		assertEquals(3, ss.getSprtInfo().size());
	}
	
	@Test
	public void getSprtInfo_fail() {
		assertNotEquals(10, ss.getSprtInfo().size());
	}
	
	@Test	//����ڿ��� ���� �������� ��ȿ�� ������ ����(����, ��ũ, ���, ���� ������, ���� ������)�� ī�װ����� ����
	public void getSprtPerson() {
		assertEquals(1, ss.getSprtPerson(2).size());
	}

	@Test
	public void getSprtPerson_fail() {
		assertNotEquals(5, ss.getSprtPerson(2).size());
	}

	@Test	//���� ���ڵ�� ��ư�� ������ �� ���� ���� ���� ����
	public void getSprtContent() {
		assertEquals(2, ss.getSprtContent(100).size());
	}

	@Test
	public void getSprtContent_fail() {
		assertNotEquals(10, ss.getSprtContent(100).size());
	}

	@Test	//����ڿ��� ���� ������ ������ ī�װ����� ����(������ ��������)
	public void getBfSprtPerson() {
		assertEquals(3, ss.getBfSprtPerson(2).size());
	}

	@Test
	public void getBfSprtPerson_fail() {
		assertNotEquals(1, ss.getBfSprtPerson(2).size());
	}

	@Test	//����ڿ��� ī�װ��� �ش��ϴ� ���� ������ ���� ����(������ ��������, Pagination
	public void getPagedBfSprtPerson() {
		int fkSprtNum = 2;
		int totalCount = ss.getBfSprtPersonCount(fkSprtNum);
		PagingVO paging = new PagingVO(1, 10);	//1�������� 10����

		List<SprtPersonVO> result = ss.getPagedBfSprtPerson(fkSprtNum, paging);
		assertEquals(3, totalCount);
		assertTrue(result.size()<=10);
	}

	@Test
	public void getPagedBfSprtPerson_fail() {
		int fkSprtNum = 6;	//�������� �ʴ� ī�װ�
		int totalCount = ss.getBfSprtPersonCount(fkSprtNum);
		PagingVO paging = new PagingVO(1, 10);	//1�������� 10����

		List<SprtPersonVO> result = ss.getPagedBfSprtPerson(fkSprtNum, paging);
		assertNotEquals(3, totalCount);
		assertTrue(result.isEmpty());
	}

	@Test	//ī�װ��� �ش��ϴ� ��ü �Խù� �� ��ȸ
	public void getBfSprtPersonCount() {
		int result = ss.getBfSprtPersonCount(2);
		assertEquals(3, result);
	}

	@Test
	public void getBfSprtPersonCount_fail() {
		int result = ss.getBfSprtPersonCount(2);
		assertNotEquals(1, result);
	}
	
}
