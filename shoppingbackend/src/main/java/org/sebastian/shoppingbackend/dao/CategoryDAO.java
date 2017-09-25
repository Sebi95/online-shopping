package org.sebastian.shoppingbackend.dao;

import java.util.List;

import org.sebastian.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();

	Category get(int id);

}
