package io.magicthegathering.javasdk.filter;

/**
 * <p>
 *     Filter for filtering {@link io.magicthegathering.javasdk.resource.Card cards} by
 *     their converted mana cost.
 * </p>
 * <p>
 *     This {@link ConvertedManaCostFilter filter} can only use a single
 *     value as request value.
 * </p>
 * 
 * @author Timon Link - timon.link@gmail.com
 */
public class ConvertedManaCostFilter extends AbstractBaseFilter {

    private static final String PARAMETER_NAME = "cmc";

    /**
     * Creates a new instance of the {@link ConvertedManaCostFilter}.
     *
     * @param filter The {@link Filter filter} to assign to <code>this</code> {@link Filter filter}.
     * @param manaCost The converted mana cost to filter by.
     */
    ConvertedManaCostFilter(Filter filter, String manaCost) {
        super(filter);
        addValue(manaCost);
    }

    @Override
    protected String parameterName() {
        return PARAMETER_NAME;
    }

}
