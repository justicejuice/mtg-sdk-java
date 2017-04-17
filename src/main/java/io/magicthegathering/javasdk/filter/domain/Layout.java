package io.magicthegathering.javasdk.filter.domain;

/**
 * Enum constants for a {@link io.magicthegathering.javasdk.resource.Card Cards} Layout-Type.
 *
 * @author Timon Link - timon.link@gmail.com
 */
public enum Layout {

    NORMAL("normal"),
    SPLIT("split"),
    FLIP("flip"),
    DOUBLE_FACED("double-faced"),
    TOKEN("token"),
    PLANE("plane"),
    SCHEME("scheme"),
    PHENOMENON("phenomenon"),
    LEVELER("leveler"),
    VANGUARD("vanguard");


    private String type;

    Layout(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
