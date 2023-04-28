package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Lottery;
import com.masai.repository.LotteryRepository;

@Service
public class winnerServiceImpl implements winnerService{
    
	@Autowired
	private LotteryRepository lotteryRepository;
	
	
	@Override
	public void storeLotteryId(Set<Integer> lotteryids) {
		List<Lottery> lotteries = new ArrayList<>();
        for (Integer lotteryId : lotteryids) {
            Lottery lottery = new Lottery(lotteryId);
            lotteries.add(lottery);
        }
        lotteryRepository.saveAll(lotteries);
	}

	@Override
	public boolean checkNumber(Integer num) {
		 Optional<Lottery> lottery = lotteryRepository.findById(num);
	        return lottery.isPresent();
	}

}
