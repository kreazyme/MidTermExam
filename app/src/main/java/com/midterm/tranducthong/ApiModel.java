package com.midterm.tranducthong;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Entity(tableName = "api_model")
public class ApiModel {
    public ApiModel(String title, String timestamp, String desc) {
        Title = title;
        Timestamp = timestamp;
        Desc = desc;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    @PrimaryKey
    @NonNull
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("title")
    private String Title;

    @SerializedName("timeStamp")
    private String Timestamp;

    @SerializedName("desc")
    private String Desc;
}
