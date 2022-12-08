package mx.springboot.form.app.models;

public class Platform {

	private Integer id;
	private String code;
	private String name;

	public Platform() {

	}

	public Platform(Integer id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Platform)) {
			return false;
		}
		
		Platform platform = (Platform) obj;
		return this.id != null && this.id.equals(platform.getId());
				
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
