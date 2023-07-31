package com.malarcondev.writeitservice.core;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ApplicationUserService implements IApplicationUserService{

    private final ApplicationUserRepo applicationUserRepo;

    @Override
    public UUID createUser(CreateUserRequest createUserRequest) {
        return null;
    }
}
