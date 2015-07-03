package com.ink.challenge;

public class EnglishNumberToWordsConverter implements NumberToWordsConverter {

	private static final String[] units = { "zero", "one", "two", "three",
			"four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "fhirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "sighteen", "nineteen" };
	private static final String[] tens = { "", "", "twenty", "thirty", "forty",
			"fifty", "sixty", "seventy", "eighty", "ninety" };

	private static final String HUNDRED = "hundred";
	private static final String THOUSAND = "thousand";
	private static final String MILLION = "million";
	private static final String AND = " and ";
	private static final String BLANK = " ";
	private static final String EMPTY = "";

	public String convert(int numberToTransform) {
		if (numberToTransform > 999999999) {
			throw new IllegalArgumentException("number is >  999999999");
		}else if(numberToTransform < 0){
			throw new IllegalArgumentException("number is negative");
		}
		return executeConversion(numberToTransform);
	}

	private String executeConversion(int numberToTransform) {
		if (numberToTransform < 20) {
			return units[numberToTransform];
		}
		if (numberToTransform < 100) {
			return tens[numberToTransform / 10]
					+ ((numberToTransform % 10 > 0) ? BLANK
							+ executeConversion(numberToTransform % 10) : EMPTY);
		}
		if (numberToTransform < 1000) {
			return units[numberToTransform / 100]
					+ BLANK
					+ HUNDRED
					+ ((numberToTransform % 100 > 0) ? AND
							+ executeConversion(numberToTransform % 100)
							: EMPTY);
		}
		if (numberToTransform < 1000000) {
			return convert(numberToTransform / 1000)
					+ BLANK
					+ THOUSAND
					+ ((numberToTransform % 1000 > 0) ? BLANK
							+ executeConversion(numberToTransform % 1000)
							: EMPTY);
		}
		return convert(numberToTransform / 1000000)
				+ BLANK
				+ MILLION
				+ ((numberToTransform % 1000000 > 0) ? " "
						+ executeConversion(numberToTransform % 1000000)
						: EMPTY);
	}

}