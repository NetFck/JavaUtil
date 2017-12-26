package de.NetFck.JavaUtil.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileUtility {
public static void CreateFile(String name) throws IOException {
	new File(name).mkdirs(); // First get all Folders.
	new File(name).delete();
	new File(name).createNewFile();
}
public static void AddLineToFile(String File, String line) {
	try {
	    Files.write(new File(File).toPath(), line.getBytes(), StandardOpenOption.APPEND);
	} catch (IOException e) {
	    System.err.println(e);
	}
}
public static String ReadFile(String filename) throws IOException {
	File f = new File(filename);
	String toRet = "";
	if(f.exists()) {
		Scanner scnr = new Scanner(f);
		while(scnr.hasNextLine()) 
			toRet += scnr.nextLine() + "\n";
		
		return toRet;
	}
	else {
		CreateFile(filename);
		return ReadFile(filename);
	}
}
}
