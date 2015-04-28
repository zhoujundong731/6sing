package com.zhou.dao;
 
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
 

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.jdbc.ConnectionManager.Callback;
import org.hibernate.transform.ResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;
/*import org.springside.modules.utils.BeanUtils;
import org.springside.modules.orm.hibernate.Page;
import org.springside.modules.orm.hibernate.QueryParameter;*/
 
/**
 * HibernateOf the base class .
 * <p>
 * You can create a service class directly using the .Or it may inherit the DAO subclass 
 * </p>
 * Modified from Springside SimpleHibernateTemplate 
 * 
 * @param <T>
 *            DAOThe object type 
 * @param <PK>
 *            Primary key type 
 * 
 * 
 */
@SuppressWarnings("unchecked")
public class GenericDAOImpl<T, PK extends Serializable> extends
        HibernateDaoSupport implements IGenericDAO<T, PK> {
 
    protected Logger logger = LoggerFactory.getLogger(getClass());
 
    protected SessionFactory sessionFactory;
 
    protected Session session;
 
    protected Class<?> entityClass;
         
    public GenericDAOImpl() {
        this.entityClass = (Class<?>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
 
    public GenericDAOImpl(SessionFactory sessionFactory, Class<T> entityClass) {     
        super.setSessionFactory(sessionFactory);
        this.entityClass = entityClass;
    }
 
    public void save(T entity) {
        Assert.notNull(entity);
        super.getHibernateTemplate().saveOrUpdate(entity);
        logger.info("save entity: {}", entity);
    }
    public PK saveForKey(T entity){
    	Assert.notNull(entity);
    	return (PK) super.getHibernateTemplate().save(entity);
    }
 
    public void delete(T entity) {
        Assert.notNull(entity);
        super.getHibernateTemplate().delete(entity);
        logger.info("delete entity: {}", entity);
    }
 
    public void delete(PK id) {
        Assert.notNull(id);
        delete(get(id));
    }
 
    public List<T> findAll() {
        return findByCriteria();
    }
 
/*    public Page<T> findAll(Page<T> page) {
        return findByCriteria(page);
    }*/
 
    public T get(final PK id) {
        if(super.getHibernateTemplate() == null){
            System.out.println("asdfasdf");
        }
        return (T) super.getHibernateTemplate().get(entityClass, id);
    }
 
    public List find(String hql, Object... values) {
        return createQuery(hql, values).list();
    }
 
/*    public Page<T> find(Page<T> page, String hql, Object... values) {
        Assert.notNull(page);
 
        if (page.isAutoCount()) {
            logger.warn("HQLQueries are not supported automatically gets the total number of results ,hqlAs {}", hql);
        }
        Query q = createQuery(hql, values);
        if (page.isFirstSetted()) {
            q.setFirstResult(page.getFirst());
        }
        if (page.isPageSizeSetted()) {
            q.setMaxResults(page.getPageSize());
        }
        page.setResult(q.list());
        return page;
    }*/
 
    /**
     * Press the HQL query only object .
     */
    public Object findUnique(String hql, Object... values) {
        return createQuery(hql, values).uniqueResult();
    }
 
    public Integer findInt(String hql, Object... values) {
        return (Integer) findUnique(hql, values);
    }
 
    public Long findLong(String hql, Object... values) {
        return (Long) findUnique(hql, values);
    }
 
    public List<T> findByCriteria(Criterion... criterion) {
        return createCriteria(criterion).list();
    }
 
/*    public Page<T> findByCriteria(Page page, Criterion... criterion) {
        Assert.notNull(page);
 
        Criteria c = createCriteria(criterion);
 
        if (page.isAutoCount()) {
            page.setTotalCount(countQueryResult(page, c));
        }
        if (page.isFirstSetted()) {
            c.setFirstResult(page.getFirst());
        }
        if (page.isPageSizeSetted()) {
            c.setMaxResults(page.getPageSize());
        }
 
        if (page.isOrderBySetted()) {
            if (page.getOrder().endsWith(QueryParameter.ASC)) {
                c.addOrder(Order.asc(page.getOrderBy()));
            } else {
                c.addOrder(Order.desc(page.getOrderBy()));
            }
        }
        page.setResult(c.list());
        return page;
    }*/
 
    /**
     * Find a list of objects by property .
     */
    public List<T> findByProperty(String propertyName, Object value) {
        Assert.hasText(propertyName);
        return createCriteria(Restrictions.eq(propertyName, value)).list();
    }
 
    public T findUniqueByProperty(String propertyName, Object value) {
        Assert.hasText(propertyName);
        return (T) createCriteria(Restrictions.eq(propertyName, value))
                .uniqueResult();
    }
 
    public Query createQuery(String queryString, Object... values) {
         Assert.hasText(queryString);
         super.getSession().createQuery(queryString);
        Query queryObject = super.getSession().createQuery(queryString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                queryObject.setParameter(i, values[i]);
            }
        }
        return queryObject;
    }
 
     
    public Criteria createCriteria(Criterion... criterions) {
        Criteria criteria = super.getSession().createCriteria(entityClass);
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria;
    }
 
     
    public boolean isPropertyUnique(String propertyName, Object newValue,
            Object orgValue) {
        if (newValue == null || newValue.equals(orgValue))
            return true;
 
        Object object = findUniqueByProperty(propertyName, newValue);
        return (object == null);
    }
 
   /* public int countQueryResult(Page<T> page, Criteria c) {
        CriteriaImpl impl = (CriteriaImpl) c;
 
        // First Projection, ResultTransformer, OrderBy out ,Empty after a three Count operations 
        Projection projection = impl.getProjection();
        ResultTransformer transformer = impl.getResultTransformer();
 
        List<CriteriaImpl.OrderEntry> orderEntries = null;
        try {
            orderEntries = (List) BeanUtils.getFieldValue(impl, "orderEntries");
            BeanUtils.setFieldValue(impl, "orderEntries", new ArrayList());
        } catch (Exception e) {
            logger.error("Not may throw an exception :{}", e.getMessage());
        }
 
        // Do Count query 
        int totalCount = (Integer) c.setProjection(Projections.rowCount())
                .uniqueResult();
        if (totalCount < 1)
            return -1;
 
        // Will the Projection and OrderBy before conditions back to go back 
        c.setProjection(projection);
 
        if (projection == null) {
            c.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        }
        if (transformer != null) {
            c.setResultTransformer(transformer);
        }
 
        try {
            BeanUtils.setFieldValue(impl, "orderEntries", orderEntries);
        } catch (Exception e) {
            logger.error("Not may throw an exception :{}", e.getMessage());
        }
 
        return totalCount;
    }*/
 
}