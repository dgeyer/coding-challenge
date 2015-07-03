package com.ink.challenge;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

public class NumberToWordsConverterTest {

	@Test
	public void zero() {

		String numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(0);
		assertEquals("zero", numberInEnglish);
	}

	@Test
	public void units() {
		String numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(5);
		assertEquals("five", numberInEnglish);

		numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(9);
		assertEquals("nine", numberInEnglish);
	}

	@Test
	public void thenths() {
		String numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(21);
		assertEquals("twenty one", numberInEnglish);

		numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(99);
		assertEquals("ninety nine", numberInEnglish);
	}

	@Test
	public void hundreds() {
		String numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(105);
		assertEquals("one hundred and five", numberInEnglish);

		numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(100);
		assertEquals("one hundred", numberInEnglish);
	}

	@Test
	public void thousands() {
		String numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(2560);
		assertEquals("two thousand five hundred and sixty", numberInEnglish);

		numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(9434);
		assertEquals("nine thousand four hundred and thirty four",
				numberInEnglish);

		numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(16320);
		assertEquals("sixteen thousand three hundred and twenty",
				numberInEnglish);

		numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(95430);
		assertEquals("ninety five thousand four hundred and thirty",
				numberInEnglish);
	}

	@Test
	public void hundredsThousands() {
		String numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(100000);
		assertEquals("one hundred thousand", numberInEnglish);

		numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(160489);
		assertEquals(
				"one hundred and sixty thousand four hundred and eighty nine",
				numberInEnglish);
	}

	@Test
	public void millions() {
		String numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(56945781);
		assertEquals(
				"fifty six million nine hundred and forty five thousand seven hundred and eighty one",
				numberInEnglish);

		numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(100000000);
		assertEquals("one hundred million", numberInEnglish);

		numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(999999999);
		assertEquals(
				"nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine",
				numberInEnglish);
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalArgument() {
		String numberInEnglish = NumberToWordsConverterFactory
				.getNumberToWordsConverter(Locale.ENGLISH.getLanguage())
				.convert(1999999999);
	}

}
