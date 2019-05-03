package vaadin.tree.test.jpa;

import java.util.List;

public class DataProvider extends PersistenceManager {

	static DataProvider INSTANCE = new DataProvider();
	
	private DataProvider() {}
	
	public static DataProvider getInstance() {
		return INSTANCE;
	}
	
	public List<WorkProjectModule> getModules() {
		String fromTable = String.format("SELECT t FROM %s t where t.pk.idProject = 9", WorkProjectModule.class.getSimpleName());
		return find(em -> em.createQuery(fromTable, WorkProjectModule.class).getResultList());	
	}

	public List<WorkProjectModule> getParentModules() {
		String fromTable = String.format("SELECT t FROM %s t where t.pk.idProject = 9 and t.parentId = 0", WorkProjectModule.class.getSimpleName());
		return find(em -> em.createQuery(fromTable, WorkProjectModule.class).getResultList());	
	}
	
	public List<WorkProjectModule> getModulesOf(Long idModule) {
		String fromTable = String.format("SELECT t FROM %s t where t.pk.idProject = 9 and t.parentId = " + idModule, WorkProjectModule.class.getSimpleName());
		return find(em -> em.createQuery(fromTable, WorkProjectModule.class).getResultList());	
	}	
	
}
