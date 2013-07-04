package org.prej.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.prej.info.LanguageInfo;

public class LanguageReader
{
	public LanguageInfo read(InputStream inputStream) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		LanguageInfo languageInfo = new LanguageInfo();
		while(null != (line = bufferedReader.readLine()))
		{
			if(line.endsWith("Credits"))
			{
				languageInfo.setMetalValues(line);
			} else if(line.endsWith("?"))
			{
				languageInfo.setValuesRequired(line);
			} else
			{
				languageInfo.setBasicElements(line);
			}
		}
		return languageInfo;
	}
}
