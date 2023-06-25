package it.aretesoftware.couscous;

public class Numbers {

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

    //

    public static int roundUp(float value) {
        return (int) Math.ceil(value);
    }

    public static int roundUp(double value) {
        return (int) Math.ceil(value);
    }

    public static int roundDown(float value) {
        return (int) Math.floor(value);
    }

    public static int roundDown(double value) {
        return (int) Math.floor(value);
    }

    //

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

    //

    private static void checkConditions(int... array) {
        if (array == null) {
            throw new NumbersException("array is null.");
        }
        else if (array.length == 0) {
            throw new NumbersException("array is empty.");
        }
    }

    private static void checkConditions(float... array) {
        if (array == null) {
            throw new NumbersException("array is null.");
        }
        else if (array.length == 0) {
            throw new NumbersException("array is empty.");
        }
    }

    private static class NumbersException extends RuntimeException {
        public NumbersException(String message) {
            super(message);
        }
    }

}
