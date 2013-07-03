package org.prej.alien;

import java.util.HashMap;
import java.util.Map;

import org.prej.roman.RomanDigit;
import org.prej.roman.RomanNumber;

public class AlienLanguage
{

	private Map<String , String> alienLanguageValueMap = null;

	private Map<String , Double> metalValueMap = null;

	public String addLanguageElement(String alienLanguage)
	{
		alienLanguageValueMap = null == alienLanguageValueMap ? new HashMap<String , String>() : alienLanguageValueMap;

		if(null != alienLanguage)
		{
			String[] alienLangArray = alienLanguage.split(" is ");

			alienLanguageValueMap.put(alienLangArray[0].trim() , RomanDigit.valueOf(alienLangArray[1].trim()).name());

			return alienLanguageValueMap.get(alienLangArray[0].trim());
		}
		return null;
	}

	public Double addMetalValue(String alienLanguage)
	{
		metalValueMap = null == metalValueMap ? new HashMap<String , Double>() : metalValueMap;

		if(null != alienLanguage)
		{
			String[] alienLangArray = alienLanguage.split(" is ");

			String[] simpleConstructArray = alienLangArray[0].split(" ");
			String[] creditArray = alienLangArray[1].split(" ");

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

				return metalValueMap.get(metal);
			}
			return null;
		}
		return null;
	}

	public Double valueOf(String alienLanguage)
	{
		String[] alienLanguageArray = alienLanguage.split(" ");

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
