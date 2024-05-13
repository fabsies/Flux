package com.example.flux.ui.theme.screens.bills

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flux.data.FluxViewModel
import com.example.flux.models.Bills
import com.example.flux.navigation.ROUTE_UPDATE_BILLS




@Composable
fun ViewBillsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current
        val billsRepository = FluxViewModel(navController, context)
        val emptyBillsState = remember { mutableStateOf(Bills("","","","","")) }
        val emptyBillsListState = remember { mutableStateListOf<Bills>() }

        val bills = billsRepository.viewBill(emptyBillsState, emptyBillsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All bills",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Magenta)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(bills){
                    BillItem(
                        category = it.category,
                        amount = it.amount,
                        date = it.date,
                        mode = it.mode,
                        id = it.id,
                        navController = navController,
                        billRepository = billsRepository )
                }
            }
        }
    }

}



@Composable
fun BillItem(category:String, amount:String, date:String, mode:String,id:String,
                navController:NavHostController, billRepository:FluxViewModel) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = category)
        Text(text = amount)
        Text(text = date)
        Text(text = mode)
        Button(onClick = {
            billRepository.deleteBill(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_BILLS+"/$id")
        }) {
            Text(text = "Update")
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ViewBillsScreenPreview() {
    ViewBillsScreen(rememberNavController())

}


