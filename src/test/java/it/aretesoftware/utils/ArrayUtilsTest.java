package it.aretesoftware.utils;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {

    @Test
    public void toObjectArray() {
        Assert.assertArrayEquals(new Integer[] {1, 2, 3}, ArrayUtils.toObjectArray(new int[] {1, 2, 3}));
        Assert.assertArrayEquals(new Float[] {1f, 2f, 3f}, ArrayUtils.toObjectArray(new float[] {1f, 2f, 3f}));
        Assert.assertArrayEquals(new Long[] {1L, 2L, 3L}, ArrayUtils.toObjectArray(new long[] {1L, 2L, 3L}));
        Assert.assertArrayEquals(new Double[] {1d, 2d, 3d}, ArrayUtils.toObjectArray(new double[] {1d, 2d, 3d}));
        Assert.assertArrayEquals(new Short[] {1, 2, 3}, ArrayUtils.toObjectArray(new short[] {1, 2, 3}));
        Assert.assertArrayEquals(new Byte[] {1, 2, 3}, ArrayUtils.toObjectArray(new byte[] {1, 2, 3}));
        Assert.assertArrayEquals(new Boolean[] {true, false}, ArrayUtils.toObjectArray(new boolean[] {true, false}));
        Assert.assertArrayEquals(new Character[] {'a', 'b', 'c'}, ArrayUtils.toObjectArray(new char[] {'a', 'b', 'c'}));
    }

    @Test
    public void isNullOrEmpty() {
        Assert.assertFalse(ArrayUtils.isNullOrEmpty(new int[] {1, 2, 3}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty(new int[] {}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty((int[]) null));
        Assert.assertFalse(ArrayUtils.isNullOrEmpty(new float[] {1f, 2f, 3f}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty(new float[] {}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty((float[]) null));
        Assert.assertFalse(ArrayUtils.isNullOrEmpty(new long[] {1L, 2L, 3L}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty(new long[] {}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty((long[]) null));
        Assert.assertFalse(ArrayUtils.isNullOrEmpty(new double[] {1d, 2d, 3d}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty(new double[] {}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty((double[]) null));
        Assert.assertFalse(ArrayUtils.isNullOrEmpty(new short[] {1, 2, 3}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty(new short[] {}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty((short[]) null));
        Assert.assertFalse(ArrayUtils.isNullOrEmpty(new byte[] {1, 2, 3}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty(new byte[] {}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty((byte[]) null));
        Assert.assertFalse(ArrayUtils.isNullOrEmpty(new boolean[] {true, false}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty(new boolean[] {}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty((boolean[]) null));
        Assert.assertFalse(ArrayUtils.isNullOrEmpty(new char[] {'a', 'b', 'c'}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty(new char[] {}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty((char[]) null));
        Assert.assertFalse(ArrayUtils.isNullOrEmpty(new String[] {"a", "b", "c"}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty(new String[] {}));
        Assert.assertTrue(ArrayUtils.isNullOrEmpty((String[]) null));
    }

    @Test
    public void isIndexValid() {
        int[] intArray = new int[] {1, 2, 3};
        Assert.assertFalse(ArrayUtils.isIndexValid(intArray, -1));
        Assert.assertTrue(ArrayUtils.isIndexValid(intArray, 0));
        Assert.assertTrue(ArrayUtils.isIndexValid(intArray, 2));
        Assert.assertFalse(ArrayUtils.isIndexValid(intArray, 4));
        float[] floatArray = new float[] {1f, 2f, 3f};
        Assert.assertFalse(ArrayUtils.isIndexValid(floatArray, -1));
        Assert.assertTrue(ArrayUtils.isIndexValid(floatArray, 0));
        Assert.assertTrue(ArrayUtils.isIndexValid(floatArray, 2));
        Assert.assertFalse(ArrayUtils.isIndexValid(floatArray, 4));
        long[] longArray = new long[] {1L, 2L, 3L};
        Assert.assertFalse(ArrayUtils.isIndexValid(longArray, -1));
        Assert.assertTrue(ArrayUtils.isIndexValid(longArray, 0));
        Assert.assertTrue(ArrayUtils.isIndexValid(longArray, 2));
        Assert.assertFalse(ArrayUtils.isIndexValid(longArray, 4));
        double[] doubleArray = new double[] {1d, 2d, 3d};
        Assert.assertFalse(ArrayUtils.isIndexValid(doubleArray, -1));
        Assert.assertTrue(ArrayUtils.isIndexValid(doubleArray, 0));
        Assert.assertTrue(ArrayUtils.isIndexValid(doubleArray, 2));
        Assert.assertFalse(ArrayUtils.isIndexValid(doubleArray, 4));
        short[] shortArray = new short[] {1, 2, 3};
        Assert.assertFalse(ArrayUtils.isIndexValid(shortArray, -1));
        Assert.assertTrue(ArrayUtils.isIndexValid(shortArray, 0));
        Assert.assertTrue(ArrayUtils.isIndexValid(shortArray, 2));
        Assert.assertFalse(ArrayUtils.isIndexValid(shortArray, 4));
        byte[] byteArray = new byte[] {1, 2, 3};
        Assert.assertFalse(ArrayUtils.isIndexValid(byteArray, -1));
        Assert.assertTrue(ArrayUtils.isIndexValid(byteArray, 0));
        Assert.assertTrue(ArrayUtils.isIndexValid(byteArray, 2));
        Assert.assertFalse(ArrayUtils.isIndexValid(byteArray, 4));
        boolean[] booleanArray = new boolean[] {true, false};
        Assert.assertFalse(ArrayUtils.isIndexValid(booleanArray, -1));
        Assert.assertTrue(ArrayUtils.isIndexValid(booleanArray, 0));
        Assert.assertTrue(ArrayUtils.isIndexValid(booleanArray, 1));
        Assert.assertFalse(ArrayUtils.isIndexValid(booleanArray, 2));
        char[] charArray = new char[] {'a', 'b', 'c'};
        Assert.assertFalse(ArrayUtils.isIndexValid(charArray, -1));
        Assert.assertTrue(ArrayUtils.isIndexValid(charArray, 0));
        Assert.assertTrue(ArrayUtils.isIndexValid(charArray, 2));
        Assert.assertFalse(ArrayUtils.isIndexValid(charArray, 4));
        String[] stringArray = new String[] {"a", "b", "c"};
        Assert.assertFalse(ArrayUtils.isIndexValid(stringArray, -1));
        Assert.assertTrue(ArrayUtils.isIndexValid(stringArray, 0));
        Assert.assertTrue(ArrayUtils.isIndexValid(stringArray, 2));
        Assert.assertFalse(ArrayUtils.isIndexValid(stringArray, 4));
    }

}