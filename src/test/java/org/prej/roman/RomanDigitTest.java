package org.prej.roman;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanDigitTest{
	
	@Test
	public void testRomanNumberValue() throws Exception {
		assertEquals(1, RomanDigit.I.value());
		assertEquals(5, RomanDigit.V.value());
		assertEquals(10, RomanDigit.X.value());
		assertEquals(50, RomanDigit.L.value());
		assertEquals(100, RomanDigit.C.value());
		assertEquals(500, RomanDigit.D.value());
		assertEquals(1000, RomanDigit.M.value());
	}
}
