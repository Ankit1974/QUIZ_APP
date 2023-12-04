package com.example.quizapp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
//import androidx.navigation.NavHostController
import com.example.quizeapp.QuizeScreen

@Composable
fun Screen7(
    Answer6: List<String>,
    viewModel: QuizViewModel,
    onCancelButtonClicked: () -> Unit = {},
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    var selectedOption by remember { mutableStateOf<String?>(null) }
    Surface(
        modifier = modifier.fillMaxHeight(),
        color = Color.Transparent
    ) {

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
                Text(text = "6. Which of the following is an immediate subclass of the Panel class?")
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Answer6.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                //  viewModel.onOptionSelected(item)
                                selectedOption = item
                                viewModel.onOptionSelected(item , 6)
                            }
                            .padding(dimensionResource(R.dimen.padding_small)),
                        verticalAlignment = Alignment.CenterVertically

                    )
                    {
                        RadioButton(
                            selected = selectedOption == item,
                            onClick = {
                                selectedOption = item
                                viewModel.onOptionSelected(item , 6)
                            },
                            colors = RadioButtonDefaults.colors(selectedColor = viewModel.optionColors[item] ?: Color.Unspecified)
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                        Text(
                            item ,
                            color = viewModel.optionColors[item] ?: Color.Unspecified
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f, false),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.Bottom
            ) {
                OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
                    Text("Cancel")
                }
                Button(
                    modifier = Modifier.weight(1f),
                    enabled = viewModel.selectedOption.value?.isNotEmpty() == true,
                    onClick = {

                        navController.navigate(QuizeScreen.question7.name)
                    }
                ) {
                    Text("Next")
                }
            }
        }
    }
}