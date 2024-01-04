@file:OptIn(ExperimentalFoundationApi::class)

package com.hilman.secretcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.magnifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.hilman.secretcompose.ui.theme.SecretComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecretComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TestMagnifier()
                }
            }
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun Test() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.basicMarquee(),
            maxLines = 1,
            text = "Long long long Long long long Long long long Long long long Long long long Long long long Long long long Long long long Long long long Long long long Long long long Long long long Long long long Long long long Long long long Long long long "
        )

    }
}


@Composable
@Preview
fun TestMagnifier() {
    var offset by remember {
        mutableStateOf(Offset.Zero)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .pointerInput(true) {
                detectDragGestures { change, _ ->
                    offset = change.position
                }
            }
            .magnifier(
                sourceCenter = {
                    offset
                },
                magnifierCenter = {
                    offset - Offset(0f, 200f)
                }

            )) {
            Image(
                painter = painterResource(id = R.drawable.hd),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}