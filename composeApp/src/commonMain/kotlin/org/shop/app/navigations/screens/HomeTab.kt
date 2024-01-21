package org.shop.app.navigations.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.shop.app.domain.repository.Repository
import org.shop.app.presentation.MainViewModel

object HomeTab : Tab {
    @Composable
    override fun Content() {
        val repository = remember { Repository() }
        val viewModel = remember { MainViewModel(repository) }
       Navigator(HomeScreen(viewModel))
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