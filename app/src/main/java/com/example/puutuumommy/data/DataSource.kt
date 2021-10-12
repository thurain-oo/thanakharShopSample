package com.example.puutuumommy.data

import com.example.puutuumommy.R
import com.example.puutuumommy.model.CatalogItem
import com.example.puutuumommy.model.ThanakhatoneItem

class DataSource() {

    fun loadCatalogItems() : List<CatalogItem>{
        return listOf<CatalogItem>(
            CatalogItem(R.drawable.start , R.string.catalogItem1),
            CatalogItem(R.drawable.start , R.string.catalogItem2),
            CatalogItem(R.drawable.start , R.string.catalogItem3),
            CatalogItem(R.drawable.start , R.string.catalogItem4),
            CatalogItem(R.drawable.start , R.string.catalogItem5),
        )
    }

    fun loadThanakhatoneItems() : List<ThanakhatoneItem>{
        return listOf<ThanakhatoneItem>(
            ThanakhatoneItem(R.drawable.start,R.string.property,R.string.price_for_thanakha_tone1),
            ThanakhatoneItem(R.drawable.start,R.string.property,R.string.price_for_thanakha_tone2),
            ThanakhatoneItem(R.drawable.start,R.string.property,R.string.price_for_thanakha_tone3),
            ThanakhatoneItem(R.drawable.start,R.string.property,R.string.price_for_thanakha_tone4),
            ThanakhatoneItem(R.drawable.start,R.string.property,R.string.price_for_thanakha_tone5),
        )
    }

}