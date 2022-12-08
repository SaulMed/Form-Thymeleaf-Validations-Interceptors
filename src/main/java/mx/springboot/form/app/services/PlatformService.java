package mx.springboot.form.app.services;

import java.util.List;

import mx.springboot.form.app.models.Platform;

public interface PlatformService {

	public List<Platform> listar();
	public Platform obtenerPorId(Integer id);
	
}
