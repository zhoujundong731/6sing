package HibernateSessionDao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import HibernateDao.IGenericDAO;

public abstract  class GenMyDao<T,PK extends Serializable> implements IGenericDAO<T,PK>{
	protected abstract Session getSession();

	@Override
	public void save(T entity) {
		
		
	}

	@Override
	public PK saveForKey(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PK id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List find(String hql, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findUnique(String hql, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findInt(String hql, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findLong(String hql, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByCriteria(Criterion... criterion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findUniqueByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query createQuery(String queryString, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criteria createCriteria(Criterion... criterions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPropertyUnique(String propertyName, Object newValue,
			Object orgValue) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
