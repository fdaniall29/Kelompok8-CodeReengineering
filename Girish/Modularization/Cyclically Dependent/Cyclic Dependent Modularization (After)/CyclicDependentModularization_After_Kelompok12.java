package com.myapp;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

package com.myapp;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Role> roles;

    public User(String name) {
        this.name = name;
        roles = new ArrayList<>();
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public String getName() {
        return name;
    }
}

package com.myapp;

import java.util.ArrayList;
import java.util.List;

public class UserRolesManager {
    private List<User> users;
    private List<Role> roles;

    public UserRolesManager() {
        users = new ArrayList<>();
        roles = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void assignRoleToUser(Role role, User user) {
        role.addUser(user);
        user.addRole(role);
    }

    // Additional methods for managing roles and users

    public List<User> getUsersByRole(Role role) {
        List<User> usersWithRole = new ArrayList<>();
        for (User user : users) {
            if (user.getRoles().contains(role)) {
                usersWithRole.add(user);
            }
        }
        return usersWithRole;
    }

    public List<Role> getRolesByUser(User user) {
        List<Role> rolesOfUser = new ArrayList<>();
        for (Role role : roles) {
            if (user.getRoles().contains(role)) {
                rolesOfUser.add(role);
            }
        }
        return rolesOfUser;
    }
}

public class App {
    public static void main(String[] args) {
        UserRolesManager manager = new UserRolesManager();

        Role adminRole = new Role("Admin");
        Role userRole = new Role("User");

        User john = new User("John");
        User sarah = new User("Sarah");

        manager.addRole(adminRole);
        manager.addRole(userRole);

        manager.addUser(john);
        manager.addUser(sarah);

        manager.assignRoleToUser(adminRole, john);
        manager.assignRoleToUser(userRole, sarah);

        List<User> usersWithAdminRole = manager.getUsersByRole(adminRole);
        System.out.println("Users with Admin role:");
        for (User user : usersWithAdminRole) {
            System.out.println(user.getName());
       
