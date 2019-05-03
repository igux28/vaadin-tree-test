/**
 * 
 */
package vaadin.tree.test.component;

/**
 * @author ALBOKA SOFT (deusto16)
 *
 */
public enum FieldType {
	TABCONTAINER(1, String.class.getName(), "trust-tab-container-field-type"),
	ACCORDIONCONTAINER(2, String.class.getName(), "trust-accordion-container-field-type");	
	
	private final Integer value;
	private final String className;
	private final String styleClass;
	
	private FieldType(final Integer value, final String className, final String styleClass){
		this.value = value;
		this.className = className;
		this.styleClass = styleClass;
	}
	
	public long getValue() {
		return this.value;
	}

	public String getClassName() {
		return this.className;
	}
	
	public String getStyleClass(){
		return this.styleClass;
	}
    
    public static FieldType getByFieldTypeValue(final Integer value) {
    	FieldType result = null;
        for (FieldType FieldType : values()) {
            if (FieldType.getValue() == value.longValue()) {
                result = FieldType;
                break;
            }
        }
        return result;
    }
    
	
}
