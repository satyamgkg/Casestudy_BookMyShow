package com.cg.controller;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.MovieAlreadyExistsException;
import com.cg.model.BookMyShowAdmin;
    import com.cg.service.BookMyShowService;

	@RestController
	@RequestMapping("/api/v1")
	public class BookMyShowController {		
			private BookMyShowService liserv;
			@Autowired
			public BookMyShowController(BookMyShowService isroserv) {
				super();
				this.liserv =isroserv;
			}
		@PostMapping("/add")
		public ResponseEntity<BookMyShowAdmin>addShowAdmin(@RequestBody BookMyShowAdmin dept) throws MovieAlreadyExistsException{
			BookMyShowAdmin  savedDept = liserv.addShow(dept);
			 return new ResponseEntity<>(savedDept, HttpStatus.CREATED);
		}
		
		@GetMapping("/getall")
		public ResponseEntity<List<BookMyShowAdmin>> getAllShowAdmin(){
	    return new ResponseEntity<List<BookMyShowAdmin>>((List<BookMyShowAdmin>)liserv.getAllShow(),HttpStatus.OK);
		}

	    @DeleteMapping("/delete/{adminId}")
	    public ResponseEntity<Void> deleteShowById(@PathVariable int adminId){
	    liserv.deleteShowBydeptno(adminId);
	    return ResponseEntity.noContent().build();
	    }

	    @PutMapping("/update")
		public BookMyShowAdmin updateShowAdmin(@RequestBody BookMyShowAdmin adminId) {  
		return liserv.updateShow(adminId);
		}

}
