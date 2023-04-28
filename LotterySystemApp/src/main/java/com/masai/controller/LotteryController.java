package com.masai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.winnerService;

@RestController
public class LotteryController {
	private final winnerService winnerService;

    public LotteryController(winnerService winnerService) {
        this.winnerService = winnerService;
    }

    @GetMapping("/check/{num}")
    public String checkNumber(@PathVariable("num") int num) {
        boolean isWinner = winnerService.checkNumber(num);
        if (isWinner) {
            return "Congratulations! Your number is a winner!";
        } else {
            return "Sorry, your number is not a winner.";
        }
    }

}
