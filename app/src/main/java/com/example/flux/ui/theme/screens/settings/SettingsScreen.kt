package com.example.flux.ui.theme.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        AccountSettings()
        CurrencySettings()
        BackupAndSync()
    }
}

@Composable
fun AccountSettings() {
    Column(modifier = Modifier/*.weight(1f)*/) {
        Text(text = "Account Settings", modifier = Modifier.padding(16.dp))
        // Here you would add fields for users to manage their account details, preferences, and notifications
    }
}

@Composable
fun CurrencySettings() {
    Column(modifier = Modifier/*.weight(1f)*/) {
        Text(text = "Currency Settings", modifier = Modifier.padding(16.dp))
        // Here you would add a dropdown or other input for users to select their desired currency
    }
}

@Composable
fun BackupAndSync() {
    Column(modifier = Modifier/*.weight(1f)*/) {
        Text(text = "Backup and Sync", modifier = Modifier.padding(16.dp))
        // Here you would add options for users to back up their data and sync it across multiple devices if desired
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen()
}
