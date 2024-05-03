package com.example.magazz.db

import android.annotation.SuppressLint
import android.content.ClipDescription
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.example.magazz.models.*

class DbManager(val context: Context)  {
    val myDBhelper = MyDbhelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = myDBhelper.writableDatabase
    }

    fun CloseDb() {
        myDBhelper.close()
    }


    //Auth Methods

    @SuppressLint("Range")
    fun CheckUser(name: String, pass: String): User? {
        val slt = "${MyDbClass.COLUMN_NAME_USER} like \"${name}\" and ${MyDbClass.COLUMN_NAME_PASSWORD} like \"${pass}\""

        val cursor = db?.query(
            MyDbClass.TABLE_NAME, null, slt, null,
            null, null, null)

        while (cursor?.moveToNext()!!) {
            var UsData = User()

            UsData.id = cursor.getString(cursor.getColumnIndex(BaseColumns._ID)).toInt()
            UsData.usname = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_USER)).toString()
            UsData.Pass = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_PASSWORD)).toString()
            UsData.Role = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_Role)).toString()

            cursor.close()
            return UsData
        }
        return null
    }

    @SuppressLint("Range")
    fun checkUsername(name: String): Boolean {
        val slt = "${MyDbClass.COLUMN_NAME_USER} like \"${name}\""

        val cursor = db?.query(
            MyDbClass.TABLE_NAME, null, slt, null,
            null, null, null)

        while (cursor?.moveToNext()!!) {
            var idd = cursor.getString(cursor.getColumnIndex(BaseColumns._ID)).toInt()
            cursor.close()
            return false
        }
        cursor.close()
        return true


    }

    fun signUp(name: String, pass: String): Boolean {
        if(checkUsername(name)) {
            val values = ContentValues().apply {
                put(MyDbClass.COLUMN_NAME_USER, name)
                put(MyDbClass.COLUMN_NAME_PASSWORD, pass)
                put(MyDbClass.COLUMN_NAME_Role, "Buyer")
            }
            db?.insert(MyDbClass.TABLE_NAME, null, values)

            return true
        }

        return false
    }

    fun signIn(name: String, pass: String): Pair<String, Int>{
        var User = CheckUser(name, pass)

        if(User == null) {
            return Pair("False", 0)
        } else {
            return Pair(User.Role, User.id)
        }
    }


    //Product Methods

    fun addProduct(name: String, description: String, price: Int, amount: Int) {
        val values = ContentValues().apply {
            put(MyDbClass.COlUMN_NAME_Product_name, name)
            put(MyDbClass.COLUMN_NAME_Product_desc, description)
            put(MyDbClass.COLUMN_NAME_Product_price, price)
            put(MyDbClass.COLUMN_NAME_Product_amount, amount)
        }
        db?.insert(MyDbClass.Product_table_name, null, values)

    }

    @SuppressLint("Range")
    fun AllProducts(): ArrayList<product> {
        var dataList = ArrayList<product>()


        val cursor = db?.query(
            MyDbClass.Product_table_name, null, null, null,
            null, null, null)

        while (cursor?.moveToNext()!!) {
            var Pdata = product()

            Pdata.id = cursor.getString(cursor.getColumnIndex(BaseColumns._ID)).toInt()
            Pdata.name = cursor.getString(cursor.getColumnIndex(MyDbClass.COlUMN_NAME_Product_name)).toString()
            Pdata.desc = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_Product_desc)).toString()
            Pdata.price = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_Product_price)).toInt()
            Pdata.amount = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_Product_amount)).toInt()

            dataList.add(Pdata)
        }
        cursor.close()
        return dataList
    }

    fun UpdateProduct(id: Int, nm: String, dc: String, pc: Int, am: Int) {
        val values = ContentValues().apply {
            if(nm != "") {put(MyDbClass.COlUMN_NAME_Product_name, nm)}
            if(dc != "") {put(MyDbClass.COLUMN_NAME_Product_desc, dc)}
            if(pc != 0) {put(MyDbClass.COLUMN_NAME_Product_price, pc)}
            if(am != 0) {put(MyDbClass.COLUMN_NAME_Product_amount, am)}

        }
        db?.update(MyDbClass.Product_table_name, values, BaseColumns._ID + "=${id}", null)
    }

    fun deleteProduct(id: Int?): Int? {
        return db?.delete(MyDbClass.Product_table_name, BaseColumns._ID +"=${id}", null)
    }


    // Admin Methods
    @SuppressLint("Range")
    fun AllUsers(): ArrayList<User2> {
        var dataList = ArrayList<User2>()


        val cursor = db?.query(
            MyDbClass.TABLE_NAME, null, null, null,
            null, null, null)

        while (cursor?.moveToNext()!!) {
            var Udata = User2()

            Udata.id = cursor.getString(cursor.getColumnIndex(BaseColumns._ID)).toInt()
            Udata.usname = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_USER)).toString()
            Udata.Role = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_Role)).toString()


            dataList.add(Udata)
        }
        cursor.close()
        return dataList
    }

    fun ChangeRole(id: Int, Role: String) {
        var v = ContentValues()
        v.put(MyDbClass.COLUMN_NAME_Role, Role)

        db?.update(MyDbClass.TABLE_NAME, v, BaseColumns._ID + "=${id}", null)
    }

    fun deleteUser(id: Int?): Int? {
        return db?.delete(MyDbClass.TABLE_NAME, BaseColumns._ID +"=${id}", null)
    }

    // Purchases

    @SuppressLint("Range")
    fun MyPurchases(id: Int): ArrayList<Purchases> {
        var dataList = ArrayList<Purchases>()
        val slt = "${MyDbClass.COLUMN_NAME_Buyer_User} like ${id}"

        val cursor = db?.query(
            MyDbClass.Purchases_table_name, null, slt, null,
            null, null, null
        )

        while (cursor?.moveToNext()!!) {
            var purch = Purchases()

            purch.id = cursor.getString(cursor.getColumnIndex(BaseColumns._ID)).toInt()
            purch.buyer_id = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_Buyer_User)).toString().toInt()
            purch.product_id = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_Bought_Product)).toString().toInt()
            purch.address = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_Address)).toString()
            purch.phoneNumber = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_Phone)).toString()

            dataList.add(purch)

        }

        cursor.close()
        return dataList
    }

    fun makePurchase(B_id: Int, P_id: Int, Ad: String, Num: String) {
        val values = ContentValues().apply {
            put(MyDbClass.COLUMN_NAME_Buyer_User, B_id)
            put(MyDbClass.COLUMN_NAME_Bought_Product, P_id)
            put(MyDbClass.COLUMN_NAME_Address, Ad)
            put(MyDbClass.COLUMN_NAME_Phone, Num)
        }
        db?.insert(MyDbClass.Purchases_table_name, null, values)

    }

    //Comments
    @SuppressLint("Range")
    fun ProductComments(id: Int): ArrayList<comment> {
        var dataList = ArrayList<comment>()
        val slt = "${MyDbClass.COLUMN_NAME_Product} like ${id}"

        val cursor = db?.query(
            MyDbClass.Comment_table_name, null, slt, null,
            null, null, null
        )

        while (cursor?.moveToNext()!!) {
            var cm = comment()

            cm.id = cursor.getString(cursor.getColumnIndex(BaseColumns._ID)).toInt()
            cm.Commented_id = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_Commented_User)).toString().toInt()
            cm.Product_id = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_Product)).toString().toInt()
            cm.Comment = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_NAME_COMMENT)).toString()

            dataList.add(cm)

        }

        cursor.close()
        return dataList
    }

    fun CommentProduct(us_id: Int, p_id: Int, com: String) {
        val values = ContentValues().apply {
            put(MyDbClass.COLUMN_NAME_Commented_User, us_id)
            put(MyDbClass.COLUMN_NAME_Product, p_id)
            put(MyDbClass.COLUMN_NAME_COMMENT, com)
        }
        db?.insert(MyDbClass.Comment_table_name, null, values)
    }
}