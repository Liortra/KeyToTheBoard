package com.example.keytotheboard;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class MyUtils {

    public static void writeFileToDevice(String dataToWrite, String fileNameWithExtension, File filesDir) {
        File folder = new File(filesDir + File.separator + "MyFiles" + File.separator + "Keyboard_Files");

        File file = new File(folder.getPath() + File.separator + fileNameWithExtension);
        PrintWriter writer = null;

        OutputStream os = null;
        try {
            os = new FileOutputStream(file,true);
            writer = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
            writer.print(dataToWrite);
            writer.flush();
            writer.close();
            Log.d("TAG", "writeFileToDevice: " + filesDir.toString() + "/" + fileNameWithExtension);
        } catch (FileNotFoundException e) {
            Log.d("TAG", "writeToFile FileNotFoundException" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("TAG", "writeToFile IOException" + e.getMessage());
            e.printStackTrace();
        }
    }
}
