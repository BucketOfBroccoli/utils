import org.junit.Assert;
import org.junit.Test;

import it.aretesoftware.couscous.Numbers;
import it.aretesoftware.couscous.Strings;

public class StringsTest {

    @Test
    public void upperCaseFirstCharacter() {
        Assert.assertEquals(Strings.upperCaseFirstCharacter("test"), "Test");
        Assert.assertEquals(Strings.upperCaseFirstCharacter("7est"), "7est");
        Assert.assertEquals(Strings.upperCaseFirstCharacter(""), "");
    }

    @Test
    public void lowerCaseFirstCharacter() {
        Assert.assertEquals(Strings.lowerCaseFirstCharacter("Test"), "test");
        Assert.assertEquals(Strings.lowerCaseFirstCharacter("7est"), "7est");
        Assert.assertEquals(Strings.lowerCaseFirstCharacter(""), "");
    }

    @Test
    public void surround() {
        final String TEST = "Test";
        Assert.assertEquals(Strings.surroundWithSingleQuotes(TEST), "'Test'");
        Assert.assertEquals(Strings.surroundWithDoubleQuotes(TEST), "\"Test\"");
        Assert.assertEquals(Strings.surroundWithRoundBrackets(TEST), "(Test)");
        Assert.assertEquals(Strings.surroundWithSquareBrackets(TEST), "[Test]");
        Assert.assertEquals(Strings.surroundWithCurlyBrackets(TEST), "{Test}");
        Assert.assertEquals(Strings.surroundWithChevrons(TEST), "<Test>");
        Assert.assertEquals(Strings.surround(TEST, "_", "_"), "_Test_");
        Assert.assertEquals(Strings.surround(TEST, "!!", "??"), "!!Test??");
    }

    @Test
    public void countCharacter() {
        Assert.assertEquals(Strings.countCharacter("This.Is.A.Test.", '.'), 4, 0);
        Assert.assertEquals(Strings.countCharacter("This.Is.A.Test.", 'T'), 2, 0);
        Assert.assertEquals(Strings.countCharacterIgnoreCase("This.Is.A.Test.", 't'), 3, 0);
    }

    @Test
    @SuppressWarnings("All")
    public void isNullOrEmpty() {
        Assert.assertTrue(Strings.isNullOrEmpty(""));
        Assert.assertTrue(Strings.isNullOrEmpty(null));
    }

}
