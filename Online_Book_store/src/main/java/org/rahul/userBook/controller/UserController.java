package org.rahul.userBook.controller;

import java.util.Scanner;

import org.rahul.userBook.dao.UserDao;
import org.rahul.userBook.dto.User;

public class UserController {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Save User");
		System.out.println("2.Update User");
		System.out.println("3.Find  User By Id");
		System.out.println("4.verify User By phone and password ");
		System.out.println("1.verify User By email and password ");

		switch (sc.nextInt()) {
		case 1: {
			User user = new User();
			System.out.println("Enter User Name:");
			user.setUsername(sc.next());
			System.out.println("Enter Email: ");
			user.setEmail(sc.next());
			System.out.println("Enter the Phone number:");
			user.setPhone(sc.nextLong());
			System.out.println("Enter the Password:");
			user.setPassword(sc.next());
			System.out.println("enter the Address");
			user.setAddress(sc.next());
			user = dao.saveUser(user);
			System.out.println("User saved with id:" + user.getUser_id());
			break;
		}

		case 2: {
			User user = new User();
			System.out.println("Enter User_id:");
			user.setUser_id(sc.nextInt());
			System.out.println("Enter User name:");
			user.setUsername(sc.next());
			System.out.println("Enter Email:");
			user.setEmail(sc.next());
			System.out.println("Enter phone number:");
			user.setPhone(sc.nextLong());
			System.out.println("Enter password:");
			user.setPassword(sc.next());

			user = dao.updateUser(user);
			System.out.println("User updated with id:" + user.getUser_id());
			break;
		}

		case 3: {
			System.out.println("Enter User Id:");
			int user_id = sc.nextInt();
			User user = dao.FindUserById(user_id);
			System.out.println(user);
			break;
		}

		case 4: {
			System.out.println("Enter email:");
			String email = sc.next();
			System.out.println("Enter password:");
			String password = sc.next();
			User user = dao.VerifyuserByemail(email, password);
			System.out.println(user);
			break;
		}

		case 5: {
			System.out.println("Enter phone number:");
			Long phone = sc.nextLong();
			System.out.println("Enter password");
			String password = sc.next();
			User user = dao.VerifyuserByPhone(phone, password);
			System.out.println(user);
			break;
		}

		default:
			break;
		}

	}

}
