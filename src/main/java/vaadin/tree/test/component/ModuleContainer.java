/**
 * 
 */
package  vaadin.tree.test.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import lombok.Getter;
import vaadin.tree.test.dto.WorkProjectModuleDTO;

/**
 * This is a module container. If a module is parent, contains a list of modules
 * @author ALBOKA SOFT (deusto16)
 *
 */
public class ModuleContainer extends ModuleComponent{


	@Getter List<ModuleComponent> moduleComponents = new ArrayList<ModuleComponent>();
	@Getter WorkProjectModuleDTO module;

	
	public ModuleContainer() {		
	}
	
	public ModuleContainer(WorkProjectModuleDTO module) {
		this.module = module;
	}

	@Override
	public void add(ModuleComponent moduleComponent) {
		moduleComponents.add(moduleComponent);
		
	}

	@Override
	public void remove(ModuleComponent moduleComponent) {
		moduleComponents.remove(moduleComponent);
		
	}
	
	@Override
	public ModuleComponent getChild(int index) {
		return moduleComponents.get(index);
	}

	private boolean isRoot(){
		if(this.module.getParentId().compareTo(new Long(0)) == 0){
			return true;
		}
		return false;
	}

	
	public int getNumberOfChildren() {
		return moduleComponents.size();
	}
	
	

}
