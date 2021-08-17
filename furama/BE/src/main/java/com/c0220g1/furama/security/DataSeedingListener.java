package com.c0220g1.furama.security;

import com.c0220g1.furama.model.entity.Role;
import com.c0220g1.furama.model.entity.User;
import com.c0220g1.furama.repository.RoleRepository;
import com.c0220g1.furama.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Seeding data test for table users and roles
 */

@Component
@RequiredArgsConstructor
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (roleRepository.findByName("ROLE_ADMIN")==null){
            roleRepository.save(new Role(null,"ROLE_ADMIN"));
        }

        if (roleRepository.findByName("ROLE_MEMBER")==null){
            roleRepository.save(new Role(null,"ROLE_MEMBER"));
        }

        if (roleRepository.findByName("ROLE_BLOCK")==null){
            roleRepository.save(new Role(null,"ROLE_BLOCK"));
        }
        if (roleRepository.findByName("ROLE_USER")==null){
            roleRepository.save(new Role(null,"ROLE_USER"));
        }

        //them admin
        if (userRepository.findByEmail("admin@gmail.com") == null){
            User admin = new User();
            admin.setEmail("admin@gmail.com");
            admin.setPassword(bCryptPasswordEncoder.encode("123456"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        if (userRepository.findByEmail("member@gmail.com") == null){
            User user = new User();
            user.setEmail("member@gmail.com");
            user.setPassword(bCryptPasswordEncoder.encode("123456"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
}
