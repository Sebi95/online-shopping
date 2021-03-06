package org.sebastian.onlineshopping.controller;

import org.sebastian.shoppingbackend.dao.CategoryDAO;
import org.sebastian.shoppingbackend.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		System.out.println(Math.sqrt(-4D));
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;

	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllPoducts() {

		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch a single category

		mv.addObject("title", "All products");

		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryPoducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch a single category
		Category category = null;

		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());

		mv.addObject("categories", categoryDAO.list());

		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

}
