
package com.ecxam_system.Exam_system.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecxam_system.Exam_system.entity.user;
import com.ecxam_system.Exam_system.repository.userRepository;

@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    private userRepository userRepo;


    // ============================
    // GET ALL USERS
    // ============================

    @GetMapping("/all")
    public List<user> getAllUsers() {

        return userRepo.findAll();
    }


    // ============================
    // REGISTER USER
    // ============================

    @PostMapping("/register")
    public user register(@RequestBody user user) {

        if (user.getRole() == null ||
            user.getRole().trim().isEmpty()) {
        }

        return userRepo.save(user);
    }


    // ============================
    // LOGIN
    // ============================
@PostMapping("/auth/login")
public ResponseEntity<?> login(@RequestBody user user) {

    Optional<user> found =
            userRepo.findByUsername(user.getUsername());

    if (found.isPresent()
            && found.get().getPassword().equals(user.getPassword())) {

        user loggedInUser = found.get();

        Map<String, Object> response = new HashMap<>();

        response.put("message", "User logged in successfully");
        response.put("id", loggedInUser.getId());
        response.put("name", loggedInUser.getName());
        response.put("username", loggedInUser.getUsername());
        response.put("email", loggedInUser.getEmail());
        response.put("role", loggedInUser.getRole());

        return ResponseEntity.ok(response);
    }

    return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body("Invalid username or password");
}

    // ============================
    // UPDATE USER
    // ============================

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable Long id,
            @RequestBody user updatedUser) {

        Optional<user> optionalUser =
                userRepo.findById(id);

        if (optionalUser.isEmpty()) {

            return ResponseEntity
                    .notFound()
                    .build();
        }

        user existingUser = optionalUser.get();

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setRole(updatedUser.getRole());

        /*
         * Only update password when a new password
         * was actually provided.
         */
        if (updatedUser.getPassword() != null
                && !updatedUser.getPassword().trim().isEmpty()) {

            existingUser.setPassword(
                    updatedUser.getPassword()
            );
        }

        user savedUser = userRepo.save(existingUser);

        return ResponseEntity.ok(
                "User updated successfully"
        );
    }


    // ============================
    // DELETE USER
    // ============================

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(
            @PathVariable Long id) {

        Optional<user> optionalUser =
                userRepo.findById(id);

        if (optionalUser.isEmpty()) {

            return ResponseEntity
                    .notFound()
                    .build();
        }

        userRepo.deleteById(id);

        return ResponseEntity.ok(
                "User deleted successfully"
        );
    }
}
