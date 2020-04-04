package com.ma.android.businessinventorymvvm.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ma.android.businessinventorymvvm.R
import com.ma.android.businessinventorymvvm.db.ProductsViewModel
import com.ma.android.businessinventorymvvm.db.entity.ProductEntity
import com.ma.android.businessinventorymvvm.di.InjectorTool
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initializeUI()
    }

    fun initializeUI() {
        val factory = InjectorTool.provideProductsViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(ProductsViewModel::class.java)
        viewModel.getProducts().observe(this, Observer { products ->
            val stringBuilder = StringBuilder()
            products.forEach { product ->
                stringBuilder.append("$product\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            val productEntity =
                ProductEntity(0, editText_author.text.toString(), editText_quote.text.toString())
            viewModel.addProduct(productEntity)
            editText_author.setText("")
            editText_quote.setText("")
        }
    }

}
