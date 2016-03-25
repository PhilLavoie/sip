package com.philz.sip;

public enum StandardHeader implements Header {
    VIA("Via"),
    TO("To"),
    FROM("From"),
    CALL_ID("Call-ID"),
    CSEQ("CSeq"),
    CONTACT("Contact"),
    MAX_FORWARDS("Max-Forwards"),
    EVENT("Event"),
    ALLOW_EVENTS("Allow-Events"),
    SUBSCRIPTION_STATE("Subscription-State"),
    EXPIRES("Expires"),
    MIN_EXPIRES("Min-Expires"),
    REFER_TO("Refer-To"),
    INFO_PACKAGE("Info-Package"),
    RACK("RAck");

    private final String representation;

    StandardHeader(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return this.representation;
    }
}
