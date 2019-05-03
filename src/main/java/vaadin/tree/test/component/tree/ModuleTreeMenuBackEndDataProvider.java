package vaadin.tree.test.component.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.vaadin.data.provider.AbstractBackEndHierarchicalDataProvider;
import com.vaadin.data.provider.HierarchicalQuery;

import vaadin.tree.test.component.HierarchichalTreeBuilder;
import vaadin.tree.test.component.ModuleComponent;
import vaadin.tree.test.component.ModuleContainer;
import vaadin.tree.test.component.ModuleItem;
import vaadin.tree.test.dto.WorkProjectModuleDTO;
import vaadin.tree.test.dto.WorkProjectModuleMapper;
import vaadin.tree.test.jpa.DataProvider;
import vaadin.tree.test.jpa.WorkProjectModule;

public class ModuleTreeMenuBackEndDataProvider extends AbstractBackEndHierarchicalDataProvider<ModuleComponent, Void> {

	private static final long serialVersionUID = 7524274774654910363L;


	@Override
	public boolean hasChildren(ModuleComponent item) {
		
		return getChildCount(new HierarchicalQuery<>(null, item)) > 0;		
	}

	private Collection<WorkProjectModuleDTO> doFetch(ModuleComponent parent) {
		
		List<WorkProjectModule> modules = new ArrayList<>();
		if(parent instanceof ModuleItem) {
			return new ArrayList<>();
		} else if (parent instanceof ModuleContainer) {
			modules = DataProvider.getInstance().getModulesOf(((ModuleContainer) parent).getModule().getIdModule());
		} else {
			modules = DataProvider.getInstance().getParentModules();
		}			
				
		return WorkProjectModuleMapper.INSTANCE.getCollectionDtoFromEntities(modules);
	}
		

	@Override
	public boolean isInMemory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getChildCount(HierarchicalQuery<ModuleComponent, Void> query) {
		ModuleComponent parent = query.getParent();
		Collection<WorkProjectModuleDTO> allProjectWorkModules = doFetch(parent);
		return Objects.isNull(allProjectWorkModules) ? 0 : allProjectWorkModules.size();
	}

	@Override
	protected Stream<ModuleComponent> fetchChildrenFromBackEnd(HierarchicalQuery<ModuleComponent, Void> query) {
		
		ModuleComponent parent = query.getParent();
		
		Collection<WorkProjectModuleDTO> allProjectWorkModules = doFetch(parent);
		
		if(allProjectWorkModules != null && allProjectWorkModules.isEmpty()) {
			return Stream.empty();
		}
		
		ModuleContainer moduleContainer = HierarchichalTreeBuilder.getTreeItems(parent, allProjectWorkModules);
		return moduleContainer.getModuleComponents().stream();
	}

	
	
	




}
