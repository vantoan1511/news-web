package com.newsweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.newsweb.dao.ICategoryDAO;
import com.newsweb.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO {

	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/newsweb";
			String username = "root";
			String password = "admin";
			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		String sql = "SELECT * FROM category";
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			set = statement.executeQuery();
			while (set.next()) {
				CategoryModel model = new CategoryModel();
				model.setCode(set.getString("code"));
				model.setName(set.getString("name"));
				results.add(model);
			}
			return results;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (set != null) {
					set.close();
				}
			} catch (Exception e2) {
			}
		}
	}

}
