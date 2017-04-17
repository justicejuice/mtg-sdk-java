package io.magicthegathering.javasdk.filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link NameFilter}.
 *
 * @author Timon Link - timon.link@gmail.com
 */
@RunWith(JUnit4.class)
public class NameFilterTest {

    @Test
    public void testSingleName() {
        // Arrange & Act.
        NameFilter testee = new NameFilter(new Filter(), "Nissa");
        String expressionResult = testee.expression;

        // Assert.
        assertEquals("name=Nissa", expressionResult);
    }

    @Test
    public void testMultipleNames() {
        // Arrange.
        NameFilter testee = new NameFilter(new Filter(), "Nissa");

        // Act.
        String expressionResult = testee.or("Jace").or("Ajani").or("Chandra").expression;

        // Assert.
        assertEquals("name=Nissa|Jace|Ajani|Chandra", expressionResult);
    }

}
