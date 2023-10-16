package com.duongvn.politicalpreparedness.representative.model

import android.os.Parcelable
import com.duongvn.politicalpreparedness.network.models.Office
import com.duongvn.politicalpreparedness.network.models.Official
import kotlinx.parcelize.Parcelize

@Parcelize
data class Representative(
    val official: Official,
    val office: Office
) : Parcelable