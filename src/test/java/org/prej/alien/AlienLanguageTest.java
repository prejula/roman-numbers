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
		
		alienLanguage.addLanguageElement("glob is I");
		assertEquals(RomanDigit.I.name() , alienLanguage.getLanguageElementVaue("glob"));

		alienLanguage.addLanguageElement("prok is V");
		assertEquals(RomanDigit.V.name() , alienLanguage.getLanguageElementVaue("prok"));

		alienLanguage.addLanguageElement("pish is X");
		assertEquals(RomanDigit.X.name() , alienLanguage.getLanguageElementVaue("pish"));
		
		alienLanguage.addLanguageElement("tegj is L");
		assertEquals(RomanDigit.L.name() , alienLanguage.getLanguageElementVaue("tegj"));
		
		assertNull(alienLanguage.getLanguageElementVaue("wwww"));

		alienLanguage.addMetalValue("glob glob Silver is 34 Credits");
		assertEquals(Double.valueOf(17) , alienLanguage.getMetalValue("Silver"));

		alienLanguage.addMetalValue("glob prok Gold is 57800 Credits");
		assertEquals(Double.valueOf(14450) , alienLanguage.getMetalValue("Gold"));
		
		alienLanguage.addMetalValue("pish pish Iron is 3910 Credits");
		assertEquals(Double.valueOf(195.5) , alienLanguage.getMetalValue("Iron"));
		
		assertNull(alienLanguage.getMetalValue("Platinum"));

		assertEquals(Double.valueOf(42) , alienLanguage.valueOf("pish tegj glob glob"));
		
		assertEquals(Double.valueOf(68) , alienLanguage.valueOf("glob prok Silver"));
		
		assertEquals(Double.valueOf(57800) , alienLanguage.valueOf("glob prok Gold"));
		
		assertEquals(Double.valueOf(782) , alienLanguage.valueOf("glob prok Iron"));
		
		assertEquals(Double.valueOf(0) , alienLanguage.valueOf("woodchuck could chuck wood"));
	}
}
