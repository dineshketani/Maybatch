package com.adobe.aem.may.batch.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator c = new Calculator();

	@Test
	public void testAdd() {
		int actualResult = c.add(1, 2);
		int expectedResult = 3;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testMul() {
		int actual = c.mul(2, 2);
		int expected = 4;
		assertEquals(expected, actual);
	}

}
