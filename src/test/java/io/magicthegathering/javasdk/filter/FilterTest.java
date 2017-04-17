package io.magicthegathering.javasdk.filter;

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
    public void testFilterName() {
        // Arrange.
        Filter testee = new Filter();

        // Act.
        String query = testee.withName("Nissa").or("Jace").end().filter();

        // Assert.
        assertEquals(query, "?name=Nissa|Jace");
    }

}
