package com.newsweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.newsweb.dao.GenericDAO;
import com.newsweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
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
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	private void setParameters(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				if (parameters[i] instanceof Long) {
					statement.setLong(i + 1, (Long) parameters[i]);
				} else if (parameters[i] instanceof String) {
					statement.setString(i + 1, (String) parameters[i]);
				} else if (parameters[i] instanceof Integer) {
					statement.setInt(i + 1, (Integer) parameters[i]);
				} else if (parameters[i] instanceof Timestamp) {
					statement.setTimestamp(i + 1, (Timestamp) parameters[i]);
				}
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		Long id = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameters(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e2) {
			}
		}
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (Exception e) {
			return count;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e2) {
			}
		}
	}
}
