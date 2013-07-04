package org.prej.main;

import java.io.IOException;
import java.io.InputStream;

import org.prej.interpreter.LanguageInterpreter;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		InputStream inputStream = Main.class.getResourceAsStream("/sample_input.txt");
		
		LanguageInterpreter languageInterpreter = new LanguageInterpreter(inputStream, System.out);
		
		languageInterpreter.interpret();
	}

}
