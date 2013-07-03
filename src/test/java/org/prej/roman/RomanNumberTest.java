package org.prej.roman;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumberTest
{

	@ Test
	public void testRomanNumberIIValue() throws Exception
	{
		assertEquals(2 , RomanNumber.valueOf("II"));
	}

	@ Test
	public void testRomanNumberCIIValue() throws Exception
	{
		RomanNumber romanNumber = new RomanNumber("II");
		assertEquals(2 , romanNumber.getValue());
	}
	
	@ Test
	public void testRomanNumberMMVIValue() throws Exception
	{
		assertEquals(2006 , RomanNumber.valueOf("MMVI"));
	}

	@ Test
	public void testRomanNumberCMMVIValue() throws Exception
	{
		RomanNumber romanNumber = new RomanNumber("MMVI");
		assertEquals(2006 , romanNumber.getValue());
	}
	
	@ Test
	public void testRomanNumberMCMXLIVValue() throws Exception
	{
		assertEquals(1944 , RomanNumber.valueOf("MCMXLIV"));
	}

	@ Test
	public void testRomanNumberCMCMXLIVValue() throws Exception
	{
		RomanNumber romanNumber = new RomanNumber("MCMXLIV");
		assertEquals(1944 , romanNumber.getValue());
	}
	
	@ Test
	public void testRomanNumberIVValue() throws Exception
	{
		assertEquals(4 , RomanNumber.valueOf("IV"));
	}

	@ Test
	public void testRomanNumberXXXIXValue() throws Exception
	{
		assertEquals(39 , RomanNumber.valueOf("XXXIX"));
	}

	@ Test
	public void testRomanNumberXXXXValue() throws Exception
	{
		assertEquals(0 , RomanNumber.valueOf("XXXX"));
	}

	@ Test
	public void testRomanNumberMXXXXValue() throws Exception
	{
		assertEquals(0 , RomanNumber.valueOf("MXXXX"));
	}

	@ Test
	public void testRomanNumberMDDValue() throws Exception
	{
		assertEquals(0 , RomanNumber.valueOf("MDD"));
	}

	@ Test
	public void testRomanNumberXXXXVValue() throws Exception
	{
		assertEquals(0 , RomanNumber.valueOf("XXXXV"));
	}
}
