package com.jiftun.catalog.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.jiftun.catalog.meals.navigateToMealScreen
import com.jiftun.entity.CategoryEntity
import com.jiftun.ui.component.NetworkErrorMessage
import com.jiftun.ui.component.ScaffoldTopAppbar
import com.jiftun.ui.theme.color

@Composable
internal fun CategoryListRoute(
    viewModel: CategoriesViewModel = hiltViewModel(), navController: NavHostController
) {
    val categoryListUiSate by viewModel.mealCategoriesListUiState.collectAsStateWithLifecycle()

    CategoryScreen(
        uiState = categoryListUiSate, navController = navController
    )
}

@Composable
fun CategoryScreen(
    uiState: CategoryListUiState, navController: NavHostController
) {
    ScaffoldTopAppbar(
        title = "Repo List", containerColor = MaterialTheme.color.secondaryBackground
    ) {
        val modifier = Modifier.padding(it)
        Box(
            modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            when (uiState) {
                is CategoryListUiState.Error -> {
                    NetworkErrorMessage(message = uiState.message, onClickRefresh = {
                        // onRefreshRepoList(RepoListUiAction.FetchRepoList)
                    })
                }

                is CategoryListUiState.HasCategoryList -> {
                    LazyColumn {
                        items(items = uiState.categories) { categories ->
                            CategoryListItem(item = categories,
                                onItemClick = { navController.navigateToMealScreen(categories.strCategory) })
                        }
                    }

                }

                CategoryListUiState.Loading -> CircularProgressIndicator()
                CategoryListUiState.CategoryListEmpty -> Text(text = "No Repo List Found")
            }
        }
    }
}

@Composable
private fun CategoryListItem(
    modifier: Modifier = Modifier, item: CategoryEntity, onItemClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(bottom = 10.dp)
            .clickable { onItemClick() },
        shape = RectangleShape
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = item.strCategoryThumb),
                    contentDescription = "",
                    modifier = modifier
                        .size(80.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape)
                )
                Spacer(modifier = modifier.width(16.dp))
                Column {
                    Text(text = item.strCategory, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}
