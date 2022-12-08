package mx.springboot.form.app.models;

import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;

//import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import mx.springboot.form.app.validations.IdRegex;
import mx.springboot.form.app.validations.Requerido;

public class Game {

//	@Pattern(regexp = "[A-Z]{1}[.][\\d]{3}[.][\\d]{2}[-][A-Z]")	// Se trabaja desde GameValidator
	@IdRegex
	private String id;

	@NotEmpty(message = "Por favor verifica que el AUTHOR del videojuego se encuentre entre 3 y 25 caracteres - Parametro Anotacion")
	@Size(min = 3, max = 25)
	@NotBlank
	private String author;

//	@NotEmpty		//Se trabaja desde GameValidator
	@Size(min = 3, max = 25)
	private String title;

//	@Valid
	@NotNull
	private Category category;

	@NotNull
	@Min(10)
	@Max(99999)
	private Integer price;

//	@NotEmpty
	@Requerido
	@Email(message = "Por favor verifica tu correo electronico e intentalo nuevamente. - Parametro Anotacion")
	private String email;

	@NotNull
	@Past
//	@Future
//	@DateTimeFormat(pattern = "yyyy-MM-dd")

	private Date lanzamiento;
	
	@NotEmpty
	private List<Platform> platforms;
	
	private Boolean adult;

	@NotEmpty
	private String players;
	
	private String secretValue;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLanzamiento() {
		return lanzamiento;
	}

	public void setLanzamiento(Date lanzamiento) {
		this.lanzamiento = lanzamiento;
	}

	public List<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<Platform> platforms) {
		this.platforms = platforms;
	}

	public Boolean getAdult() {
		return adult;
	}

	public void setAdult(Boolean adult) {
		this.adult = adult;
	}

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public String getSecretValue() {
		return secretValue;
	}

	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}

}
