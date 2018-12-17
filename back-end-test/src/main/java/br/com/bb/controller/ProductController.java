package br.com.bb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bb.model.Category;
import br.com.bb.model.Product;
import br.com.bb.repository.CategoryRepository;
import br.com.bb.repository.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	@Autowired
	public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@RequestMapping(value = "/listByCategory/{category_id}", method = RequestMethod.GET)
	public @ResponseBody List<Product> listByCategory(@PathVariable("category_id") Long category_id) throws Exception {
		Optional<Category> category = categoryRepository.findById(category_id);
		if (!category.isPresent()) {
			throw new Exception("Category informed not found.");
		}
		List<Product> list = productRepository.findByCategory(category.get());
		return list;
	}

}
