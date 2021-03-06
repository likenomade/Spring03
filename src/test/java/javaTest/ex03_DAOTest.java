package javaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import vo.MemberVO;

//test1) DAO 테스트 시나리오
//=> Detail 정확하게 구현 했는지 Test
//-> 정확한 id 를 넣었을때는 NotNull:green  
//-> 없는 id 를 넣었을때는 Null: red(오류)

//test2) 테스트 시나리오
//=> Insert 구현 정확성 Test 
//-> 입력가능 데이터 적용시에는  ,성공  1 return : green
//-> 입력불가능 데이터 적용시에는 , 실패  0 return : red 


public class ex03_DAOTest {

	MemberDAO dao = new MemberDAO();
	MemberVO vo = new MemberVO();
	
	@Test
	//test1)  Detail 정확하게 구현 했는지 Test
	public void detailTest() {
		vo.setId("apple1234"); //green
		assertNotNull(dao.selectOne(vo));	//NotNull : green, Null : red
	}
	
	
	//@Test
	//test2) Insert 구현 정확성 Test 
	public void insertTest() {
		vo.setId("unitTest");
		vo.setPassword("1234!");
		vo.setName("jisukim");
		vo.setLev("A");
		vo.setBirthd("1993-07-02");
		vo.setPoint(1000);
		vo.setWeight(44.33);
		vo.setRid("coffee");
		vo.setUploadfile("resources/uploadImage/basicman2.jpg");
		//입력 성공이면 1 return 실패이면 0
		 assertEquals(dao.insert(vo), 1);  //true : green , false : red   
	}
}//ex03_DAOTest
