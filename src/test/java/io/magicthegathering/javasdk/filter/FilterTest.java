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
        String query = testee.withName("Nissa").or("Jace").end().compile();

        // Assert.
        assertEquals("?name=Nissa|Jace", query);
    }

    @Test
    public void testCompileMultiple() {
        // Arrange.
        Filter testee = new Filter();

        // Act.
        String query = testee
                .withName("Nissa").or("Jace").end()
                .withLayout(Layout.DOUBLE_FACED).or(Layout.NORMAL).end()
                .compile();

        // Assert.
        assertEquals("?name=Nissa|Jace&layout=double-faced|normal", query);
    }

    @Test(expected = FilterAlreadyExistsException.class)
    public void testCompileFilterAlreadyExists() {
        // Arrange.
        Filter testee = new Filter();

        // Act.
        testee.withName("Nissa").nextFilter().withName("Jace").end().compile();
    }

}
