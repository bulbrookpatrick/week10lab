/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;
import models.Role;
/**
 *
 * @author Patrick
 */
public class RoleDB {
        
    public List<Role> getAll(String roleIdentification) throws Exception {
        List<Role> roles = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "Select * from role where roleID=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, roleIdentification);
            rs = ps.executeQuery();
            while (rs.next()) {
                int roleID = rs.getInt(1);
                String roleName = rs.getString(2);
                Role role = new Role(roleID, roleName);
                
                roles.add(role);
                
                
            }
            
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        
        
        
        return roles;
    }
    
    public Role get(int roleID) throws Exception {
        Role role = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select * from role where role_id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, roleID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String roleName = rs.getString(2);
                
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return role;
    }
    
    public void insert(Role role) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "Insert into role (role_id, role_name) values (?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, role.getRoleID());
            ps.setString(2, role.getRoleName());
            
            ps.executeUpdate();
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        
    }
    
    public void update(Role role) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "Update role set role_id=?, role_name=? where note_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, role.getRoleID());
            ps.setString(2, role.getRoleName());
            
            ps.executeUpdate();
            
            
        }
        
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
    }
    
    public void delete(Role role) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from role where role_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, role.getRoleID());
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
                
    }

}

