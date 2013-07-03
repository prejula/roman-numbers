package org.prej.main.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.prej.alien.AlienLanguage;

public class LanguageReader
{
	private String lineDelimeter = "#";
	private String sentenceDelimeter = " is ";

	public void read()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String alienLanguage = null;
		AlienLanguage language = new AlienLanguage();

		try
		{
			while( ! lineDelimeter.equals(alienLanguage = br.readLine()))
			{
				language.addLanguageElement(alienLanguage);
			}

			while( ! lineDelimeter.equals(alienLanguage = br.readLine()))
			{
				language.addMetalValue(alienLanguage);
			}

			while( ! lineDelimeter.equals(alienLanguage = br.readLine()))
			{
				String[] alienLanguageArray = alienLanguage.split(sentenceDelimeter);

				if(alienLanguageArray.length > 1)
				{
					String languageElement = alienLanguageArray[1].substring(0 , alienLanguageArray[1].length() - 1);
					Double value = language.valueOf(languageElement.trim());
					System.out.println(languageElement + sentenceDelimeter + value);
				} else
				{
					System.out.println("I have no idea what you are talking about.");
				}
			}
		} catch(IOException e)
		{
			System.out.println("IOException while entering value.");
		}
	}
}
