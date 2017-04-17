package io.magicthegathering.javasdk.filter;

import io.magicthegathering.javasdk.filter.domain.Layout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link LayoutFilter}.
 *
 * @author Timon Link - timon.link@gmail.com
 */
@RunWith(JUnit4.class)
public class LayoutFilterTest {

    @Test
    public void testNormal() {
        // Arrange & Act.
        LayoutFilter testee = new LayoutFilter(new Filter(), Layout.NORMAL);
        String expected = "layout=normal";

        // Assert.
        assertEquals(expected, testee.expression);
    }

    @Test
    public void testSplit() {
        // Arrange & Act.
        LayoutFilter testee = new LayoutFilter(new Filter(), Layout.SPLIT);
        String expected = "layout=split";

        // Assert.
        assertEquals(expected, testee.expression);
    }

    @Test
    public void testFlip() {
        // Arrange & Act.
        LayoutFilter testee = new LayoutFilter(new Filter(), Layout.FLIP);
        String expected = "layout=flip";

        // Assert.
        assertEquals(expected, testee.expression);
    }

    @Test
    public void testDoublefaced() {
        // Arrange & Act.
        LayoutFilter testee = new LayoutFilter(new Filter(), Layout.DOUBLE_FACED);
        String expected = "layout=double-faced";

        // Assert.
        assertEquals(expected, testee.expression);
    }

    @Test
    public void testToken() {
        // Arrange & Act.
        LayoutFilter testee = new LayoutFilter(new Filter(), Layout.TOKEN);
        String expected = "layout=token";

        // Assert.
        assertEquals(expected, testee.expression);
    }

    @Test
    public void testPlane() {
        // Arrange & Act.
        LayoutFilter testee = new LayoutFilter(new Filter(), Layout.PLANE);
        String expected = "layout=plane";

        // Assert.
        assertEquals(expected, testee.expression);
    }

    @Test
    public void testScheme() {
        // Arrange & Act.
        LayoutFilter testee = new LayoutFilter(new Filter(), Layout.SCHEME);
        String expected = "layout=scheme";

        // Assert.
        assertEquals(expected, testee.expression);
    }

    @Test
    public void testPhenomenon() {
        // Arrange & Act.
        LayoutFilter testee = new LayoutFilter(new Filter(), Layout.PHENOMENON);
        String expected = "layout=phenomenon";

        // Assert.
        assertEquals(expected, testee.expression);
    }

    @Test
    public void testLeveler() {
        // Arrange & Act.
        LayoutFilter testee = new LayoutFilter(new Filter(), Layout.LEVELER);
        String expected = "layout=leveler";

        // Assert.
        assertEquals(expected, testee.expression);
    }

    @Test
    public void testVanguard() {
        // Arrange & Act.
        LayoutFilter testee = new LayoutFilter(new Filter(), Layout.VANGUARD);
        String expected = "layout=vanguard";

        // Assert.
        assertEquals(expected, testee.expression);
    }

    @Test
    public void testAll() {
        // Arrange.
        LayoutFilter testee = new LayoutFilter(new Filter(), Layout.NORMAL);
        String expected = "layout=normal|split|flip|double-faced|" +
                                    "token|plane|scheme|phenomenon|leveler|vanguard";

        // Act.
        testee.or(Layout.SPLIT).or(Layout.FLIP).or(Layout.DOUBLE_FACED).or(Layout.TOKEN).or(Layout.PLANE)
                .or(Layout.SCHEME).or(Layout.PHENOMENON).or(Layout.LEVELER).or(Layout.VANGUARD);

        // Assert.
        assertEquals(expected, testee.expression);
    }
}
