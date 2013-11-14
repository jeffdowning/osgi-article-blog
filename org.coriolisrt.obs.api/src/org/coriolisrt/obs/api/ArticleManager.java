package org.coriolisrt.obs.api;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public interface ArticleManager {
	Article getArticle(String canonicalName);
	Article getArticle(int dbid);
	List<Article> getArticlesByCategory(String categoryName, int limit);
	List<Article> getArticlesByTag(String[] tags,int limit);
}
