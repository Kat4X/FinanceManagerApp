package com.team.core.designsystem.theme

import android.os.Build
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.team.designsystem.theme.*
import com.team.designsystem.theme.BaseTypography
import com.team.designsystem.theme.Blue10
import com.team.designsystem.theme.Blue20
import com.team.designsystem.theme.Blue30
import com.team.designsystem.theme.Blue40
import com.team.designsystem.theme.Blue80
import com.team.designsystem.theme.Blue90
import com.team.designsystem.theme.Blue95
import com.team.designsystem.theme.DarkGreen10
import com.team.designsystem.theme.DarkGreen20
import com.team.designsystem.theme.DarkGreen30
import com.team.designsystem.theme.DarkGreen40
import com.team.designsystem.theme.DarkGreen80
import com.team.designsystem.theme.DarkGreen90
import com.team.designsystem.theme.DarkGreenGray10
import com.team.designsystem.theme.DarkGreenGray90
import com.team.designsystem.theme.DarkGreenGray95
import com.team.designsystem.theme.DarkGreenGray99
import com.team.designsystem.theme.DarkPurpleGray10
import com.team.designsystem.theme.DarkPurpleGray90
import com.team.designsystem.theme.DarkPurpleGray95
import com.team.designsystem.theme.DarkPurpleGray99
import com.team.designsystem.theme.Green10
import com.team.designsystem.theme.Green20
import com.team.designsystem.theme.Green30
import com.team.designsystem.theme.Green40
import com.team.designsystem.theme.Green80
import com.team.designsystem.theme.Green90
import com.team.designsystem.theme.GreenGray30
import com.team.designsystem.theme.GreenGray50
import com.team.designsystem.theme.GreenGray60
import com.team.designsystem.theme.GreenGray80
import com.team.designsystem.theme.GreenGray90
import com.team.designsystem.theme.Orange10
import com.team.designsystem.theme.Orange20
import com.team.designsystem.theme.Orange30
import com.team.designsystem.theme.Orange40
import com.team.designsystem.theme.Orange80
import com.team.designsystem.theme.Orange90
import com.team.designsystem.theme.Orange95
import com.team.designsystem.theme.Purple10
import com.team.designsystem.theme.Purple20
import com.team.designsystem.theme.Purple30
import com.team.designsystem.theme.Purple40
import com.team.designsystem.theme.Purple80
import com.team.designsystem.theme.Purple90
import com.team.designsystem.theme.Purple95
import com.team.designsystem.theme.PurpleGray30
import com.team.designsystem.theme.PurpleGray50
import com.team.designsystem.theme.PurpleGray60
import com.team.designsystem.theme.PurpleGray80
import com.team.designsystem.theme.PurpleGray90
import com.team.designsystem.theme.Red10
import com.team.designsystem.theme.Red20
import com.team.designsystem.theme.Red30
import com.team.designsystem.theme.Red40
import com.team.designsystem.theme.Red80
import com.team.designsystem.theme.Red90
import com.team.designsystem.theme.Teal10
import com.team.designsystem.theme.Teal20
import com.team.designsystem.theme.Teal30
import com.team.designsystem.theme.Teal40
import com.team.designsystem.theme.Teal80
import com.team.designsystem.theme.Teal90


/**
 * Light default theme color scheme
 */
@VisibleForTesting
val LightDefaultColorScheme = lightColorScheme(
    primary = Purple40,
    onPrimary = Color.White,
    primaryContainer = Purple90,
    onPrimaryContainer = Purple10,
    secondary = Orange40,
    onSecondary = Color.White,
    secondaryContainer = Orange90,
    onSecondaryContainer = Orange10,
    tertiary = Blue40,
    onTertiary = Color.White,
    tertiaryContainer = Blue90,
    onTertiaryContainer = Blue10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = DarkPurpleGray99,
    onBackground = DarkPurpleGray10,
    surface = DarkPurpleGray99,
    onSurface = DarkPurpleGray10,
    surfaceVariant = PurpleGray90,
    onSurfaceVariant = PurpleGray30,
    outline = PurpleGray50
)

/**
 * Dark default theme color scheme
 */
@VisibleForTesting
val DarkDefaultColorScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = Purple20,
    primaryContainer = Purple30,
    onPrimaryContainer = Purple90,
    secondary = Orange80,
    onSecondary = Orange20,
    secondaryContainer = Orange30,
    onSecondaryContainer = Orange90,
    tertiary = Blue80,
    onTertiary = Blue20,
    tertiaryContainer = Blue30,
    onTertiaryContainer = Blue90,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = DarkPurpleGray10,
    onBackground = DarkPurpleGray90,
    surface = DarkPurpleGray10,
    onSurface = DarkPurpleGray90,
    surfaceVariant = PurpleGray30,
    onSurfaceVariant = PurpleGray80,
    outline = PurpleGray60
)

/**
 * Light Android theme color scheme
 */
@VisibleForTesting
val LightAndroidColorScheme = lightColorScheme(
    primary = Green40,
    onPrimary = Color.White,
    primaryContainer = Green90,
    onPrimaryContainer = Green10,
    secondary = DarkGreen40,
    onSecondary = Color.White,
    secondaryContainer = DarkGreen90,
    onSecondaryContainer = DarkGreen10,
    tertiary = Teal40,
    onTertiary = Color.White,
    tertiaryContainer = Teal90,
    onTertiaryContainer = Teal10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = DarkGreenGray99,
    onBackground = DarkGreenGray10,
    surface = DarkGreenGray99,
    onSurface = DarkGreenGray10,
    surfaceVariant = GreenGray90,
    onSurfaceVariant = GreenGray30,
    outline = GreenGray50
)

/**
 * Dark Android theme color scheme
 */
@VisibleForTesting
val DarkAndroidColorScheme = darkColorScheme(
    primary = Green80,
    onPrimary = Green20,
    primaryContainer = Green30,
    onPrimaryContainer = Green90,
    secondary = DarkGreen80,
    onSecondary = DarkGreen20,
    secondaryContainer = DarkGreen30,
    onSecondaryContainer = DarkGreen90,
    tertiary = Teal80,
    onTertiary = Teal20,
    tertiaryContainer = Teal30,
    onTertiaryContainer = Teal90,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = DarkGreenGray10,
    onBackground = DarkGreenGray90,
    surface = DarkGreenGray10,
    onSurface = DarkGreenGray90,
    surfaceVariant = GreenGray30,
    onSurfaceVariant = GreenGray80,
    outline = GreenGray60
)

/**
 * Light default gradient colors
 */
val LightDefaultGradientColors = GradientColors(
    primary = Purple95,
    secondary = Orange95,
    tertiary = Blue95,
    neutral = DarkPurpleGray95
)

/**
 * Light Android background theme
 */
val LightAndroidBackgroundTheme = BackgroundTheme(color = DarkGreenGray95)

/**
 * Dark Android background theme
 */
val DarkAndroidBackgroundTheme = BackgroundTheme(color = Color.Black)

/**
 * Now in Android theme.
 *
 * The order of precedence for the color scheme is: Dynamic color > Android theme > Default theme.
 * Dark theme is independent as all the aforementioned color schemes have light and dark versions.
 * The default theme color scheme is used by default.
 *
 * @param darkTheme Whether the theme should use a dark color scheme (follows system by default).
 * @param dynamicColor Whether the theme should use a dynamic color scheme (Android 12+ only).
 * @param androidTheme Whether the theme should use the Android theme color scheme.
 */
@Composable
fun FMTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    androidTheme: Boolean = false,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            } else {
                if (darkTheme) DarkDefaultColorScheme else LightDefaultColorScheme
            }
        }
        androidTheme -> if (darkTheme) DarkAndroidColorScheme else LightAndroidColorScheme
        else -> if (darkTheme) DarkDefaultColorScheme else LightDefaultColorScheme
    }

    val defaultGradientColors = GradientColors()
    val gradientColors = when {
        dynamicColor -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                defaultGradientColors
            } else {
                if (darkTheme) defaultGradientColors else LightDefaultGradientColors
            }
        }
        androidTheme -> defaultGradientColors
        else -> if (darkTheme) defaultGradientColors else LightDefaultGradientColors
    }

    val defaultBackgroundTheme = BackgroundTheme(
        color = colorScheme.surface,
        tonalElevation = 2.dp
    )
    val backgroundTheme = when {
        dynamicColor -> defaultBackgroundTheme
        androidTheme -> if (darkTheme) DarkAndroidBackgroundTheme else LightAndroidBackgroundTheme
        else -> defaultBackgroundTheme
    }

    CompositionLocalProvider(
        LocalGradientColors provides gradientColors,
        LocalBackgroundTheme provides backgroundTheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = BaseTypography,
            content = content
        )
    }
}
