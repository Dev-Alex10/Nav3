package com.example.nav3.navigation

import nav3.composeapp.generated.resources.Res
import nav3.composeapp.generated.resources.outline_checklist_24
import nav3.composeapp.generated.resources.outline_favorite_24
import nav3.composeapp.generated.resources.outline_settings_24
import org.jetbrains.compose.resources.DrawableResource

data class BottomNavItem(
    val icon: DrawableResource,
    val title: String
)

val TOP_LEVEL_DESTINATIONS = mapOf(
    Route.Todo.TodoList to BottomNavItem(
        icon = Res.drawable.outline_checklist_24,
        title = "Todos"
    ),
    Route.Todo.TodoFavorites to BottomNavItem(
        icon = Res.drawable.outline_favorite_24,
        title = "Favorites"
    ),
    Route.Settings to BottomNavItem(
        icon = Res.drawable.outline_settings_24,
        title = "Settings"
    )
)