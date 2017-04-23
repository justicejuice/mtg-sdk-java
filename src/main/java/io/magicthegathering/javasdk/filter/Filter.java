package io.magicthegathering.javasdk.filter;

import io.magicthegathering.javasdk.exception.FilterAlreadyExistsException;
import io.magicthegathering.javasdk.filter.domain.Color;
import io.magicthegathering.javasdk.filter.domain.Layout;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>
 *     This class offers the opportunity to
 *     set filters for the {@link io.magicthegathering.javasdk.api.CardAPI} and
 *     {@link io.magicthegathering.javasdk.api.SetAPI}.
 * </p>
 *
 * @author Timon Link - timon.link@gmail.com
 */
public class Filter {

    private Set<AbstractBaseFilter> appliedFilters;

    public Filter() {
        appliedFilters = new LinkedHashSet<>();
    }

    /**
     * Starts the {@link NameFilter}-Chain.
     *
     * @param name The name to filter by.
     * @return The {@link NameFilter} instance.
     */
    public NameFilter byName(String name) {
        NameFilter nameFilter = new NameFilter(this, name);

        addFilter(nameFilter);

        return nameFilter;
    }

    /**
     * Starts the {@link LayoutFilter}-Chain.
     *
     * @param layout The {@link Layout} to filter by.
     * @return The {@link LayoutFilter} instance.
     */
    public LayoutFilter byLayout(Layout layout) {
        LayoutFilter layoutFilter = new LayoutFilter(this, layout);

        addFilter(layoutFilter);

        return layoutFilter;
    }

    /**
     * Filters by the given converted mana cost.
     *
     * @param manaCost The converted mana cost to filter by.
     * @return The {@link ConvertedManaCostFilter} instance.
     */
    public ConvertedManaCostFilter byConvertedManaCost(String manaCost) {
        ConvertedManaCostFilter convertedManaCostFilter = new ConvertedManaCostFilter(this, manaCost);

        addFilter(convertedManaCostFilter);

        return convertedManaCostFilter;
    }

    /**
     * Starts the {@link ColorFilter}-Chain.
     *
     * @param color The {@link Color} to filter by.
     * @return The {@link ColorFilter} instance.
     */
    public ColorFilter byColor(Color color) {
        ColorFilter colorFilter = new ColorFilter(this, color);

        addFilter(colorFilter);

        return colorFilter;
    }

    /**
     * <p>
     *     Adds the given {@link AbstractBaseFilter filter} to the
     *     appliedFilters.
     * </p>
     * <p>
     *     If the given filter already exists, this method throws a
     *     {@link FilterAlreadyExistsException}.
     * </p>
     *
     * @param filterToAdd The {@link Filter} to add.
     */
    private void addFilter(AbstractBaseFilter filterToAdd) {
        if (appliedFilters.contains(filterToAdd)) {
            throw new FilterAlreadyExistsException(filterToAdd.parameterName());
        }
        appliedFilters.add(filterToAdd);
    }

    /**
     * Finishes the filter-chain.
     *
     * @return The final resulting expression to filter by.
     */
    public String compile() {
        String expression = "?";

        for (AbstractBaseFilter filter : appliedFilters) {
            expression += filter.expression + "&";
        }

        return StringUtils.removeEnd(expression, "&");
    }

}
