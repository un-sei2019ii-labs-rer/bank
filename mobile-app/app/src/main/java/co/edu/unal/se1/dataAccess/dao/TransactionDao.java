package co.edu.unal.se1.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.edu.unal.se1.dataAccess.model.Transaction;

@Dao
public interface TransactionDao {

    @Query("SELECT * FROM `transaction` T, user U WHERE T.user_Id == U.user_Id and user_Id = :id")
    List<Transaction> getAllTransactionsByUser(int id);

    @Insert
    void makeTransaction(Transaction transaction);

}
