package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.masai.model.Lottery;

@Service
public interface LotteryRepository extends JpaRepository<Lottery, Integer> {

}
