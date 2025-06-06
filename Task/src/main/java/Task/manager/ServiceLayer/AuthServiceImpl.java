package Task.manager.ServiceLayer;

import Task.manager.Dto.AuthRequest;
import Task.manager.Dto.AuthResponse;
import Task.manager.Entity.User;
import Task.manager.Repository.UserRepository;
import Task.manager.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public String register(AuthRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered.");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
        return "User registered successfully.";
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
            final String token = jwtUtil.generateToken(userDetails.getUsername());

            return new AuthResponse(token);
        } catch (Exception e) {
            throw new RuntimeException("Invalid email or password", e);
        }
    }
}