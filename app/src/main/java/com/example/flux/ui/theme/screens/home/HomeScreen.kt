package com.example.flux.ui.theme.screens.home

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flux.R
import com.example.flux.navigation.ROUTE_BILL_INPUT
import com.example.flux.navigation.ROUTE_BUDGET_INPUT
import com.example.flux.navigation.ROUTE_EXPENSE_INPUT
import com.example.flux.navigation.ROUTE_VIEW_BILLS
import com.example.flux.navigation.ROUTE_VIEW_BUDGETS
import com.example.flux.navigation.ROUTE_VIEW_EXPENSES

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current.applicationContext

    @Composable
    fun PictureItem(imageResource: Int) {



    }
    Row {
//        Box (modifier = Modifier.fillMaxSize())
//        {
//            Image(painter = painterResource(id = R.drawable.colordollar),
//                contentDescription ="Background Image",
//                contentScale = ContentScale.FillBounds,
//                modifier = Modifier.matchParentSize())
//        }
        Text(text = "Manage Your Finances",
            color = Color.Magenta,
            fontFamily = FontFamily.Cursive,
            fontSize = 40.sp,
            modifier = Modifier.padding(start = 40.dp, top = 10.dp))
    }

    TextComponents(value ="Manage Your Finances" , size = 70.dp , colorValue = Color.Magenta)
    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                Row(
                    modifier = Modifier.padding(start = 50.dp, top = 80.dp)
                ) {
                    //Column1
                    //Add the main card here
                    Column {
                        Card(
                            modifier = Modifier
                                .height(100.dp)
                                .width(160.dp)

                        ) {


                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bill),
                                    contentDescription = "car10",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Button(onClick = {
                            navController.navigate(ROUTE_BILL_INPUT)
                        }, modifier = Modifier.padding(start = 20.dp)) {
                            Text(text = "Add Bill", color = Color.Magenta, fontFamily = FontFamily.Serif)
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Spacer(modifier = Modifier.height(5.dp))


                    }
                    //End of Column1
                    Spacer(modifier = Modifier.width(10.dp))

                    //Column1

                    Column {
                        Card(
                            modifier = Modifier
                                .height(100.dp)
                                .width(160.dp)

                        ) {

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.cash),
                                    contentDescription = "car10",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )

                            }

                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Button(onClick = {
                            navController.navigate(ROUTE_VIEW_BILLS)
                        }, modifier = Modifier.padding(start = 20.dp)) {
                            Text(text = "View Bills", color = Color.Magenta, fontFamily = FontFamily.Serif)
                        }
                        Spacer(modifier = Modifier.height(5.dp))


                        Spacer(modifier = Modifier.height(5.dp))


                    }
                }
                Row(
                    modifier = Modifier.padding(start = 50.dp)
                ) {
                    //Column1
                    //Add the main card here
                    Column {
                        Card(
                            modifier = Modifier
                                .height(100.dp)
                                .width(160.dp)

                        ) {

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.expense),
                                    contentDescription = "car10",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Button(onClick = {
                            navController.navigate(ROUTE_BUDGET_INPUT)
                        }, modifier = Modifier.padding(start = 20.dp)) {
                            Text(text = "Add Budget", color = Color.Magenta, fontFamily = FontFamily.Serif)
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Spacer(modifier = Modifier.height(5.dp))


                    }
                    //End of Column1
                    Spacer(modifier = Modifier.width(10.dp))

                    //Column1

                    Column {
                        Card(
                            modifier = Modifier
                                .height(100.dp)
                                .width(160.dp)

                        ) {

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.cashnotes),
                                    contentDescription = "car10",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Button(onClick = {
                            navController.navigate(ROUTE_VIEW_BUDGETS)
                        }, modifier = Modifier.padding(start = 20.dp)) {
                            Text(text = "View Budgets", color = Color.Magenta, fontFamily = FontFamily.Serif)
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Spacer(modifier = Modifier.height(5.dp))


                    }



                }
            Row(
                modifier = Modifier.padding(start = 50.dp)
            ) {
                //Column1
                //Add the main card here
                Column {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)

                    ) {

                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.coinstack),
                                contentDescription = "car10",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Button(onClick = {
                        navController.navigate(ROUTE_EXPENSE_INPUT)
                    }, modifier = Modifier.padding(start = 20.dp)) {
                        Text(text = "Add Expense", color = Color.Magenta, fontFamily = FontFamily.Serif)
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Spacer(modifier = Modifier.height(5.dp))


                }
                //End of Column1
                Spacer(modifier = Modifier.width(10.dp))

                //Column1

                Column {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)

                    ) {

                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.blackmoneybag),
                                contentDescription = "car10",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Button(onClick = {
                        navController.navigate(ROUTE_VIEW_EXPENSES)
                    }, modifier = Modifier.padding(start = 20.dp)) {
                        Text(text = "View Expenses", color = Color.Magenta, fontFamily = FontFamily.Serif)
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Spacer(modifier = Modifier.height(5.dp))


                }



            }

            }
        }
    }

@Composable
fun TextComponents(value: String, size: Dp, colorValue: Color) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            //.wrapContentWidth(align = Alignment.Start)
            .wrapContentHeight(align = Alignment.Top)
            .background(Color.Black)
            .border(width = 2.dp, color = Color.Black)
            .padding(18.dp),

        text = value,
        fontSize = size,
        color = colorValue
    )
}

fun Text(modifier: Modifier, text: String, fontSize: Dp, color: Color) {

}

@Composable
    @Preview(showSystemUi = true, showBackground = true)

    fun HomeScreenPreview() {
        HomeScreen(rememberNavController())
    }
