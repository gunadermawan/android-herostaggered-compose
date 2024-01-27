package com.gun.herolist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gun.herolist.model.HeroesData
import com.gun.herolist.ui.theme.HerolistTheme


@Composable
fun HeroApp() {
    Box(modifier = Modifier) {
        LazyColumn() {
            items(HeroesData.heroes, key = { it.id }) {
                HeroesItem(name = it.name, photoUrl = it.photoUrl)
            }
        }
    }
}

@Composable
fun HeroesItem(name: String, photoUrl: String, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = photoUrl, contentDescription = null, modifier = modifier
                .padding(8.dp)
                .clip(
                    CircleShape
                )
                .size(60.dp)
        )
        Text(
            text = name,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroesItemPrev() {
    HerolistTheme {
        HeroesItem("Pangeran Diponegoro", "")
    }
}

@Preview(showBackground = true)
@Composable
fun HeroAppPrev() {
    HerolistTheme {
        HeroApp()
    }
}