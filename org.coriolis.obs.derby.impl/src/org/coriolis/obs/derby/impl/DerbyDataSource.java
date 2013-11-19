package org.coriolis.obs.derby.impl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class DerbyDataSource implements DataSource {
	
	private String databaseName;
	private String serverName;
	private transient PrintWriter logger;
	private int loginTimeout;
	private String driverName;
	
	public String getDatabaseName() {
		return databaseName;
	}
	
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return this.logger;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		this.logger = out;
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		this.loginTimeout = seconds;
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return this.loginTimeout;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		throw new SQLFeatureNotSupportedException("LogService should be used instead of parent logger");
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		throw new SQLException("The method unwrap(Class<T>) is not implemented in this data source");
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		throw new SQLException("The method isWrapperFor(Class<?>) is not implemented in this data source");
	}

	@Override
	public Connection getConnection() throws SQLException {
		Properties props = new Properties();
		String url = "jdbc:"+this.getServerName()+":"+this.getDatabaseName()+";create=true";
		Driver driver = null;
		try {
			driver = (Driver) Class.forName(this.getDriverName()).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = driver.connect(url, props);
		return conn;
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		return this.getConnection();
		
	}

	

}
