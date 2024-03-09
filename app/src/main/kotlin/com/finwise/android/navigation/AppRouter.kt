package com.finwise.android.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

class AppRouter {
    private object Route {
        const val LOGIN = "login"
        const val HOME = "home"
        const val CALCULATORS = "calculators"
        const val FINANCIAL_POSITION = "financial_position/{${ArgParams.FINANCIAL_POSITION_ID}}"
    }

    object ArgParams {
        const val FINANCIAL_POSITION_ID = "financialPositionId"

        fun toPath(param: String) = "{${param}}"
    }

    sealed class Screen(val route: String, val navArguments: List<NamedNavArgument> = emptyList()) {
        object Login : Screen(Route.LOGIN)
        object Home : Screen(Route.HOME)
        object Calculators : Screen(Route.CALCULATORS)

        object FinancialPosition : Screen(
            route = Route.FINANCIAL_POSITION,
            navArguments = listOf(
                navArgument(ArgParams.FINANCIAL_POSITION_ID) { type = NavType.Companion.StringType },
            ),
        ) {
            fun createRoute(financialPositionId: String) =
                Route.FINANCIAL_POSITION
                    .replace(ArgParams.toPath(ArgParams.FINANCIAL_POSITION_ID), financialPositionId)
        }
    }
}
