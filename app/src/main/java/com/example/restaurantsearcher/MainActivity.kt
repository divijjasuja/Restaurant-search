package com.example.restarountsearcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restaurantsearcher.R
import com.example.restaurantsearcher.ui.theme.RestaurantSearcherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantSearcherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SearchBar()
                }
            }
        }
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text(text = "Restaurant name or a Dish", fontSize = 20.sp) },
        modifier = Modifier
            .wrapContentHeight(Alignment.Top)
            .padding(top = 30.dp, start = 10.dp, end = 10.dp)
            .width(10.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        shape = RoundedCornerShape(30.dp),
        singleLine = true
    )
}

@Composable
fun restaurantCards(name: String, Description: String, cost: Int, rating: Float) {
    Box(
        modifier = Modifier
            .padding(top = 150.dp)
    ) {
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(190.dp)
                .padding(start = 5.dp, end = 5.dp)
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.chai_point),
                    contentDescription = "Restaurant image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(120.dp)
                )
                Row(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 25.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column() {
                        Text(
                            text = name,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif
                        )
                        Text(
                            text = Description,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif
                        )
                    }
                    Column(modifier = Modifier
                        .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween) {
                        Text(text = rating.toString(), fontSize = 20.sp, modifier = Modifier.padding(top = 10.dp))
                        Text(text = cost.toString(), fontSize = 15.sp,modifier = Modifier.padding(bottom = 10.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    RestaurantSearcherTheme {
        SearchBar()
        restaurantCards(name = "Chai Point", Description = "Best tea", cost = 10, rating = 5.0f)
    }
}