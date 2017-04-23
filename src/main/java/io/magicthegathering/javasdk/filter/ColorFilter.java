package io.magicthegathering.javasdk.filter;

import io.magicthegathering.javasdk.filter.domain.Color;

/**
 * <p>
 *     A Filter for filtering {@link io.magicthegathering.javasdk.resource.Card Cards} by their
 *     {@link Color color}.
 * </p>
 *
 * @author Timon Link - timon.link@gmail.com
 */
public class ColorFilter extends AbstractListAndFilter {

    private static final String PARAMETER_NAME = "colors";

    /**
     * Creates a new Instance of {@link ColorFilter}.
     *
     * @param filter The {@link Filter filter} to assign to <code>this</code> {@link Filter filter}.
     */
    ColorFilter(Filter filter, Color color) {
        super(filter);
        addValue(color.getColor());
    }

    @Override
    protected String parameterName() {
        return PARAMETER_NAME;
    }

    /**
     * Adds the given {@link Color} to the {@link ColorFilter} chain
     * by a logical <em>or</em>.
     *
     * @param color The {@link Color} to filter by.
     *
     * @return The {@link ColorFilter} instance
     */
    public ColorFilter or(Color color) {
        or(color.getColor());
        return this;
    }

    /**
     * Adds the given {@link Color} to the {@link ColorFilter} chain
     * by a logical <em>and</em>.
     *
     * @param color The {@link Color} to filter by.
     * @return The {@link ColorFilter} instance
     */
    public ColorFilter and(Color color) {
        and(color.getColor());
        return this;
    }

}
