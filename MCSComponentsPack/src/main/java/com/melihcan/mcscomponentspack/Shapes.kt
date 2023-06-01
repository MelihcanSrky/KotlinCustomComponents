package com.melihcan.mcscomponentspack

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

fun MCSFlat() = RoundedCornerShape(0.dp)
fun MCSRadiusSmall() = RoundedCornerShape(8.dp)
fun MCSRadiusMedium() = RoundedCornerShape(12.dp)
fun MCSRadiusLarge() = RoundedCornerShape(16.dp)
fun MCSRadiusCustom(radius: Int) = RoundedCornerShape(radius.dp)
fun MCSRadiusAll() = RoundedCornerShape(1000.dp)
