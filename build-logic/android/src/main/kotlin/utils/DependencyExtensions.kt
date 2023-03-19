package utils

import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.implementation(dependencyNotification: Any) =
    add("implementation", dependencyNotification)


fun DependencyHandlerScope.testImplementation(dependencyNotification: Any) =
    add("testImplementation", dependencyNotification)


fun DependencyHandlerScope.androidTestImplementation(dependencyNotification: Any) =
    add("androidTestImplementation", dependencyNotification)


fun DependencyHandlerScope.androidTestUtil(dependencyNotification: Any) =
    add("androidTestUtil", dependencyNotification)
