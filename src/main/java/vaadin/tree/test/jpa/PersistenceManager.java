package vaadin.tree.test.jpa;


import java.util.function.Consumer;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * @author ALBOKA SOFT (deusto16)
 *
 */
public class PersistenceManager {

	@PersistenceContext
	protected EntityManager entityManager;
	static EntityManagerFactory entityManagerFactory;
	
	final static String PERSISTENCE_UNIT_NAME = "persistence-unit-tree-test";
	
	protected static EntityManagerFactory getEntityManagerFactory(){
		
		if(entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);			
		}
		
		return entityManagerFactory;
	}
				
	
	protected static EntityManager getEntityManager(){
		return getEntityManagerFactory().createEntityManager();
	}
	
	/**
	 * Execute any task that need a transactional operation.
	 * If any error occurs, an exception is thrown and the operation is rolled back
	 * @param action Task with a transaction needed
	 */
	protected void transactional(Consumer<EntityManager> action) {
		entityManager = getEntityManagerFactory().createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			action.accept(entityManager);
			entityManager.getTransaction().commit();

		} catch (RuntimeException e) {
			
			if(entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			throw e;

		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
	
	
	/** 
	 * Unlike the "transactional" method, returns a value
	 * @param function
	 * @return
	 */
	protected <T> T find(Function<EntityManager,T> function) {
		entityManager = getEntityManagerFactory().createEntityManager();
        try{
            entityManager.getTransaction().begin();
            T functionResult = function.apply(entityManager);
            entityManager.getTransaction().commit();
            
            return functionResult;
            
        }catch (RuntimeException e){
            entityManager.getTransaction().rollback();
            throw e;
            
        } finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
    }
    
	
}
