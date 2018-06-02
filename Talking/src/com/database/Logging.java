package com.database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;

import com.chat.CurrentTime;

public class Logging {
	private static File file=new File("log/history.log");
	private static FileWriter writer;
   private Logging() {   
   }
   public static void log(String s) throws Exception{
	 writer=new FileWriter(file,true);
	 BufferedWriter bufferedWriter=new BufferedWriter(writer);
	 bufferedWriter.write("µÇÂ¼Ê±¼ä:"+CurrentTime.currentTime());
	 bufferedWriter.write("    ");
	 bufferedWriter.write(s);
	 bufferedWriter.newLine();
	 bufferedWriter.flush();
	 bufferedWriter.close();
	 writer.close();
   }
}
