package com.yndoo.dday

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startBtn)
        val endButton = findViewById<Button>(R.id.endBtn)

        var startDate = ""
        var endDate = ""
        var calendar_start = Calendar.getInstance()
        var calendar_end = Calendar.getInstance()

        startButton.setOnClickListener {

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    startDate = "${year}${month+1}${dayOfMonth}"
                    Log.d("날짜확인1",startDate)
                    calendar_start.set(year, month, dayOfMonth)
                }

            }, year, month, day)
            dlg.show()
        }
        endButton.setOnClickListener {

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    endDate = "${year}${month+1}${dayOfMonth}"
                    Log.d("날짜확인2",endDate)
                    calendar_end.set(year, month, dayOfMonth)

                    val finalDate = TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis - calendar_start.timeInMillis)+1

                    findViewById<TextView>(R.id.ddayText).setText("D+" + finalDate.toString())
                }

            }, year, month, day)
            dlg.show()

        }

    }
}