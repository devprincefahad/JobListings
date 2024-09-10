package dev.prince.joblistings.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import dagger.hilt.android.AndroidEntryPoint
import dev.prince.joblistings.ui.components.bottomnav.BottomBar
import dev.prince.joblistings.ui.theme.JobListingsTheme
import dev.prince.joblistings.util.shouldShowBottomBar

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JobListingsTheme {

                ScaffoldDefaults.contentWindowInsets

                val engine = rememberNavHostEngine()
                val navController = engine.rememberNavController()
                val destination = navController.appCurrentDestinationAsState().value
                    ?: NavGraphs.root.startRoute.startAppDestination

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (destination.shouldShowBottomBar()) {
                            BottomBar(navController)
                        }
                    }
                ) { padding ->
                    Surface {
                        DestinationsNavHost(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding),
                            navGraph = NavGraphs.root,
                            navController = navController,
                            engine = engine
                        )
                    }
                }
            }
        }
    }
}
