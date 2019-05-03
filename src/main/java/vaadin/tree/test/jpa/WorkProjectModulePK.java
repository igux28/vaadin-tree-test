package vaadin.tree.test.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@EqualsAndHashCode
@ToString
public class WorkProjectModulePK implements Serializable {

	private static final long serialVersionUID = 5446190735129761187L;

	@Column(insertable=false, updatable=false)
	@Getter @Setter private Long idProject;

	@Column(insertable=false, updatable=false)
	@Getter @Setter private Long idModule;

	
	public WorkProjectModulePK() {
	}
	
	public WorkProjectModulePK(Long idProject, Long idModule) {
		this.idProject = idProject;
		this.idModule = idModule;
	}
}
