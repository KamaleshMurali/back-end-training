/**
 * 
 */
package com.ofs.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofs.training.model.User;

/**
 * @author kamalesh.murali
 * @since Mar 18, 2019
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public User getUser(long id) {

        Session session = sessionFactory.getCurrentSession();
        if (session.isConnected()) {
            System.out.println("connection established...");
        }
        System.out.println(session);
//        session.beginTransaction();
        User user = (User)session.load(User.class, new Long(id));
//        session.getTransaction().commit();
        return user;
    }

    @Override
    public User create(User user) {

//        session.beginTransaction();
        sessionFactory.getCurrentSession().save(user);
//        session.getTransaction().commit();
        return user;
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        User fetchedUser = session.load(User.class, new Long(id));
//        if (fetchedUser != null) {
//            session.delete(fetchedUser);
//        }
//        session.getTransaction().commit();
    }

    @Override
    public User update(User user) {

//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.update(user);
//        session.getTransaction().commit();
//        Session anotherSession = HibernateUtil.getSessionFactory().getCurrentSession();
//        anotherSession.beginTransaction();
//        User updatedUser = anotherSession.load(User.class, new Long(user.getId()));
//        anotherSession.getTransaction().commit();
//        return updatedUser;
        return null;
    }

    @Override
    public List<User> readAll() {

//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        List<User> users = session.createQuery("from User").list();
//        session.getTransaction().commit();
//        return users;
        return null;
    }
}
