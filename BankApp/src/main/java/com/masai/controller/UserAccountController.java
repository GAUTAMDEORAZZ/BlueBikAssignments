package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.ExceptionHandler.AccountException;
import com.masai.ExceptionHandler.UserException;
import com.masai.model.Account;
import com.masai.model.User;
import com.masai.service.UserAccountService;

@RestController
public class UserAccountController {
	
	@Autowired
	private UserAccountService userService;
	
	@PostMapping("/users/{account_id}")
	public ResponseEntity<User> createUserHandler(@RequestBody User user,@PathVariable("account_id") Integer account_id)throws AccountException{
		User saveUser=userService.createUser(user, account_id);
       return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}
	
	@PostMapping("/accounts")
	public ResponseEntity<Account> createAccountHandler( @RequestBody Account account)throws UserException, AccountException{
		Account saveAccount=userService.createAccountForUser(account);
		 return new ResponseEntity<Account>(saveAccount, HttpStatus.CREATED);
	}
	
	@PatchMapping("/accounts/credit/{user_id}/{amount}")
	public ResponseEntity<String> creditBalanceHandler(@PathVariable("user_id") Integer user_id, @PathVariable("amount")  Long amount)throws UserException, AccountException{
		String resultString=userService.creditBalance(user_id, amount);
		 return new ResponseEntity<String>(resultString, HttpStatus.OK);
		 
		 
	}
	
	@PatchMapping("/accounts/debit/{user_id}/{amount}")
	public ResponseEntity<String> debitBalanceHandler(@PathVariable("user_id") Integer user_id, @PathVariable("amount")  Long amount)throws UserException, AccountException{
		String resultString=userService.debitBalance(user_id, amount);
		 return new ResponseEntity<String>(resultString, HttpStatus.OK);
		 
		 
	}

}
