package com.example.flux.ui.theme.screens.budgets


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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flux.data.FluxViewModel
import com.example.flux.navigation.ROUTE_VIEW_BILLS
import com.example.flux.navigation.ROUTE_VIEW_BUDGETS


@Composable
fun BudgetInput(navController: NavHostController) {
    var context = LocalContext.current
    var budgetAmount by remember { mutableStateOf(TextFieldValue("")) }
    var budgetCategory by remember { mutableStateOf(TextFieldValue("")) }
    var budgetSetDate by remember { mutableStateOf(TextFieldValue("")) }
    var budgetPaymentMode by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier.border(
            width = 2.dp,
            color = Color.White,
            //shape = RoundedCornerShape(30.dp)
        )
    ) {

        TextComponent(value = "My Budgets", size = 30.sp, Color.Magenta)
        TextComponent(value = "Input budget here", size = 15.sp, Color.Magenta)

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Category")

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Planned amount")

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Due date")

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Payment mode")

        Spacer(modifier = Modifier.height(25.dp))

        // CheckboxComponent("I confirm to have read and agree to the policy, terms and Conditions")

//        Button(
//            onClick = { /*TODO*/ }, modifier = Modifier
//                .fillMaxWidth()
//                .padding(30.dp)
//        ) {
//            Text(modifier = Modifier.padding(10.dp), text = "SAVE EXPENSE")
//
//        }

        Button(
            onClick = {
                val budgetRepository = FluxViewModel(navController,context)
                budgetRepository.saveBudget(budgetAmount.text.trim(),
                    budgetCategory.text.trim(), budgetSetDate.text.trim(), budgetPaymentMode.text.trim())
                navController.navigate(ROUTE_VIEW_BUDGETS)
                      },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "SAVE BUDGET",
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
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
fun BudgetInputPreview(){
    BudgetInput(rememberNavController())
}

