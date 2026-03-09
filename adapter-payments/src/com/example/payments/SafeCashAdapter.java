package com.example.payments;

import java.util.Objects;

/**
 * Adapter that makes SafeCashClient compatible with PaymentGateway interface.
 * Translates the PaymentGateway.charge() call to SafeCashClient.createPayment() + confirm().
 */
public class SafeCashAdapter implements PaymentGateway {
    
    private final SafeCashClient safeCashClient;

    public SafeCashAdapter(SafeCashClient safeCashClient) {
        this.safeCashClient = Objects.requireNonNull(safeCashClient, "safeCashClient");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId");

        SafeCashPayment payment = safeCashClient.createPayment(amountCents, customerId);
        return payment.confirm();
    }
}
