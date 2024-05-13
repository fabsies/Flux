package com.example.flux.ui.theme.screens.expenses

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flux.data.FluxViewModel
import com.example.flux.navigation.ROUTE_VIEW_BUDGETS


@Composable
fun ExpenseInput(navController: NavHostController) {
    var context = LocalContext.current
    var expenseAmount by remember { mutableStateOf(TextFieldValue("")) }
    var expenseCategory by remember { mutableStateOf(TextFieldValue("")) }
    var expenseDueDate by remember { mutableStateOf(TextFieldValue("")) }
    var expensePaymentMode by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier.border(
            width = 2.dp,
            color = Color.White,
            //shape = RoundedCornerShape(30.dp)
        )
    ) {

        TextComponent(value = "My Expenses", size = 30.sp, Color.Magenta)
        TextComponent(value = "Input expenses here", size = 15.sp, Color.Magenta)

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Expense category")

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Amount spent")

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Date and Time")

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Payment mode")

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {
                val expenseRepository = FluxViewModel(navController,context)
                expenseRepository.saveExpense(expenseAmount.text.trim(),
                    expenseCategory.text.trim(), expenseDueDate.text.trim(), expensePaymentMode.text.trim())
                navController.navigate(ROUTE_VIEW_BUDGETS)
                      },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "SAVE EXPENSE",
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
//        Button(
//            onClick = {/*TODO*/},
//            colors = ButtonDefaults.buttonColors(Color.Magenta),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(
//                modifier = Modifier.padding(10.dp),
//                text = "LAZY LAYOUT",
//                color = Color.Black
//            )
//        }
    }
}


@Composable
fun WelcomeBack() {
    Text(text = "Welcome Back")
}


@Composable
fun TextComponent(value: String, size: TextUnit, colorValue: Color) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            //.wrapContentWidth(align = Alignment.Start)
            .wrapContentHeight(align = Alignment.Top)
            .background(Color.DarkGray)
            .border(width = 1.dp, color = Color.White)
            .padding(18.dp),

        text = value,
        fontSize = size,
        color = colorValue
    )
}


@Composable
fun TextFieldsLabels(value: String) {
    Text(text = value)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(mylabel: String) {
    var text by remember {
        mutableStateOf(value = "")
    }

    TextField(modifier = Modifier.fillMaxWidth(), value = text, onValueChange = { newText ->
        text = newText
    }, label = {
        TextFieldsLabels(value = mylabel)
    }
    )
}

@Composable
fun CheckboxComponent(value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember {
            mutableStateOf(value = false)
        }
        Checkbox(checked = checkedState.value, onCheckedChange = {

        })
        TextFieldsLabels(value = value)
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ExpenseInputPreview(){
    ExpenseInput(rememberNavController())
}

