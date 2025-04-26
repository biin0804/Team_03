//package test.com.bok.dao;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.bok.model.PagingVO;
//import com.bok.model.SprtContentVO;
//import com.bok.model.SprtDAO;
//import com.bok.model.SprtInfoVO;
//import com.bok.model.SprtPersonVO;
//
//public class SprtDAOTest {
//	static SprtDAO dao;
//
//	@Before
//	public void setUp() throws Exception {
//		dao = new SprtDAO();
//	}
//
//	@Test	//ī�װ� ��������
//	public void getSprtInfo() {
//		List<SprtInfoVO> result = dao.getSprtInfo();
//		assertEquals(3, result.size());
//	}
//
//	@Test
//	public void getSprtInfo_fail() {
//		List<SprtInfoVO> result = dao.getSprtInfo();
//		assertNotEquals(10, result.size());
//	}
//
//	@Test	//����ڿ��� ���� �������� ��ȿ�� ������ ����(����, ��ũ, ���, ���� ������, ���� ������)�� ī�װ����� ����
//	public void getSprtPerson() {
//		List<SprtPersonVO> result = dao.getSprtPerson(2);
//		assertEquals(1, result.size());
//	}
//
//	@Test
//	public void getSprtPerson_fail() {
//		List<SprtPersonVO> result = dao.getSprtPerson(2);
//		assertNotEquals(5, result.size());
//	}
//
//	@Test	//���� ���ڵ�� ��ư�� ������ �� ���� ���� ���� ����
//	public void getSprtContent() {
//		List<SprtContentVO> result = dao.getSprtContent(100);
//		assertEquals(2, result.size());
//	}
//
//	@Test
//	public void getSprtContent_fail() {
//		List<SprtContentVO> result = dao.getSprtContent(100);
//		assertNotEquals(10, result.size());
//	}
//
//	@Test	//����ڿ��� ���� ������ ������ ī�װ����� ����(������ ��������)
//	public void getBfSprtPerson() {
//		List<SprtPersonVO> result = dao.getBfSprtPerson(2);
//		assertEquals(3, result.size());
//	}
//
//	@Test
//	public void getBfSprtPerson_fail() {
//		List<SprtPersonVO> result = dao.getBfSprtPerson(2);
//		assertNotEquals(1, result.size());
//	}
//
//	@Test	//����ڿ��� ī�װ��� �ش��ϴ� ���� ������ ���� ����(������ ��������, Pagination
//	public void getPagedBfSprtPerson() {
//		int fkSprtNum = 2;
//		int totalCount = dao.getBfSprtPersonCount(fkSprtNum);
//		PagingVO paging = new PagingVO(1, 10);	//1�������� 10����
//
//		List<SprtPersonVO> result = dao.getPagedBfSprtPerson(fkSprtNum, paging);
//		assertEquals(3, totalCount);
//		assertTrue(result.size()<=10);
//	}
//
//	@Test
//	public void getPagedBfSprtPerson_fail() {
//		int fkSprtNum = 6;	//�������� �ʴ� ī�װ�
//		int totalCount = dao.getBfSprtPersonCount(fkSprtNum);
//		PagingVO paging = new PagingVO(1, 10);	//1�������� 10����
//
//		List<SprtPersonVO> result = dao.getPagedBfSprtPerson(fkSprtNum, paging);
//		assertNotEquals(3, totalCount);
//		assertTrue(result.isEmpty());
//	}
//
//	@Test	//ī�װ��� �ش��ϴ� ��ü �Խù� �� ��ȸ
//	public void getBfSprtPersonCount() {
//		int result = dao.getBfSprtPersonCount(2);
//		assertEquals(3, result);
//		System.out.println(result);
//	}
//
//	@Test
//	public void getBfSprtPersonCount_fail() {
//		int result = dao.getBfSprtPersonCount(2);
//		assertNotEquals(1, result);
//	}
//}