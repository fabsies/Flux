package com.example.flux.ui.theme.screens.reports

import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ReportsAndInsightsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        ExpenseReports()
        BudgetReports()
        SavingsProgress()
    }
}

@Composable
fun ExpenseReports() {
    Column(modifier = Modifier/*.weight(1f)*/) {
        Text(text = "Expense Reports", modifier = Modifier.padding(16.dp))
        // Here you would use a library to create charts, this is just a placeholder
        Text(text = "Chart goes here", modifier = Modifier.weight(1f))
    }
}

@Composable
fun BudgetReports() {
    Column(modifier = Modifier/*.weight(1f)*/) {
        Text(text = "Budget Reports", modifier = Modifier.padding(16.dp))
        // Here you would use a library to create charts, this is just a placeholder
        Text(text = "Chart goes here", modifier = Modifier.weight(1f))
    }
}

@Composable
fun SavingsProgress() {
    Column(modifier = Modifier/*.weight(1f)*/) {
        Text(text = "Savings Progress", modifier = Modifier.padding(16.dp))
        // Here you would use a library to create charts, this is just a placeholder
        Text(text = "Chart goes here", modifier = Modifier.weight(1f))
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewReportsAndInsightsScreen() {
    ReportsAndInsightsScreen(

    )
}
