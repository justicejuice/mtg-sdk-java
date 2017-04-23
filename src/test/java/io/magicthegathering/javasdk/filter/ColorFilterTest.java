package io.magicthegathering.javasdk.filter;

import io.magicthegathering.javasdk.filter.domain.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Tests the ColorFilter
 *
 * @author Timon Link - timon.link@gmail.com
 */
@RunWith(JUnit4.class)
public class ColorFilterTest {


    @Test
    public void testBlue() {
        assertEquals("colors=blue", filterAndGetExpression(Color.BLUE));
    }

    @Test
    public void testRed() {
        assertEquals("colors=red", filterAndGetExpression(Color.RED));
    }

    @Test
    public void testBlack() {
        assertEquals("colors=black", filterAndGetExpression(Color.BLACK));
    }

    @Test
    public void testWhite() {
        assertEquals("colors=white", filterAndGetExpression(Color.WHITE));
    }

    @Test
    public void testGreen() {
        assertEquals("colors=green", filterAndGetExpression(Color.GREEN));
    }

    private String filterAndGetExpression(Color color) {
        return new ColorFilter(new Filter(), color).expression;
    }

}
