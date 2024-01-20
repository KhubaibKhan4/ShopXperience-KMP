package org.shop.app.navigations.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.shop.app.navigations.components.HomeScreen

object HomeTab : Tab {
    @Composable
    override fun Content() {
       Navigator(HomeScreen())
    }


    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Outlined.Home)
            val title = "Home"
            val index: UShort = 0u
            return TabOptions(
                index, title, icon
            )
        }
}