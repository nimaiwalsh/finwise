package com.finwise.android.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.finwise.core.ui.R
import com.finwise.core.ui.theme.AppIcons
import com.finwise.feature.calculators.home.CalculatorsDestination
import com.finwise.feature.financialposition.overview.FinancialPositionDestination
import com.finwise.feature.home.HomeDestination
import com.finwise.feature.newsfeed.NewsFeedDestination

/**
 * Top level destinations used for Bottom App Bar Navigation on the [MAIN_GRAPH].
 */
sealed class TopLevelDestination(
    val route: String,
    val title: Int? = null,
    val selectedIcon: ImageVector? = null,
    val unselectedIcon: ImageVector? = null,
) {
    data object Home : TopLevelDestination(
        route = HomeDestination::class.qualifiedName.toString(),
        title = R.string.home,
        selectedIcon = AppIcons.HomeFilled,
        unselectedIcon = AppIcons.HomeOutlined,
    )

    data object Calculators : TopLevelDestination(
        route = CalculatorsDestination::class.qualifiedName.toString(),
        title = R.string.calculators,
        selectedIcon = AppIcons.CalculatorFilled,
        unselectedIcon = AppIcons.CalculatorOutlined,
    )

    data object FinancialPosition : TopLevelDestination(
        route = FinancialPositionDestination::class.qualifiedName.toString(),
        title = R.string.financialPosition,
        selectedIcon = AppIcons.MoneyFilled,
        unselectedIcon = AppIcons.MoneyOutlined,
    )

    data object NewsFeed : TopLevelDestination(
        route = NewsFeedDestination::class.qualifiedName.toString(),
        title = R.string.news,
        selectedIcon = AppIcons.NewsFilled,
        unselectedIcon = AppIcons.NewsOutlined,
    )
}
