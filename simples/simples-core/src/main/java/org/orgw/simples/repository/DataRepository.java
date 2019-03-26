package org.orgw.simples.repository;

import java.util.Collection;

import javax.persistence.EntityManager;


public interface DataRepository<M> {
	EntityManager getEntityManager();

    M get(Object id);

    void save(M entity);

    void update(M entity);

    void refresh(M entity);
    
    Collection<M> bulkSave(Collection<M> entities);
}
