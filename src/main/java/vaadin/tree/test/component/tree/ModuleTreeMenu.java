package vaadin.tree.test.component.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;


import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import vaadin.tree.test.component.ModuleComponent;
import vaadin.tree.test.component.ModuleContainer;
import vaadin.tree.test.component.ModuleItem;
import vaadin.tree.test.dto.WorkProjectModuleDTO;

public class ModuleTreeMenu extends Tree<ModuleComponent>{

	static final String SPACE = " ";

	private static final long serialVersionUID = 634732681970531886L;

	public static final String MODULE_TREE_MENU_ID = "ModuleTreemenu";
	
	ModuleComponent moduleComponent = null;
	
	
	@Getter ModuleTreeMenuBackEndDataProvider moduleTreeMenuBackEndDataProvider;
	
	
//	ModuleTreeMenuDataProvider dataProvider = new ModuleTreeMenuDataProvider();
	
	@Getter ModuleContainer modulesConfiguration;
	@Getter ModuleComponent firstItem = null;
	
	Collection<WorkProjectModuleDTO> menuItems = new ArrayList<>();
	
	final String ITEM_DESCRIPTION_FORMAT = "%s %s";
	
	
	@Setter private UI currentViewUI;
	@Getter String filterText = "";
	
	private Long idProject;
	
	public ModuleTreeMenu() {
		super();		
		moduleTreeMenuBackEndDataProvider = new ModuleTreeMenuBackEndDataProvider();
		setId(MODULE_TREE_MENU_ID);
		initTree();
		
	}
	
	
	public void updateTree() {
		moduleTreeMenuBackEndDataProvider.refreshAll();
		
	}
	
	private void initTree() {
		setSizeFull();
		this.setDataProvider(moduleTreeMenuBackEndDataProvider);
		buildTreeItemCaption();
		
	}
	
	private void buildTreeItemCaption() {
		this.setItemDescriptionGenerator(item -> {
			return getItemCaption(item);
		});
		
		this.setItemCaptionGenerator(item -> {
			return getItemCaption(item);
		});
		
	}
	
	private String getItemCaption(ModuleComponent item) {
		String description = "";
		if(item instanceof ModuleItem) {
			description = ((ModuleItem)item).getModuleItem().getDescription();
		} else {
			description = ((ModuleContainer)item).getModule().getDescription();
		}
		return String.format(ITEM_DESCRIPTION_FORMAT, item.getPositionPrefix(), description);
	}

	

	
}
