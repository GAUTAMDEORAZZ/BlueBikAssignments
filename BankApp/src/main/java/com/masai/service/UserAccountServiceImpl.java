package com.masai.service;

import java.lang.StackWalker.Option;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.ExceptionHandler.AccountException;
import com.masai.ExceptionHandler.UserException;
import com.masai.model.Account;
import com.masai.model.User;
import com.masai.repository.AccountRepo;
import com.masai.repository.UserRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService{
    
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User createUser(User user,Integer account_id)throws AccountException {
	     
		  Optional<Account> opt = accountRepo.findById(account_id);
		  if(opt.isEmpty()) {
			  throw new AccountException("No Account found ");
		  }
		  else {
			  user.setAccount(opt.get());
			  User saveUser=userRepo.save(user);
		   	 return saveUser;
		  }
		
		 
	}

	@Override
	public Account createAccountForUser(Account account) throws UserException {
     
    	  return  accountRepo.save(account);
       
       
	}

	@Override
	public String creditBalance(Integer user_id, Long amount) throws UserException, AccountException {
	   Optional<User> opt=userRepo.findById(user_id);
	   if(opt.isEmpty()) {
		   throw new UserException("Transaction falied:credentials is not valid");
	   }
	   else{
		   Integer account_id=opt.get().getAccount().getAccount_id();
		   Optional<Account> actOpt	=accountRepo.findById(account_id);
		   if(actOpt.isEmpty()) {
			   throw new AccountException("Transaction falied: There is no account found of this user");
		   }
		   else {
			   Account account=actOpt.get();
			   if(account.getBalance()+amount>=1000000) {
				   throw new AccountException("Transaction falied : The Amount is  Exceeded 1 million ");
			   }
			   else {
			   account.setBalance(account.getBalance()+amount);
			   accountRepo.save(account);
			   return "Transaction successfull :  The available  Balance is :" +(account.getBalance());
			   }
		   }
	   }
	 
	}

	@Override
	public String debitBalance(Integer user_id, Long amount) throws UserException,AccountException {
		 Optional<User> opt=userRepo.findById(user_id);
		   if(opt.isEmpty()) {
			   throw new UserException("Transaction falied:credentials is not valid");
		   }
		   else{
			   Integer account_id=opt.get().getAccount().getAccount_id();
			   Optional<Account> actOpt	=accountRepo.findById(account_id);
			   if(actOpt.isEmpty()) {
				   throw new AccountException("Transaction falied: There is no account found of this user");
			   }
			   else {
				   Account account=actOpt.get();
				   if(account.getBalance()-amount<0) {
					   throw new AccountException("Transaction falied : unsufficient Balance");
				   }
				   else {
				   account.setBalance(account.getBalance()-amount);
				   accountRepo.save(account);
				   return "Transaction successfull : "+  "you recieve the amount : "+amount+" The avilable balance is " +(account.getBalance());
				   }
			   }
		   }

	}

}
