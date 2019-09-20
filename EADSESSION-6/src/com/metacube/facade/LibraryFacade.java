package com.metacube.facade;

import java.util.List;

import com.metacube.dao.BaseDao;
import com.metacube.enums.Status;
import com.metacube.factory.Factory;
import com.metacube.model.Book;

public class LibraryFacade {

	private BaseDao baseDao = Factory.createLibraryDao();

	public List<Book> showBookList() {
		String query = "SELECT * FROM BOOK";
		return baseDao.showBookList(query);
	}

	public Book showBookByTitle(String title) {
		String query = "SELECT * FROM BOOK WHERE TITLE = '" + title + "'";
		return baseDao.showBookByTitle(query);
	}

	public Status deleteAllBooks() {
		String query = "TRUNCATE TABLE BOOK";
		return baseDao.deleteAllBooks(query);
	}

	public Status deleteBookById(int id) {
		String query = "DELETE FROM BOOK WHERE id = '" + id + "'";
		return baseDao.deleteBookById(query);
	}

	public Status addBook(String bookTitle, String bookWriter,
			String publisher, int publishedYear) {
		String query = "INSERT INTO BOOK(TITLE,WRITER,PUBLISHER,PUBLISHED_YEAR) VALUES ('"
				+ bookTitle + "'"  + ", '"
				+ bookWriter + "'"  + ", '"
				+ publisher + "'"  + ", '"
				+ publishedYear + "')";
		return baseDao.addBook(query);
	}

//	public Status updateBook(String title, int publishedYear) {
//		String query = "UPDATE BOOK SET PUBLISHED_YEAR = '" + publishedYear +"' WHERE TITLE = '" + title + "'" ;
//		return baseDao.updateBook(query);
//	}
//	

}
