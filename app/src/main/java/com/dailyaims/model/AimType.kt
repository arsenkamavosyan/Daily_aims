package com.dailyaims.model

import androidx.annotation.StringRes
import com.dailyaims.R

enum class AimType(@StringRes val value: Int) {
    QTY(R.string.qty),
    KM(R.string.km),
    METER(R.string.meter),
    MINUTE(R.string.minute),
    HOUR(R.string.hour)
}
