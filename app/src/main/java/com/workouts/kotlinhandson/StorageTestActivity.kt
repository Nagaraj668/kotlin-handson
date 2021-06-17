package com.workouts.kotlinhandson

import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream

class StorageTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage_test)

        println(" isExternalStorageReadable: ${isExternalStorageReadable()}")
        println(" isExternalStorageWritable: ${isExternalStorageWritable()}")

        println(filesDir.absolutePath)
        println(cacheDir.absolutePath)
        println(externalCacheDir?.absolutePath)

        val externalStorageVolumes: Array<out File> =
            ContextCompat.getExternalFilesDirs(applicationContext, null)
        val primaryExternalStorage = externalStorageVolumes[0]

        println("external storage size: ${externalStorageVolumes.size}")
        println("primaryExternalStorage: ${externalStorageVolumes[0]}")
        println("secondaryExternalStorage: ${externalStorageVolumes[1]}")

        println(Environment.getExternalStorageDirectory().absolutePath)
        val sdcard = Environment.getExternalStorageDirectory()
        val dir = File(sdcard.absolutePath + "/your-dir-name/")
        dir.mkdir()

        val file = File(dir, "My-File-Name.txt")
        val data = "This is the content of my file"
        val os: FileOutputStream = FileOutputStream(file).also {
            it.write(data.toByteArray())
        }
        os.close()
    }

    private fun isExternalStorageWritable(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }

    private fun isExternalStorageReadable(): Boolean {
        return Environment.getExternalStorageState() in
                setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
    }

}