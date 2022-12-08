package mx.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.springboot.form.app.services.CategoryService;

@Component
public class CategoryPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private CategoryService service;

	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(idString);
			this.setValue(service.obtenerPorId(id));
		} catch (Exception e) {
			this.setValue(null);
		}
	}

}
