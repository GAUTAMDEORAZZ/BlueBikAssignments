package com.masai.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Lottery {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lottery_id;

	public Integer getLottery_id() {
		return lottery_id;
	}

	public void setLottery_id(Integer lottery_id) {
		this.lottery_id = lottery_id;
	}

	public Lottery(Integer lottery_id) {
		super();
		this.lottery_id = lottery_id;
	}
	
	

}
