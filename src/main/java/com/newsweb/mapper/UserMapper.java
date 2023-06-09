package com.newsweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.newsweb.model.RoleModel;
import com.newsweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			RoleModel role = new RoleModel();
			user.setId(resultSet.getLong("id"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setFullname(resultSet.getString("fullname"));
			user.setStatus(resultSet.getInt("status"));
			user.setRoleId(resultSet.getLong("roleid"));
//			user.setCreateDate(resultSet.getTimestamp("create_date"));
//			user.setCreateBy(resultSet.getString("create_by"));
			try {
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
			}
			if (resultSet.getTimestamp("modify_date") != null) {
				user.setModifyDate(resultSet.getTimestamp("modify_date"));
			}
			if (resultSet.getString("modify_by") != null) {
				user.setModifyBy(resultSet.getString("modify_by"));
			}
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

}
