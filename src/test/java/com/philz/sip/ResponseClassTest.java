package com.philz.sip;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.philz.sip.ResponseClass.responseClassOfStatusCode;
import static org.junit.Assert.*;

public class ResponseClassTest {

    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Test public void testWithHighestNumberUnderLowerBound() {
        expectedException.expect(IllegalArgumentException.class);

        responseClassOfStatusCode(99);
    }

    @Test public void testWithLowestNumberAboveHigherBound() {
        expectedException.expect(IllegalArgumentException.class);

        responseClassOfStatusCode(700);
    }

    private void loopAssertEquals(ResponseClass expected, int startValue, int exclusiveMaxBound) {
        for (int i = startValue; i < exclusiveMaxBound; i++) {
            ResponseClass responseClass = responseClassOfStatusCode(i);
            assertEquals(expected, responseClass);
        }
    }

    @Test public void testInformational() {
        loopAssertEquals(ResponseClass.INFORMATIONAL, 100, 200);
    }

    @Test public void testSuccess() {
        loopAssertEquals(ResponseClass.SUCCESS, 200, 300);
    }

    @Test public void testRedirection() {
        loopAssertEquals(ResponseClass.REDIRECTION, 300, 400);
    }

    @Test public void testClientError() {
        loopAssertEquals(ResponseClass.CLIENT_ERROR, 400, 500);
    }

    @Test public void testServerError() {
        loopAssertEquals(ResponseClass.SERVER_ERROR, 500, 600);
    }

    @Test public void testGlobalError() {
        loopAssertEquals(ResponseClass.GLOBAL_ERROR, 600, 700);
    }

}
