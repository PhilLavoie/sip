package com.philz.sip;

/**
 * Interface for SIP messages responses.
 *
 * For a list of known methods, see {@link StandardMethod}.
 *
 * It makes no sense for these object to be mutable, so
 */
public interface Method {
    String getRepresentation();
}
