package org.prej.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.prej.constants.LanguageConstants;
import org.prej.info.LanguageInfo;

public class LanguageWriter
{

	public void write(OutputStream outputStream , LanguageInfo languageInfo) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

		Iterator<Entry<String , Double>> it = languageInfo.getOutputMap().entrySet().iterator();

		while(it.hasNext())
		{
			Map.Entry<String , Double> mapEntry = it.next();

			String output = (null != mapEntry.getValue() && 0 != mapEntry.getValue()) ? mapEntry.getKey() + LanguageConstants.SENTENCE_DELIMITER
					+ mapEntry.getValue() : "I have no idea what you are talking about";

			bufferedWriter.write(output + "\r\n");
		}
		
		bufferedWriter.flush();
	}
}
