package co.edu.unal.se1.dataAccess.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import static androidx.room.ForeignKey.CASCADE;

// Account table

@Entity
public class Account implements Serializable {

    @PrimaryKey
    public int account_Id;

    @ForeignKey(entity = User.class, parentColumns = "user_Id", childColumns = "user_Id", onDelete = CASCADE)
    public int user_Id;

    @ForeignKey(entity = Admin.class, parentColumns = "admin_Id", childColumns = "admin_Id", onDelete = CASCADE)
    public int admin_Id;

    @ColumnInfo(name = "balance")
    public int balance;

    public Account(int account_Id, int user_Id, int admin_Id, int balance) {
        this.account_Id = account_Id;
        this.user_Id = user_Id;
        this.admin_Id = admin_Id;
        this.balance = balance;
    }


    // Getters and Setters

    public int getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(int account_Id) {
        this.account_Id = account_Id;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public int getAdmin_Id() {
        return admin_Id;
    }

    public void setAdmin_Id(int admin_Id) {
        this.admin_Id = admin_Id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
