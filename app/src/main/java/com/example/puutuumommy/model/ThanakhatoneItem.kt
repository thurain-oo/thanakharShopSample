package com.example.puutuumommy.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ThanakhatoneItem(
    @DrawableRes val imageResourceId : Int,
    @StringRes val property : Int ,
    @StringRes val price : Int
)