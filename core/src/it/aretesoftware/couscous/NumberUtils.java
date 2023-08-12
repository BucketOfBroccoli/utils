package it.aretesoftware.couscous;

/**
 * Various methods for easier handling of numbers.
 * @author AreteS0ftware */
public class NumberUtils {

    public static final String DECIMAL_REGEX = "^(\\+|-)?([0-9])*\\.{1}([0-9]+)?(f|F|d|D)?$";
    public static final String INTEGER_REGEX = "^(\\+|-)?([0-9]+)$";
    public static final String HEXADECIMAL_REGEX = "(#|0x|0X)?[0-9a-fA-F]+$";
    public static final String WHITESPACE_REGEX = "[ \\t\\n]+";
    public static final String TRAILLESS_NUMBER_REGEX = "^(\\+|-)?([0-9])*\\.?([0-9]+)?$";

    private NumberUtils() {

    }

    public static float roundOffTo2DecPlaces(float value) {
        return (float) (Math.round(value * 100.0) / 100.0);
    }

    public static float roundOffTo3DecPlaces(float value) {
        return (float) (Math.round(value * 1000.0) / 1000.0);
    }

    public static float roundOffTo2DecPlaces(double value) {
        return (float) (Math.round(value * 100.0) / 100.0);
    }

    public static float roundOffTo3DecPlaces(double value) {
        return (float) (Math.round(value * 1000.0) / 1000.0);
    }

    public static int max(int... array) {
        checkConditions(array);
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int min(int... array) {
        checkConditions(array);
        int min = Integer.MAX_VALUE;
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static float max(float... array) {
        checkConditions(array);
        float max = Float.MIN_VALUE;
        for (float value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static float min(float... array) {
        checkConditions(array);
        float min = Float.MAX_VALUE;
        for (float value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static float average(int... array) {
        float sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    public static float average(float... array) {
        float sum = 0;
        for (float value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    private static void checkConditions(int... array) {
        if (array == null) {
            throw new NumberUtilsException("array is null.");
        }
        else if (array.length == 0) {
            throw new NumberUtilsException("array is empty.");
        }
    }

    private static void checkConditions(float... array) {
        if (array == null) {
            throw new NumberUtilsException("array is null.");
        }
        else if (array.length == 0) {
            throw new NumberUtilsException("array is empty.");
        }
    }

    public static boolean isDecimal(String value) {
        // Float & Double
        return value.matches(DECIMAL_REGEX);
    }

    public static boolean isInteger(String value) {
        // Long & Integer
        return value.matches(INTEGER_REGEX);
    }

    public static boolean isHexadecimal(String value) {
        // Hexadecimal
        return value.matches(HEXADECIMAL_REGEX);
    }

    public static boolean isNumber(String value) {
        value = value.trim();
        boolean isNumeric = isDecimal(value);
        if (!isNumeric) isNumeric = isInteger(value);
        if (!isNumeric) isNumeric = isHexadecimal(value);
        return isNumeric;
    }

    static class NumberUtilsException extends RuntimeException {
        NumberUtilsException(String message) {
            super(message);
        }
    }

}
