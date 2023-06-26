package it.aretesoftware.couscous;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import it.aretesoftware.couscous.exceptions.DataParserException;

public class DataParser {

    public static Object toObject(String value) {
        if (isColor(value)) {
            return toColor(value);
        }
        else if (isVector3(value)) {
            return toVector3(value);
        }
        else if (isVector2(value)) {
            return toVector2(value);
        }
        else if (isBoolean(value)) {
            return Boolean.parseBoolean(value);
        }
        else if (isNumeric(value)) {
            return toNumber(value);
        }
        return value;
    }



    public static boolean isNumeric(String value) {
        return value.matches("(^(\\+|-)?)([0-9])*((\\.?[0-9]+)?(f|F|d|D)?)$");
    }

    public static Number toNumber(String value, Number defaultValue) {
        return isNumeric(value) ? toNumber(value) : defaultValue;
    }

    @SuppressWarnings("DuplicateCondition")
    public static Number toNumber(String value) {
        if (!isNumeric(value)) throw new DataParserException("'" + value + "' is not a number.");
        if (value.contains(".") || value.contains("f") || value.contains("F")) {
            return Float.parseFloat(value);
        }
        else if (value.contains(".") || value.contains("d") || value.contains("D")) {
            return Double.parseDouble(value);
        }
        else if (value.contains("l") || value.contains("L")) {
            return Long.parseLong(value);
        }
        else {
            return Integer.decode(value);   //decode() checks for hexadecimal numbers
        }
    }



    public static boolean isBoolean(String value) {
        return value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");
    }

    public static boolean toBoolean(String value, boolean defaultValue) {
        return isBoolean(value) ? toBoolean(value) : defaultValue;
    }

    public static boolean toBoolean(String value) {
        if (value.equalsIgnoreCase("true")) {
            return true;
        }
        else if (value.equalsIgnoreCase("false")) {
            return false;
        }
        else {
            throw new DataParserException("'" + value + "' is not a boolean.");
        }
    }



    public static boolean isColor(String value) {
        return isValid(value, 4);
    }

    public static Color toColor(String value, Color defaultValue) {
        return isColor(value) ? toColor(value) : defaultValue;
    }

    public static Color toColor(String value) {
        String[] split = checkConditions(value, 4,
                "'" + value + "' does not have the four RGBA values that make up a Color.",
                "One of the RGBA values in '" + value + "' is not a number.");
        float r = Float.parseFloat(split[0]);
        float g = Float.parseFloat(split[1]);
        float b = Float.parseFloat(split[2]);
        float a = Float.parseFloat(split[3]);
        return new Color(r, g, b, a);
    }



    public static boolean isVector3(String value) {
        return isValid(value, 3);
    }

    public static Vector3 toVector3(String value, Vector3 defaultValue) {
        return isVector3(value) ? toVector3(value) : defaultValue;
    }

    public static Vector3 toVector3(String value) {
        String[] split = checkConditions(value, 3,
                "'" + value + "' does not have the three XYZ values that make up a Vector3.",
                "One of the XYZ values in '" + value + "' is not a number.");
        float x = Float.parseFloat(split[0]);
        float y = Float.parseFloat(split[1]);
        float z = Float.parseFloat(split[2]);
        return new Vector3(x, y, z);
    }



    public static boolean isVector2(String value) {
        return isValid(value, 2);
    }

    public static Vector2 toVector2(String value, Vector2 defaultValue) {
        return isVector2(value) ? toVector2(value) : defaultValue;
    }

    public static Vector2 toVector2(String value) {
        String[] split = checkConditions(value, 2,
                "'" + value + "' does not have the two XY values that make up a Vector2.",
                "One of the XY values in '" + value + "' is not a number.");
        float x = Float.parseFloat(split[0]);
        float y = Float.parseFloat(split[1]);
        return new Vector2(x, y);
    }

    //

    private static boolean isValid(String value, int arrayLengthAllowed) {
        String[] split = value.split(" +");
        if (split.length != arrayLengthAllowed) {
            return false;
        }
        for (String number : split) {
            if (!isNumeric(number)) {
                return false;
            }
        }
        return true;
    }

    private static String[] checkConditions(String value, int arrayLengthAllowed, String arrayLengthErrorMessage, String notNumericErrorMessage) throws DataParserException {
        String[] split = value.split(" +");
        if (split.length != arrayLengthAllowed) {
            throw new DataParserException(arrayLengthErrorMessage);
        }
        for (String number : split) {
            if (!isNumeric(number)) {
                throw new DataParserException(notNumericErrorMessage);
            }
        }
        return split;
    }

}
