package io.magicthegathering.javasdk.filter;

import io.magicthegathering.javasdk.filter.domain.Layout;

/**
 * <p>
 *      This {@link LayoutFilter filter} filters the request by
 *      {@link Layout layout-types}.
 * </p>
 *
 * @author Timon Link - timon.link@gmail.com
 */
class LayoutFilter extends AbstractListOrFilter {

    private static final String PARAMETER_NAME = "layout";

    /**
     * Creates a new instance of {@link AbstractListOrFilter}.
     *
     * @param filter The {@link Filter filter} to assign to <code>this</code> {@link Filter filter}.
     * @param layout The {@link Layout} to filter by.
     */
    LayoutFilter(Filter filter, Layout layout) {
        super(filter);
        addValue(layout.getType());
    }

    @Override
    protected String parameterName() {
        return PARAMETER_NAME;
    }

    /**
     * Chains together {@link Layout layoutTypes} by a logical <em>or</em>.
     *
     * @param layout The {@link Layout layout}.
     *
     * @return The {@link LayoutFilter} instance.
     */
    public LayoutFilter or(Layout layout) {
        super.or(layout.getType());
        return this;
    }
}
