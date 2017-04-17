package io.magicthegathering.javasdk.filter;

/**
 * <p>
 *     This class implements the base methods, every filter
 *     needs.
 * </p>
 * <p>
 *     Extend this class, if you need a filter which <em>only</em>
 *     supports a single value.
 * </p>
 *
 * @see AbstractListOrFilter
 * @see AbstractListAndFilter
 *
 * @author Timon Link - timon.link@gmail.com
 */
abstract class AbstractBaseFilter {

    String expression;
    private Filter filter;

    protected abstract String parameterName();

    /**
     * Creates a new instance of the {@link AbstractBaseFilter}.
     *
     * @param filter The {@link Filter filter} to assign to <code>this</code> {@link Filter filter}.
     * @param expression The expression to assign to <code>this</code> expression.
     */
    AbstractBaseFilter(Filter filter, String expression) {
        this.filter = filter;
        this.expression = expression;
        createStartExpression();
    }


    /**
     * This method creates <this>this</this> filters start
     * expression.
     * It has to be called when
     */
    private void createStartExpression() {
        if (isFirst()) {
            expression = "?";
        } else {
            expression += "&";
        }
        expression += parameterName();
        expression += "=";
    }

    /**
     * Checks if <code>this</code> filter is the first query
     * parameter of the expression.
     *
     * @return <code>true</code> if the filter is the first query parameter, else <code>false</code>.
     */
    private boolean isFirst() {
        return expression == null || expression.isEmpty();
    }

    /**
     * Adds the given value to <code>this</code> expression.
     *
     * @param value The value to add.
     *
     * @return <code>this</code> filter for further chaining.
     */
    AbstractBaseFilter addValue(String value) {
        expression += value;
        return this;
    }

    /**
     * Ends <code>this</code> filter.
     *
     * @return The {@link Filter filter}.
     */
    public Filter end() {
        filter.setExpression(expression);
        return filter;
    }

    /**
     * Returns the expression of the filter. It
     * will result in a query URL.
     *
     * @return The expression.
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Sets <code>this</code> expression to the given expression.
     *
     * @param expression The expression to set.
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }
}
