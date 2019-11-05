package co.edu.unal.se1.dataAccess.db;

import androidx.room.RoomDatabase;
import co.edu.unal.se1.dataAccess.dao.UserDao;
import co.edu.unal.se1.dataAccess.dao.AdminDao;
import co.edu.unal.se1.dataAccess.dao.TransactionDao;
import co.edu.unal.se1.dataAccess.dao.AccountDao;
import co.edu.unal.se1.dataAccess.model.Account;
import co.edu.unal.se1.dataAccess.model.Transaction;
import co.edu.unal.se1.dataAccess.model.User;
import co.edu.unal.se1.dataAccess.model.Admin;


@androidx.room.Database(entities = {User.class, Admin.class ,Transaction.class, Account.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract AdminDao adminDao();
    public abstract TransactionDao transactionDao();
    public abstract AccountDao accountDao();

}


