package com.cg.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.MovieAlreadyExistsException;
import com.cg.model.BookMyShowAdmin;
import com.cg.repository.BookMyShowRepository;
@Service
public class BookMyShowServiceImpl implements BookMyShowService{

private BookMyShowRepository movieRepo;
    @Autowired
	public BookMyShowServiceImpl(BookMyShowRepository movieRepo) {
	super();
	this.movieRepo = movieRepo;
    }
	
	@Override
	public BookMyShowAdmin addShow(BookMyShowAdmin ad) throws MovieAlreadyExistsException {
		if(movieRepo.existsById(ad.getAdminId())) {
			throw new MovieAlreadyExistsException();
			}
	   BookMyShowAdmin saveli= movieRepo.save(ad);
		return saveli;
	}

	@Override
	public List<BookMyShowAdmin> getAllShow() {
		return (List<BookMyShowAdmin>) movieRepo.findAll();
	}

	@Override
	public void deleteShowBydeptno(int adminId) {
		movieRepo.deleteById(adminId);	
	}

	@Override
	public BookMyShowAdmin updateShow(BookMyShowAdmin ud) {
		BookMyShowAdmin record;
		Optional<BookMyShowAdmin> opt= movieRepo.findById(ud.getAdminId());
		if(opt.isPresent()) {
		record=opt.get();
		record.setAdminname(ud.getAdminname());
		record.setmovie(ud.getmovie());
		movieRepo.save(record);
		}else {
		return new BookMyShowAdmin();
		}
		return record;
	}

	
}
