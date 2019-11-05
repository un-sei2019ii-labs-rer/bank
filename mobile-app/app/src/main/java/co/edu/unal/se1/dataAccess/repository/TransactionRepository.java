package co.edu.unal.se1.dataAccess.repository;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Transaction;

public class TransactionRepository {

    private String DB_NAME = "se1_db_bank";

    private Database database;
    public TransactionRepository(Context context) {
        database = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().build();
    }

    public List<Transaction> getAllTransactionsByUser(int id){
        return database.transactionDao().getAllTransactionsByUser(id);
    }

    public void makeTransaction(Transaction transaction){
        database.transactionDao().makeTransaction(transaction);
    }

}
