/**
 * 
 */
package  vaadin.tree.test.component;

import java.util.Objects;

import vaadin.tree.test.dto.WorkProjectModuleDTO;


/**
 * A module. It contains a {@link WorkProjectModuleDTO}
 * @author ALBOKA SOFT (deusto16)
 *
 */
public class ModuleItem extends ModuleComponent{

	
	WorkProjectModuleDTO moduleItem;
	
	protected ModuleItem() {
		throw new AssertionError("You can't instanciate this object with this constructor !!!");
	}
	
	public ModuleItem(WorkProjectModuleDTO moduleItem) {
		this.moduleItem = moduleItem;
	}
	
	public WorkProjectModuleDTO getModuleItem() {
		return moduleItem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(moduleItem.getIdModule(), moduleItem.getIdProject());
	}

	@Override
	public boolean equals(Object other) {
		
		if(Objects.isNull(other)) {
			return false;
		}
		
		if(!other.getClass().isAssignableFrom(ModuleItem.class)) {
			return false;
		}
		
		ModuleItem moduleItem = (ModuleItem)other;
		
		return this.moduleItem.isSameItemAs(moduleItem.getModuleItem());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.moduleItem.toString();
	}
	
	
	
}
