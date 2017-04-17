package io.magicthegathering.javasdk.filter;

/**
 * <p>
 *     This Filter filters the API request by a {@link io.magicthegathering.javasdk.resource.Card cards}
 *     name.
 * </p>
 *
 * @author Timon Link - timon.link@gmail.com
 */
class NameFilter extends AbstractListOrFilter {

    private static final String PARAMETER_NAME = "name";

    /**
     * Creates a new instance of {@link NameFilter}.
     *
     * @param filter The {@link Filter filter} to assign to <code>this</code> {@link Filter filter}.
     * @param name The name of the {@link io.magicthegathering.javasdk.resource.Card cards} to filter by.
     */
    NameFilter(Filter filter, String name) {
        super(filter);
        addValue(name);
    }

    @Override
    protected String parameterName() {
        return PARAMETER_NAME;
    }

}
