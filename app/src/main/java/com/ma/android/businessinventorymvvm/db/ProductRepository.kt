package com.ma.android.businessinventorymvvm.db

import com.ma.android.businessinventorymvvm.db.dao.ProductDao
import com.ma.android.businessinventorymvvm.db.entity.ProductEntity

//class ProductRepository(private val productDao: ProductDao) {
class ProductRepository private constructor(private val productDao: ProductDao) {

    fun addProduct(quote: ProductEntity) {
        productDao.addQuote(quote)
    }

    fun getProducts() = productDao.getQuotes()

    companion object {
        // Singleton instantiation
        @Volatile
        private var instance: ProductRepository? = null

        fun getInstance(quoteDao: ProductDao) =
            instance ?: synchronized(this) {
                instance ?: ProductRepository(quoteDao).also { instance = it }
            }
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
//    val allProducts: LiveData<MutableList<ProductEntity>> = productDao.getAll()

//    suspend fun insert(productEntity: ProductEntity) {
//        productDao.insert(productEntity)
//    }

//    suspend fun update(productEntity: ProductEntity): Int {
//        return productDao.update(productEntity)
//    }

//    suspend fun delete(productEntity: ProductEntity): Int {
//        return productDao.delete(productEntity)
//    }

//    fun getItem(ids: Long): LiveData<MutableList<ProductEntity>> {
//        return productDao.loadAllByIds(ids)
//    }
//
//    val allSummary: LiveData<List<SummaryEntity>> = productDao.getSummary()

}