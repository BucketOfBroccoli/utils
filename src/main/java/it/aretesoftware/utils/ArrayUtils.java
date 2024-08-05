package it.aretesoftware.utils;

/**
 * Various methods for handling arrays.
 * @author BucketOfBroccoli */
public class ArrayUtils {

    private ArrayUtils() {

    }

    public static Integer[] toObjectArray(int[] array) {
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Float[] toObjectArray(float[] array) {
        Float[] result = new Float[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Long[] toObjectArray(long[] array) {
        Long[] result = new Long[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Double[] toObjectArray(double[] array) {
        Double[] result = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Short[] toObjectArray(short[] array) {
        Short[] result = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Byte[] toObjectArray(byte[] array) {
        Byte[] result = new Byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Boolean[] toObjectArray(boolean[] array) {
        Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Character[] toObjectArray(char[] array) {
        Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static boolean isNullOrEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNullOrEmpty(float[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNullOrEmpty(long[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNullOrEmpty(double[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNullOrEmpty(short[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNullOrEmpty(byte[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNullOrEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNullOrEmpty(char[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNullOrEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isIndexValid(int[] array, int index) {
        if (array == null) throw new ArrayUtilsException("Array is null.");
        return index >= 0 && index < array.length;
    }

    public static boolean isIndexValid(float[] array, int index) {
        if (array == null) throw new ArrayUtilsException("Array is null.");
        return index >= 0 && index < array.length;
    }

    public static boolean isIndexValid(long[] array, int index) {
        if (array == null) throw new ArrayUtilsException("Array is null.");
        return index >= 0 && index < array.length;
    }

    public static boolean isIndexValid(double[] array, int index) {
        if (array == null) throw new ArrayUtilsException("Array is null.");
        return index >= 0 && index < array.length;
    }

    public static boolean isIndexValid(short[] array, int index) {
        if (array == null) throw new ArrayUtilsException("Array is null.");
        return index >= 0 && index < array.length;
    }

    public static boolean isIndexValid(byte[] array, int index) {
        if (array == null) throw new ArrayUtilsException("Array is null.");
        return index >= 0 && index < array.length;
    }

    public static boolean isIndexValid(boolean[] array, int index) {
        if (array == null) throw new ArrayUtilsException("Array is null.");
        return index >= 0 && index < array.length;
    }

    public static boolean isIndexValid(char[] array, int index) {
        if (array == null) throw new ArrayUtilsException("Array is null.");
        return index >= 0 && index < array.length;
    }

    public static boolean isIndexValid(Object[] array, int index) {
        if (array == null) throw new ArrayUtilsException("Array is null.");
        return index >= 0 && index < array.length;
    }

    static class ArrayUtilsException extends RuntimeException {
        ArrayUtilsException(String message) {
            super(message);
        }
    }

}
