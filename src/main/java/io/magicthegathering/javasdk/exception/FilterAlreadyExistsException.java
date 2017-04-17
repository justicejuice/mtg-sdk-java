package io.magicthegathering.javasdk.exception;

/**
 * An Exception which should be thrown, when a {@link io.magicthegathering.javasdk.filter.AbstractBaseFilter filter}
 * already was added to a request.
 *
 * @author Timon Link - timon.link@gmail.com
 */
public class FilterAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = -1953614025186586712L;

    public FilterAlreadyExistsException(String filterName) {
        super("The filter \'" + filterName + "\' already exists!");
    }
}
