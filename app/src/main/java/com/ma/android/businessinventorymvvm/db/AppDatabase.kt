package com.ma.android.businessinventorymvvm.db

import com.ma.android.businessinventorymvvm.db.dao.ProductDao

//@Database(entities = [ProductEntity::class], version = 1)
class AppDatabase private constructor() {

    //    abstract fun productDao(): ProductDao
    val productDao = ProductDao()

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: AppDatabase().also { INSTANCE = it }

        }

    }
}
