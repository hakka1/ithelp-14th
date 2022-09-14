    package com.hakka1.ithelp.example.eample.example.day5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hakka1.ithelp.example.eample.example.day5.ui.theme.ExampleDay5Theme

class LayoutsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleDay5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NoteList()
                }
            }
        }
    }
}

data class Note(val title: String, val body: String)

    object SampleData {
        // Sample conversation data
        val conversationSample = listOf(
            Note(
                "Colleague",
                "Test...Test...Test..."
            ),
            Note(
                "Colleague",
                "List of Android versions:\n" +
                        "Android KitKat (API 19)\n" +
                        "Android Lollipop (API 21)\n" +
                        "Android Marshmallow (API 23)\n" +
                        "Android Nougat (API 24)\n" +
                        "Android Oreo (API 26)\n" +
                        "Android Pie (API 28)\n" +
                        "Android 10 (API 29)\n" +
                        "Android 11 (API 30)\n" +
                        "Android 12 (API 31)\n"
            ),
            Note(
                "Colleague",
                "I think Kotlin is my favorite programming language.\n" +
                        "It's so much fun!"
            ),
            Note(
                "Colleague",
                "Searching for alternatives to XML layouts..."
            ),
            Note(
                "Colleague",
                "Hey, take a look at Jetpack Compose, it's great!\n" +
                        "It's the Android's modern toolkit for building native UI." +
                        "It simplifies and accelerates UI development on Android." +
                        "Less code, powerful tools, and intuitive Kotlin APIs :)"
            ),
            Note(
                "Colleague",
                "It's available from API 21+ :)"
            ),
            Note(
                "Colleague",
                "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
            ),
            Note(
                "Colleague",
                "Android Studio next version's name is Arctic Fox"
            ),
            Note(
                "Colleague",
                "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
            ),
            Note(
                "Colleague",
                "I didn't know you can now run the emulator directly from Android Studio"
            ),
            Note(
                "Colleague",
                "Compose Previews are great to check quickly how a composable layout looks like"
            ),
            Note(
                "Colleague",
                "Previews are also interactive after enabling the experimental setting"
            ),
            Note(
                "Colleague",
                "Have you tried writing build.gradle with KTS?"
            ),
        )
    }


@Composable
fun NoteItem(note: Note) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_profile_face1),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(width = 2.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Surface(shape = MaterialTheme.shapes.large, elevation = 2.dp) {
                Text(text = note.title, style= MaterialTheme.typography.subtitle1)
            }

            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = note.body,
                modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.body2
            )
        }

    }
}

@Composable
fun NoteList() {
    LazyColumn {
        items(SampleData.conversationSample) { note ->
            NoteItem(note)
        }
    }
}

@Preview(showBackground = true, widthDp = 600, heightDp = 800)
@Composable
fun PreviewNotes() {
    ExampleDay5Theme {
        NoteList()
    }
}