package com.example.receipt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.blankj.utilcode.util.IntentUtils
import com.blankj.utilcode.util.UriUtils
import jxl.Workbook
import jxl.write.Label
import org.koin.android.ext.android.inject
import retrofit2.Retrofit
import java.io.File

class MainActivity : AppCompatActivity() {

    private val retrofit by inject<Retrofit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit
        retrofit

        s2()
        s1()
    }

    private fun s1(){
        val dir = File(filesDir, "excel")
        val file = File(dir,"测试.xls")
        val uri = FileProvider.getUriForFile(this,"com.example.receipt.fileprovider",file)
//        val uri= UriUtils.file2Uri(file)
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM,uri)
            type = "application/vnd.ms-excel"
        }

        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(intent,"测试标题"))

    }


    private fun s2() {
        val dir = File(filesDir, "excel")
        dir.mkdir()
        val file = File(dir,"测试.xls")
        val workbook = Workbook.createWorkbook(file)
        val sheet = workbook.createSheet("测试", 0)
        val label = Label(0, 0, "测试")
        sheet.addCell(label)
        workbook.write()
        workbook.close()
    }

}