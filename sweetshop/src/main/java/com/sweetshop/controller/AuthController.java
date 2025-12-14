package com.sweetshop.controller;

import com.sweetshop.model.User;
import com.sweetshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; 
    }

    @PostMapping("/register")
    public String saveUser(
            @RequestParam String username,
            @RequestParam String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); 
        user.setRole("ROLE_USER");

        userRepository.save(user); 

        return "redirect:/login";
    }
}
