package com.example.nav3.todo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.nav3.navigation.Navigator
import com.example.nav3.navigation.Route
import com.example.nav3.navigation.TOP_LEVEL_DESTINATIONS
import com.example.nav3.navigation.TodoNavigationBar
import com.example.nav3.navigation.rememberNavigationState
import com.example.nav3.navigation.toEntries
import com.example.nav3.settings.SettingsScreen
import com.example.nav3.todo.screens.TodoDetailScreen
import com.example.nav3.todo.screens.TodoListScreen

@Composable
fun TodoNavigation(
    modifier: Modifier = Modifier
) {
    val navigationState = rememberNavigationState(
        startRoute = Route.Todo.TodoList,
        topLevelRoutes = TOP_LEVEL_DESTINATIONS.keys
    )
    val navigator = remember {
        Navigator(navigationState)
    }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            TodoNavigationBar(
                selectedKey = navigationState.topLevelRoute,
                onSelectKey = {
                    navigator.navigate(it)
                }
            )
        }
    ) { innerPadding ->
        NavDisplay(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            onBack = navigator::goBack,
            entries = navigationState.toEntries(
                entryProvider {
                    entry<Route.Todo.TodoList> {
                        TodoListScreen(
                            onTodoClick = {
                                navigator.navigate(Route.Todo.TodoDetail(it))
                            }
                        )
                    }
                    entry<Route.Todo.TodoFavorites> {
                        TodoListScreen(
                            onTodoClick = {
                                navigator.navigate(Route.Todo.TodoDetail(it))
                            }
                        )
                    }
                    entry<Route.Todo.TodoDetail> {
                        TodoDetailScreen(
                            todo = it.todo
                        )
                    }

                    entry<Route.Settings> {
                        SettingsScreen()
                    }
                }
            ),
        )
    }
}