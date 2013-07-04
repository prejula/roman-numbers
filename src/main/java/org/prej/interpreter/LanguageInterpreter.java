package org.prej.interpreter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.prej.alien.AlienLanguage;
import org.prej.info.LanguageInfo;
import org.prej.reader.LanguageReader;
import org.prej.writer.LanguageWriter;


public class LanguageInterpreter
{
	private String sentenceDelimeter = " is ";
	private InputStream inputStream;
	private OutputStream outputStream;

	public LanguageInterpreter(InputStream inputStream , OutputStream outputStream)
	{
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}

	public void interpret() throws IOException
	{
		LanguageReader languageReader = new LanguageReader();
		LanguageInfo languageInfo = languageReader.read(inputStream);
		
		interpretAlienLanguage(languageInfo);
		
		LanguageWriter fileWriter = new LanguageWriter();
		fileWriter.write(outputStream, languageInfo);
	}

	private void interpretAlienLanguage(LanguageInfo languageInfo)
	{
		AlienLanguage alienLanguage = new AlienLanguage();
		
		for (String basicElement : languageInfo.getBasicElements())
		{
			alienLanguage.addLanguageElement(basicElement);
		}
		
		for (String metalValue : languageInfo.getMetalValues())
		{
			alienLanguage.addMetalValue(metalValue);
		}
		
		for (String requiredValueString : languageInfo.getValuesRequired())
		{
			String[] requiredValueArray = requiredValueString.split(sentenceDelimeter);

			if(requiredValueArray.length > 1)
			{
				String languageElement = requiredValueArray[1].substring(0 , requiredValueArray[1].length() - 1);
				Double value = alienLanguage.valueOf(languageElement.trim());
				
				languageInfo.setOutputMap(languageElement, value);
				
			} else
			{
				languageInfo.setOutputMap(requiredValueString, null);
			}
		}
	}
}
