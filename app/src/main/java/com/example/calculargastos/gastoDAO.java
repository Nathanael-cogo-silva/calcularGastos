package com.example.calculargastos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface gastoDAO {

        @Query("SELECT * FROM gasto")
        List<gasto> listar();



        @Insert
        void insert(gasto... gastos);

        @Delete
        void remover(gasto gasto);
    }


