package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class Users {
	
//
	@Id
	private int userid;
	private String username;
	private String useremail;
	private String movie;
	
	//
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//
	public Users(int userid, String username, String useremail, String movie) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.movie = movie;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
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
		return "LibraryUser [Userid=" + userid + ", Username=" + username + ", Useremail=" + useremail + ", movie="
				+ movie + "]";
	}

}
