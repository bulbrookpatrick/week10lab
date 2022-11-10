/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.RoleService;
import services.UserService;

/**
 *
 * @author Patrick
 */
public class UserServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RoleService rs = new RoleService();
        UserService us = new UserService();
        
        try {
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
            List<User> users = us.getAll(email);
            request.setAttribute("users", users);
                
        }
        
        catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }
        
        String action = request.getParameter("action");
        if (action != null && action.equals("view")) {
            try {
                String email = request.getParameter("email");
                User user = us.get(email);
                request.setAttribute("selectedUser", user);
                
            }
            catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);


    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
            
            UserService us = new UserService();
            
            String action = request.getParameter("action");
            
            String fName = request.getParameter("fName");
            String lName = request.getParameter("lName");
            String password = request.getParameter("password");
            int role = Integer.parseInt(request.getParameter("roleID"));
            
            try {
                switch (action) {
                    case "add":
                        us.insert(email, fName, lName, password, role);
                            
                    case "edit":
                        us.update(email, fName, lName, password, role);
                            
                    case "delete":
                        us.delete(email);
                }
            }
                catch (Exception ex) {
             Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
                        }
            
            try {
                List<User> users = us.getAll(email);
                request.setAttribute("users", users);
            }
            catch (Exception ex) {
                     Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);


}
}
