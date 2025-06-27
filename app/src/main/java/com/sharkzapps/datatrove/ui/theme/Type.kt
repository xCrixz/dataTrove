package com.sharkzapps.datatrove.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sharkzapps.datatrove.R


val garamondFamily = FontFamily(
    Font(R.font.garamondbold, FontWeight.Bold),
    Font(R.font.garamondsemibold, FontWeight.SemiBold),
    Font(R.font.garamondextrabold, FontWeight.ExtraBold),
    Font(R.font.garamondregular, FontWeight.Normal),
    Font(R.font.garamondsemibolditalic, FontWeight.Light)
)
val abrilFamily = FontFamily(
    Font(R.font.abrilfatfaceregular, FontWeight.Normal)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = garamondFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = abrilFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
    /*labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)