package org.coriolis.obs.derby.setup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbySetup {

	public void startup(Connection conn) throws InstantiationException, IllegalAccessException, ClassNotFoundException{		
		checkCatalogs(conn);
	}
	
	public void checkCatalogs(Connection conn){
		System.out.println("Checking tables");
		try {
			ResultSet catalogs = conn.getMetaData().getTables(null, "APP", null, new String[]{"TABLE"});
			int count = 0;
			while(catalogs.next()){
				count++; 
			}
			
			System.out.println("Found "+count+" tables");
			if(count < 2){
				createArticleTable(conn);
				createTagTable(conn);
			}
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	private void createArticleTable(Connection conn){
		String stmtString = "CREATE TABLE ARTICLES (ARTICLE_ID INT not null primary "+
	"key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), CANONICAL_NAME VARCHAR(50), "+
	" HEADLINE VARCHAR(1024),DESCRIPTION VARCHAR(150),BODY LONG VARCHAR,AUTHOR VARCHAR(150),AUTHOR_TITLE "+
	"VARCHAR(255),DATELINE VARCHAR(255),LOCATION VARCHAR(255), PRIMARY_CATEGORY VARCHAR(255))";
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			stmt.execute(stmtString);
			System.out.println("Articles tables created....");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	
	private void createTagTable(Connection conn){
		String stmtString = "CREATE TABLE ARTICLE_TAGS ( ARTICLE_ID INT, TAG_NAME varchar(255) not null )";
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			stmt.execute(stmtString);
			System.out.println("Tags tables created....");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	
	}
	
	
}
