package com.malarcondev.writeitservice.core;

import com.malarcondev.writeitservice.Helper.ApplicationUserHelper;
import com.malarcondev.writeitservice.customer.CreateCustomerRequest;
import com.malarcondev.writeitservice.customer.ICustomerService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ApplicationUserService implements IApplicationUserService{

    private final ApplicationUserRepo applicationUserRepo;
    private final ApplicationUserHelper applicationUserHelper;
    private final ICustomerService iCustomerService;

    @Override
    public UUID createUser(CreateUserRequest createUserRequest) {
        if (createUserRequest.password().isBlank())
            throw new IllegalArgumentException(
                    "Password is required"
            );
        if (createUserRequest.role() == null)
            throw new IllegalArgumentException(
                    "role is required"
            );
        byte[] salt = applicationUserHelper.createSalt();
        byte[] hashedPassword = applicationUserHelper.createPasswordHash(createUserRequest.password(), salt);

        ApplicationUser applicationUser = createUser(createUserRequest, salt, hashedPassword);

        return assignUserRole(createUserRequest, applicationUser);
    }

    @NotNull
    private ApplicationUser createUser(CreateUserRequest createUserRequest, byte[] salt, byte[] hashedPassword) {
        ApplicationUser applicationUser = new ApplicationUser(
                createUserRequest.email(),
                createUserRequest.firstName(),
                createUserRequest.lastName(),
                salt,
                hashedPassword,
                createUserRequest.role()
        );
        applicationUserRepo.save(applicationUser);
        return applicationUser;
    }

    private UUID assignUserRole(CreateUserRequest createUserRequest, ApplicationUser applicationUser) {
            CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest(
                    createUserRequest.firstName(),
                    createUserRequest.lastName(),
                    createUserRequest.age(),
                    createUserRequest.email(),
                    createUserRequest.address(),
                    createUserRequest.password()
            );
            return iCustomerService.createCustomer(applicationUser, createCustomerRequest);
    }
}
