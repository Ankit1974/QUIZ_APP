package com.example.quizapp

//User
//package com.example.quizeapp


//import androidx.compose.ui.tooling.data.EmptyGroup.name

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quizeapp.QuizeScreen

@Composable
fun Screeen1(
    navController: NavHostController,
    onNameEntered: (String) -> Unit,
    modifier : Modifier = Modifier

) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable._172658),
            contentDescription = null, // provide a content description
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceBetween
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            )
            {
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.very_large)))
                Image(
                    painter = painterResource(id = R.drawable.a33024a4f33d4176f50d88b86ece5350ofqt8hr0c3m6ufqa_9),
                    contentDescription = null,
                    modifier = Modifier
                        .widthIn(min = 300.dp)
                        .height(100.dp)
                )

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.very_medium)))
            }

            Row(modifier = Modifier.weight(1f, false)) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    EditTextField(onNameEntered)
                    SelectExploreButton(
                        onClick = {
                          // onNameEntered.invoke(name)
                            navController.navigate(QuizeScreen.question1.name)
                        }
                    )
                }
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(onNameEntered: (String) -> Unit) {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        textStyle = TextStyle(color = Color.Blue),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Characters,
            autoCorrect = true,
            keyboardType = KeyboardType.Text
        ),
        placeholder = {
            Text("Enter your Name")
        }
    )
    DisposableEffect(text) {
        onNameEntered.invoke(text)
        onDispose { }
    }
}

@Composable
fun SelectExploreButton(
   // onNameEntered: (String) -> Unit,
    onClick: () -> Unit,
    //onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            // onClick = onNextButtonClicked,
            onClick= onClick,
            modifier = modifier.widthIn(min = 300.dp)
        ) {
            Text(stringResource(id = R.string.Login_Button))
        }
    }
}


