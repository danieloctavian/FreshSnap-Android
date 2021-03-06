package com.daniel.freshsnap_android.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vegetables (
    var name_vegetables: String,
    var photo_vegetables: Int
): Parcelable
