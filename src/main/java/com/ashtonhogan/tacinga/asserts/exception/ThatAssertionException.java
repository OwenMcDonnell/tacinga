package com.ashtonhogan.tacinga.asserts.exception;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class ThatAssertionException extends Exception {

    private static final long serialVersionUID = 1L;

    public ThatAssertionException(final String message) {
        super(message);
    }

    public ThatAssertionException(final Throwable cause) {
        super(cause);
    }
}
