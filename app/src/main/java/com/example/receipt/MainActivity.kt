package com.example.receipt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jxl.LabelCell
import jxl.Workbook
import jxl.write.Label
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import retrofit2.Retrofit
import java.io.File

class MainActivity : AppCompatActivity() {

    private val retrofit by inject<Retrofit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit
        retrofit

        s()
    }


    private fun s(){
        val file = File(cacheDir,"2.xls")
        val workbook = Workbook.createWorkbook(file)
        val sheet = workbook.createSheet("测试",0)
        val label = Label(0,0,"hehe")
        sheet.addCell(label)
        workbook.write()
        workbook.close()
    }
}