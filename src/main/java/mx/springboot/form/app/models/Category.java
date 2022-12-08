package mx.springboot.form.app.models;

import jakarta.validation.constraints.NotNull;

public class Category {

//	@NotNull
	private Integer id;
	private String code;
	private String name;

	public Category() {
	}

	public Category(Integer id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return this.id.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
