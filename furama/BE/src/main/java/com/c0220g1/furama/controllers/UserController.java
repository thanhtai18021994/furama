package com.c0220g1.furama.controllers;

import com.c0220g1.furama.model.entity.Role;
import com.c0220g1.furama.model.entity.User;
import com.c0220g1.furama.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

     @GetMapping("/api/user/principal")
     public ResponseEntity<User> getPrincipal(){
         Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         String username=null;
         if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
         } else {
             username = principal.toString();
         }
         User user=userService.getUser(username);
         return new ResponseEntity<>(user,HttpStatus.OK);
     }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>>getUsers() {
         return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }


    @PostMapping("/api/user/addRole")
    public ResponseEntity<Void> addRole(@RequestBody Role role){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user=userService.getUser(username);
        List<Role> roles=new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
