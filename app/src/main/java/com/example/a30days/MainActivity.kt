package com.example.a30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
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
            }
        }
    }
}

@Composable
fun CoupleActivityCard(coupleActivity: CoupleActivity, dayNumber: Int) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        ){
            Text(
                text = "Day #${dayNumber}: " + stringResource(id = coupleActivity.stringID),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
            )
            Image(
                painter = painterResource(id = coupleActivity.imageID),
                contentDescription = stringResource(id = coupleActivity.stringID),
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp)
            )
            Text(
                text = stringResource(id = coupleActivity.descriptionID),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    _30DaysTheme {
        CoupleActivityCard(coupleActivity = ActivitiesDataSource.activitiesList[0], 1)
    }
}