package com.spring.junitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CalculatorTest {
	@Test
	public void testSum() {
		Calculator c = new Calculator();
		
		double res = c.sum(10, 20);
		//30�� ����(���)��, res�� ����, 0�� ���� ����   -assertEquals�� �����Լ�
		assertEquals(30, res, 0);
	}
}
