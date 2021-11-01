package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;


public class CalculatorTest {
	
	@Test
	public void test() {
		Calculator c = new Calculator();
		
		double res = c.sum(10, 20);
		//30�� ����(���)��, res�� ����, 0�� ���� ����   -assertEquals�� �����Լ�
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
	
	//@Test ������̼��� ����ϸ� static�� ����� �� ����.
	//@Test ������̼��� �޼����� �Ű�����(�Ķ����) ���� ������ �ȵȴ�
//	@Test
//	public void jUnitTest() {
//		
//	}
}
