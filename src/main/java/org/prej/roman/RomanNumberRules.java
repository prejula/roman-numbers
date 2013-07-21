package org.prej.roman;

import java.util.ArrayList;
import java.util.List;

public final class RomanNumberRules
{
	private static List<RomanDigit> repeatableDigitsList = null;

	private static List<RomanDigit> nonRepeatableDigitsList = null;

	static
	{
		repeatableDigitsList = new ArrayList<RomanDigit>();
		repeatableDigitsList.add(RomanDigit.I);
		repeatableDigitsList.add(RomanDigit.X);
		repeatableDigitsList.add(RomanDigit.C);
		repeatableDigitsList.add(RomanDigit.M);

		nonRepeatableDigitsList = new ArrayList<RomanDigit>();
		nonRepeatableDigitsList.add(RomanDigit.D);
		nonRepeatableDigitsList.add(RomanDigit.L);
		nonRepeatableDigitsList.add(RomanDigit.V);

	}

	public static boolean validate(String romanDigitString)
	{
		boolean validate = false;

		char[] romanDigitArray = romanDigitString.toCharArray();
		int length = romanDigitArray.length;

		validate = validateDigitSuccession(romanDigitArray , length) ? validatePrecedentLowerDigit(romanDigitArray , length) : validate;

		return validate;
	}

	private static boolean validatePrecedentLowerDigit(char[] romanDigitArray , int length)
	{
		boolean validate = false;

		for(int i = 0; i < length; i ++ )
		{

			RomanDigit rmDigit = RomanDigit.valueOf(String.valueOf(romanDigitArray[i]));
			RomanDigit nextRmDigit = i < length - 1 ? RomanDigit.valueOf(String.valueOf(romanDigitArray[i + 1])) : null;

			validate = null == nextRmDigit ? true : rmDigit.equals(RomanDigit.I)
					&& (nextRmDigit.equals(RomanDigit.V) || nextRmDigit.equals(RomanDigit.X)) ? true : rmDigit.equals(RomanDigit.X)
					&& (nextRmDigit.equals(RomanDigit.L) || nextRmDigit.equals(RomanDigit.C)) ? true : rmDigit.equals(RomanDigit.C)
					&& (nextRmDigit.equals(RomanDigit.D) || nextRmDigit.equals(RomanDigit.M)) ? true : (rmDigit.equals(RomanDigit.V)
					|| rmDigit.equals(RomanDigit.L) || rmDigit.equals(RomanDigit.D))
					&& rmDigit.value() < nextRmDigit.value() ? false : validate;
		}

		return validate;
	}

	private static boolean validateDigitSuccession(char[] romanDigitArray , int length)
	{
		boolean validate = true;
		int repeatTimes = 0;

		if(length >= 3)
		{
			for(int i = 0; i < length; i ++ )
			{
				RomanDigit rmDigit = RomanDigit.valueOf(String.valueOf(romanDigitArray[i]));

				for(int j = i + 1; j < length; j ++ )
				{
					RomanDigit nextRomanDigit = RomanDigit.valueOf(String.valueOf(romanDigitArray[j]));

					validate = nonRepeatableDigitsList.contains(rmDigit) && rmDigit.equals(nextRomanDigit) ? false : validate;

					if(validate && repeatableDigitsList.contains(rmDigit) && rmDigit.equals(nextRomanDigit))
					{
						repeatTimes = j == i + 1 ? 1 : repeatTimes;

						repeatTimes = repeatTimes == 1 ? j == i + 2 ? 2 : repeatTimes : repeatTimes;

						repeatTimes = repeatTimes == 2 ? j == i + 3 ? 3 : repeatTimes : repeatTimes;
					}
				}

				if(3 == repeatTimes)
				{
					validate = false;
					break;
				}
			}
		}
		return validate;
	}
}
