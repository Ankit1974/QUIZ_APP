package com.example.quizapp

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    private val _selectedOption = MutableLiveData<String>()
    val selectedOption: LiveData<String> = _selectedOption

    private val _isAnswerCorrect = MutableLiveData<Boolean?>()
    val isAnswerCorrect: LiveData<Boolean?> = _isAnswerCorrect

    private val _optionColors = mutableMapOf<String, Color>()
    val optionColors: Map<String, Color> = _optionColors

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val correctAnswers = mapOf(
        1 to "The applet makes the Java code secure and portable",
        2 to "Javadoc tool" ,
        3 to "getName()" ,
        4 to "for ( int i = 99; i >= 0; i / 9 )" ,
        5 to "Variable Shadowing" ,
        6 to "Applet class" ,
        7 to "Tight Coupling" ,
        8 to "Race condition" ,
        9 to "Map m1 = Collections.synchronizedMap(hashMap);" ,
        10 to "java.lang.StringBuilder"
    )

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    private val totalQuestions = 10
    init {
        _score.value = 0
    }

    fun onOptionSelected(option: String , questionNumber : Int) {
        Log.d("QuizViewModel", "Option selected for Question $questionNumber: $option")
        _selectedOption.value = option

        // Check if the selected option is correct
        _isAnswerCorrect.value = checkAnswer(option , questionNumber)

        // Update the color of the selected option
        updateOptionColor(option, _isAnswerCorrect.value)

        if (_isAnswerCorrect.value == true) {
            _score.value = _score.value?.plus(1)
        }

    }

    private fun checkAnswer(selectedOption: String , questionNumber: Int): Boolean {
        return selectedOption == correctAnswers [questionNumber]
    }

    private fun updateOptionColor(option: String, isCorrect: Boolean?) {
        _optionColors[option] = when {
            isCorrect == true && option == _selectedOption.value -> Color.Green
            isCorrect == false && option == _selectedOption.value -> Color.Red
            else -> Color.Unspecified
        }
    }

    fun clearSelectedOption() {
        _selectedOption.value = ""
        _isAnswerCorrect.value = null
    }
    fun calculateScore(): Int {
        return _score.value ?: 0
    }

    fun setUserName(name: String) {
        _userName.value = name
    }

}

