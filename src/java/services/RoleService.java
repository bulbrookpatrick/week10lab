/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.util.*;
import models.Role;
import dataaccess.RoleDB;
/**
 *
 * @author Patrick
 */
public class RoleService {
    public Role get(int roleID) throws Exception {
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.get(roleID);
        return role;
        
    }
    
    public List<Role> getAll (String roleID) throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAll(roleID);
        return roles;
    }
    
    public void insert(int roleID, String roleName) throws Exception {
        Role role = new Role(roleID, roleName);
        RoleDB roleDB = new RoleDB();
        roleDB.insert(role);
        
        
    }
    
    public void update(int roleID, String roleName) throws Exception {
        Role role = new Role(roleID, roleName);
        RoleDB roleDB = new RoleDB();
        roleDB.update(role);
    }
    
    public void delete(int roleID) throws Exception {
        Role role = new Role();
        role.setRoleID(roleID);
        RoleDB roleDB = new RoleDB();
        roleDB.delete(role);
    }
}
