package com.example.recipeappproject.DataClasses
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Register_users_table")
data class RegisterEntity(
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "user_name")
    var userName: String,

    @ColumnInfo(name= "user_email")
    var userEmail:String,

    @ColumnInfo(name = "password_text")
    var password: String


)
