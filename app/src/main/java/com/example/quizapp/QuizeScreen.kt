//package com.example.quizapp

package com.example.quizeapp
//import QuizeViewModel
//import Screen2
import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.LastScreen
import com.example.quizapp.QuizViewModel
import com.example.quizapp.R
import com.example.quizapp.Screeen1
import com.example.quizapp.Screen10
import com.example.quizapp.Screen11
import com.example.quizapp.Screen2
import com.example.quizapp.Screen3
import com.example.quizapp.Screen4
import com.example.quizapp.Screen5
import com.example.quizapp.Screen6
import com.example.quizapp.Screen7
import com.example.quizapp.Screen8
import com.example.quizapp.Screen9


enum class QuizeScreen(@StringRes val title:Int) {
    Start(title = R.string.app_name),
    question1(title = R.string.Question1),
    question2(title = R.string.Question2),
    question3(title = R.string.Question3),
    question4(title = R.string.Question4),
    question5(title = R.string.Question5),
    question6(title = R.string.Question6),
    question7(title = R.string.Question7),
    question8(title = R.string.Question8),
    question9(title = R.string.Question9),
    question10(title = R.string.Question10),
    Last(title = R.string.Last)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizeAppBar(
    currentScreen: QuizeScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.FORWARD_BUTTON)
                    )
                }
            }
        }
    )
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  QuizeScreen(
    viewModel: QuizViewModel = remember { QuizViewModel() },
    navController : NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = QuizeScreen.valueOf(
        backStackEntry?.destination?.route ?: QuizeScreen.Start.name
    )
    Scaffold(
        topBar = {
            QuizeAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = QuizeScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = QuizeScreen.Start.name) {
                Screeen1(
                    navController = navController,
                    onNameEntered = { name ->
                        viewModel.setUserName(name)
                    }
                )
            }
            composable(route = QuizeScreen.question1.name) {
                Screen2(
                    Answer1 = listOf(
                        "Bytecode is executed by JVM",
                        "The applet makes the Java code secure and portable",
                        "Use of exception handling",
                        "Dynamic binding between objects"
                    ),
                    viewModel = viewModel,
                    navController = navController,
                )
            }

            composable(route = QuizeScreen.question2.name) {
                Screen3(
                    Answer2 = listOf(
                        "javap tool",
                        "javaw command",
                        "Javadoc tool",
                        "javah command"
                    ),
                    viewModel = viewModel,
                    navController = navController,
                )
            }
            composable(route = QuizeScreen.question3.name) {
                Screen4(
                    Answer3 = listOf("getClass()", "intern()", "getName()", "toString()"),
                    viewModel = viewModel,
                    navController = navController,
                )
            }
            composable(route = QuizeScreen.question4.name) {
                Screen5(
                    Answer4 = listOf(
                        "for ( int i = 99; i >= 0; i / 9 )",
                        "for ( int i = 7; i <= 77; i += 7 )",
                        "for ( int i = 20; i >= 2; - -i )",
                        "for ( int i = 2; i <= 20; i = 2* i )"
                    ),
                    viewModel = viewModel,
                    navController = navController,
                )
            }
            composable(route = QuizeScreen.question5.name) {
                Screen6(
                    Answer5 = listOf(
                        "Serialization",
                        "Variable Shadowing",
                        "Abstraction",
                        "Multi-threading"
                    ),
                    viewModel = viewModel,
                    navController = navController,
                )
            }
            composable(route = QuizeScreen.question6.name) {
                Screen7(
                    Answer6 = listOf("Applet class", "Window class", "Frame class", "Dialog class"),
                    viewModel = viewModel,
                    navController = navController,
                )
            }
            composable(route = QuizeScreen.question7.name) {
                Screen8(
                    Answer7 = listOf(
                        "Tight Coupling",
                        "Cohesion",
                        "Loose Coupling",
                        "None of the above"
                    ),
                    viewModel = viewModel,
                    navController = navController,
                )
            }
            composable(route = QuizeScreen.question8.name) {
                Screen9(
                    Answer8 = listOf(
                        "Time-Lapse",
                        "Critical situation",
                        "Race condition",
                        "Recursion"
                    ),
                    viewModel = viewModel,
                    navController = navController,
                )
            }
            composable(route = QuizeScreen.question9.name) {
                Screen10(
                    Answer9 = listOf(
                        "Map m = hashMap.synchronizeMap();",
                        "HashMap map =hashMap.synchronizeMap();",
                        "Map m1 = Collections.synchronizedMap(hashMap);",
                        "Map m2 = Collection.synchronizeMap(hashMap);/c"
                    ),
                    viewModel = viewModel,
                    navController = navController,
                )
            }
            composable(route = QuizeScreen.question10.name) {
                Screen11(
                    Answer10 = listOf(
                        "java.lang.String",
                        "java.lang.Byte",
                        "java.lang.Short",
                        "java.lang.StringBuilder"
                    ),
                    viewModel = viewModel,
                    navController = navController,
                )
            }
            composable(route = QuizeScreen.Last.name) {
                LastScreen(
                    //Answer10 = listOf("java.lang.String" , "java.lang.Byte" , "java.lang.Short" , "java.lang.StringBuilder"),
                     viewModel = viewModel ,
                    navController = navController,
                    score = viewModel.calculateScore() ,
                    userName = viewModel.userName.value ?: "Guest"
                )
            }
        }
    }
}