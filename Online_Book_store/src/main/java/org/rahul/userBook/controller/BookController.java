package org.rahul.userBook.controller;


import java.util.List;
import java.util.Scanner;

import org.rahul.userBook.dao.BookDao;
import org.rahul.userBook.dto.Book;

public class BookController {
	public static void main(String[] args) {
		BookDao bookDao=new BookDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.save Books");
		System.out.println("2.update Books");
		System.out.println("3.find Book By User Id:");
		
		
		
		switch (sc.nextInt()) {
		case 1:
		{
			Book book=new Book();
			
			System.out.println("Enter Book title:");
			book.setTitle(sc.next());
			
			System.out.println("Enter the Author name:");
			book.setAuthor(sc.nextLine());
			book.setAuthor(sc.next());
			
			System.out.println("Enter the price");
			book.setPrice(sc.nextInt());
			
			System.out.println("Enter the Quantity");
			book.setQuantity(sc.nextInt());
			
			System.out.println("Enter the date");
			book.setDate(sc.next());
//			book = bookDao.saveBook(book, user_id);
//			
			System.out.println("Enter user_id:");
            int user_id = sc.nextInt();
             book = bookDao.saveBook(book, user_id);
             if (book != null) {
                 System.out.println("Book saved successfully!");
             } else {
                 System.out.println("Failed to save book.");
             }
			break;
			
		}
		case 2:
		{
			Book book=new Book();
			System.out.println("Enter the book_id:");
			book.setBook_id(sc.nextInt());
			System.out.println("Enter the book title:");
			book.setTitle(sc.next());
			System.out.println("Enter the Author name;");
			book.setAuthor(sc.next());
			System.out.println("Enter the price:");
			book.setPrice(sc.nextInt());
			System.out.println("Enter the Quantity:");
			book.setQuantity(sc.nextInt());
			System.out.println("Enter the date");
			book.setDate(sc.next());
			book = bookDao.updateBook(book);
			break;
			
		}
		case 3:
		{
			System.out.println("enter user id to find books");
			int user_id=sc.nextInt();
			List<Book> book=bookDao.findBookByUserId(user_id);
			if(book.isEmpty())
			{
				
			}
			else
			{
				for(Book b:book)
				{
					System.out.println(b);
				}
			}
			break;
		}
			

		default:
			break;
		}
	}

}