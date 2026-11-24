package com.prashantlatta.chimeflow.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private enum class Destination(val label: String) {
    Dashboard("Home"), Chimes("Chimes"), Schedule("Schedule"), SoundVoice("Sound"), Settings("Settings")
}

@Composable
fun ChimeFlowApp() {
    var selected by remember { mutableIntStateOf(0) }
    var isRunning by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selected == index,
                        onClick = { selected = index },
                        icon = {},
                        label = { Text(destination.label) }
                    )
                }
            }
        }
    ) { padding ->
        when (Destination.entries[selected]) {
            Destination.Dashboard -> DashboardScreen(
                isRunning = isRunning,
                onToggle = { isRunning = !isRunning },
                modifier = Modifier.padding(padding)
            )
            Destination.Chimes -> PlaceholderScreen("Chimes", "Independent chime slots will be implemented in Phase 2.", Modifier.padding(padding))
            Destination.Schedule -> PlaceholderScreen("Schedule", "Daily and weekly active periods will be implemented in Phase 2.", Modifier.padding(padding))
            Destination.SoundVoice -> PlaceholderScreen("Sound & Voice", "Sound, Android TTS and vibration controls will be implemented in Phase 4.", Modifier.padding(padding))
            Destination.Settings -> PlaceholderScreen("Settings", "Theme, language, permissions and backup settings will be implemented in upcoming phases.", Modifier.padding(padding))
        }
    }
}

@Composable
private fun DashboardScreen(
    isRunning: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(Modifier.height(18.dp))
            Text("ChimeFlow", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text("A calm, reliable hourly chime", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(Modifier.padding(22.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("NEXT CHIME", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("--:--", style = MaterialTheme.typography.displayMedium, fontWeight = FontWeight.Light)
                    Text("Scheduling engine is not connected yet.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Column {
                    Text(if (isRunning) "Session active" else "Session stopped", fontWeight = FontWeight.SemiBold)
                    Text("UI preview only", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
                if (isRunning) {
                    OutlinedButton(onClick = onToggle) { Text("Stop") }
                } else {
                    Button(onClick = onToggle) { Text("Start") }
                }
            }
        }
        item {
            Text("Your chimes", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
            Card {
                Column(Modifier.padding(16.dp)) {
                    Text("No chime slots yet")
                    Text("Create independent schedules in the Chimes section.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
        item { Spacer(Modifier.height(12.dp)) }
    }
}

@Composable
private fun PlaceholderScreen(title: String, description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Text(description, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text("This section is a planned placeholder, not a finished feature.", style = MaterialTheme.typography.labelMedium)
    }
}
