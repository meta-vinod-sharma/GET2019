package com.metacube.factory;

import java.sql.SQLException;

import com.metacube.dao.LibraryDao;
import com.metacube.facade.LibraryFacade;

public class Factory {
	
	public static LibraryFacade createLibraryFacade() {
		return new LibraryFacade();
	}

	public static LibraryDao createLibraryDao() {
		try {
			return new LibraryDao();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			return null;
		}
	}
}
