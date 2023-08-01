package com.malarcondev.writeitservice.customer;

import com.malarcondev.writeitservice.core.Role;

public record UpdateCustomerRequest(
        Integer age,
        String address,
        Role role
) {
}
