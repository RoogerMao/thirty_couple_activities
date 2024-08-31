package com.example.a30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30days.data.ActivitiesDataSource
import com.example.a30days.data.CoupleActivity
import com.example.a30days.ui.theme._30DaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysTheme {
                CoupleActivitiesApp()
            }
        }
    }
}

@Composable
fun CoupleActivitiesApp() {
    Column (
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.surfaceContainer)
            .safeDrawingPadding()
    ) {
        Text(
            text = "30 Days of Couple Activities",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        CouplesActivityList(coupleActivityList = ActivitiesDataSource.activitiesList)
    }
}

@Composable
fun CouplesActivityList(coupleActivityList: List<CoupleActivity>) {
    LazyColumn (
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 0.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(coupleActivityList) { coupleActivity ->
            CoupleActivityCard(
                coupleActivity = coupleActivity,
                dayNumber = coupleActivityList.indexOf(coupleActivity) + 1
            )
        }
    }
}

@Composable
fun CoupleActivityCard(coupleActivity: CoupleActivity, dayNumber: Int) {
    Card(
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
            disabledContentColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = {
                    coupleActivity.expanded.value = !coupleActivity.expanded.value
                }
            )
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .animateContentSize()
        ){
            Text(
                text = "Day #${dayNumber}: " + stringResource(id = coupleActivity.stringID),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Image(
                painter = painterResource(id = coupleActivity.imageID),
                contentDescription = stringResource(id = coupleActivity.stringID),
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp)
            )
            if(coupleActivity.expanded.value)
                Text(
                    text = stringResource(id = coupleActivity.descriptionID),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30DaysTheme {
        CoupleActivitiesApp()
    }
}