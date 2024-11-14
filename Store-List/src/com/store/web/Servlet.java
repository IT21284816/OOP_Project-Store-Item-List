package com.store.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.dao.DAO;
import com.store.model.Main;

@WebServlet("/")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO dAO;

    public void init() {
        dAO = new DAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertMenu(request, response);
                    break;
                case "/delete":
                    deleteMenu(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateMenu(request, response);
                    break;
                case "/all-list":
                    allList(request, response);
                    break;    
                default:
                    listMenu(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void allList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Main> menuList = dAO.AllMenus();
        request.setAttribute("menuList", menuList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("storeItem-details.jsp");
        dispatcher.forward(request, response);
    }

    private void listMenu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Main> menuList = dAO.selectAllMenus();
        request.setAttribute("menuList", menuList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("storeItem-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("storeItem-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Main existingMenu = dAO.selectMenu(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("storeItem-form.jsp");
        request.setAttribute("menu", existingMenu);
        dispatcher.forward(request, response);
    }

    private void insertMenu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String categoryID = request.getParameter("categoryID");
        String menuName = request.getParameter("menuName");
        String price = request.getParameter("price");
        String image = request.getParameter("image");
        String discount = request.getParameter("discount");
        String description = request.getParameter("description");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        
        Main newMenu = new Main(categoryID, menuName, price, image, discount, description, startDate, endDate);
        dAO.insertMenu(newMenu);
        response.sendRedirect("list");
    }

    private void updateMenu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String categoryID = request.getParameter("categoryID");
        String menuName = request.getParameter("menuName");
        String price = request.getParameter("price");
        String image = request.getParameter("image");
        String discount = request.getParameter("discount");
        String description = request.getParameter("description");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        
        Main updatedMenu = new Main(id, categoryID, menuName, price, image, discount, description, startDate, endDate);
        dAO.updateMenu(updatedMenu);
        response.sendRedirect("list");
    }

    private void deleteMenu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dAO.deleteMenu(id);
        response.sendRedirect("list");
    }
}
