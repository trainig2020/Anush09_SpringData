package org.anusha.dao;

import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SimpleJdbcDaoImpl extends JdbcDaoSupport {

	public Map<String, Object> getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		// jdbcTemplate.setDataSource(getDataSource());
		return this.getJdbcTemplate().queryForMap(sql);

	}
}