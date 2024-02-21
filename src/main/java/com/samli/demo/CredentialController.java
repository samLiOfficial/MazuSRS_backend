package com.samli.demo;

import com.samli.demo.Credential;
import com.samli.demo.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CredentialController {

    @Autowired
    private CredentialRepository credentialRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Credential credential) {
        Credential foundCredential = credentialRepository.findByUsername(credential.getUsername());

        if (foundCredential != null && foundCredential.getPassword().equals(credential.getPassword())) {
            // Assuming you'll handle sessions or JWT tokens here
            return ResponseEntity.ok().body("User authenticated");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
