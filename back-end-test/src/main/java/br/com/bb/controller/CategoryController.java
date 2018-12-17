package br.com.bb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bb.model.Category;
import br.com.bb.repository.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {

	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public @ResponseBody List<Category> listAll() {
		List<Category> list = categoryRepository.findAll();
		return list;
	}

}
