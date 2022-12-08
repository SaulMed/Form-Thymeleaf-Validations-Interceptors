package mx.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.springboot.form.app.models.Platform;

@Service
public class PlatformServiceImp implements PlatformService {

	private List<Platform> platforms;

	public PlatformServiceImp() {
		this.platforms = new ArrayList<>();
		platforms.add(new Platform(1, "XB", "Xbox"));
		platforms.add(new Platform(2, "PS4", "PS4"));
		platforms.add(new Platform(3, "WI", "WII"));
		platforms.add(new Platform(4, "PC", "PC"));
	}

	@Override
	public List<Platform> listar() {
		return this.platforms;
	}

	@Override
	public Platform obtenerPorId(Integer id) {
		Platform result = null;
		for (Platform plataforma : platforms) {
			if (id == plataforma.getId()) {
				result = plataforma;
				break;
			}
		}
		return result;
	}

}
