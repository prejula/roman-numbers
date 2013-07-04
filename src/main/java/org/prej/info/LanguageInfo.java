package org.prej.info;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LanguageInfo
{

	private List<String> basicElements;

	private List<String> metalValues;
	
	private List<String> valuesRequired;
	
	private Map<String,Double> outputMap;
	
	public List<String> getBasicElements()
	{
		return basicElements;
	}

	public void setBasicElements(String basicElement)
	{
		this.basicElements = null == this.basicElements ? new ArrayList<String>() : this.basicElements;
		
		basicElements.add(basicElement);
	}

	public List<String> getMetalValues()
	{
		return metalValues;
	}

	public void setMetalValues(String metalValue)
	{
		this.metalValues = null == this.metalValues ? new ArrayList<String>() : this.metalValues;
		
		metalValues.add(metalValue);
	}

	public List<String> getValuesRequired()
	{
		return valuesRequired;
	}

	public void setValuesRequired(String valueRequired)
	{
		this.valuesRequired = null == this.valuesRequired ? new ArrayList<String>() : this.valuesRequired;
		
		valuesRequired.add(valueRequired);
	}

	public void setOutputMap(String languageElement , Double value)
	{
		outputMap = null == outputMap ? new LinkedHashMap<String , Double>() : outputMap;
		
		outputMap.put(languageElement , value);
	}
	
	public Map<String, Double> getOutputMap()
	{
		return outputMap;
	}
}
