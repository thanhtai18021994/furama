package com.c0220g1.furama.service.service;



import com.c0220g1.furama.model.entity.Role;
import com.c0220g1.furama.model.entity.User;

import java.util.List;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 7/10/2021
 */
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
}
