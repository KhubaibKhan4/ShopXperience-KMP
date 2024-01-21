package org.shop.app.navigations.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import org.shop.app.data.model.ProductsItem

@Composable
fun ProductList(products: List<ProductsItem>) {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "New Arrivals",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "See All",
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.End,
                    color = Color.Blue.copy(0.75f)
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Adaptive(150.dp),
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                state = rememberLazyGridState(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(products) { productItems ->
                    ProductItem(productItems)
                }
            }
        }
    }
}

@Composable
fun ProductItem(
    productsItem: ProductsItem
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(6.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(255.dp)
                .height(185.dp)
                .clip(shape = RoundedCornerShape(12.dp))
        ) {
            Image(
                painter = rememberImagePainter(productsItem.images[0]),
                contentDescription = null
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp, end = 8.dp)
                    .size(25.dp)
                    .clip(
                        shape = CircleShape
                    )
                    .background(color = Color.DarkGray.copy(0.45f))
                    .align(alignment = Alignment.TopEnd),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 6.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = productsItem.title,
                fontSize = MaterialTheme.typography.titleSmall.fontSize,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = Color.Black,
                maxLines = 1
            )
            Text(
                text = productsItem.category.name,
                fontSize = MaterialTheme.typography.labelMedium.fontSize,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                color = Color.LightGray
            )
            Text(
                text = "$" + productsItem.price,
                fontSize = MaterialTheme.typography.titleSmall.fontSize,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
    }
}