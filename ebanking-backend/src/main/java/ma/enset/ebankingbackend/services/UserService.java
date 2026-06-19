package ma.enset.ebankingbackend.services;

import ma.enset.ebankingbackend.dtos.CreateUserRequest;
import ma.enset.ebankingbackend.entities.User;

public abstract class UserService {
    public abstract User createUser(CreateUserRequest request);
}
