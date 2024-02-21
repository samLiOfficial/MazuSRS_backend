package com.samli.demo;

import com.samli.demo.Credential;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CredentialRepository extends MongoRepository<Credential, String> {
    Credential findByUsername(String username);
}
