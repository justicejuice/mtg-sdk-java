package io.magicthegathering.javasdk.filter;

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

    private String expression;

    /**
     * Starts the {@link NameFilter}-Chain.
     *
     * @param name The name to filter for.
     * @return The {@link NameFilter} instance.
     */
    public NameFilter withName(String name) {
        return new NameFilter(this, expression, name);
    }


    public String filter() {
        return expression;
    }

    public String getExpression() {
        return expression;
    }

    void setExpression(String expression) {
        this.expression = expression;
    }
}
