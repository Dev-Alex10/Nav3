package com.example.nav3.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.example.nav3.auth.AuthNavigation
import com.example.nav3.todo.TodoNavigation
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun NavigationRoot(modifier: Modifier = Modifier) {
    val rootBackStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.Auth::class, Route.Auth.serializer())
                    subclass(Route.Todo::class, Route.Todo.serializer())
                }
            }
        },
        Route.Auth
    )
    NavDisplay(
        modifier = modifier,
        backStack = rootBackStack,
        transitionSpec = {
            fadeIn(animationSpec = tween(durationMillis = 1000)) togetherWith
                    fadeOut(animationSpec = tween(durationMillis = 1000))
        },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Route.Auth> {
                AuthNavigation(
                    onLogin = {
                        rootBackStack.remove(Route.Auth)
                        rootBackStack.add(Route.Todo)
                    }
                )
            }
            entry<Route.Todo> {
                TodoNavigation()
            }
        }
    )
}