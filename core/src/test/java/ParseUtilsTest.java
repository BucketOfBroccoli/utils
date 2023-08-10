import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import org.junit.Assert;
import org.junit.Test;

import it.aretesoftware.couscous.ParseUtils;

public class ParseUtilsTest {

    @Test
    public void toObject() {
        Assert.assertEquals(ParseUtils.toObject("0 0 0 0"), Color.CLEAR);
        Assert.assertEquals(ParseUtils.toObject("0 0 0"), Vector3.Zero);
        Assert.assertEquals(ParseUtils.toObject("0 0"), Vector2.Zero);
        Assert.assertEquals(ParseUtils.toObject("true"), true);
        Assert.assertEquals(ParseUtils.toObject("0.1"), 0.1f);
        Assert.assertEquals(ParseUtils.toObject("0.1f"), 0.1f);
        Assert.assertEquals(ParseUtils.toObject("0.1F"), 0.1f);
        Assert.assertEquals(ParseUtils.toObject("0.1d"), 0.1d);
        Assert.assertEquals(ParseUtils.toObject("0.1D"), 0.1D);
        Assert.assertEquals(ParseUtils.toObject("1"), 1);
        Assert.assertEquals(ParseUtils.toObject("1000"), 1000);
        Assert.assertEquals(ParseUtils.toObject("0x8B87"), 35719);
        Assert.assertEquals(ParseUtils.toObject("#8B87"), 35719);
        Assert.assertEquals(ParseUtils.toObject("#0x8B87"), "#0x8B87");
        Assert.assertEquals(ParseUtils.toObject("1 2 3 4 5"), "1 2 3 4 5");
        Assert.assertEquals(ParseUtils.toObject("String"), "String");
    }

    @Test
    public void toObjectString() {
        Object obj;
        Assert.assertEquals(ParseUtils.toString(obj = Color.BLACK), "0.0 0.0 0.0 1.0");
        Assert.assertEquals(ParseUtils.toString(obj = Vector3.Zero), "0.0 0.0 0.0");
        Assert.assertEquals(ParseUtils.toString(obj = Vector2.Zero), "0.0 0.0");
        Assert.assertEquals(ParseUtils.toString(obj = true), "true");
        Assert.assertEquals(ParseUtils.toString(obj = 0.1f), "0.1f");
        Assert.assertEquals(ParseUtils.toString(obj = 0.1), "0.1d");
        Assert.assertEquals(ParseUtils.toString(obj = 0.1d), "0.1d");
        Assert.assertEquals(ParseUtils.toString(obj = 1), "1");
        Assert.assertEquals(ParseUtils.toString(obj = 1L), "1L");
        Assert.assertEquals(ParseUtils.toString(obj = "0x8B87"), "0x8B87");
        Assert.assertEquals(ParseUtils.toString(obj = "#8B87"), "#8B87");
        Assert.assertEquals(ParseUtils.toString(obj = "#0x8B87"), "#0x8B87");
        Assert.assertEquals(ParseUtils.toString(obj = "String"), "String");
    }

    @Test
    public void isNumeric() {
        // Float & Double
        Assert.assertTrue(ParseUtils.isNumeric("0.1"));
        Assert.assertTrue(ParseUtils.isNumeric("0.1f"));
        Assert.assertTrue(ParseUtils.isNumeric(".1f"));
        Assert.assertTrue(ParseUtils.isNumeric("0.f"));
        Assert.assertTrue(ParseUtils.isNumeric("0.2d"));
        Assert.assertTrue(ParseUtils.isNumeric("0.d"));
        Assert.assertTrue(ParseUtils.isNumeric(".2d"));

        // Integer & Long
        Assert.assertTrue(ParseUtils.isNumeric("0"));
        Assert.assertTrue(ParseUtils.isNumeric("999"));
        Assert.assertTrue(ParseUtils.isNumeric("-1"));
        Assert.assertTrue(ParseUtils.isNumeric("+1"));

        // Hexadecimal Integers
        Assert.assertTrue(ParseUtils.isNumeric("#8009"));
        Assert.assertTrue(ParseUtils.isNumeric("0x8009"));
        Assert.assertTrue(ParseUtils.isNumeric("#0DE1"));
        Assert.assertTrue(ParseUtils.isNumeric("0x0DE1"));
        Assert.assertFalse(ParseUtils.isNumeric("#0x8009"));
        Assert.assertFalse(ParseUtils.isNumeric("0x#8009"));
        Assert.assertFalse(ParseUtils.isNumeric("8009z"));
    }

    @Test
    public void toNumber() {
        // Float & Double
        final float delta = 0.00000001f;
        Assert.assertEquals(ParseUtils.toNumber("0.1").floatValue(), 0.1, delta);
        Assert.assertEquals(ParseUtils.toNumber("0.1f").floatValue(), 0.1, delta);
        Assert.assertEquals(ParseUtils.toNumber(".1f").floatValue(), 0.1, delta);
        Assert.assertEquals(ParseUtils.toNumber("1.f").floatValue(), 1, delta);
        Assert.assertEquals(ParseUtils.toNumber("0.1").doubleValue(), 0.1, delta);
        Assert.assertEquals(ParseUtils.toNumber("0.1d").doubleValue(), 0.1, delta);
        Assert.assertEquals(ParseUtils.toNumber(".1d").doubleValue(), 0.1, delta);
        Assert.assertEquals(ParseUtils.toNumber("1.d").doubleValue(), 1, delta);
        Assert.assertEquals(ParseUtils.toNumber("wasd", 0.1f), 0.1f);

        // Integer & Long
        Assert.assertEquals(ParseUtils.toNumber("1").intValue(), 1, 0);
        Assert.assertEquals(ParseUtils.toNumber("1").longValue(), 1, 0);

        // Hexadecimal Integers
        Assert.assertEquals(ParseUtils.toNumber("0x8B87").intValue(), 35719, 0);
        Assert.assertEquals(ParseUtils.toNumber("#8B87").intValue(), 35719, 0);
        Assert.assertEquals(ParseUtils.toNumber("0x8009").intValue(), 32777, 0);
        Assert.assertEquals(ParseUtils.toNumber("#8009").intValue(), 32777, 0);
        Assert.assertEquals(ParseUtils.toNumber("8009").intValue(), 8009, 0);
    }

    @Test
    @SuppressWarnings("All")
    public void toNumberString() {
        Assert.assertEquals(ParseUtils.toString(0), "0");
        Assert.assertEquals(ParseUtils.toString(0.1f), "0.1f");
        Assert.assertEquals(ParseUtils.toString(0.1d), "0.1d");
        Assert.assertEquals(ParseUtils.toString(0.1), "0.1d");
        Assert.assertEquals(ParseUtils.toString(1l), "1L");
        Assert.assertEquals(ParseUtils.toString(1L), "1L");
        Assert.assertEquals(ParseUtils.toString(0x8009), "32777");
    }

    @Test
    public void isBoolean() {
        Assert.assertTrue(ParseUtils.isBoolean("true"));
        Assert.assertTrue(ParseUtils.isBoolean("false"));
        Assert.assertFalse(ParseUtils.isBoolean("0"));
        Assert.assertFalse(ParseUtils.isBoolean("1"));
        Assert.assertFalse(ParseUtils.isBoolean("wasd"));
    }

    @Test
    public void toBoolean() {
        Assert.assertTrue(ParseUtils.toBoolean("true"));
        Assert.assertFalse(ParseUtils.toBoolean("false"));
        Assert.assertTrue(ParseUtils.toBoolean("wasd", true));
    }

    @Test
    public void isColor() {
        Assert.assertTrue(ParseUtils.isColor("1 0 0 0"));
        Assert.assertTrue(ParseUtils.isColor("1.0 0.0 0.0 0.0"));
        Assert.assertTrue(ParseUtils.isColor("1 0.0 0.4 0"));
        Assert.assertTrue(ParseUtils.isColor("+1 0 0 0"));
        Assert.assertTrue(ParseUtils.isColor("-1 0 0 0"));
        Assert.assertFalse(ParseUtils.isColor("w a s d"));
        Assert.assertFalse(ParseUtils.isColor("1 0 0"));
    }

    @Test
    public void toColor() {
        Assert.assertEquals(ParseUtils.toColor("1 1 1 1"), new Color(1, 1, 1, 1));
        Assert.assertEquals(ParseUtils.toColor("0.1 0.2 0.3 0.4"), new Color(0.1f, 0.2f, 0.3f, 0.4f));
        Assert.assertEquals(ParseUtils.toColor("255 255 255 255"), new Color(255, 255, 255, 255));
        Assert.assertEquals(ParseUtils.toColor("0   0 0   0"), Color.CLEAR);
        Assert.assertEquals(ParseUtils.toColor("1 1 1", Color.CLEAR), Color.CLEAR);
    }

    @Test
    public void toColorString() {
        Assert.assertEquals(ParseUtils.toString(Color.BLACK), "0.0 0.0 0.0 1.0");
        Assert.assertEquals(ParseUtils.toString(Color.WHITE), "1.0 1.0 1.0 1.0");
        Assert.assertEquals(ParseUtils.toString(new Color(0.1f, 0.2f, 0.3f, 0.4f)), "0.1 0.2 0.3 0.4");
    }

    @Test
    public void isVector3() {
        Assert.assertTrue(ParseUtils.isVector3("0 0 0"));
        Assert.assertTrue(ParseUtils.isVector3(" 0 0 0"));
        Assert.assertTrue(ParseUtils.isVector3("0 0 0 "));
        Assert.assertTrue(ParseUtils.isVector3(" 0 0 0 "));
        Assert.assertTrue(ParseUtils.isVector3(" 0   0 0 "));
        Assert.assertTrue(ParseUtils.isVector3("0.1 0.2 0.3"));
        Assert.assertFalse(ParseUtils.isVector3("1 1"));
        Assert.assertFalse(ParseUtils.isVector3("1"));
        Assert.assertFalse(ParseUtils.isVector3(""));
    }

    @Test
    public void toVector3() {
        Assert.assertEquals(ParseUtils.toVector3("0 0 0"), new Vector3());
        Assert.assertEquals(ParseUtils.toVector3("1 1 1"), new Vector3(1, 1, 1));
        Assert.assertEquals(ParseUtils.toVector3("0.1 0.2 0.3"), new Vector3(0.1f, 0.2f, 0.3f));
        Assert.assertEquals(ParseUtils.toVector3(" 0   1 2"), new Vector3(0, 1, 2));
        Assert.assertEquals(ParseUtils.toVector3("", Vector3.Zero), Vector3.Zero);
    }

    @Test
    public void toVector3String() {
        Assert.assertEquals(ParseUtils.toString(new Vector3()), "0.0 0.0 0.0");
        Assert.assertEquals(ParseUtils.toString(new Vector3(1, 1, 1)), "1.0 1.0 1.0");
        Assert.assertEquals(ParseUtils.toString(new Vector3(0.1f, 0.2f, 0.3f)), "0.1 0.2 0.3");
    }

    @Test
    public void isVector2() {
        Assert.assertTrue(ParseUtils.isVector2("0 0"));
        Assert.assertTrue(ParseUtils.isVector2(" 0 0"));
        Assert.assertTrue(ParseUtils.isVector2("0 0 "));
        Assert.assertTrue(ParseUtils.isVector2(" 0 0 "));
        Assert.assertTrue(ParseUtils.isVector2(" 0   0 "));
        Assert.assertTrue(ParseUtils.isVector2("0.1 0.2"));
        Assert.assertFalse(ParseUtils.isVector2("1"));
        Assert.assertFalse(ParseUtils.isVector2(""));
    }

    @Test
    public void toVector2() {
        Assert.assertEquals(ParseUtils.toVector2("0 0"), new Vector2());
        Assert.assertEquals(ParseUtils.toVector2("1 1"), new Vector2(1, 1));
        Assert.assertEquals(ParseUtils.toVector2("0.1 0.2"), new Vector2(0.1f, 0.2f));
        Assert.assertEquals(ParseUtils.toVector2(" 0   1 "), new Vector2(0, 1));
        Assert.assertEquals(ParseUtils.toVector2("", Vector2.Zero), Vector2.Zero);
    }

    @Test
    public void toVector2String() {
        Assert.assertEquals(ParseUtils.toString(new Vector2()), "0.0 0.0");
        Assert.assertEquals(ParseUtils.toString(new Vector2(1, 1)), "1.0 1.0");
        Assert.assertEquals(ParseUtils.toString(new Vector2(0.1f, 0.2f)), "0.1 0.2");
    }
}
