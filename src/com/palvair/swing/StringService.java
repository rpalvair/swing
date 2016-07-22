package com.palvair.swing;

public class StringService {

	public static String capitalize(final String input) {
		if (hasWhiteSpaces(input)) {
			final String[] parts = input.split("\\s+");
			String result = "";
			for (String part : parts) {
				result += capitalizePart(part) + " ";
			}
			return result;
		}
		if (input != null && input.length() > 0) {
			return capitalizePart(input);
		}
		throw new RuntimeException("Input should not be null or empty");
	}

	public static boolean hasWhiteSpaces(final String input) {
		for (int i = 0; i < input.length(); i++) {
			if (Character.isWhitespace(input.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static String capitalizePart(final String part) {
		return part.substring(0, 1).toUpperCase().concat(part.substring(1));
	}
}
