package org.coriolisrt.obs.api;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public interface CategoryManager {
	List<Category> getAllCategories();
}
