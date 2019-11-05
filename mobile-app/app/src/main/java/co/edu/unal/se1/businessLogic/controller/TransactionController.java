package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import java.util.Calendar;
import java.util.Date;

import co.edu.unal.se1.dataAccess.model.Account;
import co.edu.unal.se1.dataAccess.model.Transaction;
import co.edu.unal.se1.dataAccess.model.User;
import co.edu.unal.se1.dataAccess.repository.AccountRepository;
import co.edu.unal.se1.dataAccess.repository.TransactionRepository;
import co.edu.unal.se1.dataAccess.repository.UserRepository;

public class TransactionController {

    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public TransactionController() {

    }

    public void makeTransaction(Transaction transaction, Context context) {
        transactionRepository = new TransactionRepository(context);
        transactionRepository.makeTransaction(transaction);
    }

    public boolean sendMoney(int source_Id, int target_id, int value, Context context) {

        userRepository = new UserRepository(context);
        accountRepository = new AccountRepository(context);
        transactionRepository = new TransactionRepository(context);

        final User sourceUser = userRepository.getUserById(source_Id);
        final Account sourcerAccount = accountRepository.getAccountById(source_Id);

        final User targetUser = userRepository.getUserById(target_id);
        final Account targetAccount = accountRepository.getAccountById(target_id);

        if(sourcerAccount.getBalance() >= value){
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH)+1;
            int year = calendar.get(Calendar.YEAR);
            calendar.set(day,month,year);
            Date currentDate = calendar.getTime();

            final Transaction transaction = new Transaction(target_id, source_Id, currentDate, value);
            transactionRepository.makeTransaction(transaction);

            sourcerAccount.setBalance(sourcerAccount.getBalance() - value);
            targetAccount.setBalance(targetAccount.getBalance() + value);

            accountRepository.updateAccount(sourcerAccount);
            accountRepository.updateAccount(targetAccount);

            return true;
        }
        else{
            return false;
        }

    }

}
