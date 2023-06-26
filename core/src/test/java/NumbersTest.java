import org.junit.Assert;
import org.junit.Test;

import it.aretesoftware.couscous.Numbers;

public class NumbersTest {

    @Test
    public void roundOffTo2DecPlaces() {
        Assert.assertEquals(Numbers.roundOffTo2DecPlaces(0.123456789f), 0.12f, 0f);
        Assert.assertEquals(Numbers.roundOffTo2DecPlaces(0.123456789d), 0.12f, 0f);
    }

    @Test
    public void roundOffTo3DecPlaces() {
        Assert.assertEquals(Numbers.roundOffTo3DecPlaces(0.123456789f), 0.123f, 0f);
        Assert.assertEquals(Numbers.roundOffTo3DecPlaces(0.123456789d), 0.123f, 0f);
    }

    @Test
    public void roundUp() {
        Assert.assertEquals(Numbers.roundUp(0.001f), 1);
        Assert.assertEquals(Numbers.roundUp(0.001d), 1);
    }

    @Test
    public void roundDown() {
        Assert.assertEquals(Numbers.roundDown(0.999f), 0);
        Assert.assertEquals(Numbers.roundDown(0.999d), 0);
    }

    @Test
    @SuppressWarnings("All")
    public void min() {
        //int
        Assert.assertEquals(Numbers.min(0, 1, 2, 5, 10, 100, 999), 0, 0);
        Assert.assertEquals(Numbers.min(-999, -5, 0, 1, 2, 10), -999, 0);
        Assert.assertEquals(Numbers.min(new int[] {0, 1, 2, 5, 10, 100, 999}), 0, 0);
        //float
        Assert.assertEquals(Numbers.min(0.1f, 1.2f, 2.3f, 5.1f, 10.1f, 100.4f, 999), 0.1f, 0);
        Assert.assertEquals(Numbers.min(-999.7f, -5.3f, 0f, 1.3f, 2.9f, 10.8f), -999.7f, 0);
        Assert.assertEquals(Numbers.min(new float[] {0.1f, 1.2f, 2.3f, 5.1f, 10.1f, 100.4f, 999}), 0.1f, 0);
    }

    @Test
    @SuppressWarnings("All")
    public void max() {
        //int
        Assert.assertEquals(Numbers.max(0, 1, 2, 5, 10, 100, 999), 999, 0);
        Assert.assertEquals(Numbers.max(-999, -5, 0, 1, 2, 10), 10, 0);
        Assert.assertEquals(Numbers.max(new int[] {0, 1, 2, 5, 10, 100, 999}), 999, 0);
        //float
        Assert.assertEquals(Numbers.max(0.1f, 1.2f, 2.3f, 5.1f, 10.1f, 100.4f, 999.1f), 999.1f, 0);
        Assert.assertEquals(Numbers.max(-999.7f, -5.3f, 0f, 1.3f, 2.9f, 10.8f), 10.8f, 0);
        Assert.assertEquals(Numbers.max(new float[] {0.1f, 1.2f, 2.3f, 5.1f, 10.1f, 100.4f, 999.1f}), 999.1f, 0);
    }

    @Test
    @SuppressWarnings("All")
    public void average() {
        // int & float
        Assert.assertEquals(Numbers.average(5, 10, 20, 25), 15, 0);
        Assert.assertEquals(Numbers.average(1f, 2f, 7f), 3.33f, 0.01f);
        Assert.assertEquals(Numbers.average(new int[] {5, 10, 20, 25}), 15, 0);
    }

}
