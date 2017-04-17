package io.magicthegathering.javasdk.exception;

import io.magicthegathering.javasdk.api.MTGAPI;

import java.io.IOException;

/**
 * Thrown by {@link MTGAPI} when an http request to magicthegathering.io API fails to return anything.
 * 
 * @author nniklas
 *
 */
public class HttpRequestFailedException extends RuntimeException {

    private static final long serialVersionUID = -6747090146706989350L;

    public HttpRequestFailedException(IOException e) {
		super(e);
	}

}
