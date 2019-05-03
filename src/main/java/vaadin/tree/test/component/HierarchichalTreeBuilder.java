package vaadin.tree.test.component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import vaadin.tree.test.dto.WorkProjectModuleDTO;

/**
 * Get the items wrapped in a {@link ModuleContainer} for a Tree Hierarchichally ordered.
 * @author IBAN UGARTE
 *
 */
public class HierarchichalTreeBuilder implements Serializable {

	private static final long serialVersionUID = -4239212307263128370L;
	
	StringBuilder message = new StringBuilder();
	
	ModuleComponent parent;
	Collection<WorkProjectModuleDTO> children;
	ModuleComponent allModules = new ModuleContainer();
	
	private int parentPosition = 1;
	static final Collection<FieldType> FIELD_CONTAINERS = Arrays.asList(FieldType.TABCONTAINER, FieldType.ACCORDIONCONTAINER);
	
	
	private HierarchichalTreeBuilder(){}
	
	public static ModuleContainer getTreeItems(ModuleComponent parent, Collection<WorkProjectModuleDTO> children){
		HierarchichalTreeBuilder treeBuilder = new HierarchichalTreeBuilder();
		treeBuilder.parent = parent;
		treeBuilder.children = children;
		treeBuilder.buildItems();
		return (ModuleContainer) treeBuilder.allModules;
		
	}
	
	private void buildItems(){
		
		for(WorkProjectModuleDTO module : children){
			
			if(isModuleContainer(module)) {
				createContainer(module);
			} else {
				createItem(module);
			}
		}
		
	}
	
	private boolean isModuleContainer(WorkProjectModuleDTO module) {
		FieldType fieldType = FieldType.getByFieldTypeValue(module.getModuleFieldType());
		return FIELD_CONTAINERS.contains(fieldType);
	}
	
	private void createContainer(WorkProjectModuleDTO module) {
		ModuleComponent container = getNewModuleContainer(module);
		setPositionsPrefixes(container);
		this.allModules.add(container);
	}

	private void createItem(WorkProjectModuleDTO module) {
		ModuleComponent item = getNewModuleItem(module);
		setPositionsPrefixes(item);
		this.allModules.add(item);
		
	}
	
	private void setPositionsPrefixes(ModuleComponent container) {
		container.setPosition(parentPosition++);
		container.setPositionPrefix(getPositionPrefix(container));
	}
	
	private String getPositionPrefix(ModuleComponent component) {
		if(Objects.isNull(parent)) {
			return String.valueOf(component.getPosition());
		}
		return parent.getPositionPrefix() + "." + String.valueOf(component.getPosition());
	}

	private ModuleContainer getNewModuleContainer(WorkProjectModuleDTO module) {
		return new ModuleContainer(module);
	}
	
	private ModuleItem getNewModuleItem(WorkProjectModuleDTO module) {
		return new ModuleItem(module);
	}

	
}
