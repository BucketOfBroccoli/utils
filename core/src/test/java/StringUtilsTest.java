import org.junit.Assert;
import org.junit.Test;

import it.aretesoftware.couscous.StringUtils;

public class StringUtilsTest {

    @Test
    public void upperCaseFirstCharacter() {
        Assert.assertEquals(StringUtils.capitalizeFirstCharacter("test"), "Test");
        Assert.assertEquals(StringUtils.capitalizeFirstCharacter("7est"), "7est");
        Assert.assertEquals(StringUtils.capitalizeFirstCharacter(""), "");
    }

    @Test
    public void lowerCaseFirstCharacter() {
        Assert.assertEquals(StringUtils.uncapitalizeFirstCharacter("Test"), "test");
        Assert.assertEquals(StringUtils.uncapitalizeFirstCharacter("7est"), "7est");
        Assert.assertEquals(StringUtils.uncapitalizeFirstCharacter(""), "");
    }

    @Test
    public void surround() {
        final String TEST = "Test";
        Assert.assertEquals(StringUtils.surroundWithSingleQuotes(TEST), "'Test'");
        Assert.assertEquals(StringUtils.surroundWithDoubleQuotes(TEST), "\"Test\"");
        Assert.assertEquals(StringUtils.surroundWithRoundBrackets(TEST), "(Test)");
        Assert.assertEquals(StringUtils.surroundWithSquareBrackets(TEST), "[Test]");
        Assert.assertEquals(StringUtils.surroundWithCurlyBrackets(TEST), "{Test}");
        Assert.assertEquals(StringUtils.surroundWithChevrons(TEST), "<Test>");
        Assert.assertEquals(StringUtils.surround(TEST, "_", "_"), "_Test_");
        Assert.assertEquals(StringUtils.surround(TEST, "!!", "??"), "!!Test??");
        Assert.assertEquals(StringUtils.surround(TEST, '-', '-'), "-Test-");
    }

    @Test
    public void countCharacter() {
        Assert.assertEquals(StringUtils.countCharacter("This.Is.A.Test.", '.'), 4, 0);
        Assert.assertEquals(StringUtils.countCharacter("This.Is.A.Test.", 'T'), 2, 0);
        Assert.assertEquals(StringUtils.countCharacterIgnoreCase("This.Is.A.Test.", 't'), 3, 0);
    }

    @Test
    @SuppressWarnings("All")
    public void isNullOrEmpty() {
        Assert.assertTrue(StringUtils.isNullOrEmpty(""));
        Assert.assertTrue(StringUtils.isNullOrEmpty(null));
    }

    @Test
    public void join() {
        Assert.assertEquals(StringUtils.join(new String[] {"First", "Second", "Third"}, ","), "First,Second,Third");
        Assert.assertEquals(StringUtils.join(new String[] {"First", "Second", "Third"}, ';'), "First;Second;Third");
    }

}
