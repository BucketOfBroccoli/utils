package it.aretesoftware.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void upperCaseCharacter() {
        Assert.assertEquals(StringUtils.upperCaseCharacter("test", 0), "Test");
        Assert.assertEquals(StringUtils.upperCaseCharacter("test", 1), "tEst");
        Assert.assertEquals(StringUtils.upperCaseCharacter("test", 3), "tesT");
    }

    @Test
    public void lowerCaseCharacter() {
        Assert.assertEquals(StringUtils.lowerCaseCharacter("Test", 0), "test");
        Assert.assertEquals(StringUtils.lowerCaseCharacter("tEst", 1), "test");
        Assert.assertEquals(StringUtils.lowerCaseCharacter("tesT", 3), "test");
    }

    @Test
    public void upperCaseFirstCharacter() {
        Assert.assertEquals(StringUtils.upperCaseFirstCharacter("test"), "Test");
        Assert.assertEquals(StringUtils.upperCaseFirstCharacter("7est"), "7est");
        Assert.assertEquals(StringUtils.upperCaseFirstCharacter(""), "");
    }

    @Test
    public void lowerCaseFirstCharacter() {
        Assert.assertEquals(StringUtils.lowerCaseFirstCharacter("Test"), "test");
        Assert.assertEquals(StringUtils.lowerCaseFirstCharacter("7est"), "7est");
        Assert.assertEquals(StringUtils.lowerCaseFirstCharacter(""), "");
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
        Assert.assertFalse(StringUtils.isNullOrEmpty("Test"));
    }

    @Test
    public void isIndexValid() {
        Assert.assertTrue(StringUtils.isIndexValid("Test", 0));
        Assert.assertTrue(StringUtils.isIndexValid("Test", 3));
        Assert.assertFalse(StringUtils.isIndexValid("Test", 4));
        Assert.assertFalse(StringUtils.isIndexValid("Test", -1));
        Assert.assertFalse(StringUtils.isIndexValid("", 0));
    }

    @Test
    public void join() {
        Assert.assertEquals(StringUtils.join(new String[] {"First", "Second", "Third"}, ","), "First,Second,Third");
        Assert.assertEquals(StringUtils.join(new String[] {"First", "Second", "Third"}, ';'), "First;Second;Third");
    }

}