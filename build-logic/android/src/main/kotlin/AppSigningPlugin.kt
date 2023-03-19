@file:Suppress("unused")

import com.android.build.api.dsl.ApkSigningConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.util.*

class AppSigningPlugin : Plugin<Project> {
    override fun apply(target: Project) = Unit
}

data class SignInConfig(
    val keystoreFile: File,
    val password: String,
    val alias: String,
    val aliasPassword: String,
)

enum class ServicesProvider {
    GOOGLE
}

fun loadSignConfig(
    directory: File,
    keystorePropertiesFile: File,
): SignInConfig? {
    if (!keystorePropertiesFile.exists()) return null

    val properties = Properties().apply {
        load(keystorePropertiesFile.inputStream())
    }
    val keystoreFilePath = properties.getProperty("keystore.path")
    val keystoreFile = File(directory, keystoreFilePath)
    val keystorePassword = properties.getProperty("keystore.password")
    val alias = properties.getProperty("keystore.alias")
    val aliasPassword = properties.getProperty("keystore.alias.password")

    return SignInConfig(
        keystoreFile,
        keystorePassword,
        alias,
        aliasPassword,
    )
}

@Suppress("UnstableApiUsage")
fun ApkSigningConfig.signWithProperties(
    keystorePropertiesFile: File,
//    servicesProvider: ServicesProvider = ServicesProvider.GOOGLE,
) {
    val directory = keystorePropertiesFile.parentFile.apply { mkdirs() }
    val signingConfig = loadSignConfig(directory, keystorePropertiesFile)
        ?: return

    storeFile = signingConfig.keystoreFile
    storePassword = signingConfig.password
    keyAlias = signingConfig.alias
    keyPassword = signingConfig.aliasPassword
}
