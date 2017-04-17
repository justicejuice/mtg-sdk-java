package io.magicthegathering.javasdk.filter;

import io.magicthegathering.javasdk.exception.FilterAlreadyExistsException;
import io.magicthegathering.javasdk.filter.domain.Layout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link Filter}.
 *
 * @author Timon Link - timon.link@gmail.com
 */
@RunWith(JUnit4.class)
public class FilterTest {

    @Test
    public void testCompile() {
        // Arrange.
        Filter testee = new Filter();

        // Act.
        String query = testee.byName("Nissa").or("Jace").end().compile();

        // Assert.
        assertEquals("?name=Nissa|Jace", query);
    }

    @Test
    public void testCompileAllFilters() {
        // Arrange.
        Filter testee = new Filter();

        // Act.
        String query = testee
                .byName("Nissa").or("Jace").nextFilter()
                .byLayout(Layout.DOUBLE_FACED).or(Layout.NORMAL).nextFilter()
                .byConvertedManaCost("5").end()
                .compile();

        // Assert.
        assertEquals("?name=Nissa|Jace&layout=double-faced|normal&cmc=5", query);
    }

    @Test(expected = FilterAlreadyExistsException.class)
    public void testCompileFilterAlreadyExists() {
        // Arrange.
        Filter testee = new Filter();

        // Act.
        testee.byName("Nissa").nextFilter().byName("Jace").end().compile();
    }

}
