package mx.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.springboot.form.app.models.Category;

@Service
public class CategoryServiceImp implements CategoryService {

	private List<Category> listaCategories;

	public CategoryServiceImp() {
		this.listaCategories = Arrays.asList(new Category(1, "ADV", "Adventure"), new Category(2, "ACT", "Action"),
				new Category(3, "STR", "Strategy"), new Category(4, "SHR", "Survival Horror"),
				new Category(5, "SHT", "Shooter"));
	}

	@Override
	public List<Category> listar() {
		return listaCategories;
	}

	@Override
	public Category obtenerPorId(Integer id) {
		Category result = null;
		for (Category categoria : this.listaCategories) {
			if (id == categoria.getId()) {
				result = categoria;
			}
		}
		return result;
	}

}
