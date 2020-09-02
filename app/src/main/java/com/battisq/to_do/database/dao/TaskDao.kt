package com.battisq.to_do.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.battisq.to_do.models.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task")
    fun gelAllTasks(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)
}