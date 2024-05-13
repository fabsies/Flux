package com.example.flux.ui.theme.screens.bills


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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.createBitmap
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flux.R
import com.example.flux.data.FluxViewModel
import com.example.flux.navigation.ROUTE_VIEW_BILLS
import com.google.firebase.database.core.Context


@Composable
fun BillInput(navController: NavHostController) {

    var context = LocalContext.current
    var billAmount by remember { mutableStateOf(TextFieldValue("")) }
    var billCategory by remember { mutableStateOf(TextFieldValue("")) }
    var billDueDate by remember { mutableStateOf(TextFieldValue("")) }
    var billPaymentMode by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier.border(
            width = 2.dp,
            color = Color.White,
            //shape = RoundedCornerShape(30.dp)
        )
    ) {
        Box (modifier = Modifier.background(color = Color.Gray))
        {
//            Image(painter = painterResource(id = R.drawable.colordollar),
//                contentDescription ="Background Image",
//                contentScale = ContentScale.FillBounds,
//                modifier = Modifier.matchParentSize())
        }

        TextComponent(value = "My Bills", size = 30.sp, Color.Magenta)
        TextComponent(value = "Input bills here", size = 15.sp, Color.Magenta)

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Bill category")

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Amount spent")

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Date and Time")

        Spacer(modifier = Modifier.height(25.dp))

        TextFieldComponent("Payment mode")

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {
                val billRepository = FluxViewModel(navController,context)
                billRepository.saveBill(billAmount.text.trim(),
                    billCategory.text.trim(), billDueDate.text.trim(), billPaymentMode.text.trim())
                navController.navigate(ROUTE_VIEW_BILLS)
            },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "SAVE BILL",
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
    }
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
@Preview(showBackground = true, showSystemUi = true)
fun BillInputPreview(){
    BillInput(rememberNavController())
}

