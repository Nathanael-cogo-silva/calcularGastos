package com.example.calculargastos;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {gasto.class}, version = 1)

public abstract class AppDataBase extends RoomDatabase {
    public abstract gastoDAO gastoDAO();
}
