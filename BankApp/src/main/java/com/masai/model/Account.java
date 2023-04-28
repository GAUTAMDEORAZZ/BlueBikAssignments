package com.masai.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer account_id;

	private Long  balance;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="account" )
	private Set<User> users=new HashSet<>();
}
