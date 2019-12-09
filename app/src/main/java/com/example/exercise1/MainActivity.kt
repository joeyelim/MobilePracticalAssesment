package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    lateinit var carPrice : EditText
    lateinit var downPayment : EditText
    lateinit var LoanPeriod : EditText
    lateinit var interestRate : EditText

    lateinit var resultLoanTextView : TextView
    lateinit var resultRateTextView : TextView
    lateinit var resultMRTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        LoanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        interestRate = findViewById<EditText>(R.id.editTextInterestRate)

        resultLoanTextView = findViewById<TextView>(R.id.textViewLoanResult)
        resultRateTextView = findViewById<TextView>(R.id.textViewInterestResult)
        resultMRTextView = findViewById<TextView>(R.id.textViewMonRepResult)

        buttonCalculate.setOnClickListener{
//            var loanResult =  carPrice.text.toString().toDouble() - downPayment.text
//            textViewLoanResult.setText(loanResult.toString())
            clickHandlerFunction(it)
        }

        buttonReset.setOnClickListener{
            clickHandlerFunction2(it)
        }

    }

    private fun clickHandlerFunction2(viewThatIsClicked: View) {
        carPrice.setText("")
        downPayment.setText("")
        LoanPeriod.setText("")
        interestRate.setText("")
    }

    private fun clickHandlerFunction(viewThatIsClicked: View) {
        resultLoanTextView.text = (carPrice.text.toString().toDouble() - downPayment.text.toString().toDouble()).toString()
        resultRateTextView.text = (carPrice.text.toString().toDouble() * interestRate.text.toString().toDouble() * LoanPeriod.text.toString().toDouble()).toString()
        resultMRTextView.text = ((carPrice.text.toString().toDouble() + interestRate.text.toString().toDouble()) / LoanPeriod.text.toString().toDouble()/12).toString()
    }


}


