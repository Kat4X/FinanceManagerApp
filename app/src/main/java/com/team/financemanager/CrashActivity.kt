package com.team.financemanager

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BugReport
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.team.core.common.GlobalExceptionHandler
import com.team.core.design.theme.StellarisTheme
import timber.log.Timber

class CrashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalExceptionHandler.getThrowableFromIntent(intent).let {
            Timber.e("ErrorDataLog: $it")
        }

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            StellarisTheme {
                BoxWithConstraints {
                    CrashScreen(
                        onClick = ::reportErrorData,
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }
        }
    }

    private fun reportErrorData() {
        // TODO set error
        finishAffinity()
        startActivity(Intent(this, MainActivity::class.java))
    }
}

@Composable
fun CrashScreen(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    // Remember a SystemUiController
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        // Update all the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons,
        )

        // setStatusBarColor() and setNavigationBarColor() also exist

        onDispose {}
    }

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = Icons.Rounded.BugReport,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.size(32.dp),
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Непредвиденная ошибка",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Spacer(modifier = Modifier.padding(6.dp))
        Text(
            text = "TODO сделать извинения и попросить зарепортить",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = onClick, shape = RoundedCornerShape(10.dp)) {
            Text(
                text = "Report and restart",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(name = "phone", device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480")
@Composable
fun PreviewCrashScreen() {
    StellarisTheme {
        BoxWithConstraints {
            CrashScreen(
                onClick = {},
            )
        }
    }
}
