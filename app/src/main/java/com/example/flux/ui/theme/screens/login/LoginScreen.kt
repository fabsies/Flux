package com.example.flux.ui.theme.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flux.data.AuthViewModel
import com.example.flux.navigation.ROUTE_HOME
import com.example.flux.navigation.ROUTE_REGISTER

@Composable
fun LoginScreen(navController: NavController) {
//type navController:NavHostController inside the parenthesis
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Login here",
            color = Color.Magenta,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =email , onValueChange = {email=it},
            label = { Text(text = "Enter Email", color = Color.Black) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =pass , onValueChange = {pass=it},
            label = { Text(text = "Enter Password", color = Color.Black) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val mylogin = AuthViewModel(navController, context)
            mylogin.login(email.text.trim(),pass.text.trim())
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Log In")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
           navController.navigate(ROUTE_REGISTER)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Don't have account? Click to Register")
        }

    }


}


@Preview
@Composable
fun Loginpage() {
    LoginScreen(rememberNavController())
}