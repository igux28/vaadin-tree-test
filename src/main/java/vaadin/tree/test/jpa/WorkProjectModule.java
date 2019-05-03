package vaadin.tree.test.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="work_project_module")
@ToString
public class WorkProjectModule implements Serializable {

	private static final long serialVersionUID = 7805234650147480518L;

	@EmbeddedId
	@Getter @Setter private WorkProjectModulePK pk;

	@Getter @Setter private String description;
	@Getter @Setter private Long parentId;

	
	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	@Getter @Setter private boolean disabled;
	
	@Getter @Setter private Integer idFieldType;
	
	
	public WorkProjectModule() {
	}
}
