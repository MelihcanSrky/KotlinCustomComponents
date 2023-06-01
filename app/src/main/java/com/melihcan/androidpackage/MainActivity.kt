package com.melihcan.androidpackage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.melihcan.androidpackage.ui.theme.AndroidPackageTheme
import com.melihcan.androidpackage.ui.theme.BackgroundSecondaryLight
import com.melihcan.mcscomponentspack.MCSButton
import com.melihcan.mcscomponentspack.MCSRadioButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val (groupValue, setGroupValue) = remember { mutableStateOf(0) }
            AndroidPackageTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Text(text = "Buttons")
                        Row() {
                            MCSButton(label = "Button #1", icon = Icons.Default.Create)
                            Spacer(modifier = Modifier.width(12.dp))
                            MCSButton(
                                label = "Button #2",
                                icon = Icons.Default.Create,
                                backgroundPrimaryColor = BackgroundSecondaryLight,
                                textPrimaryColor = Color.White,
                                iconPrimaryColor = Color.White
                            )
                        }
                        Divider()
                        Text(text = "Radio Buttons")
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            MCSRadioButton(value = 0, groupValue = groupValue, onClick = {
                                setGroupValue(0)
                            }, label = "Radio #1", icon = Icons.Default.Add)
                            MCSRadioButton(value = 1, groupValue = groupValue, onClick = {
                                setGroupValue(1)
                            }, label = "Radio #2", icon = null)
                            MCSRadioButton(value = 2, groupValue = groupValue, onClick = {
                                setGroupValue(2)
                            }, label = "Radio #3", icon = Icons.Default.Close)
                            MCSRadioButton(value = 3, groupValue = groupValue, onClick = {
                                setGroupValue(3)
                            }, label = "Radio #4", icon = null)
                        }
                        Divider()
                    }
                }
            }
        }
    }
}