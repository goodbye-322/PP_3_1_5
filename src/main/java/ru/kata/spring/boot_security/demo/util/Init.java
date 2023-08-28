package ru.kata.spring.boot_security.demo.util;//package Kata.Security.Task.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Component
public class Init {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");

        roleService.add(role1);
        roleService.add(role2);

        Set<Role> roleAdmin = new HashSet<>();
        Set<Role> roleUser = new HashSet<>();
        roleUser.add(role1);
        roleAdmin.add(role2);

        User admin = new User("123", "admin@mail.ru", "admin", "admin", 20, roleAdmin);

        userService.add(admin);
    }
}
