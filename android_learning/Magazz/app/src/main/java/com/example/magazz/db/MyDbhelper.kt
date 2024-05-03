package com.example.magazz.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbhelper (context: Context):
    SQLiteOpenHelper(context, MyDbClass.DATABASE_NAME, null, MyDbClass.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDbClass.CreateTable)
        db?.execSQL(MyDbClass.CreateTable2)
        db?.execSQL(MyDbClass.CreateTable3)
        db?.execSQL(MyDbClass.CreateTable4)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(MyDbClass.DropTable)
        db?.execSQL(MyDbClass.DropTable2)
        db?.execSQL(MyDbClass.DropTable3)
        db?.execSQL(MyDbClass.DropTable4)
        onCreate(db)
    }
}