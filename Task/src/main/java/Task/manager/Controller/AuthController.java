package Task.manager.Controller;

import Task.manager.Dto.AuthRequest;
import Task.manager.Dto.AuthResponse;
import Task.manager.ServiceLayer.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    // POST /auth/signup
    // AuthController.java
    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody AuthRequest request) {
        try {
            String result = authService.register(request);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Collections.singletonMap("message", result));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    // POST /auth/login
    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody AuthRequest request) {
        return authService.login(request);
    }
}
