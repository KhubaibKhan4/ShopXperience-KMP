package org.shop.app.navigations.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import org.shop.app.theme.LocalThemeIsDark


class HomeScreen : Screen {
    @Composable
    override fun Content() {
        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "ShopXperience",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer(modifier = Modifier.weight(1.0f))

                var isDark by LocalThemeIsDark.current
                IconButton(
                    onClick = { isDark = !isDark }
                ) {
                    Icon(
                        modifier = Modifier.padding(8.dp).size(20.dp),
                        imageVector = if (isDark) Icons.Default.LightMode else Icons.Default.DarkMode,
                        contentDescription = null
                    )
                }
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Home")
            }
        }
    }
}