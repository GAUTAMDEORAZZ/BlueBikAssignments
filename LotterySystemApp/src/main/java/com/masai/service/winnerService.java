package com.masai.service;

import java.util.Set;

public interface winnerService {
  
	public void storeLotteryId(Set<Integer> lotteryids);
	public boolean checkNumber(Integer num);
}
