package pholib.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pholib.model.User;

/**
 * Created by melina on 4/3/17.
 */
public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
