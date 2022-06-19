package com.dailyaims.model

enum class AimType(val value: String) {
    QTY("Qty"),
    KM("Km"),
    METER("Meter"),
    MINUTE("minute"),
    HOUR("Hour");

    fun getTypeFromString(value: String): AimType =
        when (value) {
            QTY.value -> QTY
            KM.value -> KM
            METER.value -> METER
            MINUTE.value -> MINUTE
            HOUR.value -> HOUR
            else -> QTY
        }
}
