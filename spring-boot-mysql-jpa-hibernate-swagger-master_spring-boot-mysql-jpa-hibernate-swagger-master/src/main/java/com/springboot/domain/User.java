package com.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



import lombok.Data;
import java.util.Date;

@Data
public class User {
	


	    
		private long id;
	    private String email;
	    private String name;

	  


  

} // class User
