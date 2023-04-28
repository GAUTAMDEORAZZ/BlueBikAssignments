package com.masai.service;

import java.util.List;

import com.masai.model.Lottery;
import com.masai.repository.LotteryRepository;

public class LotteryServiceImpl implements LotteryService {
	 private final LotteryRepository lotteryRepository;

	    public LotteryServiceImpl(LotteryRepository lotteryRepository) {
	        this.lotteryRepository = lotteryRepository;
	    }

         @Override
	    public void saveLottery(Lottery lottery) {
	        lotteryRepository.save(lottery);
	    }

	   
         @Override
	    public List<Lottery> findAllLotteries() {
	        return lotteryRepository.findAll();
	    }
}
