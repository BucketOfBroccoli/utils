import org.junit.Assert;
import org.junit.Test;

import it.aretesoftware.couscous.NumberUtils;

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
    }

    @Test
    public void roundOffTo2DecPlaces() {
        Assert.assertEquals(NumberUtils.roundOffTo2DecPlaces(0.123456789f), 0.12f, 0f);
        Assert.assertEquals(NumberUtils.roundOffTo2DecPlaces(0.123456789d), 0.12f, 0f);
    }

    @Test
    public void roundOffTo3DecPlaces() {
        Assert.assertEquals(NumberUtils.roundOffTo3DecPlaces(0.123456789f), 0.123f, 0f);
        Assert.assertEquals(NumberUtils.roundOffTo3DecPlaces(0.123456789d), 0.123f, 0f);
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
