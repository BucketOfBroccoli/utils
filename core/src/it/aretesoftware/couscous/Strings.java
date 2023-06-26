package it.aretesoftware.couscous;

@SuppressWarnings("All")
public class Strings {

    public static String upperCaseFirstCharacter(String value) {
        if (isNullOrEmpty(value)) return value;
        StringBuilder builder = new StringBuilder();
        builder.append(Character.toUpperCase(value.charAt(0)));
        builder.append(value.substring(1));
        return builder.toString();
    }

    public static String lowerCaseFirstCharacter(String value) {
        if (isNullOrEmpty(value)) return value;
        StringBuilder builder = new StringBuilder();
        builder.append(Character.toLowerCase(value.charAt(0)));
        builder.append(value.substring(1));
        return builder.toString();
    }

    //

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

    //

    public static String join(char separator, String... values) {
        return join(String.valueOf(separator), values);
    }

    public static String join(String separator, String... values) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < values.length; index++) {
            String value = values[index];
            builder.append(value);
            if (index < values.length - 1) {
                builder.append(separator);
            }
        }
        return builder.toString();
    }

    //

    public static int countCharacter(String value, char characterToCount) {
        int counter = 0;
        for (char character : value.toCharArray()) {
            if (character == characterToCount) {
                counter++;
            }
        }
        return counter;
    }

    public static int countCharacterIgnoreCase(String value, char characterToCount) {
        int counter = 0;
        for (char character : value.toCharArray()) {
            if (Character.toUpperCase(character) == characterToCount
                || Character.toLowerCase(character) == characterToCount) {
                counter++;
            }
        }
        return counter;
    }

    //

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

}
