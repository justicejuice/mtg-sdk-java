package io.magicthegathering.javasdk.filter;

import io.magicthegathering.javasdk.filter.domain.Layout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Timon Link - timon.link@gmail.com
 */
@RunWith(JUnit4.class)
public class AbstractBaseFilterTest {

    @Test
    public void testEquals() {
        // Arrange.
        AbstractBaseFilter filter1 = new NameFilter(new Filter(), "Nissa");
        AbstractBaseFilter filter2 = new NameFilter(new Filter(), "Jace");

        // Assert.
        assertEquals(filter1, filter2);
    }

    @Test
    public void testEqualsFail() {
        // Arrange.
        AbstractBaseFilter filter1 = new NameFilter(new Filter(), "Nissa");
        AbstractBaseFilter filter2 = new LayoutFilter(new Filter(), Layout.FLIP);

        // Assert.
        assertNotEquals(filter1, filter2);
    }

}
