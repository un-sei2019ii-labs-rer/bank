package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import co.edu.unal.se1.dataAccess.model.Account;
import co.edu.unal.se1.dataAccess.repository.AccountRepository;


public class AccountController {

    private AccountRepository accountRepository;
    private TransactionController transactionController;

    public AccountController() {

    }

    public void createAccount(Account account, Context context) {
        accountRepository = new AccountRepository(context);
        accountRepository.createAccount(account);
    }

    public void deleteAccount(int user_Id, Context context){

        final Account account = accountRepository.getAccountById(user_Id);

        if (account.getBalance() == 0){
           accountRepository = new AccountRepository(context);
           accountRepository.deleteAccount(user_Id);
        }
        else{
            transactionController = new TransactionController();
            int target_Id = 0;
            if (transactionController.sendMoney(user_Id, target_Id, account.getBalance(), context)){
                if(account.getBalance() == 0){
                    accountRepository = new AccountRepository(context);
                    accountRepository.deleteAccount(user_Id);
                }
            }
        }
    }
}
