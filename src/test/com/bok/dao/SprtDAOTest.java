package test.com.bok.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bok.model.SprtDAO;
import com.bok.model.SprtPersonVO;

public class SprtDAOTest {
	static SprtDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new SprtDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test	//����ڿ��� ���� �������� ��ȿ�� ������ ����(����, ��ũ, ���, ���� ������, ���� ������)�� ī�װ����� ����
	public void testGetSprtPerson() {
		List<SprtPersonVO> result = dao.getSprtPerson(2);
		assertEquals(1, result.size());
	}


}
