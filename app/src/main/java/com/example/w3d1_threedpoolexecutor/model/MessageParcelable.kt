package com.example.w3d1_threedpoolexecutor.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MessageParcelable(val message: String) : Parcelable
