package com.masai.service;

import com.masai.ExceptionHandler.AccountException;
import com.masai.ExceptionHandler.UserException;
import com.masai.model.Account;
import com.masai.model.User;

public interface UserAccountService {
	
	public User createUser(User user,Integer account_id)throws AccountException;
	
	public Account createAccountForUser(Account account)throws UserException,AccountException;
	public String  creditBalance(Integer user_id,Long amount)throws UserException, AccountException;
	public String  debitBalance(Integer user_id, Long amount)throws UserException,AccountException;
}
