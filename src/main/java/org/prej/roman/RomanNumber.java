package org.prej.roman;

public final class RomanNumber
{

	private int romanValue = 0;

	public RomanNumber(String romanDigitString)
	{
		if(RomanNumberRules.validate(romanDigitString))
		{
			romanValue = evaluateRomanDigitString(romanDigitString);
		}
	}

	public int getValue()
	{
		return romanValue;
	}

	public static int valueOf(String romanDigitString)
	{

		return RomanNumberRules.validate(romanDigitString) ? evaluateRomanDigitString(romanDigitString) : 0;
	}

	private static int evaluateRomanDigitString(String romanDigitString)
	{

		int value = 0;
		char[] romanDigitArray = romanDigitString.toCharArray();
		int length = romanDigitArray.length;

		for(int i = 0; i < length;)
		{

			int rmDigit = RomanDigit.valueOf(String.valueOf(romanDigitArray[i])).value;

			int nextRmDigit = i < length - 1 ? RomanDigit.valueOf(String.valueOf(romanDigitArray[i + 1])).value : 0;

			if(rmDigit < nextRmDigit)
			{
				value = value + (nextRmDigit - rmDigit);
				i = i + 2;
			} else
			{
				value = value + rmDigit;
				i = i + 1;
			}

		}
		return value;
	}
}
