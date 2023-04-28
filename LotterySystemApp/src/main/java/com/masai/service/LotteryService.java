package com.masai.service;

import java.util.List;

import com.masai.model.Lottery;

public interface LotteryService {
	 void saveLottery(Lottery lottery);
	    List<Lottery> findAllLotteries();
}
