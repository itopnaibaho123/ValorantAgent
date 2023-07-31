package com.example.valorant_agent.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import com.example.valorant_agent.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.valorant_agent.model.AgentData


@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Boolean,
    index: Int
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "${AgentData.agents[index].name} Detail")
                },
                modifier = Modifier
                    .border(
                        border = BorderStroke(0.5.dp, Color.LightGray),
                    )
                    .padding(all = 4.dp),
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(id = R.string.back)
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        Box(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            val agent = AgentData.agents[index]
            Column(modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Column(
                    modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = agent.iconUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(200.dp)
                            .clip(CircleShape)
                    )
                }
                Text(text = agent.name, fontWeight = FontWeight.Bold)
                Text(text = agent.description)
                Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(text = "Role:")
                    Text(text = agent.role)
                }
            }
        }
    }
}