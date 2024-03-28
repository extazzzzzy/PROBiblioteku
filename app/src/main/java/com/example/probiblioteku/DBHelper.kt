package com.example.probiblioteku

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
        SQLiteOpenHelper(context, "app", factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INTEGER PRIMARY KEY, numberTicket TEXT, name TEXT, surname TEXT, patronymic TEXT)"
        db!!.execSQL(query);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(user: User) {
        val values = ContentValues()
        values.put("numberTicket", user.numberTicket)
        values.put("name", user.name)
        values.put("surname", user.surname)
        values.put("patronymic", user.patronymic)

        val db = this.writableDatabase
        db.insert("users", null, values)

        db.close()

    }

    fun getUser(ticket: String): Boolean {
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM users WHERE numberTicket = '$ticket'", null)
        return result.moveToFirst()
    }


}
