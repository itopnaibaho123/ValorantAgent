package com.example.valorant_agent.ui.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*

//import androidx.compose.material3.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.valorant_agent.model.AgentData
import com.example.valorant_agent.ui.navigation.Screen
import coil.compose.AsyncImage
import com.example.valorant_agent.ui.theme.ValorantAgentTheme
import com.example.valorant_agent.R



@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Valorant Agents")
                },
                modifier = Modifier
                    .border(
                        border = BorderStroke(0.5.dp, Color.LightGray),
                    )
                    .padding(all = 4.dp),
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate(Screen.Profile.route)
                        },
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_baseline_person_24),
                            contentDescription = stringResource(id = R.string.about),
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        Box(modifier = modifier
            .padding(innerPadding)
            .fillMaxSize()) {
            LazyColumn {
                itemsIndexed(AgentData.agents) { index, agent ->
                    AgentList(
                        index = index,
                        name = agent.name,
                        photoUrl = agent.iconUrl,
                        modifier = Modifier.fillMaxWidth(),
                        navController = navController
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ValorantAgentTheme {
        HomeScreen()
    }
}


@Composable
fun AgentList(
    index: Int,
    name: String,
    photoUrl: String,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable {
            navController.navigate(Screen.Detail.createRoute(index))
        },
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp)
        )
    }
}
