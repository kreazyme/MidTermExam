package com.midterm.tranducthong;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDAO {

    @Insert
    public void Insert(ApiModel...dogBreeds);

    @Update
    public void Update(ApiModel...dogBreeds);

    @Delete
    public void Delete(ApiModel...dogBreeds);

    @Query("SELECT * FROM api_model")
    public List<ApiModel> getDogs();

}
