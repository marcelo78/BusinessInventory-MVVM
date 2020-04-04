package com.ma.android.businessinventorymvvm.di

import com.ma.android.businessinventorymvvm.db.AppDatabase
import com.ma.android.businessinventorymvvm.db.ProductRepository
import com.ma.android.businessinventorymvvm.db.ProductsViewModelFactory

object InjectorTool {

    fun     provideProductsViewModelFactory(): ProductsViewModelFactory {
        val productRepository = ProductRepository.getInstance(AppDatabase.getDatabase().productDao)
        return ProductsViewModelFactory(productRepository)
    }

}