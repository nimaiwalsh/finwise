package com.finwise.android.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.finwise.core.ui.R
import com.finwise.core.ui.theme.AppIcons
import com.finwise.feature.calculators.CALCULATORS_ROUTE
import com.finwise.feature.financialposition.FinancialPositionScreen
import com.finwise.feature.home.HOME_ROUTE
import com.finwise.feature.newsfeed.NEWSFEED_ROUTE

/**
 * Top level destinations used for Bottom App Bar Navigation on the [MAIN_GRAPH].
 */
sealed class TopLevelDestination(
    val route: String,
    val title: Int? = null,
    val selectedIcon: ImageVector? = null,
    val unselectedIcon: ImageVector? = null,
) {
    object Home : TopLevelDestination(
        route = HOME_ROUTE,
        title = R.string.home,
        selectedIcon = AppIcons.HomeFilled,
        unselectedIcon = AppIcons.HomeOutlined,
    )

    object Calculators : TopLevelDestination(
        route = CALCULATORS_ROUTE,
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
        route = NEWSFEED_ROUTE,
        title = R.string.news,
        selectedIcon = AppIcons.NewsFilled,
        unselectedIcon = AppIcons.NewsOutlined,
    )
}
