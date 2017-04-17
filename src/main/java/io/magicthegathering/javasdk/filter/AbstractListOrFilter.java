package io.magicthegathering.javasdk.filter;

/**
 * <p>
 *     This class extends the {@link AbstractBaseFilter} with the functionality
 *     of supporting a list query.
 * </p>
 * <p>
 *     Extend this class if you need a filter which supports
 *     a list of values chained <em>only</em> by the logical or.
 * </p>
 *
 * @see AbstractBaseFilter
 * @see AbstractListAndFilter
 *
 * @author Timon Link - timon.link@gmail.com
 */
abstract class AbstractListOrFilter extends AbstractBaseFilter {

    private static final String LOGICAL_OR = "|";

    /**
     * Creates a new instance of {@link AbstractListOrFilter}.
     *
     * @param filter The {@link Filter filter} to assign to <code>this</code> {@link Filter filter}.
     */
    AbstractListOrFilter(Filter filter) {
        super(filter);
    }

    /**
     * Chains the filters existing expression values and the given
     * value together with a logical <code>or</code>.
     *
     * @param value The value to chain to the existing Expression
     *
     * @return <code>this</code> for further chaining.
     */
    public AbstractListOrFilter or(String value) {
        expression += LOGICAL_OR;

        addValue(value);

        return this;
    }

}
