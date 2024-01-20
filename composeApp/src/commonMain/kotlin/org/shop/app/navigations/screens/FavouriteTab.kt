package org.shop.app.navigations.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object FavouriteTab: Tab {
    @Composable
    override fun Content() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Favourite")
        }
    }

    override val options: TabOptions
        @Composable
        get(){
            val icon = rememberVectorPainter(Icons.Outlined.FavoriteBorder)
            val title = "Favourite"
            val index: UShort = 3u
            return TabOptions(
                index, title, icon
            )
        }
}