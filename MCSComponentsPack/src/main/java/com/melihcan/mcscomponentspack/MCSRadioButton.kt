package com.melihcan.mcscomponentspack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MCSButton(
    label: String,
    icon: ImageVector?,
    onClick: () -> Unit = {},
    shape: RoundedCornerShape = MCSRadiusSmall(),
    backgroundPrimaryColor: Color = BackgroundPrimaryLight,
    textPrimaryColor: Color = Color.Black,
    iconPrimaryColor: Color = BackgroundSecondaryLight,
) = MCSButtonBase(
    label = label,
    icon = icon,
    onClick = onClick,
    shape = shape,
    backgroundPrimaryColor = backgroundPrimaryColor,
    textPrimaryColor = textPrimaryColor,
    iconPrimaryColor = iconPrimaryColor,
)

@Composable
fun MCSRadioButton(
    value: Int = -1,
    groupValue: Int = -1,
    label: String,
    icon: ImageVector?,
    onClick: () -> Unit = {},
    shape: RoundedCornerShape = MCSRadiusAll(),
    backgroundPrimaryColor: Color = BackgroundPrimaryLight,
    backgroundSecondaryColor: Color = BackgroundSecondaryLight,
    textPrimaryColor: Color = Color.Black,
    textSecondaryColor: Color = BackgroundPrimaryLight,
    iconPrimaryColor: Color = BackgroundSecondaryLight,
    iconSecondaryColor: Color = BackgroundPrimaryLight,
) = MCSButtonBase(
    value = value,
    groupValue = groupValue,
    label = label,
    icon = icon,
    onClick = onClick,
    shape = shape,
    backgroundPrimaryColor = backgroundPrimaryColor,
    backgroundSecondaryColor = backgroundSecondaryColor,
    textPrimaryColor = textPrimaryColor,
    textSecondaryColor = textSecondaryColor,
    iconPrimaryColor = iconPrimaryColor,
    iconSecondaryColor = iconSecondaryColor
)


@Composable
private fun MCSButtonBase(
    value: Int = -1,
    groupValue: Int = -1,
    label: String,
    icon: ImageVector?,
    onClick: () -> Unit = {},
    shape: RoundedCornerShape = MCSFlat(),
    backgroundPrimaryColor: Color = BackgroundPrimaryLight,
    backgroundSecondaryColor: Color = BackgroundSecondaryLight,
    textPrimaryColor: Color = Color.Black,
    textSecondaryColor: Color = BackgroundPrimaryLight,
    iconPrimaryColor: Color = BackgroundSecondaryLight,
    iconSecondaryColor: Color = BackgroundPrimaryLight,
) {
    val (backgroundColor, setBackgroundColor) = remember { mutableStateOf(backgroundPrimaryColor) }
    val (textColor, setTextColor) = remember { mutableStateOf(textPrimaryColor) }
    val (iconColor, setIconColor) = remember { mutableStateOf(iconPrimaryColor) }

    fun setBackgroundColor(): Color {
        if (value == groupValue) {
            setBackgroundColor(backgroundSecondaryColor)
        } else {
            setBackgroundColor(backgroundPrimaryColor)
        }
        return backgroundColor
    }

    fun setTextColor(): Color {
        if (value == groupValue) {
            setTextColor(textSecondaryColor)
        } else {
            setTextColor(textPrimaryColor)
        }
        return textColor
    }

    fun setIconColor(): Color {
        if (value == groupValue) {
            setIconColor(iconSecondaryColor)
        } else {
            setIconColor(iconPrimaryColor)
        }
        return iconColor
    }

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (value == -1) backgroundColor else setBackgroundColor()
        ),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp
        ),
        shape = shape
    ) {
        if (icon != null)
            Icon(
                imageVector = icon,
                label,
                tint = if (value == -1) iconColor else setIconColor(),
                modifier = Modifier
                    .size(24.dp)
                    .padding(0.dp)
            )
        Text(
            label,
            modifier = Modifier.padding(0.dp),
            color = if (value == -1) textColor else setTextColor()
        )
    }
}
