package com.jdg.swole

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jdg.swole.domain.User
import com.jdg.swole.ui.theme.SwoleTheme

class SelectUserActivity : ComponentActivity() {
    val users: List<User> = listOf(
        User(1, "Jay", "Green"),
        User(2, "Fred", "Derf")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwoleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    UserList(users = users)
                }
            }
        }
    }
}

@Composable
fun UserList(users: List<User>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Who's working out?")
        for (user: User in users) {
            Button(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth(.75f),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = user.fullName()
                )
            }
        }
    }
}


@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    SwoleTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            UserList(listOf<User>(
                User(1, "Jay", "Green"),
                User(2, "Fred", "Derf")
            ))
        }
    }
}