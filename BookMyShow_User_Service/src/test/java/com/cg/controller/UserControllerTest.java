package com.cg.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.model.Users;
import com.cg.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mocMvc;



	@Mock
	private UserService Us;
	private Users u;
	private List<Users> Userlist;
	@InjectMocks
	private UserController Uc;
	@BeforeEach
	public void setUp() {
	u = new Users(254,"satyam","satyam@gmail.com","RRR2");
	mocMvc= MockMvcBuilders.standaloneSetup(Uc).build();
	}
	@Test
	public void UserControllerTest() throws Exception{
	when(Us.addUser(any())).thenReturn(u);
	mocMvc.perform(post("/api/v1/add")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJSONString(u)))
	.andExpect(status().isCreated());
	verify(Us,times(1)).addUser(any());

	}

	@Test
	public void getAllUsersControllerTest() throws Exception {
	when(Us.getAllUser()).thenReturn(Userlist);
	mocMvc.perform(MockMvcRequestBuilders.get("/api/v1/getall")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJSONString(u)))
	.andDo(MockMvcResultHandlers.print());
	verify(Us,times(1)).getAllUser();

	}

	public static String asJSONString(final Object obj) {
	// TODO Auto-generated method stub
	try {

	return new ObjectMapper().writeValueAsString(obj);
	} catch (Exception e) {
	throw new RuntimeException(e);
	}
	}


}
