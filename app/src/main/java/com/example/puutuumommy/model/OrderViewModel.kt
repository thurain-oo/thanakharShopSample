package com.example.puutuumommy.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _itemType = MutableLiveData<String>()
    val itemType : LiveData<String> = _itemType

    private val _pricePerItem = MutableLiveData<Int>()
    val pricePerItem : LiveData<Int> = _pricePerItem

    private val _quantity = MutableLiveData<Int>()
    val quantity : LiveData<Int> = _quantity

    private val _address = MutableLiveData<String>()
    val address : LiveData<String> = _address

    private val _phone = MutableLiveData<String>()
    val phone : LiveData<String> = _phone

    private val _totalPrice = MutableLiveData<Int>()
    val totalPrice : LiveData<Int> = _totalPrice

    init {
        resetOrder()
    }

    fun resetOrder(){
        _itemType.value =""
        _pricePerItem.value = 0
        _quantity.value = 1
        _address.value = ""
        _phone.value = ""
        _totalPrice.value= 0
    }

    fun calculatePrice() {
        _totalPrice.value = (_pricePerItem.value ?:0)* (_quantity.value ?:0)
    }

    fun setPerItem(pricePerEach : Int) {
        _pricePerItem.value= pricePerEach
        calculatePrice()

    }

    fun setQuantity(quantity : Int){
        _quantity.value = quantity
        calculatePrice()
    }

    fun setAddress(address : String){
        _address.value = address
    }

    fun setPhone(phone: String){
        _phone.value = phone
    }

    fun setItemType(item : String){
        _itemType.value = item
    }

}