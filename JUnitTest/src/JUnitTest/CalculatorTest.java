package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;


public class CalculatorTest {
	
	@Test
	public void test() {
		Calculator c = new Calculator();
		
		double res = c.sum(10, 20);
		//30은 예상(기대)값, res는 변수, 0은 오차 범위   -assertEquals는 단정함수
		assertEquals(30, res, 0);
		
		
//		if(res != 30) {
//			System.err.println("err :" + res);
//		}
		res = c.sum(1.1, 2);
		assertEquals(3.1, res, 0);
//		if(res != 3.1) {
//			System.err.println("err : " + res);
//		}
		res = c.sum(1.1, -2);
		assertEquals(-0.9, res, 0.1);
//		if(res != -0.9 ) {
//			System.err.println("err : " + res);
//		}
	}
	
	
	
	
//	public static void main(String[] args) {
//		CalculatorTest cTest = new CalculatorTest();
//		cTest.jUnitTest();
//	}
	
//	@Test
//	public void main() {
//		CalculatorTest cTest = new CalculatorTest();
//		cTest.jUnitTest();
//	}
	
	//@Test 어노테이션을 사용하면 static을 사용할 수 없다.
	//@Test 어노테이션의 메서드의 매개변수(파라미터) 값이 있으면 안된다
//	@Test
//	public void jUnitTest() {
//		
//	}
}
