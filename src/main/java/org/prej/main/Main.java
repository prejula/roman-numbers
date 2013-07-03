package org.prej.main;

import org.prej.main.reader.LanguageReader;

public class Main
{

	public static void main(String[] args)
	{
		System.out.println("Please read the below instructions before proceeding.");
		System.out.println("Step1. Enter basic language elements example, glob is I. After entering all basic elements enter # for next step.");
		System.out.println("Step2. Enter metal values, example glob glob Silver is 34 Credits. After entering all values enter # for next step.");
		System.out.println("Step3. Enter the language element for which value is required. After entering all values enter # to exit.");
		
		LanguageReader languageReader = new LanguageReader();
		
		languageReader.read();
		
	}

}
