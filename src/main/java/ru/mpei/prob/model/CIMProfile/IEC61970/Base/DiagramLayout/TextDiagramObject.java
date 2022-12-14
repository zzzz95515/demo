package ru.mpei.prob.model.CIMProfile.IEC61970.Base.DiagramLayout;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A diagram object for placing free-text or text derived from an associated 
 * domain object.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:51 MSK 2020
 */

@Entity
@Table(name = "textdiagramobject")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextDiagramObject extends DiagramObject {
	/**
	 * The text that is displayed by this text diagram object.
	 */
	@Column(name="text", nullable = true)
	private String text;


	public String getText(){
		return this.text;
	}

	@FieldSetter(fieldName = "TextDiagramObject.text", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setText(String text){
		this.text = text;
	}

	public TextDiagramObject(){

	}

}
