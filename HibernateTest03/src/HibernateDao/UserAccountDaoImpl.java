package HibernateDao;

import org.hibernate.SessionFactory;

import com.zhou.account.bean.UserAccount;

public class UserAccountDaoImpl extends GenericDAOImpl<UserAccount, Long>{
	public Long add(UserAccount account){
		return super.saveForKey(account);
	}

	public UserAccountDaoImpl(SessionFactory sessionFactory,
			Class<UserAccount> entityClass) {
		super(sessionFactory, entityClass);
		// TODO Auto-generated constructor stub
	}
	
}
