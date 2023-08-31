package com.example.calculargastos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class gasto {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "gastos")
    public String gastos;
}
