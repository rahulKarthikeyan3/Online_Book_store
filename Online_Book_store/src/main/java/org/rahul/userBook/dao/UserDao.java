package org.rahul.userBook.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.rahul.userBook.dto.User;

public class UserDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

	public User saveUser(User user) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(user);
		transaction.begin();
		transaction.commit();
		return user;
	}

	public User updateUser(User user) {
		EntityTransaction transaction = manager.getTransaction();
		User dbUser = manager.find(User.class, user.getUser_id());
		if (dbUser != null) {
			dbUser.setUsername(user.getUsername());
			dbUser.setEmail(user.getEmail());
			dbUser.setPassword(user.getPassword());
			dbUser.setAddress(user.getAddress());
			dbUser.setPhone(user.getPhone());
			transaction.begin();
			transaction.commit();
		}
		return user;
	}

	public User FindUserById(int User_id) {
		return manager.find(User.class, User_id);
	}

	public User VerifyuserByPhone(long phone, String password) {
		Query q = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	public User VerifyuserByemail(String email, String password) {
		Query q = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}
}
