package com.abatplus.tha.urlshortener.rest.exception;

import java.util.UUID;

public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException(UUID urlId) {
        super("UrlEntity with ID " + urlId + " does not exist.");
    }
}
