/**
 * 
 */
package com.ofs.training.dao;

import java.util.ArrayList;
import java.util.List;

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

    /* (non-Javadoc)
     * @see com.ofs.training.dao.UserDao#create()
     */
    @Override
    public User create(User user) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        System.out.println(session);
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }

    /* (non-Javadoc)
     * @see com.ofs.training.dao.UserDao#delete(long)
     */
    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User fetchedUser = session.load(User.class, new Long(id));
        if (fetchedUser != null) {
            session.delete(fetchedUser);
        }
        session.getTransaction().commit();
    }

    /* (non-Javadoc)
     * @see com.ofs.training.dao.UserDao#update(com.ofs.training.model.User)
     */
    @Override
    public User update(User user) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        Session anotherSession = HibernateUtil.getSessionFactory().getCurrentSession();
        anotherSession.beginTransaction();
        User updatedUser = anotherSession.load(User.class, new Long(user.getId()));
        anotherSession.getTransaction().commit();
        return updatedUser;
    }

    /* (non-Javadoc)
     * @see com.ofs.training.dao.UserDao#readAll()
     */
    @Override
    public List<User> readAll() {
        // TODO Auto-generated method stub
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        session.getTransaction().commit();
        return users;
    }
    
    


}
