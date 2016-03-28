package com.philz.sip;

public enum ResponseClass {
    INFORMATIONAL,
    SUCCESS,
    REDIRECTION,
    CLIENT_ERROR,
    SERVER_ERROR,
    GLOBAL_ERROR;

    private static final ResponseClass[] RESPONSE_CLASSES =
        {INFORMATIONAL, SUCCESS, REDIRECTION, CLIENT_ERROR, SERVER_ERROR, GLOBAL_ERROR};


    public static ResponseClass responseClassOfStatusCode(int statusCode) {
        if (statusCode < 100 || statusCode >= 700) {
            throw new IllegalArgumentException(
                "invalid status code: " + statusCode + " expected to be [100, 700[");
        }

        return RESPONSE_CLASSES[(statusCode / 100) - 1];
    }
}
