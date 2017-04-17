package io.magicthegathering.javasdk.filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * @author Timon Link - timon.link@gmail.com
 */
@RunWith(JUnit4.class)
public class ConvertedManaCostFilterTest {

    @Test
    public void testFilterConvertedManaCost() {
        // Arrange & Act.
        ConvertedManaCostFilter convertedManaCostFilter = new ConvertedManaCostFilter(new Filter(), "5");
        String expected = "cmc=5";

        // Assert.
        assertEquals(expected, convertedManaCostFilter.expression);
    }

}
