package com.cg.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Admin")
public class BookMyShowAdmin {
//
@Id
private int adminId;
private String adminname;
private String  movie;

//
public BookMyShowAdmin() {
	super();
	// TODO Auto-generated constructor stub
}

//
public BookMyShowAdmin(int adminId, String adminname, String movie) {
	super();
	this.adminId = adminId;
	this.adminname = adminname;
	this.movie = movie;
}

//
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdminname() {
	return adminname;
}
public void setAdminname(String adminname) {
	this.adminname = adminname;
}
public String getmovie() {
	return movie;
}
public void setmovie(String movie) {
	this.movie = movie;
}

//
@Override
public String toString() {
	return "LibraryAdmin [adminId=" + adminId + ", adminname=" + adminname + ", movie=" + movie + "]";
}


}
