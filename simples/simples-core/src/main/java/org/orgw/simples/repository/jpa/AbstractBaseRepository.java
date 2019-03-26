package org.orgw.simples.repository.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import org.orgw.simples.repository.DataRepository;
import org.orgw.simples.repository.model.EmailDetails;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Repository
public abstract class AbstractBaseRepository<M> implements DataRepository<M> {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Value("${hibernate.jdbc.batch_size}")
    private int batchSize;

    @PersistenceContext(unitName = "entityManagerFactory")
    protected EntityManager entityManager;    

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }    

    @Override
    public M get(final Object id) {
        return entityManager.find(getParameterizedType(), id);
    }

    @SuppressWarnings("unchecked")
    private Class<M> getParameterizedType() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass()
                .getGenericSuperclass();
        return (Class<M>) parameterizedType.getActualTypeArguments()[0];
    }

    

    public  Collection<M> bulkSave(Collection<M> entities) {
      final List<M> savedEntities = new ArrayList<M>(entities.size());
      int i = 0;
      int insertCount=0;
      for (M m : entities) {
        savedEntities.add(persist(m,insertCount));
        //i++;
        //if (i % batchSize == 0 && insertCount > 0) {
          // Flush a batch of inserts and release memory.
          entityManager.flush();
          entityManager.clear();
        //}
      }
      return savedEntities;
    }
    
    private M persist(M m,Integer count) {
    	  /*if (m.getId() == null) {
    	    entityManager.persist(m);
    	    return m;
    	  } else {
    	    return entityManager.merge(m);
    	  }*/
    	try{
    		entityManager.persist(m);
    		count++;
    	}catch(Exception e){
    		LOG.debug(" persist::: Exception",e);
    	}
    	return m;
    }
    
    @Override
    public void save(M entity) {
        this.entityManager.persist(entity);
    }

    @Override
    public void update(M entity) {
        this.entityManager.merge(entity);
    }

    @Override
    public void refresh(M entity) {
        this.entityManager.refresh(entity);
    }

    protected Integer calcOffset(Integer pageNo, Integer limit) {
        return (pageNo - 1) * limit;
    }

	public EmailDetails getleaverequestdetails(String employeid) {
		// TODO Auto-generated method stub
		return null;
	}
}
