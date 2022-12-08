package mx.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

public class UpperLetterEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		setValue(text.toUpperCase().trim());
	}

	
	
}
