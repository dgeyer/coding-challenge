package com.ink.challenge;

import java.util.Locale;

public class NumberToWordsConverterFactory {

	public static NumberToWordsConverter getNumberToWordsConverter(String language) {
		if (Locale.ENGLISH.getLanguage().equals(language)) {
			return new EnglishNumberToWordsConverter();
		} else {
			throw new IllegalArgumentException("Language not implemented!");
		}

	}

}
