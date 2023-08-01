package com.malarcondev.writeitservice.customer;

public record CreateCustomerRequest(
        String firstName,
        String lastName,
        Integer age,
        String email,
        String address,
        String password
) {
}
