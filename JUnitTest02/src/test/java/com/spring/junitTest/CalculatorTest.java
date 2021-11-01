package com.spring.junitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CalculatorTest {
	@Test
	public void testSum() {
		Calculator c = new Calculator();
		
		double res = c.sum(10, 20);
		//30은 예상(기대)값, res는 변수, 0은 오차 범위   -assertEquals는 단정함수
		assertEquals(30, res, 0);
	}
}
