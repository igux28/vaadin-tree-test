/**
 * 
 */
package  vaadin.tree.test.component;

/**
 * ModuleComponent provides default implementations for every module object.
 * 
 * Because some of these method only make sense for ModuleField and some only
 * for ModuleContainer, the default implementation is UnsupportedOperationException()
 * 
 * @author ALBOKA SOFT (deusto16)
 *
 */
public abstract class ModuleComponent {
	
	public static Long SUPER_PARENT = new Long(0);
	
	private String positionPrefix = "";
	private int position = 0;
	
	
	public ModuleComponent getParent(Long id){
		throw new UnsupportedOperationException();
	}
	
	public void add(ModuleComponent moduleComponent){
		throw new UnsupportedOperationException();
	}
	
	public void remove(ModuleComponent moduleComponent){
		throw new UnsupportedOperationException();
	}
	
	public ModuleComponent getChild(int index){
		throw new UnsupportedOperationException();
	}
	
	public void setPositionPrefix(String positionPrefix) {
		this.positionPrefix = positionPrefix;
	}
	
	public String getPositionPrefix() {
		return this.positionPrefix;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
