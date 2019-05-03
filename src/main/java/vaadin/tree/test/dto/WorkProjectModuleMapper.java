package vaadin.tree.test.dto;

import java.util.ArrayList;
import java.util.Collection;

import vaadin.tree.test.jpa.WorkProjectModule;
import vaadin.tree.test.jpa.WorkProjectModulePK;

public enum WorkProjectModuleMapper {
	INSTANCE;

	public Collection<WorkProjectModuleDTO> getCollectionDtoFromEntities(Collection<WorkProjectModule> modules) {

		Collection<WorkProjectModuleDTO> dtoCollection = new ArrayList<>();

		modules.forEach(entity -> {
			dtoCollection.add(getDtoFromEntity(entity));
		});

		return dtoCollection;
	}

	public WorkProjectModuleDTO getDtoFromEntity(WorkProjectModule workProjectsModuleEntity) {
		WorkProjectModuleDTO dto = new WorkProjectModuleDTO();

		dto.setIdProject(workProjectsModuleEntity.getPk().getIdProject());
		dto.setIdModule(workProjectsModuleEntity.getPk().getIdModule());
		dto.setParentId(workProjectsModuleEntity.getParentId());
		dto.setDescription(workProjectsModuleEntity.getDescription());
		dto.setDisabled(workProjectsModuleEntity.isDisabled());
		dto.setModuleFieldType(workProjectsModuleEntity.getIdFieldType());
		return dto;
	}

	public WorkProjectModule getEntityFromDto(WorkProjectModuleDTO dto) {
		WorkProjectModule entity = new WorkProjectModule();

		WorkProjectModulePK pk = new WorkProjectModulePK(dto.getIdProject(), dto.getIdModule());
		entity.setPk(pk);
		entity.setParentId(dto.getParentId());
		entity.setDescription(dto.getDescription());
		entity.setDisabled(dto.isDisabled());
		entity.setIdFieldType(dto.getModuleFieldType());
		return entity;
	}
}
