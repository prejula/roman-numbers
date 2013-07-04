package org.prej.alien;

import java.util.HashMap;
import java.util.Map;

import org.prej.constants.LanguageConstants;
import org.prej.roman.RomanDigit;
import org.prej.roman.RomanNumber;

public class AlienLanguage
{

	private Map<String , String> alienLanguageValueMap = null;

	private Map<String , Double> metalValueMap = null;

	public void addLanguageElement(String alienLanguage)
	{
		alienLanguageValueMap = null == alienLanguageValueMap ? new HashMap<String , String>() : alienLanguageValueMap;

		if(null != alienLanguage)
		{
			String[] alienLangArray = alienLanguage.split(LanguageConstants.SENTENCE_DELIMITER);

			alienLanguageValueMap.put(alienLangArray[0].trim() , RomanDigit.valueOf(alienLangArray[1].trim()).name());
		}
	}

	public String getLanguageElementVaue(String alienLanguage)
	{
		return alienLanguageValueMap.get(alienLanguage);
	}
	
	public void addMetalValue(String alienLanguage)
	{
		metalValueMap = null == metalValueMap ? new HashMap<String , Double>() : metalValueMap;

		if(null != alienLanguage)
		{
			String[] alienLangArray = alienLanguage.split(LanguageConstants.SENTENCE_DELIMITER);

			String[] simpleConstructArray = alienLangArray[0].split(LanguageConstants.SPACE);
			String[] creditArray = alienLangArray[1].split(LanguageConstants.SPACE);

			double credit = Integer.parseInt(creditArray[0].trim());
			StringBuilder romanDigitString = new StringBuilder();
			String metal = null;

			for(String simpleConstruct : simpleConstructArray)
			{
				String t = alienLanguageValueMap.get(simpleConstruct);

				metal = null == t ? simpleConstruct : metal;

				if(null != t)
				{
					romanDigitString.append(t);
				}
			}

			if(null != metal)
			{
				metalValueMap.put(metal , credit / RomanNumber.valueOf(romanDigitString.toString()));

			}
		}
	}

	public Double getMetalValue(String metal)
	{
		return metalValueMap.get(metal);
	}
	
	public Double valueOf(String alienLanguage)
	{
		String[] alienLanguageArray = alienLanguage.split(LanguageConstants.SPACE);

		StringBuilder romanDigitString = new StringBuilder();

		double romanValue = 0;
		Double metalValue = null;
		Double totalValue = null;

		for(String alienString : alienLanguageArray)
		{
			String romanDigit = alienLanguageValueMap.get(alienString);

			if(null != romanDigit)
			{
				romanDigitString.append(romanDigit);
			}
		}

		romanValue = RomanNumber.valueOf(romanDigitString.toString());

		totalValue = romanValue;

		for(String metal : alienLanguageArray)
		{
			metalValue = metalValueMap.get(metal);

			if(null != metalValue)
			{
				totalValue = romanValue * metalValue;
				break;
			}
		}
		return totalValue;
	}
}
