package co.edu.unal.se1.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.edu.unal.se1.dataAccess.model.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE user_Id = :user_Id")
    User getUserById(int user_Id);

    @Insert
    void createUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

}
