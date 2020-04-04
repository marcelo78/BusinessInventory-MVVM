package com.ma.android.businessinventorymvvm.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ma.android.businessinventorymvvm.db.entity.ProductEntity

/**
 * Fake ProductDao
 */
class ProductDao {
    // A fake database table
    private val productList = mutableListOf<ProductEntity>()

    // MutableLiveData is from the Architecture Components Library
    // LiveData can be observed for changes
    private val products = MutableLiveData<List<ProductEntity>>()

    init {
        // Immediately connect the now empty quoteList
        // to the MutableLiveData which can be observed
        products.value = productList
    }

    fun addQuote(quote: ProductEntity) {
        productList.add(quote)
        // After adding a quote to the "database",
        // update the value of MutableLiveData
        // which will notify its active observers
        products.value = productList
    }

    // Casting MutableLiveData to LiveData because its value
    // shouldn't be changed from other classes
    fun getQuotes() = products as LiveData<List<ProductEntity>>
}

//@Dao
//interface ProductDao {

//    @Query("SELECT * FROM product ORDER BY 2 ASC")
//    fun getAll(): LiveData<MutableList<ProductEntity>>

//    @Query("SELECT * FROM product WHERE id=:ids")
//    fun loadAllByIds(ids: Long): LiveData<MutableList<ProductEntity>>

//    @Query("SELECT * FROM product WHERE name_inventory LIKE :name LIMIT 1")
//    fun findByName(name: String): LiveData<ProductEntity>

//    @Insert
//    fun insertAll(vararg products: ProductEntity)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(product: ProductEntity)

//    @Delete
//    suspend fun delete(product: ProductEntity): Int

//    @Query("DELETE FROM product")
//    suspend fun deleteAll()

//    @Update
//    suspend fun update(product: ProductEntity): Int

//    @Query("SELECT SUM((bought_no - sold_no) * unid_buy_price_us) data1, SUM(CASE WHEN bought_no = sold_no THEN bought_no ELSE (bought_no - sold_no) END) data2, SUM(CASE WHEN bought_no = sold_no THEN 0 ELSE (sold_no) END) data3, ROUND(SUM(total_profit_us), 2) data4, ROUND(SUM(total_cost_us), 2) data5, ROUND(SUM(sold_no * unid_sell_price_us), 2) data6 FROM product")
//    fun getSummary(): LiveData<List<SummaryEntity>>

//}
