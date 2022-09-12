    package com.hakka1.ithelp.example.eample.example.day5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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

data class Note(val title: String, val author: String)


@Composable
fun NoteItem(note: Note, cover: Int) {
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
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = note.title)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = note.author)
        }
    }
}

@Composable
fun NoteList() {
    Column {
        NoteItem(note = Note(author = "Mary", title = "Kotlin Tutorial"), R.drawable.ic_profile_face1)
        Divider(modifier = Modifier.height(1.dp), color = Color.Gray)
        NoteItem(note = Note(author = "Shawn", title = "Java Tutorial"), R.drawable.ic_profile_face2)
        Divider(modifier = Modifier.height(1.dp), color = Color.Gray)
        NoteItem(note = Note(author = "Eric", title = "Golang Tutorial"), R.drawable.ic_profile_face2)
        Divider(modifier = Modifier.height(1.dp), color = Color.Gray)
        NoteItem(note = Note(author = "Joye", title = "Node JS Tutorial"), R.drawable.ic_profile_face1)
    }
}

@Preview(showBackground = true, widthDp = 600, heightDp = 800)
@Composable
fun PreviewNotes() {
    ExampleDay5Theme {
        NoteList()
    }
}