package io.magicthegathering.javasdk.filter.domain;

/**
 * This enum holds every possible color of a card.
 *
 * @author Timon Link - timon.link@gmail.com
 */
public enum Color {

    RED("red"),
    BLUE("blue"),
    GREEN("green"),
    BLACK("black"),
    WHITE("white");


    private String color;

    Color(String color) {
        this.color = color;
    }

    /**
     * Returns the colors name to pass as parameter value.
     *
     * @return The colors name.
     */
    public String getColor() {
        return color;
    }
}
