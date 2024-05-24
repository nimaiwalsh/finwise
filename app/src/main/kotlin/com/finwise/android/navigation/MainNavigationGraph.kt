package com.finwise.android.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.finwise.feature.calculators.calculatorsNavGraph
import com.finwise.feature.financialposition.financialPositionNavGraph
import com.finwise.feature.HomeGraph
import com.finwise.feature.homeNavGraph
import com.finwise.feature.newsFeedNavGraph
import kotlinx.serialization.Serializable

@Serializable
object MainGraph

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
    navigateToLogin: () -> Unit,
) {
    navigation<MainGraph>(
        startDestination = HomeGraph,
    ) {

        homeNavGraph(
            navController = navController,
            onNavigateToLogin = navigateToLogin,
        )

        calculatorsNavGraph(navController = navController)

        newsFeedNavGraph(navController = navController)

        financialPositionNavGraph(navController = navController)
    }
}