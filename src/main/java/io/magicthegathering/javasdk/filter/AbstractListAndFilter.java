package io.magicthegathering.javasdk.filter;

/**
 * <p>
 *      This class extends the {@link AbstractListOrFilter}
 *      to add the functionality to chain values together by a
 *      logical <em>and</em>.
 * </p>
 * <p>
 *     Extend this class if you need a filter which supports both,
 *     logical <em>or</em> and logical <em>and</em>.
 * </p>
 *
 * @see AbstractBaseFilter
 * @see AbstractListOrFilter
 *
 * @author Timon Link - timon.link@gmail.com
 */
public abstract class AbstractListAndFilter extends AbstractListOrFilter {

    private static final String LOGICAL_AND = ",";

    /**
     * Creates a new Instance of {@link AbstractListAndFilter}.
     *
     * @param filter The {@link Filter filter} to assign to <code>this</code> {@link Filter filter}.
     */
    AbstractListAndFilter(Filter filter) {
        super(filter);
    }

    /**
     * Chains the filters existing expression values and the given
     * value together with a logical <code>and</code>.
     *
     * @param value The value to chain to the existing Expression
     *
     * @return <code>this</code> for further chaining.
     */
    public AbstractListAndFilter and(String value) {
        expression += LOGICAL_AND;

        addValue(value);

        return this;
    }
}
