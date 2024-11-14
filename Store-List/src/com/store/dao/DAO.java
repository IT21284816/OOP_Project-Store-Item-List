package com.store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.model.Main;

public class DAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/store?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";

    private static final String INSERT_SQL = "INSERT INTO store" +
            " (categoryID, menuName, price, image, discount, description, startDate, endDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_BY_ID = "SELECT id, categoryID, menuName, price, image, discount, description, startDate, endDate FROM store WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM store";
    private static final String DELETE_SQL = "DELETE FROM store WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE store SET categoryID = ?, menuName = ?, price = ?, image = ?, discount = ?, description = ?, startDate = ?, endDate = ?  WHERE id = ?;";

    public DAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertMenu(Main menu) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, menu.getCategoryID());
            preparedStatement.setString(2, menu.getMenuName());
            preparedStatement.setString(3, menu.getPrice());
            preparedStatement.setString(4, menu.getImage());
            preparedStatement.setString(5, menu.getDiscount());
            preparedStatement.setString(6, menu.getDescription());
            preparedStatement.setString(7, menu.getStartDate());
            preparedStatement.setString(8, menu.getendDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Main selectMenu(int id) {
        Main menu = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String categoryID = rs.getString("categoryID");
                String menuName = rs.getString("menuName");
                String price = rs.getString("price");
                String image = rs.getString("image");
                String discount = rs.getString("discount");
                String description = rs.getString("description");
                String startDate = rs.getString("StartDate");
                String endDate = rs.getString("endDate");
                menu = new Main(id, categoryID, menuName, price, image, discount, description, startDate, endDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    public List<Main> selectAllMenus() {
        List<Main> menuList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String categoryID = rs.getString("categoryID");
                String menuName = rs.getString("menuName");
                String price = rs.getString("price");
                String image = rs.getString("image");
                String discount = rs.getString("discount");
                String description = rs.getString("description");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");
                menuList.add(new Main(id, categoryID, menuName, price, image, discount, description, startDate, endDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }
    
    
    public List<Main> AllMenus() {
        List<Main> menuList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String categoryID = rs.getString("categoryID");
                String menuName = rs.getString("menuName");
                String price = rs.getString("price");
                String image = rs.getString("image");
                String discount = rs.getString("discount");
                String description = rs.getString("description");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");
                menuList.add(new Main(id, categoryID, menuName, price, image, discount, description, startDate, endDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }
    

    public boolean deleteMenu(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateMenu(Main menu) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL);) {
            statement.setString(1, menu.getCategoryID());
            statement.setString(2, menu.getMenuName());
            statement.setString(3, menu.getPrice());
            statement.setString(4, menu.getImage());
            statement.setString(5, menu.getDiscount());
            statement.setString(6, menu.getDescription());
            statement.setString(7, menu.getStartDate());
            statement.setString(8, menu.getendDate());
            statement.setInt(9, menu.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
