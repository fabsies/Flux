package com.example.flux.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flux.ui.theme.screens.bills.BillInput
import com.example.flux.ui.theme.screens.bills.ViewBillsScreen
import com.example.flux.ui.theme.screens.budgets.BudgetInput
import com.example.flux.ui.theme.screens.budgets.ViewBudgetsScreen
import com.example.flux.ui.theme.screens.expenses.ExpenseInput
import com.example.flux.ui.theme.screens.expenses.ViewExpensesScreen
import com.example.flux.ui.theme.screens.home.HomeScreen
import com.example.flux.ui.theme.screens.login.LoginScreen
import com.example.flux.ui.theme.screens.register.RegisterScreen
import com.example.flux.ui.theme.screens.reports.ReportsAndInsightsScreen
import com.example.flux.ui.theme.screens.settings.SettingsScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination: String = ROUTE_REGISTER){
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_BILL_INPUT) {
            BillInput(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_BUDGET_INPUT) {
            BudgetInput(navController)
        }
        composable(ROUTE_EXPENSE_INPUT) {
            ExpenseInput(navController)
        }

        composable(ROUTE_REPORTS) {
            ReportsAndInsightsScreen()
        }
        composable(ROUTE_SETTINGS){
            SettingsScreen()
        }
        composable(ROUTE_VIEW_BILLS){
            ViewBillsScreen(navController)
        }
        composable(ROUTE_UPDATE_BILLS){
            ViewBillsScreen(navController)
        }
        composable(ROUTE_VIEW_EXPENSES){
            ViewExpensesScreen(navController)
        }
        composable(ROUTE_UPDATE_EXPENSES){
            ViewExpensesScreen(navController)
        }
        composable(ROUTE_VIEW_BUDGETS){
            ViewBudgetsScreen(navController)
        }
        composable(ROUTE_UPDATE_BUDGETS){
            ViewBudgetsScreen(navController )
        }
    }
}
