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

    protected String expression;

    private Filter filter;

    protected abstract String parameterName();

    /**
     * Creates a new instance of the {@link AbstractBaseFilter}.
     *
     * @param filter The {@link Filter filter} to assign to <code>this</code> {@link Filter filter}.
     */
    AbstractBaseFilter(Filter filter) {
        this.filter = filter;
        createStartExpression();
    }


    /**
     * This method creates <this>this</this> filters start
     * expression.
     */
    private void createStartExpression() {
        expression = parameterName();
        expression += "=";
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
        return filter;
    }

    /**
     * Ends <code>this</code> filter and starts
     * a new one.
     *
     * @return The {@link Filter filter}.
     */
    public Filter nextFilter() {
        return filter;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof AbstractBaseFilter)) return false;

        AbstractBaseFilter that = (AbstractBaseFilter) o;

        return parameterName() != null ? parameterName().equals(that.parameterName()) : that.parameterName() == null;
    }

    @Override
    public int hashCode() {
        return parameterName() != null ? parameterName().hashCode() : 0;
    }
}
