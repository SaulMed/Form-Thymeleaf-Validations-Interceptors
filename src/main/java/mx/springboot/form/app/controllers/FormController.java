package mx.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import mx.springboot.form.app.editors.CategoryPropertyEditor;
import mx.springboot.form.app.editors.PlatformPropertyEditor;
import mx.springboot.form.app.editors.UpperLetterEditor;
import mx.springboot.form.app.models.Category;
import mx.springboot.form.app.models.Game;
import mx.springboot.form.app.models.Platform;
import mx.springboot.form.app.services.CategoryService;
import mx.springboot.form.app.services.PlatformService;
import mx.springboot.form.app.validations.GameValidator;

@Controller
@SessionAttributes("game") // Permite la persistencia de game durante la sesion actual, sin perder Id
public class FormController {

	@Autowired
	private GameValidator validator;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryPropertyEditor categoryEditor;

	@Autowired
	private PlatformService platformService;

	@Autowired
	private PlatformPropertyEditor platformEdidor;

	@InitBinder // Permite la validacion y poblar el objeto
	public void initBinder(WebDataBinder binder) {

		// Obtener data del campo date del formulario y cambiar formato manualmente, sin
		// anotaciones (sustituye al @DateTimeFormat)
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false); // Establecer analizador NO estricto (tolerante)
		binder.registerCustomEditor(Date.class, "lanzamiento", new CustomDateEditor(dateFormat, true));

		// Applicar nuevo Filter Custom Editor para aplicar un uppercase y un trim a los strings UNICAMENTE a TITLE
		binder.registerCustomEditor(String.class, "title", new UpperLetterEditor());

		binder.registerCustomEditor(Category.class, "category", categoryEditor);

		binder.registerCustomEditor(Platform.class, "platforms", platformEdidor);

		// Agregar GameValidator al binder
		binder.addValidators(validator);
	}

	@ModelAttribute(name = "listaCategorias")
	public List<Category> listaCategorias() {
		return categoryService.listar();
	}

	// Cargar data de Categorias al Modelo como Atributo
	@ModelAttribute(name = "categorias")
	public List<String> categories() {
		return Arrays.asList("Adventure", "Action", "Strategy", "Survival Horror", "Shooter");
	}

	@ModelAttribute(name = "categoriasMap")
	public Map<String, String> categoriesMap() { // Trabajar con una lista enlazada
		Map<String, String> categorias = new HashMap<String, String>();
		categorias.put("ADV", "Adventure");
		categorias.put("ACT", "Action");
		categorias.put("STR", "Strategy");
		categorias.put("SHR", "Survival Horror");
		categorias.put("SHT", "Shooter");

		return categorias;
	}

	@ModelAttribute(name = "listaPlatformsString")
	public List<String> listaPlatformsString() {
		List<String> platform = new ArrayList<>();
		platform.add("Xbox");
		platform.add("Play Station 4");
		platform.add("Wii");
		platform.add("PCerda Master Race");
		return platform;
	}

	@ModelAttribute(name = "listaPlatformMap")
	public Map<String, String> listaPlatformMap() {
		Map<String, String> platforms = new HashMap<String, String>();
		platforms.put("XBX", "Xbox");
		platforms.put("PS4", "Play Station 4");
		platforms.put("WI", "Wii");
		platforms.put("PC", "PCerda Master Race");
		return platforms;
	}

	@ModelAttribute(name = "listaPlatformObj")
	public List<Platform> listaPlatformObj() {
		return this.platformService.listar();
	}

	@ModelAttribute(name = "players")
	public List<String> players() {
		return Arrays.asList("Solitary", "Multiplayer");
	}

	@GetMapping("/form")
	public String showForm(Model modelo) {
		Game game = new Game();
		// Cargar dato por defecto al game
		game.setId("K.256.65-");
		game.setAuthor("Epic Games");
		game.setAdult(true);
		game.setSecretValue("Hi! , I'm secret value");
		game.setCategory(new Category(2, "ACT", "Action"));
		game.setPlatforms(Arrays.asList(new Platform(2, "PS4", "PS4"), new Platform(1, "XB", "Xbox")));

		modelo.addAttribute("titulo", "Form Game");
		modelo.addAttribute("game", game);
		return "form";
	}

	@PostMapping("/form")
	public String sendForm(@Valid Game game, BindingResult result, Model modelo) {

//		validator.validate(game, result);	//Se verifica game si cumple con las validaciones establecidas en GameValidator

		if (result.hasErrors()) {
			// Enviar mensajes de validaciones a la vista de forma Manual
//			Map<String , String> errores = new HashMap<>();
//			result.getFieldErrors().forEach( error -> {
//				errores.put(error.getField(), "El campo ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()) );
//			});
//			
//			modelo.addAttribute("error", errores);
			modelo.addAttribute("titulo", "Form Result");
			return "form";
		}
		return "redirect:/ver";
	}

	@GetMapping("/ver")
	public String ver(@SessionAttribute(name = "game", required = false) Game game, Model modelo,
			SessionStatus status) {

		if (game == null) {
			return "redirect:/form";
		}

		modelo.addAttribute("titulo", "Form Result");
		status.setComplete();// Eliminar el objeto game de la session
		return "resultado";
	}

}
