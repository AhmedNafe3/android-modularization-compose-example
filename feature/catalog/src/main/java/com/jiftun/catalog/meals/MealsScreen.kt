package com.jiftun.catalog.meals

import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.jiftun.meal.data.model.MealsEntity
import com.jiftun.ui.component.NetworkErrorMessage
import com.jiftun.ui.component.ScaffoldTopAppbar
import com.jiftun.ui.theme.color

@Composable
internal fun MealsRoute(viewModel: MealsViewModel = hiltViewModel()) {
    val mealsListUiSate by viewModel.mealListUiState.collectAsStateWithLifecycle()
    MealsScreen(mealsListUiSate)
}

@Composable
fun MealsScreen(
    uiState: MealsUiState
) {
    ScaffoldTopAppbar(title = "Meals", containerColor = MaterialTheme.color.secondaryBackground) {
        val modifier = Modifier.padding(it)
        Box(
            modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            when (uiState) {
                is MealsUiState.Error -> {
                    NetworkErrorMessage(message = uiState.message, onClickRefresh = {
                        // onRefreshRepoList(RepoListUiAction.FetchRepoList)
                    })
                }

                is MealsUiState.HasMealsList -> {
                    LazyColumn {
                        items(items = uiState.mealsEntity) { meals ->
                            MealListItem(
                                item = meals
                            )
                        }
                    }

                }

                MealsUiState.Loading -> CircularProgressIndicator()
                MealsUiState.MealsListEmpty -> Text(text = "No Repo List Found")
            }
        }

    }
}


@Composable
private fun MealListItem(
    modifier: Modifier = Modifier,
    item: MealsEntity,
) {
    Card(
        modifier = modifier.padding(bottom = 10.dp), shape = RectangleShape
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
                    painter = rememberAsyncImagePainter(model = item.strMealThumb),
                    contentDescription = "",
                    modifier = modifier
                        .size(80.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape)
                )
                Spacer(modifier = modifier.width(16.dp))
                Column {
                    Text(text = item.strMeal, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MealsScreenPreview() {
    MealListItem(
        item = MealsEntity(
            idMeal = "52959",
            strMeal = "Baked salmon with fennel & tomatoes",
            strMealThumb = "\"https://www.themealdb.com/images/media/meals/1548772327.jpg"
        )
    )
}