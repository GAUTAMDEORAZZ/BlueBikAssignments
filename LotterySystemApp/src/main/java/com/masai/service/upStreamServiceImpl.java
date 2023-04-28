package com.masai.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.masai.model.Lottery;
import com.masai.repository.LotteryRepository;

import lombok.Value;

public class upStreamServiceImpl implements UpstreamService {
   
	@Autowired
	private LotteryRepository lotteryRepo;
	
	@Override
	public Set<Integer> getLotteryIds() {
	  Set<Integer> set=new HashSet<>();
	 List<Lottery> lottries=  lotteryRepo.findAll();
	 for(Lottery lot:lottries) {
		 Integer ids=lot.getLottery_id();
		 set.add(ids);
		 
	 }
	  
	 return set;
		
	}

	
}
