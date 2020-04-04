package com.ma.android.businessinventorymvvm.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductsViewModelFactory(private val productRepository: ProductRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductsViewModel(productRepository) as T
    }

}