osgi-article-blog
=================

This project is a proof of concept and the guts for a blogging platform on OSGi better aligned with news and hyperlocal news organizations. It's also a BNDTOOLS project so you will need eclipse and bndtools to operate on it. 

It will consist of many bundles however they all (including the cnf) can be loaded by one clone of this repository.

## org.coriolis.obs.articles.impl
This is the implementation of the ArticleManager. It has no publicly exported classes.

## org.coriolis.obs.derby.impl
This is the DataSourceFactory and EmbeddedDatabase all in one implementation of Apache Derby.

## org.coriolis.obs.api
This is the core api that all obs facets will utilize
