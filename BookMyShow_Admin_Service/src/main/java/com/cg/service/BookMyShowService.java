package com.cg.service;

import java.util.List;

import com.cg.exception.MovieAlreadyExistsException;
import com.cg.model.BookMyShowAdmin;

public interface BookMyShowService {
	
	public BookMyShowAdmin addShow(BookMyShowAdmin ad) throws MovieAlreadyExistsException;
	public List<BookMyShowAdmin> getAllShow();
	public void deleteShowBydeptno(int adminId);
	public BookMyShowAdmin updateShow(BookMyShowAdmin ud);
	
}