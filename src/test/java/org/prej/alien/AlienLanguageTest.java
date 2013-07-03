package org.prej.alien;

import static org.junit.Assert.*;

import org.junit.Test;
import org.prej.roman.RomanDigit;

public class AlienLanguageTest
{
	@ Test
	public void testAddSimpleAlienLanguageConstructs() throws Exception
	{
		AlienLanguage alienLanguage = new AlienLanguage();
		
		assertEquals(RomanDigit.I.name() , alienLanguage.addLanguageElement("glob is I"));

		assertEquals(RomanDigit.V.name() , alienLanguage.addLanguageElement("prok is V"));

		assertEquals(RomanDigit.X.name() , alienLanguage.addLanguageElement("pish is X"));

		assertEquals(RomanDigit.L.name() , alienLanguage.addLanguageElement("tegj is L"));

		assertEquals(Double.valueOf(17) , alienLanguage.addMetalValue("glob glob Silver is 34 Credits"));

		assertEquals(Double.valueOf(14450) , alienLanguage.addMetalValue("glob prok Gold is 57800 Credits"));

		assertEquals(Double.valueOf(195.5) , alienLanguage.addMetalValue("pish pish Iron is 3910 Credits"));

		assertEquals(Double.valueOf(42) , alienLanguage.valueOf("pish tegj glob glob"));
		
		assertEquals(Double.valueOf(68) , alienLanguage.valueOf("glob prok Silver"));
		
		assertEquals(Double.valueOf(57800) , alienLanguage.valueOf("glob prok Gold"));
		
		assertEquals(Double.valueOf(782) , alienLanguage.valueOf("glob prok Iron"));
		
		assertEquals(Double.valueOf(0) , alienLanguage.valueOf("woodchuck could chuck wood"));
	}
}
