package com.zhou.dao;
 
import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;

import com.zhou.vo.PageBean;
 
 
/**
 * 
 * @version 2009-1-10
 * @author lzpeng
 * 
 */
public interface IGenericDAO<T, PK extends Serializable> {
	
    /**
     * 增加
     * @param entity
     */
    public void save(T entity);
    public void save2(T entity);
    /**
     * 返回Id的添加
     * @param entity
     * @return ID
     */
    public PK saveForKey(T entity);
    
    /**
     * 修改
     * @param entity
     */
    public void update(T entity);
 
    /**
     * 删除
     * @param entity
     */
    public void delete(T entity);
 
    /**
     * 删除
     * @param id
     */
    public void delete(PK id);
 
    /**
     * 查询所有
     * @return list
     */
    public List<T> findAll();
    public List<T> findAllByHql();
 
    /**
     * 分页查询所有
     * @param page
     * @return pageBean
     */
    public PageBean findAll(PageBean page);
 
    /**
     * Gets the object by ID .
     */
    public T get(final PK id);
 
    /**
     * Press the HQL Query object list .
     * 
     * @param hql
     *            hqlStatement 
     * @param values
     *            Number of variable parameters 
     */
    public List find(String hql, Object... values);
 
    /**
     * Press the HQL query paging . No support for automatically gets the total number of results ,User further execution of the query .
     * 
     * @param page
     *            Paging parameters .Including the pageSize and firstResult .
     * @param hql
     *            hqlStatement .
     * @param values
     *            Number of variable parameters .
     * 
     * @return Paging query results ,Comes with a results list and all query parameters .
     */
    public PageBean find(PageBean page, String hql, Object... values);
 
    /**
     * Press the HQL query only object .
     */
    public Object findUnique(String hql, Object... values);
 
    /**
     * Press the HQL query results Intger class shape .
     */
    public Integer findInt(String hql, Object... values);
 
    /**
     * According to the results of the HQL Query type long .
     */
    public Long findLong(String hql, Object... values);
 
    /**
     * According to the Criterion query object list .
     * 
     * @param criterion
     *            Number of variable Criterion .
     */
    public List<T> findByCriteria(Criterion... criterion);
 
    /**
     * According to the Criterion paging query .
     * 
     * @param page
     *            Paging parameters .Including the pageSize, firstResult, orderBy, asc, autoCount .
     *            Where firstResult can be directly specified ,You can also specify pageNo . autoCountSpecifies whether dynamic gets total number of results .
     * 
     * @param criterion
     *            Number of variable Criterion .
     * @return Paging query results .Comes with a results list and all query parameters .
     */
    //public Page<T> findByCriteria(Page page, Criterion... criterion);
 
    /**
     * Find a list of objects by property .
     */
    public List<T> findByProperty(String propertyName, Object value);
 
    /**
     * Find unique object by property .
     */
    public T findUniqueByProperty(String propertyName, Object value);
 
    /**
     * Depending on the query function and argument list to create a Query object ,Subsequent to processing ,The auxiliary function .
     */
    public Query createQuery(String queryString, Object... values);
 
    /**
     * According to the Criterion conditions create Criteria ,Subsequent to processing ,The auxiliary function .
     */
    public Criteria createCriteria(Criterion... criterions);
 
    /**
     * Determine the object's property value is unique within the database .
     * 
     */
    public boolean isPropertyUnique(String propertyName, Object newValue,
            Object orgValue);
 
    /**
     * Through this query count query to obtain the total number of objects .
     * 
     * @return pageThe totalCount property in the object is assigned .
     */
    //public int countQueryResult(Page<T> page, Criteria c);
}