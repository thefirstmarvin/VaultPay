package com.vaultpay.userservice.repository;

import com.vaultpay.userservice.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
