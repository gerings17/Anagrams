package org.jointheleague.gerings17;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CopyWriter {
	public static void main (String[]args) throws IOException{
	String pathName = new String(new java.io.File("src").getCanonicalPath());
	File sourceDir = new File(pathName);
	for(File f:sourceDir.listFiles()){
		FileWriter writer = new FileWriter(f, true);
		writer.append("Copyright Skylar Gering, " + )
		
	}
		
	}
}
