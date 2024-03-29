package com.finwise.android.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import com.finwise.core.ui.R
import com.finwise.core.ui.theme.AppIcons
import com.finwise.feature.calculators.CalculatorScreen
import com.finwise.feature.financialposition.FinancialPositionScreen
import com.finwise.feature.home.navigation.HomeScreen
import com.finwise.feature.login.navigation.AuthScreen
import com.finwise.feature.newsfeed.NewsScreen

private object Route {
    const val MAIN = "main"
}
sealed class AppScreen(val route: String, val navArguments: List<NamedNavArgument> = emptyList()) {

    // Login NavGraph
    object Auth : AppScreen(AuthScreen.Graph.route)

    // Main NavGraph
    object Main : TopLevelDestination(Route.MAIN) {
        object Home : TopLevelDestination(
            route = HomeScreen.Home.route,
            title = R.string.home,
            selectedIcon = AppIcons.HomeFilled,
            unselectedIcon = AppIcons.HomeOutlined,
        )

        object Calculators : TopLevelDestination(
            route = CalculatorScreen.Calculators.route,
            title = R.string.calculators,
            selectedIcon = AppIcons.CalculatorFilled,
            unselectedIcon = AppIcons.CalculatorOutlined,
        )

        object FinancialPosition : TopLevelDestination(
            route = FinancialPositionScreen.Overview.route,
            title = R.string.financialPosition,
            selectedIcon = AppIcons.MoneyFilled,
            unselectedIcon = AppIcons.MoneyOutlined,
        )

        object NewsFeed : TopLevelDestination(
            route = NewsScreen.NewsList.route,
            title = R.string.news,
            selectedIcon = AppIcons.NewsFilled,
            unselectedIcon = AppIcons.NewsOutlined,
        )
    }
}

sealed class TopLevelDestination(
    val route: String,
    val title: Int? = null,
    val selectedIcon: ImageVector? = null,
    val unselectedIcon: ImageVector? = null,
    val navArguments: List<NamedNavArgument> = emptyList(),
)
