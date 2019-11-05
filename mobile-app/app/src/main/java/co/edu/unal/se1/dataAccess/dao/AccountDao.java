package co.edu.unal.se1.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.edu.unal.se1.dataAccess.model.Account;

@Dao
public interface AccountDao {

    @Query("SELECT account_Id, name FROM account A, user U WHERE A.user_Id = U.user_Id and user_Id = :id")
    List<Account> showAccounts(int id);

    @Query("SELECT * FROM account WHERE id = :id")
    Account getAccountById(int id);

    @Insert
    void createAccount(Account account);

    @Update
    void updateAccount(Account account);

    @Delete
    void deleteAccount(Account account);
}
