package com.example.magazz.db

import android.provider.BaseColumns

object MyDbClass {


    //User
    const val TABLE_NAME = "user_table"
    const val COLUMN_NAME_USER = "Username"
    const val COLUMN_NAME_PASSWORD = "Password"
    const val COLUMN_NAME_Role = "Role"

    const val CreateTable = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_USER TEXT, $COLUMN_NAME_PASSWORD, $COLUMN_NAME_Role TEXT CHECK($COLUMN_NAME_Role IN (\"Buyer\", \"Seller\", \"Admin\")))"
    const val DropTable = "DROP TABLE IF EXISTS $TABLE_NAME"


    //Products
    const val Product_table_name = "product_table"
    const val COlUMN_NAME_Product_name = "ProductName"
    const val COLUMN_NAME_Product_desc = "Description"
    const val COLUMN_NAME_Product_price = "Price"
    const val COLUMN_NAME_Product_amount = "Amount"

    const val CreateTable2 = "CREATE TABLE IF NOT EXISTS $Product_table_name (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COlUMN_NAME_Product_name TEXT, $COLUMN_NAME_Product_desc TEXT, $COLUMN_NAME_Product_price INTEGER, $COLUMN_NAME_Product_amount INTEGER)"
    const val DropTable2 = "DROP TABLE IF EXISTS $Product_table_name"


    //Rating
    const val Rating_table_name = "rating_table"
    const val COLUMN_NAME_Rated_user = "user_id"
    const val COLUMN_NAME_Rated_product = "product_id"
    const val COLUMN_NAME_RATING = "rating"

 //   const val CreateTable5 = "CREATE TABLE IF NOT EXISTS $Rating_table_name (" +
   //         "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_Rated_user INTEGER, $COLUMN_NAME_Rated_product INTEGER, $COLUMN_NAME_RATING INTEGER"
 //   const val DropTable5 = "DROP TABLE IF EXISTS $Rating_table_name"

    //Comments
    const val Comment_table_name = "comment_table"
    const val COLUMN_NAME_Commented_User = "user_id"
    const val COLUMN_NAME_Product = "product_id"
    const val COLUMN_NAME_COMMENT = "comment"
    const val CreateTable4 = "CREATE TABLE IF NOT EXISTS $Comment_table_name (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_Commented_User INTEGER, $COLUMN_NAME_Product INTEGER, $COLUMN_NAME_COMMENT TEXT)"
    const val DropTable4 = "DROP TABLE IF EXISTS $Comment_table_name"


    //Purchases
    const val Purchases_table_name = "Purchases"
    const val COLUMN_NAME_Buyer_User = "user_id"
    const val COLUMN_NAME_Bought_Product = "product_id"
    const val COLUMN_NAME_Address = "address"
    const val COLUMN_NAME_Phone = "phone_number"

    const val CreateTable3 = "CREATE TABLE IF NOT EXISTS $Purchases_table_name (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_Buyer_User INTEGER, $COLUMN_NAME_Bought_Product INTEGER, $COLUMN_NAME_Address TEXT, $COLUMN_NAME_Phone TEXT)"
    const val DropTable3 = "DROP TABLE IF EXISTS $Purchases_table_name"


    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "Magaz.db"




}