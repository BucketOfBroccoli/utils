package it.aretesoftware.utils;

/**
 * Various methods for handling numbers.
 * @author BucketOfBroccoli */
public class NumberUtils {

    private NumberUtils() {

    }

    public static float roundOffTo2DecimalPlaces(float value) {
        return roundOff(value, 2);
    }

    public static float roundOffTo3DecimalPlaces(float value) {
        return roundOff(value, 3);
    }

    public static float roundOffTo2DecimalPlaces(double value) {
        return roundOff(value, 2);
    }

    public static float roundOffTo3DecimalPlaces(double value) {
        return roundOff(value, 3);
    }

    public static float roundOff(double value, int places) {
        float roundOff = getRoundingDivisor(places);
        return (Math.round(value * roundOff) / roundOff);
    }

    public static float roundOff(float value, int places) {
        float roundOff = getRoundingDivisor(places);
        return (Math.round(value * roundOff) / roundOff);
    }

    private static float getRoundingDivisor(int places) {
        if (places < 0) {
            throw new NumberUtilsException("Number of decimal places for rounding off a number must be positive.");
        }
        else if (places == 0) {
            return 1;
        }
        else {
            return Float.parseFloat(
                    String.format("1%0" + places + "d", 0)
            );
        }
    }

    public static int roundNearest(float value, int nearest) {
        boolean negative = value < 0;
        if (negative) nearest = -nearest;
        return Math.round(value / nearest) * nearest;
    }

    public static int floorNearest(float value, int nearest) {
        boolean negative = value < 0;
        if (negative) nearest = -nearest;
        return (int) (Math.floor(value / nearest) * nearest);
    }

    public static int ceilNearest(float value, int nearest) {
        boolean negative = value < 0;
        if (negative) nearest = -nearest;
        return (int) (Math.ceil(value / nearest) * nearest);
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

    public static boolean isNumber(String value) {
        return getNumberType(value) != NumberType.nan;
    }

    public static boolean isInteger(String value) {
        return getNumberType(value) == NumberType.integer;
    }

    public static boolean isDecimal(String value) {
        return getNumberType(value) == NumberType.decimal;
    }

    public static boolean isHexadecimal(String value) {
        return getNumberType(value) == NumberType.hexadecimal;
    }

    public static boolean isScientific(String value) {
        return getNumberType(value) == NumberType.scientific;
    }

    private static NumberType getNumberType(String value) {
        if (value == null || value.isEmpty()) {
            return NumberType.nan;
        }

        boolean possibleHexadecimal = false;
        boolean possibleDecimal = false;
        boolean possibleScientificNotation = false;
        boolean signed = false;
        int dotIndex = -1, exponentIndex = -1;

        char[] charArray = value.toCharArray();
        int stringLength = charArray.length;
        for (int index = 0; index < charArray.length; index++) {
            char c = charArray[index];
            switch (c) {
                case '+':
                case '-':
                    signed = true;
                    continue;
                case '#':
                case 'A':
                case 'B':
                case 'C':
                case 'X':
                case 'a':
                case 'b':
                case 'c':
                case 'x':
                    possibleHexadecimal = true;
                    continue;
                case 'd':
                case 'f':
                case 'D':
                case 'F':
                    possibleDecimal = true;
                    possibleHexadecimal = true;
                    continue;
                case 'E':
                case 'e':
                    possibleScientificNotation = true;
                    possibleHexadecimal = true;
                    exponentIndex = index;
                    continue;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    continue;
                case '.':
                    if (dotIndex >= 0) {
                        // More than one dot detected means
                        // the string is not a number
                        return NumberType.nan;
                    }
                    possibleDecimal = true;
                    dotIndex = index;
                    continue;
                default:
                    // any other character means
                    // the string is not a number
                    return NumberType.nan;
            }
        }

        // Store whether the String starts with the following:
        // #
        // 0X
        // 0x
        int signOffset = 0;
        if (signed && (charArray[0] == '+' || charArray[0] == '-')) {
            signOffset = 1;
        }
        boolean startsWithPound = charArray[signOffset] == '#';
        boolean startsWithZeroX = charArray[signOffset] == '0' && charArray.length >= 2
                && (charArray[signOffset + 1] == 'X' || charArray[signOffset + 1] == 'x');

        if (!startsWithPound && !startsWithZeroX && possibleDecimal) {
            char trail = charArray[stringLength - 1];
            if (trail == 'f' || trail == 'F' || trail == 'd' || trail == 'D') {
                if (dotIndex == stringLength - 2 && dotIndex - 1 < 0) {
                    return NumberType.nan;
                }
                char beforeTrail = charArray[stringLength - 2];
                if (!Character.isDigit(beforeTrail) && beforeTrail != '.') {
                    return NumberType.nan;
                }
            }
        }

        if (possibleHexadecimal) {
            if (startsWithPound || startsWithZeroX) {
                int startOffset = startsWithPound ? 1 : 2;
                for (int index = signOffset + startOffset; index < stringLength; index++) {
                    char c = charArray[index];
                    switch (c) {
                        case '#':
                        case 'x':
                        case 'X':
                            return NumberType.nan;
                    }
                }
                // if there's no dot and there's more characters than the leading ones, it's a hexadecimal
                return dotIndex < 0 && (startsWithPound ? charArray.length > 1 : charArray.length > 2)
                        ? NumberType.hexadecimal : NumberType.nan;
            }
        }

        if (!startsWithPound && !startsWithZeroX && possibleScientificNotation) {
            char next = charArray[exponentIndex + 1];
            if (!Character.isDigit(next) && next != '+' && next != '-') {
                return NumberType.nan;
            }
            if (dotIndex == exponentIndex - 1) {
                if (dotIndex - 1 < 0) {
                    return NumberType.nan;
                }
                char beforeDot = charArray[dotIndex - 1];
                if (!Character.isDigit(beforeDot)) {
                    return NumberType.nan;
                }
            }
            for (int index = exponentIndex + 2; index < stringLength; index++) {
                char character = charArray[index];
                if (Character.isDigit(character)) {
                    continue;
                }
                if (index == stringLength - 1) {
                    if (character == 'f' || character == 'F' || character == 'd' || character == 'D') {
                        return NumberType.scientific;
                    }
                }
                else {
                    return NumberType.nan;
                }
            }
            return NumberType.scientific;
        }

        return possibleDecimal ? NumberType.decimal : NumberType.integer;
    }

    public static Number toNumber(String value, Number defaultValue) {
        return isNumber(value) ? toNumber(value) : defaultValue;
    }

    public static Number toNumber(String value) {
        return toNumber(value, getNumberType(value));
    }

    private static Number toNumber(String value, NumberType type) {
        switch (type) {
            case integer:
                return Integer.parseInt(value);
            case hexadecimal:
                return Integer.decode(value);
            case decimal:
            case scientific:
                if (value.endsWith("f") || value.endsWith("F")) {
                    return Float.parseFloat(value);
                }
                else if (value.endsWith("d") || value.endsWith("D")) {
                    return Double.parseDouble(value);
                }
                return Float.parseFloat(value);
            default:
                throw new NumberUtilsException("'" + value + "' is not a number.");
        }
    }

    enum NumberType {
        integer,
        decimal,
        hexadecimal,
        scientific,
        nan
    }

    static class NumberUtilsException extends RuntimeException {
        NumberUtilsException(String message) {
            super(message);
        }
    }

}