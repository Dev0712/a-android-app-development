package com.example.smp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "person")
    data class PersonEntity(
        @ColumnInfo(name = "person_name") val personName : String,
        @ColumnInfo(name="person_email") val personEmail:String,
        @PrimaryKey val person_mobileno :String,
        @ColumnInfo(name="person_address") val personAddress : String,
        @ColumnInfo(name="person_password") val personPassword: String,
        @ColumnInfo(name = "person_confirm_password") val personConfirmPassword: String
    )
