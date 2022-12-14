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
/**
 *
 * @author Patrick
 */
public class UserDB {
    public User get(String email) throws Exception {
        User user = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from user where email=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String password = rs.getString(4);
                int role = rs.getInt(5);
                user = new User(email, fName, lName, password, role);
            }
        }
            finally {
                    DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
                    }
        return user;
        }
    
    
        public List<User> getAll (String userID) throws Exception {
        
    List<User> users = new ArrayList<>();    
    ConnectionPool cp = ConnectionPool.getInstance();
    Connection con = cp.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    String sql = "Select * from user where email = ?";
        
    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, userID);
        rs = ps.executeQuery();
        
        while (rs.next()) {
           String email = rs.getString(1);
           String fName = rs.getString(2);
           String lName = rs.getString(3);
           String password = rs.getString(4);
           int role = rs.getInt(5);
           
           
           User user = new User(email, fName, lName, password, role);
           
          
        }
}
    finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
}
    return users;
}

    public void insert(User user) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into user (email, first_name, last_name, password, role) values (?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getfName());
            ps.setString(3, user.getlName());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getRole());
            ps.executeUpdate();
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void update(User user) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
                String sql = "update user set email=?, first_name=?, last_name=?, password=?, role=?";

        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getfName());
            ps.setString(3, user.getlName());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getRole());
            ps.executeUpdate();
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void delete(User user) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "delete deom user where email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        

    }


}
