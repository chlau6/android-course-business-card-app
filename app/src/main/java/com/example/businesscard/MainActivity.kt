package com.example.businesscard

import android.graphics.drawable.Icon
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color(0xFF0F3948)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {
        Profile(fullName = stringResource(R.string.full_name),
            title = stringResource(R.string.title),
        )
    }
}

@Composable
fun Profile(fullName: String, title: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 256.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(R.drawable.android_logo),
            contentDescription = "Profile Picture",
            modifier = Modifier.size(64.dp)
        )

        Text(text = fullName,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp,
            color = Color.White
        )

        Text(text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
    }

    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 64.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Divider(color = Color.Gray)

        Info(icon = Icons.Filled.Phone,
            description = stringResource(R.string.phone_description),
            info = stringResource(R.string.phone_number)
        )

        Divider(color = Color.Gray)

        Info(icon = Icons.Filled.Share,
            description = stringResource(R.string.share_description),
            info = stringResource(R.string.share_info)
        )

        Divider(color = Color.Gray)

        Info(icon = Icons.Filled.Email,
            description = stringResource(R.string.email_description),
            info = stringResource(R.string.email_address)
        )
    }
}

@Composable
fun Info(icon: ImageVector, description: String, info: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically) {

        Icon(
            modifier = Modifier.padding(start = 48.dp),
            imageVector = icon,
            contentDescription = description,
            tint = Color(0xFF3ddc84),
        )

        Text(
            modifier = Modifier.padding(start = 32.dp),
            text = info,
            color = Color.White,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}