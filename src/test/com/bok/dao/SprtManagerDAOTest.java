//package test.com.bok.dao;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.bok.model.SprtContentVO;
//import com.bok.model.SprtManagerDAO;
//import com.bok.model.SprtPersonVO;
//
//public class SprtManagerDAOTest {
//	static SprtManagerDAO dao;
//	@Before
//	public void setUp() throws Exception {
//		dao = new SprtManagerDAO();
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		System.out.println("�����׽�Ʈ ����");
//	}
//
//	  //@Test
//	    public void getSprtPerson_True() {
//	        int testSprtpNum = 101;
//	        SprtPersonVO sp = dao.getSprtPerson(testSprtpNum);
//	        assertNotNull(sp);
//	    }
//	
//	  //@Test
//	  public void getSprtPerson_False(){
//		  int testSprtpNum = 200;
//		  SprtPersonVO sp = dao.getSprtPerson(testSprtpNum);
//	        assertNotNull(sp);
//	  }
//	  
//	  //@Test
//	  public void getSprtContent_True(){
//		  List<SprtContentVO> scList = dao.getSprtContent(101);
//		  assertNotNull(scList);
//	      assertTrue(scList.size() > 0);
//	  }
//	  
//	  //@Test
//	  public void getSprtContent_False(){
//		  List<SprtContentVO> scList = dao.getSprtContent(1010);
//		  assertNotNull(scList);
//	      assertTrue(scList.size() > 0);
//	  }
//	  
//	  
//	  //@Test
//	  public void addSprtCategory_True(){
//		  String testCategory = "�ູ����22";
//		  boolean result = dao.addSprtCategory(testCategory);
//		  assertTrue(result);
//	  }
//	  
//	  //@Test
//	  public void addSprtCategory_False(){
//		  //UK ���� ���� - Exception ó�� ���ֱ�.
//		  String testCategory = "û��";
//		  boolean result = dao.addSprtCategory(testCategory);
//		  assertTrue(result);
//	  }
//	  
//	  
//	  //@Test
//	  public void setAddSprt_True(){
//		  SprtPersonVO person = new SprtPersonVO(0, "�׽�Ʈ ����", "https://test.link", "���", null, "2025-05-01", "2025-05-31", 4);
//	        SprtContentVO content1 = new SprtContentVO(0, "������1", "����1", 0);
//	        SprtContentVO content2 = new SprtContentVO(0, "������2", "����2", 0);
//
//	        boolean result = dao.setAddSprt(person, Arrays.asList(content1, content2));
//	        assertTrue(result);
//	  }
//
//	  //@Test
//	  public void setAddSprt_False(){
//		  //ī�װ��� ���� ��� �� 
//		  SprtPersonVO person = new SprtPersonVO(0, "�׽�Ʈ ����", "https://test.link", "���", null, "2025-05-01", "2025-05-31", 7);
//	        SprtContentVO content1 = new SprtContentVO(0, "������1", "����1", 0);
//	        SprtContentVO content2 = new SprtContentVO(0, "������2", "����2", 0);
//
//	        boolean result = dao.setAddSprt(person, Arrays.asList(content1, content2));
//	        assertTrue(result);
//	  }
//	  
//	  //@Test
//	  public void setSprt_True(){
//		  SprtPersonVO person = new SprtPersonVO(111,"�׽�Ʈ222 ����", "https://test.link", "���222", "2025-05-01", "2025-05-31");
//	        SprtContentVO content1 = new SprtContentVO(1019, "������1222", "����1222");
//	        SprtContentVO content2 = new SprtContentVO(1020, "������2222", "����2222");
//	        boolean result = dao.setSprt(person, Arrays.asList(content1, content2));
//	        assertTrue(result);
//		  
//	  }
//	  
//	  //@Test
//	  public void setSprt_False(){
//		  SprtPersonVO person = new SprtPersonVO(99,"�׽�Ʈ222 ����", "https://test.link", "���222", "2025-05-01", "2025-05-31");
//	        SprtContentVO content1 = new SprtContentVO(1019, "������1222", "����1222");
//	        SprtContentVO content2 = new SprtContentVO(1020, "������2222", "����2222");
//	        boolean result = dao.setSprt(person, Arrays.asList(content1, content2));
//	        assertTrue(result);
//		  
//	  }
//	  
//	  //@Test
//	  public void removeSprt_False(){
//		  boolean result = dao.removeSprt(9999999);
//		  assertTrue(result);
//	  }
//	  
//	  //@Test
//	  public void removeSprt_True(){
//		  boolean result = dao.removeSprt(111);
//		  assertTrue(result);
//	  }
//	  
//	  //@Test
//	  public void getBfSprtPerson_False(){
//		  List<SprtPersonVO> bf = dao.getBfSprtPerson(444);
//		  assertFalse(bf.isEmpty());
//	  }
//	  
//	  //@Test
//	  public void getBfSprtPerson_True(){
//		  List<SprtPersonVO> bf = dao.getBfSprtPerson(3);
//		  assertNotNull(bf);
//	  }
//	  
//
//}
//    
//
