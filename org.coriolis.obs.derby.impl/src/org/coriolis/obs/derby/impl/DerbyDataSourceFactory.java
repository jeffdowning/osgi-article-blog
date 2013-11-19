package org.coriolis.obs.derby.impl;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.XADataSource;

import org.osgi.service.jdbc.DataSourceFactory;
import aQute.bnd.annotation.component.Component;

@Component(properties={"OSGI_JDBC_DRIVER_CLASS=org.apache.derby.jdbc.EmbeddedDriver","OSGI_JDBC_DRIVER_NAME=Derby","OSGI_JDBC_DRIVER_VERSION=10.7"})
public class DerbyDataSourceFactory implements DataSourceFactory {
	
	@Override
	public DataSource createDataSource(Properties props) throws SQLException {
		String url = props.getProperty(DataSourceFactory.JDBC_URL);
        if(url!=null && url.length()>0) 
                throw new IllegalArgumentException("DataSourceFactory.JDBC_URL is not supported");
        String databaseName = props.getProperty(DataSourceFactory.JDBC_DATABASE_NAME);
        String serverName = props.getProperty(DataSourceFactory.JDBC_SERVER_NAME);
        
       
        DerbyDataSource ds = new DerbyDataSource();       
        
        if(databaseName!=null) {
                ds.setDatabaseName(databaseName);
        }else{
        	ds.setDatabaseName(this.getClass().getName());
        }
        
        ds.setServerName(serverName);
        ds.setDriverName("org.apache.derby.jdbc.EmbeddedDriver");

       
        return ds;              
	}

	@Override
	public ConnectionPoolDataSource createConnectionPoolDataSource(
			Properties props) throws SQLException {
		throw new SQLException("ConnectionPoolDataSource implementation is not available for this service");
	}

	@Override
	public XADataSource createXADataSource(Properties props) throws SQLException {
		throw new SQLException("XADataSource implementation is not available for this service");	
	}

	@Override
	public Driver createDriver(Properties props) throws SQLException {
		return new org.apache.derby.jdbc.EmbeddedDriver();
	}

}
