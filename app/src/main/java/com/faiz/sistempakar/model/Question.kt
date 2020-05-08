package com.faiz.sistempakar.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    var text: String,
    var checked: Boolean = false
): Parcelable