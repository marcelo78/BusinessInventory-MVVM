package com.ma.android.businessinventorymvvm.db

import androidx.lifecycle.ViewModel
import com.ma.android.businessinventorymvvm.db.entity.ProductEntity

class ProductsViewModel(private val productRepository: ProductRepository) : ViewModel() {

    fun getProducts() = productRepository.getProducts()

    fun addProduct(productEntity: ProductEntity) = productRepository.addProduct(productEntity)

//    companion object {
//        private val TAG = ProductViewModel::class.java.simpleName
//    }

    // The ViewModel maintains a reference to the repository to get data.
//    private val repository: ProductRepository

    // LiveData gives us updated words when they change.
//    val allProducts: LiveData<MutableList<ProductEntity>>
//    val allSummary: LiveData<List<SummaryEntity>>

//    init {
    // Gets reference to WordDao from RoomDatabase to construct
    // the correct WordRepository.
//        val productDao = AppDatabase.getDatabase(application, viewModelScope).productDao()
//        repository = ProductRepository(productDao)
//        allProducts = repository.allProducts
//        allSummary = repository.allSummary
//    }

//    fun insert(product: ProductEntity) = viewModelScope.launch {
//        repository.insert(product)
//    }

//    fun update(product: ProductEntity) = viewModelScope.launch {
//        val returnInt = repository.update(product)
//        Log.d(TAG, "update:------------:$returnInt:------------")
//    }

//    fun delete(product: ProductEntity) = viewModelScope.launch {
//        val returnInt = repository.delete(product)
//        Log.d(TAG, "delete:------------:$returnInt:------------")
//    }

//    fun getItem(ids: Long): LiveData<MutableList<ProductEntity>> {
//        return repository.getItem(ids)
//    }

}
