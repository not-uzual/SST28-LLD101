package com.example.payments;

import java.util.Objects;

/**
 * Adapter that makes FastPayClient compatible with PaymentGateway interface.
 * Translates the PaymentGateway.charge() call to FastPayClient.payNow().
 */
public class FastPayAdapter implements PaymentGateway {
    
    private final FastPayClient fastPayClient;

    public FastPayAdapter(FastPayClient fastPayClient) {
        this.fastPayClient = Objects.requireNonNull(fastPayClient, "fastPayClient");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId");

        return fastPayClient.payNow(customerId, amountCents);
    }
}
