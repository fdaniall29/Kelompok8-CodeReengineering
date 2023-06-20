package com.myapp;
import java.util.ArrayList;
import java.util.List;


public class Role {
 private String roleName;
 private List<User> users;

 public Role(String roleName) {
     this.roleName = roleName;
     users = new ArrayList<>();
 }

 public void addUser(User user) {
     users.add(user);
 }

 public List<User> getUsers() {
     return users;
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