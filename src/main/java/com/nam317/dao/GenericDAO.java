package com.nam317.dao;

import java.util.List;

import com.nam317.mapper.RowMapper;

public interface GenericDAO<T> {    // generic type T
	<T> List<T> query(String sql, RowMapper<T> rowmapper, Object... parameters);
	void update (String sql, Object... parameters);
	Long insert (String sql, Object... parameters);
	int count(String sql,Object... parameters);
}
