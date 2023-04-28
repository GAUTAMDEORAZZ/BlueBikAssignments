package com.masai.service;

import java.util.HashSet;
import java.util.Set;

public class CalculationServiceImple implements CalculationService {

	private UpstreamService upstreamService;

    public void CalculatingServiceImpl(UpstreamService upstreamService) {
        this.upstreamService = upstreamService;
    }

	@Override
	public Set<Integer> calculateLotteryIds() {
		 Set<Integer> lotteryIds = upstreamService.getLotteryIds();
	        Set<Integer> winningLotteryIds = new HashSet<>();

	        for (Integer lotteryId : lotteryIds) {
	            // perform some calculation to determine if the lotteryId is a winner
	            if (lotteryId % 2 == 0) {
	                winningLotteryIds.add(lotteryId);
	            }
	        }

	        return winningLotteryIds;
	    }
	}


