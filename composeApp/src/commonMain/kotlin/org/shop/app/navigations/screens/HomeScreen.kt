package org.shop.app.navigations.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.seiko.imageloader.rememberImagePainter
import org.shop.app.data.model.ProductsItem
import org.shop.app.domain.usecase.ResultState
import org.shop.app.navigations.components.ErrorBox
import org.shop.app.navigations.components.LoadingBox
import org.shop.app.navigations.components.ProductList
import org.shop.app.presentation.MainViewModel
import org.shop.app.theme.LocalThemeIsDark


class HomeScreen(
    private val viewModel: MainViewModel
) : Screen {
    @Composable
    override fun Content() {
        var productResult by remember { mutableStateOf<List<ProductsItem>>(emptyList()) }
        LaunchedEffect(Unit) {
            viewModel.getProducts()
        }
        val state by viewModel.products.collectAsState()
        when (state) {
            is ResultState.LOADING -> {
                LoadingBox()
            }

            is ResultState.SUCCESS -> {
                val productData = (state as ResultState.SUCCESS).products
                productResult = productData
            }

            is ResultState.ERROR -> {
                val errorException = (state as ResultState.ERROR).error
                ErrorBox(errorException)
            }
        }
        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = rememberImagePainter("https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes-thumbnail.png"),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Hi, KMP",
                            fontSize = MaterialTheme.typography.titleSmall.fontSize,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                        Text(
                            text = "Let's go shopping",
                            fontSize = MaterialTheme.typography.labelSmall.fontSize,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        )
                    }
                }
                /* Text(
                     text = "ShopXperience",
                     style = MaterialTheme.typography.titleMedium,
                     modifier = Modifier.padding(16.dp)
                 )*/

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
                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        modifier = Modifier.padding(8.dp).size(20.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        modifier = Modifier.padding(8.dp).size(20.dp),
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                    )
                }
            }
            productResult?.let { products ->
                ProductList(products)
            }

        }
    }
}