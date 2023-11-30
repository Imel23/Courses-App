package com.example.coursesapp

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.model.Topic
import com.example.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {

            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopicCard(modifier: Modifier, topic: Topic){
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(topic.topicTitleResourceId),
                modifier= Modifier
                    .height(68.dp)
                    .width(68.dp)
                )
            Column(modifier=Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)) {
                Text(
                    text = stringResource(id = topic.topicTitleResourceId),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(modifier = Modifier.padding(top = 8.dp)){
                    Image(painter = painterResource(id = R.drawable.ic_grain), contentDescription = null)
                    Text(
                        text = topic.numberOfCourses.toString(),
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@SuppressLint("NewApi")
@Preview
@Composable
fun PreviewTopicCard(){
    TopicCard(modifier = Modifier, topic = Topic(R.string.architecture, 58, R.drawable.architecture))
}
