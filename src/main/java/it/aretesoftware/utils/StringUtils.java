package it.aretesoftware.utils;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Various methods for handling strings.
 * @author BucketOfBroccoli */
public class StringUtils {

    private StringUtils() {

    }

    public static String upperCaseFirstCharacter(String value) {
        return upperCaseCharacter(value, 0);
    }

    public static String lowerCaseFirstCharacter(String value) {
        return lowerCaseCharacter(value, 0);
    }

    public static String upperCaseCharacter(String value, int charIndex) {
        if (value == null) {
            throw new StringUtilsException("String is null.");
        }
        else if (value.isEmpty()) {
            return value;
        }
        if (!isIndexValid(value, charIndex))
            throw new StringUtilsException("Index " + charIndex + " of string '" + value + "' is out of bounds.");
        StringBuilder builder = new StringBuilder();
        builder.append(value.substring(0, charIndex));
        builder.append(Character.toUpperCase(value.charAt(charIndex)));
        builder.append(value.substring(charIndex + 1, value.length()));
        return builder.toString();
    }

    public static String lowerCaseCharacter(String value, int charIndex) {
        if (value == null) {
            throw new StringUtilsException("String is null.");
        }
        else if (value.isEmpty()) {
            return value;
        }
        if (!isIndexValid(value, charIndex))
            throw new StringUtilsException("Index " + charIndex + " of string '" + value + "' is out of bounds.");
        StringBuilder builder = new StringBuilder();
        builder.append(value.substring(0, charIndex));
        builder.append(Character.toLowerCase(value.charAt(charIndex)));
        builder.append(value.substring(charIndex + 1, value.length()));
        return builder.toString();
    }

    public static String surroundWithDoubleQuotes(String value) {
        return surround(value, "\"", "\"");
    }

    public static String surroundWithSingleQuotes(String value) {
        return surround(value, "'", "'");
    }

    public static String surroundWithRoundBrackets(String value) {
        return surround(value, "(", ")");
    }

    public static String surroundWithSquareBrackets(String value) {
        return surround(value, "[", "]");
    }

    public static String surroundWithCurlyBrackets(String value) {
        return surround(value, "{", "}");
    }

    public static String surroundWithChevrons(String value) {
        return surround(value, "<", ">");
    }

    public static String surround(String value, char first, char second) {
        return surround(value, String.valueOf(first), String.valueOf(second));
    }

    public static String surround(String value, String first, String second) {
        StringBuilder builder = new StringBuilder();
        builder.append(first);
        builder.append(value);
        builder.append(second);
        return builder.toString();
    }

    public static String join(String[] values, char separator) {
        return join(Arrays.asList(values), String.valueOf(separator));
    }

    public static String join(String[] values, String separator) {
        return join(Arrays.asList(values), separator);
    }

    public static String join(Iterable<String> pieces, String separator) {
        StringBuilder buffer = new StringBuilder();
        Iterator<String> iterator = pieces.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next());
            if (iterator.hasNext()) {
                buffer.append(separator);
            }
        }
        return buffer.toString();
    }

    public static int countCharacter(String value, char character) {
        int counter = 0;
        for (char c : value.toCharArray()) {
            if (character == c) {
                counter++;
            }
        }
        return counter;
    }

    public static int countCharacterIgnoreCase(String value, char character) {
        int counter = 0;
        for (char c : value.toCharArray()) {
            if (Character.toUpperCase(c) == character
                    || Character.toLowerCase(c) == character) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isIndexValid(String value, int charIndex) {
        if (value == null) throw new StringUtilsException("String is null.");
        return charIndex >= 0 && charIndex < value.length();
    }

    static class StringUtilsException extends RuntimeException {
        StringUtilsException(String message) {
            super(message);
        }
    }

}