import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import org.junit.Assert;
import org.junit.Test;

import it.aretesoftware.couscous.Data;

public class DataTest {

    @Test
    public void toObject() {
        Assert.assertEquals(Data.toObject("0 0 0 0"), Color.CLEAR);
        Assert.assertEquals(Data.toObject("0 0 0"), Vector3.Zero);
        Assert.assertEquals(Data.toObject("0 0"), Vector2.Zero);
        Assert.assertEquals(Data.toObject("true"), true);
        Assert.assertEquals(Data.toObject("0.1"), 0.1f);
        Assert.assertEquals(Data.toObject("0.1f"), 0.1f);
        Assert.assertEquals(Data.toObject("0.1F"), 0.1f);
        Assert.assertEquals(Data.toObject("0.1d"), 0.1d);
        Assert.assertEquals(Data.toObject("0.1D"), 0.1D);
        Assert.assertEquals(Data.toObject("1l"), 1L);
        Assert.assertEquals(Data.toObject("1L"), 1L);
        Assert.assertEquals(Data.toObject("1"), 1);
        Assert.assertEquals(Data.toObject("0x8B87"), 35719);
        Assert.assertEquals(Data.toObject("#8B87"), 35719);
        Assert.assertEquals(Data.toObject("#0x8B87"), "#0x8B87");
        Assert.assertEquals(Data.toObject("1 2 3 4 5"), "1 2 3 4 5");
        Assert.assertEquals(Data.toObject("String"), "String");
    }

    @Test
    public void toObjectString() {
        Object obj;
        Assert.assertEquals(Data.toString(obj = Color.BLACK), "0.0 0.0 0.0 1.0");
        Assert.assertEquals(Data.toString(obj = Vector3.Zero), "0.0 0.0 0.0");
        Assert.assertEquals(Data.toString(obj = Vector2.Zero), "0.0 0.0");
        Assert.assertEquals(Data.toString(obj = true), "true");
        Assert.assertEquals(Data.toString(obj = 0.1f), "0.1f");
        Assert.assertEquals(Data.toString(obj = 0.1), "0.1d");
        Assert.assertEquals(Data.toString(obj = 0.1d), "0.1d");
        Assert.assertEquals(Data.toString(obj = 1), "1");
        Assert.assertEquals(Data.toString(obj = 1L), "1L");
        Assert.assertEquals(Data.toString(obj = "0x8B87"), "0x8B87");
        Assert.assertEquals(Data.toString(obj = "#8B87"), "#8B87");
        Assert.assertEquals(Data.toString(obj = "#0x8B87"), "#0x8B87");
        Assert.assertEquals(Data.toString(obj = "String"), "String");
    }

    @Test
    public void isNumeric() {
        // Float & Double
        Assert.assertTrue(Data.isNumeric("0.1"));
        Assert.assertTrue(Data.isNumeric("0.1f"));
        Assert.assertTrue(Data.isNumeric(".1f"));
        Assert.assertTrue(Data.isNumeric("0.f"));
        Assert.assertTrue(Data.isNumeric("0.2d"));
        Assert.assertTrue(Data.isNumeric("0.d"));
        Assert.assertTrue(Data.isNumeric(".2d"));

        // Integer & Long
        Assert.assertTrue(Data.isNumeric("0"));
        Assert.assertTrue(Data.isNumeric("999"));
        Assert.assertTrue(Data.isNumeric("3L"));
        Assert.assertTrue(Data.isNumeric("3l"));
        Assert.assertFalse(Data.isNumeric("0.3l"));
        Assert.assertFalse(Data.isNumeric(".3l"));

        // Hexadecimal Integers
        Assert.assertTrue(Data.isNumeric("#8009"));
        Assert.assertTrue(Data.isNumeric("0x8009"));
        Assert.assertTrue(Data.isNumeric("#0DE1"));
        Assert.assertTrue(Data.isNumeric("0x0DE1"));
        Assert.assertFalse(Data.isNumeric("#0x8009"));
        Assert.assertFalse(Data.isNumeric("0x#8009"));
        Assert.assertFalse(Data.isNumeric("8009z"));
    }

    @Test
    public void toNumber() {
        // Float & Double
        final float delta = 0.00000001f;
        Assert.assertEquals(Data.toNumber("0.1").floatValue(), 0.1, delta);
        Assert.assertEquals(Data.toNumber("0.1f").floatValue(), 0.1, delta);
        Assert.assertEquals(Data.toNumber(".1f").floatValue(), 0.1, delta);
        Assert.assertEquals(Data.toNumber("1.f").floatValue(), 1, delta);
        Assert.assertEquals(Data.toNumber("0.1").doubleValue(), 0.1, delta);
        Assert.assertEquals(Data.toNumber("0.1d").doubleValue(), 0.1, delta);
        Assert.assertEquals(Data.toNumber(".1d").doubleValue(), 0.1, delta);
        Assert.assertEquals(Data.toNumber("1.d").doubleValue(), 1, delta);
        Assert.assertEquals(Data.toNumber("wasd", 0.1f), 0.1f);

        // Integer & Long
        Assert.assertEquals(Data.toNumber("1").intValue(), 1, 0);
        Assert.assertEquals(Data.toNumber("1l").intValue(), 1, 0);
        Assert.assertEquals(Data.toNumber("1L").intValue(), 1, 0);

        // Hexadecimal Integers
        Assert.assertEquals(Data.toNumber("0x8B87").intValue(), 35719, 0);
        Assert.assertEquals(Data.toNumber("#8B87").intValue(), 35719, 0);
        Assert.assertEquals(Data.toNumber("0x8009").intValue(), 32777, 0);
        Assert.assertEquals(Data.toNumber("#8009").intValue(), 32777, 0);
        Assert.assertEquals(Data.toNumber("8009").intValue(), 8009, 0);
    }

    @Test
    @SuppressWarnings("All")
    public void toNumberString() {
        Assert.assertEquals(Data.toString(0), "0");
        Assert.assertEquals(Data.toString(0.1f), "0.1f");
        Assert.assertEquals(Data.toString(0.1d), "0.1d");
        Assert.assertEquals(Data.toString(0.1), "0.1d");
        Assert.assertEquals(Data.toString(1l), "1L");
        Assert.assertEquals(Data.toString(1L), "1L");
        Assert.assertEquals(Data.toString(0x8009), "32777");
    }

    @Test
    public void isBoolean() {
        Assert.assertTrue(Data.isBoolean("true"));
        Assert.assertTrue(Data.isBoolean("false"));
        Assert.assertFalse(Data.isBoolean("0"));
        Assert.assertFalse(Data.isBoolean("1"));
        Assert.assertFalse(Data.isBoolean("wasd"));
    }

    @Test
    public void toBoolean() {
        Assert.assertTrue(Data.toBoolean("true"));
        Assert.assertFalse(Data.toBoolean("false"));
        Assert.assertTrue(Data.toBoolean("wasd", true));
    }

    @Test
    public void isColor() {
        Assert.assertTrue(Data.isColor("1 0 0 0"));
        Assert.assertTrue(Data.isColor("1.0 0.0 0.0 0.0"));
        Assert.assertTrue(Data.isColor("1 0.0 0.4 0"));
        Assert.assertFalse(Data.isColor("+1 0 0 0"));
        Assert.assertFalse(Data.isColor("-1 0 0 0"));
        Assert.assertFalse(Data.isColor("w a s d"));
        Assert.assertFalse(Data.isColor("1 0 0"));
    }

    @Test
    public void toColor() {
        Assert.assertEquals(Data.toColor("1 1 1 1"), new Color(1, 1, 1, 1));
        Assert.assertEquals(Data.toColor("0.1 0.2 0.3 0.4"), new Color(0.1f, 0.2f, 0.3f, 0.4f));
        Assert.assertEquals(Data.toColor("255 255 255 255"), new Color(255, 255, 255, 255));
        Assert.assertEquals(Data.toColor("0   0 0   0"), Color.CLEAR);
        Assert.assertEquals(Data.toColor("1 1 1", Color.CLEAR), Color.CLEAR);
    }

    @Test
    public void toColorString() {
        Assert.assertEquals(Data.toString(Color.BLACK), "0.0 0.0 0.0 1.0");
        Assert.assertEquals(Data.toString(Color.WHITE), "1.0 1.0 1.0 1.0");
        Assert.assertEquals(Data.toString(new Color(0.1f, 0.2f, 0.3f, 0.4f)), "0.1 0.2 0.3 0.4");
    }

    @Test
    public void isVector3() {
        Assert.assertTrue(Data.isVector3("0 0 0"));
        Assert.assertTrue(Data.isVector3(" 0 0 0"));
        Assert.assertTrue(Data.isVector3("0 0 0 "));
        Assert.assertTrue(Data.isVector3(" 0 0 0 "));
        Assert.assertTrue(Data.isVector3(" 0   0 0 "));
        Assert.assertTrue(Data.isVector3("0.1 0.2 0.3"));
        Assert.assertFalse(Data.isVector3("1 1"));
        Assert.assertFalse(Data.isVector3("1"));
        Assert.assertFalse(Data.isVector3(""));
    }

    @Test
    public void toVector3() {
        Assert.assertEquals(Data.toVector3("0 0 0"), new Vector3());
        Assert.assertEquals(Data.toVector3("1 1 1"), new Vector3(1, 1, 1));
        Assert.assertEquals(Data.toVector3("0.1 0.2 0.3"), new Vector3(0.1f, 0.2f, 0.3f));
        Assert.assertEquals(Data.toVector3(" 0   1 2"), new Vector3(0, 1, 2));
        Assert.assertEquals(Data.toVector3("", Vector3.Zero), Vector3.Zero);
    }

    @Test
    public void toVector3String() {
        Assert.assertEquals(Data.toString(new Vector3()), "0.0 0.0 0.0");
        Assert.assertEquals(Data.toString(new Vector3(1, 1, 1)), "1.0 1.0 1.0");
        Assert.assertEquals(Data.toString(new Vector3(0.1f, 0.2f, 0.3f)), "0.1 0.2 0.3");
    }

    @Test
    public void isVector2() {
        Assert.assertTrue(Data.isVector2("0 0"));
        Assert.assertTrue(Data.isVector2(" 0 0"));
        Assert.assertTrue(Data.isVector2("0 0 "));
        Assert.assertTrue(Data.isVector2(" 0 0 "));
        Assert.assertTrue(Data.isVector2(" 0   0 "));
        Assert.assertTrue(Data.isVector2("0.1 0.2"));
        Assert.assertFalse(Data.isVector2("1"));
        Assert.assertFalse(Data.isVector2(""));
    }

    @Test
    public void toVector2() {
        Assert.assertEquals(Data.toVector2("0 0"), new Vector2());
        Assert.assertEquals(Data.toVector2("1 1"), new Vector2(1, 1));
        Assert.assertEquals(Data.toVector2("0.1 0.2"), new Vector2(0.1f, 0.2f));
        Assert.assertEquals(Data.toVector2(" 0   1 "), new Vector2(0, 1));
        Assert.assertEquals(Data.toVector2("", Vector2.Zero), Vector2.Zero);
    }

    @Test
    public void toVector2String() {
        Assert.assertEquals(Data.toString(new Vector2()), "0.0 0.0");
        Assert.assertEquals(Data.toString(new Vector2(1, 1)), "1.0 1.0");
        Assert.assertEquals(Data.toString(new Vector2(0.1f, 0.2f)), "0.1 0.2");
    }
}
