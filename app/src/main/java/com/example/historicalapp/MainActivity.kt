package com.example.historicalapp

import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.time.Year

class MainActivity : AppCompatActivity() {

    enum class HistoricalPeople(val year: Int, val description: String){
        EVENT_1(95,"Your age is the same as Nelson Mandela who fought for freedom in SA"),
        EVENT_2(84,"Your age is the same as Isaac Newton who was the first person to discover gravity"),
        EVENT_3(67,"Your age is the same as  Leonardo da Vinci who had painted the Mona lisa"),
        EVENT_4(76,"Your age is the same as Albert Einstein who was famous for his equation E = mc to the power of 2"),
        EVENT_5(73,"Your age is the same as Charles Darwin who was famous for theory of evolution"),
        EVENT_6(32,"Your age is the same as Alexander the Great who was the world's greatest military generals"),
        EVENT_7(51,"Your age is the same as Napoleon who was an emperor of France known to win many battles"),
        EVENT_8(50,"Your age is the same as king Arthur who has led Britain to glory and made himself a legend"),
        EVENT_9(47,"Your age is the same as oda Nobunaga he was known for being a great war lord in japan"),
        EVENT_10(86,"Your age is the same as Nikola Tesla who was known for providing a system for electricity ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtEnterAge = findViewById<EditText>(R.id.edtYear)
        val btnResult =findViewById<Button>(R.id.btnResults)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnResult?.setOnClickListener()
        {
            val enterAge = edtEnterAge.text.toString().toInt()

            if (enterAge != null && enterAge in 0..100) {

                val eventYears = HistoricalPeople.values().map { it.year }

                val events = when (enterAge) {
                    in eventYears -> {
                        val event = HistoricalPeople.values().find { it.year == enterAge + 1 }
                        listOf("In $enterAge: ${event?.description ?: "event"}")
                    }

                    in eventYears.map { it + 1 } -> {
                        val event = HistoricalPeople.values().find { it.year == enterAge - 1 }
                        listOf(
                            "your enter age is one year after the historical people of " +
                                    "${event?.description ?: "event"}"
                        )
                    }

                    else -> listOf("No historical events found for $enterAge.")
                }
                txtResult.text = events.joinToString("\n")
            } else {
                txtResult.text = "No event has been found from the input of your enter age."
            }
        }

        btnClear?.setOnClickListener(){
            edtEnterAge.text.clear()
            txtResult.text = ""
        }
    }
}