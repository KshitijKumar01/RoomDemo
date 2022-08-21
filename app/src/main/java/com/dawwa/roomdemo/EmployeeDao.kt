package com.dawwa.roomdemo

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// DAO = data access object
@Dao
interface EmployeeDao {

    @Insert
    suspend fun insert(employeeEntity: EmployeeEntity)

    @Update
    suspend fun update(employeeEntity: EmployeeEntity)

    @Delete
    suspend fun delete(employeeEntity: EmployeeEntity)

    @Query("SELECT * FROM `employee-table`")
    fun fetchALlEmployee():Flow<List<EmployeeEntity>>

    @Query("SELECT * FROM `employee-table` where id = :id")
    fun fetchEmployeeById(id : Int):Flow<EmployeeEntity>

}
