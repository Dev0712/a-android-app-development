package com.example.babaro.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface PersonDao {

    @Insert
    fun insertPerson(personEntity :PersonEntity)


    @Delete
    fun deletePerson(personEntity :PersonEntity)

    @Query( "SELECT * FROM person")
    fun getAllPerson():List<PersonEntity>


    @Query( "SELECT * FROM person WHERE person_mobileno = :personMobileno")
    fun getPersonbyMobileno(personMobileno: String) : PersonEntity
}