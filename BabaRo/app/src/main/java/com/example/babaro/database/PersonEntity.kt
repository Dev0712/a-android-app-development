package com.example.babaro.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "person")
data class PersonEntity(
    @ColumnInfo(name = "person_name") val personName : String,
    @PrimaryKey val person_mobileno :String,
    @ColumnInfo(name="person_address") val personAddress : String
)