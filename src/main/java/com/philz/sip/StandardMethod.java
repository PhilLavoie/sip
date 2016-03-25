package com.philz.sip;

import com.google.common.collect.ImmutableList;

import static com.philz.sip.StandardHeader.*;

public enum StandardMethod implements Method {
    INVITE("INVITE", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, CONTACT, MAX_FORWARDS)),
    REGISTER("REGISTER", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, MAX_FORWARDS)),
    BYE("BYE", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, MAX_FORWARDS)),
    ACK("ACK", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, MAX_FORWARDS)),
    CANCEL("CANCEL", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, MAX_FORWARDS)),
    OPTIONS("OPTIONS", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, MAX_FORWARDS)),
    SUBSCRIBE("SUBSCRIBE",
        arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, CONTACT, MAX_FORWARDS, EVENT, ALLOW_EVENTS)),
    NOTIFY("NOTIFY", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, MAX_FORWARDS, EVENT, ALLOW_EVENTS,
        SUBSCRIPTION_STATE)),
    PUBLISH("PUBLISH",
        arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, CONTACT, MAX_FORWARDS, EVENT, ALLOW_EVENTS, EXPIRES,
            MIN_EXPIRES)),
    REFER("REFER", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, MAX_FORWARDS, REFER_TO)),
    MESSAGE("MESSAGE", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, MAX_FORWARDS)),
    INFO("INFO", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, MAX_FORWARDS, INFO_PACKAGE)),
    PRACK("PRACK", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, MAX_FORWARDS, RACK)),
    UPDATE("UPDATE", arrayOf(VIA, TO, FROM, CALL_ID, CSEQ, CONTACT, MAX_FORWARDS));

    private final String representation;
    private final ImmutableList<Header> mandatoryHeaders;

    StandardMethod(String representation, Header[] mandatoryHeaders) {
        this.representation = representation;
        this.mandatoryHeaders = ImmutableList.copyOf(mandatoryHeaders);
    }

    private static final <T> T[] arrayOf(T... values) {
        return values;
    }

    public String getRepresentation() {
        return this.representation;
    }

    public Iterable<Header> getMandatoryHeaders() {
        return this.mandatoryHeaders;
    }
}
