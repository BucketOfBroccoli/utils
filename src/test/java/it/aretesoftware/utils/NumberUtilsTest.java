package it.aretesoftware.utils;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtilsTest {

    @Test
    public void isNumber() {
        // Float & Double
        Assert.assertTrue(NumberUtils.isNumber("0.1"));
        Assert.assertTrue(NumberUtils.isNumber("0.1f"));
        Assert.assertTrue(NumberUtils.isNumber(".1f"));
        Assert.assertTrue(NumberUtils.isNumber("0.f"));
        Assert.assertTrue(NumberUtils.isNumber("0.2d"));
        Assert.assertTrue(NumberUtils.isNumber("0.d"));
        Assert.assertTrue(NumberUtils.isNumber(".2d"));

        // Integer & Long
        Assert.assertTrue(NumberUtils.isNumber("0"));
        Assert.assertTrue(NumberUtils.isNumber("999"));
        Assert.assertTrue(NumberUtils.isNumber("-1"));
        Assert.assertTrue(NumberUtils.isNumber("+1"));

        // Hexadecimal Integers
        Assert.assertTrue(NumberUtils.isNumber("#8009"));
        Assert.assertTrue(NumberUtils.isNumber("0x8009"));
        Assert.assertTrue(NumberUtils.isNumber("#0DE1"));
        Assert.assertTrue(NumberUtils.isNumber("0x0DE1"));
        Assert.assertFalse(NumberUtils.isNumber("#0x8009"));
        Assert.assertFalse(NumberUtils.isNumber("0x#8009"));
        Assert.assertFalse(NumberUtils.isNumber("8009z"));

        // Scientific Notation
        Assert.assertTrue(NumberUtils.isNumber("1.2846202978398e+19"));
        Assert.assertTrue(NumberUtils.isNumber("1e3"));
        Assert.assertTrue(NumberUtils.isNumber("100e5"));
        Assert.assertTrue(NumberUtils.isNumber("-1.2846202978398e+19"));
        Assert.assertTrue(NumberUtils.isNumber("+1e3"));
        Assert.assertTrue(NumberUtils.isNumber("-100e5"));
        Assert.assertTrue(NumberUtils.isNumber("1.57e3f"));
        Assert.assertTrue(NumberUtils.isNumber("1.57e3F"));
        Assert.assertTrue(NumberUtils.isNumber("1.57e3d"));
        Assert.assertTrue(NumberUtils.isNumber("1.57e3D"));
    }

    @Test
    public void isInteger() {
        // Unsigned integer
        Assert.assertTrue(NumberUtils.isInteger("321"));
        Assert.assertTrue(NumberUtils.isInteger("123"));
        Assert.assertTrue(NumberUtils.isInteger("999"));
        // Signed integer
        Assert.assertTrue(NumberUtils.isInteger("-321"));
        Assert.assertTrue(NumberUtils.isInteger("+123"));
        Assert.assertTrue(NumberUtils.isInteger("-999"));
    }

    @Test
    public void isDecimal() {
        // Unsigned decimal
        Assert.assertTrue(NumberUtils.isDecimal("1.0"));
        Assert.assertTrue(NumberUtils.isDecimal("0.1"));
        Assert.assertTrue(NumberUtils.isDecimal("0.12345"));
        // Unsigned decimal w/ trail
        Assert.assertTrue(NumberUtils.isDecimal("0.1f"));
        Assert.assertTrue(NumberUtils.isDecimal("0.1F"));
        Assert.assertTrue(NumberUtils.isDecimal("0.1d"));
        Assert.assertTrue(NumberUtils.isDecimal("0.1D"));
        // Signed decimal
        Assert.assertTrue(NumberUtils.isDecimal("+1.0"));
        Assert.assertTrue(NumberUtils.isDecimal("-0.1"));
        Assert.assertTrue(NumberUtils.isDecimal("-0.12345"));
        // Signed decimal w/ trail
        Assert.assertTrue(NumberUtils.isDecimal("+0.1f"));
        Assert.assertTrue(NumberUtils.isDecimal("-0.1F"));
        Assert.assertTrue(NumberUtils.isDecimal("+0.1d"));
        Assert.assertTrue(NumberUtils.isDecimal("-0.1D"));
        // Edge cases
        Assert.assertTrue(NumberUtils.isDecimal("1.f"));
        Assert.assertTrue(NumberUtils.isDecimal("0.f"));
        Assert.assertTrue(NumberUtils.isDecimal("0.d"));
        Assert.assertFalse(NumberUtils.isDecimal(".f"));
        Assert.assertFalse(NumberUtils.isDecimal(".d"));
    }

    @Test
    public void isHexadecimal() {
        // #
        Assert.assertTrue(NumberUtils.isHexadecimal("#ABCDEF"));
        Assert.assertTrue(NumberUtils.isHexadecimal("#aBcDeF"));
        Assert.assertTrue(NumberUtils.isHexadecimal("#abcdef"));
        Assert.assertTrue(NumberUtils.isHexadecimal("+#ABCDEF"));
        Assert.assertTrue(NumberUtils.isHexadecimal("-#abcdef"));
        Assert.assertTrue(NumberUtils.isHexadecimal("#a0b1c2D3E4"));
        Assert.assertTrue(NumberUtils.isHexadecimal("#0123456789"));
        Assert.assertTrue(NumberUtils.isHexadecimal("+#A0B1C2D3E4"));
        Assert.assertTrue(NumberUtils.isHexadecimal("-#0123456789"));
        Assert.assertFalse(NumberUtils.isHexadecimal("#F33G1"));
        Assert.assertFalse(NumberUtils.isHexadecimal("+#F33G1"));
        Assert.assertFalse(NumberUtils.isHexadecimal("-#F33G1"));
        Assert.assertFalse(NumberUtils.isHexadecimal("#01234.56789"));
        Assert.assertFalse(NumberUtils.isHexadecimal("#ABC.DEF"));
        Assert.assertFalse(NumberUtils.isHexadecimal("#A0B1C2.D3E4F5"));
        Assert.assertFalse(NumberUtils.isHexadecimal("-#01234.56789"));
        Assert.assertFalse(NumberUtils.isHexadecimal("+#ABC.DEF"));
        Assert.assertFalse(NumberUtils.isHexadecimal("-#A0B1C2.D3E4F5"));
        // 0X
        Assert.assertTrue(NumberUtils.isHexadecimal("0XABCDEF"));
        Assert.assertTrue(NumberUtils.isHexadecimal("0XaBcDeF"));
        Assert.assertTrue(NumberUtils.isHexadecimal("0Xabcdef"));
        Assert.assertTrue(NumberUtils.isHexadecimal("+0XABCDEF"));
        Assert.assertTrue(NumberUtils.isHexadecimal("-0Xabcdef"));
        Assert.assertTrue(NumberUtils.isHexadecimal("0Xa0b1c2D3E4"));
        Assert.assertTrue(NumberUtils.isHexadecimal("0X0123456789"));
        Assert.assertTrue(NumberUtils.isHexadecimal("+0XA0B1C2D3E4"));
        Assert.assertTrue(NumberUtils.isHexadecimal("-0X0123456789"));
        Assert.assertFalse(NumberUtils.isHexadecimal("0XF33G1"));
        Assert.assertFalse(NumberUtils.isHexadecimal("+0XF33G1"));
        Assert.assertFalse(NumberUtils.isHexadecimal("-0XF33G1"));
        Assert.assertFalse(NumberUtils.isHexadecimal("0X01234.56789"));
        Assert.assertFalse(NumberUtils.isHexadecimal("0XABC.DEF"));
        Assert.assertFalse(NumberUtils.isHexadecimal("0XA0B1C2.D3E4F5"));
        Assert.assertFalse(NumberUtils.isHexadecimal("-0X01234.56789"));
        Assert.assertFalse(NumberUtils.isHexadecimal("+0XABC.DEF"));
        Assert.assertFalse(NumberUtils.isHexadecimal("-0XA0B1C2.D3E4F5"));
        // 0x
        Assert.assertTrue(NumberUtils.isHexadecimal("0xABCDEF"));
        Assert.assertTrue(NumberUtils.isHexadecimal("0xaBcDeF"));
        Assert.assertTrue(NumberUtils.isHexadecimal("0xabcdef"));
        Assert.assertTrue(NumberUtils.isHexadecimal("+0xABCDEF"));
        Assert.assertTrue(NumberUtils.isHexadecimal("-0xabcdef"));
        Assert.assertTrue(NumberUtils.isHexadecimal("0xa0b1c2D3E4"));
        Assert.assertTrue(NumberUtils.isHexadecimal("0x0123456789"));
        Assert.assertTrue(NumberUtils.isHexadecimal("+0xA0B1C2D3E4"));
        Assert.assertTrue(NumberUtils.isHexadecimal("-0x0123456789"));
        Assert.assertFalse(NumberUtils.isHexadecimal("0xF33G1"));
        Assert.assertFalse(NumberUtils.isHexadecimal("+0xF33G1"));
        Assert.assertFalse(NumberUtils.isHexadecimal("-0xF33G1"));
        Assert.assertFalse(NumberUtils.isHexadecimal("0x01234.56789"));
        Assert.assertFalse(NumberUtils.isHexadecimal("0xABC.DEF"));
        Assert.assertFalse(NumberUtils.isHexadecimal("0xA0B1C2.D3E4F5"));
        Assert.assertFalse(NumberUtils.isHexadecimal("-0x01234.56789"));
        Assert.assertFalse(NumberUtils.isHexadecimal("+0xABC.DEF"));
        Assert.assertFalse(NumberUtils.isHexadecimal("-0xA0B1C2.D3E4F5"));
    }

    @Test
    public void isScientific() {
        // Unsigned
        Assert.assertTrue(NumberUtils.isScientific("1.2846202978398e+19"));
        Assert.assertTrue(NumberUtils.isScientific("1e3"));
        Assert.assertTrue(NumberUtils.isScientific("100e5"));
        // Signed
        Assert.assertTrue(NumberUtils.isScientific("-1.2846202978398e+19"));
        Assert.assertTrue(NumberUtils.isScientific("+1e3"));
        Assert.assertTrue(NumberUtils.isScientific("-100e5"));
        // Unsigned exponent w/ trail
        Assert.assertTrue(NumberUtils.isScientific("1.57e3f"));
        Assert.assertTrue(NumberUtils.isScientific("1.57e3F"));
        Assert.assertTrue(NumberUtils.isScientific("1.57e3d"));
        Assert.assertTrue(NumberUtils.isScientific("1.57e3D"));
        // Signed exponent w/ trail
        Assert.assertTrue(NumberUtils.isScientific("1.57e-3f"));
        Assert.assertTrue(NumberUtils.isScientific("1.57e+3F"));
        Assert.assertTrue(NumberUtils.isScientific("1.57e+3d"));
        Assert.assertTrue(NumberUtils.isScientific("1.57e-3D"));
        // Edge cases
        Assert.assertTrue(NumberUtils.isScientific("0.e3"));
        Assert.assertTrue(NumberUtils.isScientific("0.e3f"));
        Assert.assertFalse(NumberUtils.isScientific(".e3"));
        Assert.assertFalse(NumberUtils.isScientific(".e-3"));
    }

    @Test
    public void toNumber() {
        // Float & Double
        final float delta = 0.00000001f;
        Assert.assertEquals(NumberUtils.toNumber("0.1").floatValue(), 0.1, delta);
        Assert.assertEquals(NumberUtils.toNumber("0.1f").floatValue(), 0.1, delta);
        Assert.assertEquals(NumberUtils.toNumber(".1f").floatValue(), 0.1, delta);
        Assert.assertEquals(NumberUtils.toNumber("1.f").floatValue(), 1, delta);
        Assert.assertEquals(NumberUtils.toNumber("0.1").doubleValue(), 0.1, delta);
        Assert.assertEquals(NumberUtils.toNumber("0.1d").doubleValue(), 0.1, delta);
        Assert.assertEquals(NumberUtils.toNumber(".1d").doubleValue(), 0.1, delta);
        Assert.assertEquals(NumberUtils.toNumber("1.d").doubleValue(), 1, delta);
        Assert.assertEquals(NumberUtils.toNumber("wasd", 0.1f), 0.1f);
        // Integer & Long
        Assert.assertEquals(NumberUtils.toNumber("1").intValue(), 1, 0);
        Assert.assertEquals(NumberUtils.toNumber("1").longValue(), 1, 0);
        // Hexadecimal Integers
        Assert.assertEquals(NumberUtils.toNumber("0x8B87").intValue(), 35719, 0);
        Assert.assertEquals(NumberUtils.toNumber("#8B87").intValue(), 35719, 0);
        Assert.assertEquals(NumberUtils.toNumber("0x8009").intValue(), 32777, 0);
        Assert.assertEquals(NumberUtils.toNumber("#8009").intValue(), 32777, 0);
        Assert.assertEquals(NumberUtils.toNumber("8009").intValue(), 8009, 0);
        // Scientific Notation
        Assert.assertEquals(NumberUtils.toNumber("1e3").intValue(), 1000, 0);
        Assert.assertEquals(NumberUtils.toNumber("100e5").intValue(), 10000000, 0);
        // NaN
        Assert.assertEquals(NumberUtils.toNumber("Test", 5).intValue(), 5, 0);
        Assert.assertEquals(NumberUtils.toNumber("10", 5).intValue(), 10, 0);
    }

    @Test
    public void roundOffTo2DecimalPlaces() {
        Assert.assertEquals(NumberUtils.roundOffTo2DecimalPlaces(0.123456789f), 0.12f, 0f);
        Assert.assertEquals(NumberUtils.roundOffTo2DecimalPlaces(0.123456789d), 0.12f, 0f);
    }

    @Test
    public void roundOffTo3DecimalPlaces() {
        Assert.assertEquals(NumberUtils.roundOffTo3DecimalPlaces(0.123456789f), 0.123f, 0f);
        Assert.assertEquals(NumberUtils.roundOffTo3DecimalPlaces(0.123456789d), 0.123f, 0f);
    }

    @Test
    public void roundOff() {
        Assert.assertEquals(NumberUtils.roundOff(1.123f, 0), 1f, 0f);

        Assert.assertEquals(NumberUtils.roundOff(1.123456789f, 2), 1.12f, 0f);

        Assert.assertEquals(NumberUtils.roundOff(0.123456789f, 2), 0.12f, 0f);
        Assert.assertEquals(NumberUtils.roundOff(0.123456789d, 2), 0.12f, 0f);

        Assert.assertEquals(NumberUtils.roundOff(0.123456789f, 3), 0.123f, 0f);
        Assert.assertEquals(NumberUtils.roundOff(0.123456789d, 3), 0.123f, 0f);

        Assert.assertEquals(NumberUtils.roundOff(0.123456789f, 4), 0.1235f, 0f);
        Assert.assertEquals(NumberUtils.roundOff(0.123456789f, 5), 0.12346f, 0f);
        Assert.assertEquals(NumberUtils.roundOff(0.123456789f, 6), 0.123457f, 0f);
    }

    @Test
    public void roundNearest() {
        Assert.assertEquals(-10, NumberUtils.roundNearest(-7.5f, 5));
        Assert.assertEquals(-5, NumberUtils.roundNearest(-2.5f, 5));
        Assert.assertEquals(0, NumberUtils.roundNearest(-2.49f, 5));
        Assert.assertEquals(0, NumberUtils.roundNearest(2.49f, 5));
        Assert.assertEquals(5, NumberUtils.roundNearest(2.5f, 5));
        Assert.assertEquals(10, NumberUtils.roundNearest(7.5f, 5));
    }

    @Test
    public void floorNearest() {
        Assert.assertEquals(-10, NumberUtils.floorNearest(-14.99f, 5));
        Assert.assertEquals(-5, NumberUtils.floorNearest(-9.99f, 5));
        Assert.assertEquals(0, NumberUtils.floorNearest(-4.99f, 5));
        Assert.assertEquals(0, NumberUtils.floorNearest(4.99f, 5));
        Assert.assertEquals(5, NumberUtils.floorNearest(9.99f, 5));
        Assert.assertEquals(10, NumberUtils.floorNearest(14.99f, 5));
    }

    @Test
    public void ceilNearest() {
        Assert.assertEquals(-10, NumberUtils.ceilNearest(-5.01f, 5));
        Assert.assertEquals(-5, NumberUtils.ceilNearest(-0.01f, 5));
        Assert.assertEquals(5, NumberUtils.ceilNearest(0.01f, 5));
        Assert.assertEquals(10, NumberUtils.ceilNearest(5.01f, 5));
    }

    @Test
    @SuppressWarnings("All")
    public void min() {
        //int
        Assert.assertEquals(NumberUtils.min(0, 1, 2, 5, 10, 100, 999), 0, 0);
        Assert.assertEquals(NumberUtils.min(-999, -5, 0, 1, 2, 10), -999, 0);
        Assert.assertEquals(NumberUtils.min(new int[] {0, 1, 2, 5, 10, 100, 999}), 0, 0);
        //float
        Assert.assertEquals(NumberUtils.min(0.1f, 1.2f, 2.3f, 5.1f, 10.1f, 100.4f, 999), 0.1f, 0);
        Assert.assertEquals(NumberUtils.min(-999.7f, -5.3f, 0f, 1.3f, 2.9f, 10.8f), -999.7f, 0);
        Assert.assertEquals(NumberUtils.min(new float[] {0.1f, 1.2f, 2.3f, 5.1f, 10.1f, 100.4f, 999}), 0.1f, 0);
    }

    @Test
    @SuppressWarnings("All")
    public void max() {
        //int
        Assert.assertEquals(NumberUtils.max(0, 1, 2, 5, 10, 100, 999), 999, 0);
        Assert.assertEquals(NumberUtils.max(-999, -5, 0, 1, 2, 10), 10, 0);
        Assert.assertEquals(NumberUtils.max(new int[] {0, 1, 2, 5, 10, 100, 999}), 999, 0);
        //float
        Assert.assertEquals(NumberUtils.max(0.1f, 1.2f, 2.3f, 5.1f, 10.1f, 100.4f, 999.1f), 999.1f, 0);
        Assert.assertEquals(NumberUtils.max(-999.7f, -5.3f, 0f, 1.3f, 2.9f, 10.8f), 10.8f, 0);
        Assert.assertEquals(NumberUtils.max(new float[] {0.1f, 1.2f, 2.3f, 5.1f, 10.1f, 100.4f, 999.1f}), 999.1f, 0);
    }

    @Test
    @SuppressWarnings("All")
    public void average() {
        // int & float
        Assert.assertEquals(NumberUtils.average(5, 10, 20, 25), 15, 0);
        Assert.assertEquals(NumberUtils.average(1f, 2f, 7f), 3.33f, 0.01f);
        Assert.assertEquals(NumberUtils.average(new int[] {5, 10, 20, 25}), 15, 0);
    }

}