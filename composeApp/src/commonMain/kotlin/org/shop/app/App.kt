package org.shop.app

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Shop
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.shop.app.navigations.screens.AccountTab
import org.shop.app.navigations.screens.CartTab
import org.shop.app.navigations.screens.FavouriteTab
import org.shop.app.navigations.screens.HomeTab
import org.shop.app.navigations.screens.ShopTab
import org.shop.app.navigations.screens.items.NavigationItem
import org.shop.app.theme.AppTheme
import org.shop.app.theme.LocalThemeIsDark

@Composable
internal fun App() = AppTheme {

    val items = listOf(
        NavigationItem(
            title = "Home",
            selectedIcon = Icons.Outlined.Home,
            unselectedIcon = Icons.Filled.Home,
            hasNews = false,
        ),
        NavigationItem(
            title = "Shop",
            selectedIcon = Icons.Filled.Shop,
            unselectedIcon = Icons.Outlined.Shop,
            hasNews = true,
        ),
        NavigationItem(
            title = "Cart",
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
            hasNews = false,
        ),
        NavigationItem(
            title = "Favourite",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.Favorite,
            hasNews = false,
        ),
        NavigationItem(
            title = "Account",
            selectedIcon = Icons.Filled.AccountBox,
            unselectedIcon = Icons.Outlined.AccountBox,
            hasNews = false,
        ),
    )
    TabNavigator(HomeTab) { tabNavigator ->
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    modifier = Modifier.fillMaxWidth().windowInsetsPadding(WindowInsets.ime),
                    backgroundColor = MaterialTheme.colorScheme.background,
                    contentColor = contentColorFor(Color.Black),
                    elevation = 8.dp
                ){
                    TabItem(HomeTab)
                    TabItem(ShopTab)
                    TabItem(CartTab)
                    TabItem(FavouriteTab)
                    TabItem(AccountTab)
                }
            }
        ){
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(bottom = it.calculateBottomPadding(), top = it.calculateTopPadding())
            ) {
                CurrentTab()
            }
        }
    }

}
@Composable
fun RowScope.TabItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface)
            .height(58.dp).clip(RoundedCornerShape(16.dp)),
        selected = tabNavigator.current == tab,
        onClick = {
            tabNavigator.current = tab
        },
        icon = {
            tab.options.icon?.let { painter ->
                Icon(
                    painter = painter,
                    contentDescription = tab.options.title,
                    tint = if (tabNavigator.current ==tab) Color.Black else Color.Gray,
                )
            }
        },
        label = {
            tab.options.title.let { title ->
                Text(
                    text = title,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                )
            }
        },
        enabled = true,
        alwaysShowLabel = true,
        interactionSource = MutableInteractionSource(),
        selectedContentColor = Color.Black,
        unselectedContentColor = Color.Black.copy(alpha = 0.80f),

    )

}

internal expect fun openUrl(url: String?)