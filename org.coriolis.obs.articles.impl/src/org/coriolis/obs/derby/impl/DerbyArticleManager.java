package org.coriolis.obs.derby.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.coriolis.obs.derby.setup.DerbySetup;
import org.coriolisrt.obs.api.Article;
import org.coriolisrt.obs.api.ArticleManager;
import org.osgi.framework.BundleContext;
import org.osgi.service.jdbc.DataSourceFactory;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

@Component(immediate=true)
public class DerbyArticleManager implements ArticleManager {
	
	private transient DataSourceFactory dsfactory;

	@Override
	public Article getArticle(String canonicalName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getArticle(int dbid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> getArticlesByCategory(String categoryName, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> getArticlesByTag(String[] tags, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Activate
	public void activate(BundleContext ctx){
		System.out.println("Activating Derby Implementation");
		try {
			Properties props = new Properties();
			props.put(DataSourceFactory.JDBC_DATABASE_NAME, "articlesDB");
			props.put(DataSourceFactory.JDBC_SERVER_NAME, "derby");
			
			new DerbySetup().startup(dsfactory.createDataSource(props).getConnection());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void submitArticle(Article article) {
		
		
	}

	public DataSourceFactory getDsfactory() {
		return dsfactory;
	}

	@Reference(target="(OSGI_JDBC_DRIVER_CLASS=org.apache.derby.jdbc.EmbeddedDriver)")
	public void setDsfactory(DataSourceFactory dsfactory) {
		System.out.println("Found factory implementation for derby embedded!");
		this.dsfactory = dsfactory;
	}

}
