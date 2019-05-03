package vaadin.tree.test.dto;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

public class WorkProjectModuleDTO implements Serializable {

	private static final long serialVersionUID = 439679922690480657L;

	@Getter
	@Setter
	private Long idProject;

	@Getter
	@Setter
	private Long idModule;

	@Getter
	@Setter
	private String description;

	@Getter
	@Setter
	private Long parentId;

	@Getter
	@Setter
	private boolean disabled;
	
	@Getter
	@Setter
	private Integer moduleFieldType;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idModule == null) ? 0 : idModule.hashCode());
		result = prime * result + ((idProject == null) ? 0 : idProject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkProjectModuleDTO other = (WorkProjectModuleDTO) obj;
		return isSameItemAs(other);
	}
	
	public boolean isSameItemAs(WorkProjectModuleDTO other) {
		if (Objects.isNull(other))
			return false;
		
		if (this.idModule.compareTo(other.idModule) == 0 &&
				this.idProject.compareTo(other.idProject) == 0) {
				return true;
		}
		
		return false;
	}

}
