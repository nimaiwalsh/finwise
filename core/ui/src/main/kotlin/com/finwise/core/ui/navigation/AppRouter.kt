package com.finwise.core.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.finwise.core.ui.R
import com.finwise.core.ui.theme.AppIcons

private object Route {
    // Login NavGraph Routes
    const val AUTH = "auth"
    const val LOGIN = "login"
    const val REGISTER = "register"

    // Main NavGraph Routes
    const val MAIN = "main"
    const val HOME = "home"
    const val CALCULATORS = "calculators"
    const val NEWS_FEED = "newsFeed"
    const val FINANCIAL_POSITION = "financialPosition"
    const val FINANCIAL_POSITION_DETAIL = "financialPosition/{${ArgParams.FINANCIAL_POSITION_ID}}"
}

object ArgParams {
    const val FINANCIAL_POSITION_ID = "financialPositionId"

    fun toPath(param: String) = "{${param}}"
}

sealed class AppScreen(val route: String, val navArguments: List<NamedNavArgument> = emptyList()) {

    // Login NavGraph
    object Auth : AppScreen(Route.AUTH) {
        object Login : AppScreen(Route.LOGIN)
        object Register : AppScreen(Route.REGISTER)
    }

    // Main NavGraph
    object Main : TopLevelDestination(Route.MAIN) {
        object Home : TopLevelDestination(
            route = Route.HOME,
            title = R.string.home,
            selectedIcon = AppIcons.HomeFilled,
            unselectedIcon = AppIcons.HomeOutlined,
        )

        object Calculators : TopLevelDestination(
            route = Route.CALCULATORS,
            title = R.string.calculators,
            selectedIcon = AppIcons.CalculatorFilled,
            unselectedIcon = AppIcons.CalculatorOutlined,
        )

        object FinancialPosition : TopLevelDestination(
            route = Route.FINANCIAL_POSITION,
            title = R.string.financialPosition,
            selectedIcon = AppIcons.MoneyFilled,
            unselectedIcon = AppIcons.MoneyOutlined,
        )

        object NewsFeed : TopLevelDestination(
            route = Route.NEWS_FEED,
            title = R.string.news,
            selectedIcon = AppIcons.NewsFilled,
            unselectedIcon = AppIcons.NewsOutlined,
        )
    }

    object FinancialPositionDetail : AppScreen(
        route = Route.FINANCIAL_POSITION_DETAIL,
        navArguments = listOf(
            navArgument(ArgParams.FINANCIAL_POSITION_ID) { type = NavType.Companion.StringType },
        ),
    ) {
        fun createRoute(financialPositionId: String) =
            Route.FINANCIAL_POSITION_DETAIL
                .replace(ArgParams.toPath(ArgParams.FINANCIAL_POSITION_ID), financialPositionId)
    }
}

sealed class TopLevelDestination(
    val route: String,
    val title: Int? = null,
    val selectedIcon: ImageVector? = null,
    val unselectedIcon: ImageVector? = null,
    val navArguments: List<NamedNavArgument> = emptyList(),
)
