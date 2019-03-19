/**
 * 
 */
package com.ofs.training.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofs.training.model.User;
import com.ofs.training.resource.HibernateUtil;

/**
 * @author kamalesh.murali
 * @since Mar 18, 2019
 */
@Repository
public class UserDaoImpl implements UserDao {

    /* (non-Javadoc)
     * @see com.ofs.training.dao.UserDao#getUser()
     */
    @Override
    public User getUser(long id) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        System.out.println(session);
//        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = (User)session.load(User.class, new Long(id));
        session.getTransaction().commit();
        return user;
    }

    
}
