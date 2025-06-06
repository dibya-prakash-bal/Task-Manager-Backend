package Task.manager.ServiceLayer;

import Task.manager.Dto.AuthRequest;
import Task.manager.Dto.AuthResponse;


public interface AuthService {
    String register(AuthRequest request);
    AuthResponse login(AuthRequest request);
}
