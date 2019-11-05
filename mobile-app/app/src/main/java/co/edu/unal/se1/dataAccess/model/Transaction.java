package co.edu.unal.se1.dataAccess.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

import java.util.Date;

@Entity
public class Transaction {

    @PrimaryKey(autoGenerate = true)
    public int id;

    // Target Account id
    @ForeignKey(entity = Account.class, parentColumns = "account_Id", childColumns = "account_Id", onDelete = CASCADE)
    public int account_Id;

    // Source User id
    @ForeignKey(entity = User.class, parentColumns ="user_Id", childColumns = "user_Id", onDelete = CASCADE)
    public int user_Id;

    @ColumnInfo(name = "date")
    public Date date;

    @ColumnInfo(name = "amount")
    public int amount;

    public Transaction(int account_Id, int user_Id, Date date, int amount) {
        this.account_Id = account_Id;
        this.user_Id = user_Id;
        this.date = date;
        this.amount = amount;
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
