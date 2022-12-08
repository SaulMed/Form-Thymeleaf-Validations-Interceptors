package mx.springboot.form.app.services;

import java.util.List;

import mx.springboot.form.app.models.Category;

public interface CategoryService {
	
	public List<Category> listar();
	public Category obtenerPorId(Integer id);

}
