
//package com.example.quizeapp
package com.example.quizapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compose.QuizeAppTheme
import com.example.quizeapp.QuizeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizeAppTheme{
                QuizeScreen()
            }
        }
    }

}
