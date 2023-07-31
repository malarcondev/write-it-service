package com.malarcondev.writeitservice.core;

import java.util.UUID;

public interface IApplicationUserService {
    UUID createUser(CreateUserRequest createUserRequest);
}
