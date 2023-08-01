package com.malarcondev.writeitservice.customer;

import java.util.UUID;

public record RetrieveCustomerRequest(
        UUID id,
        String firstName,
        String lastName,
        Integer age,
        String email,
        String address
) {
}
