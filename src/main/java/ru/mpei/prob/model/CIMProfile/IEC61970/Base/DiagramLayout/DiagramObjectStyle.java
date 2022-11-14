package ru.mpei.prob.model.CIMProfile.IEC61970.Base.DiagramLayout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * A reference to a style used by the originating system for a diagram object. 
 *  A diagram object style describes information such as line thickness, shape 
 * such as circle or rectangle etc, and color.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:51 MSK 2020
 */

@Entity
@Table(name = "diagramobjectstyle")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiagramObjectStyle extends IdentifiedObject {

	/**
	 * A diagram object has a style associated that provides a reference for the 
	 * style used in the originating system.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "DiagramObjectStyle")
	private List<DiagramObject> StyledObjects;

	@JsonIgnore
	public List<DiagramObject> getStyledObjects(){
		return this.StyledObjects;
	}

	@AssociationSetter(fieldName = "DiagramObjectStyle.StyledObjects", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.DiagramLayout.DiagramObject", cardinality = "many")
	public void setStyledObjects(List<DiagramObject> StyledObjects){
		this.StyledObjects = StyledObjects;
	}

	public DiagramObjectStyle(){

	}

}