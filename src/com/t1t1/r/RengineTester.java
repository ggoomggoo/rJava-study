package com.t1t1.r;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.rosuda.JRI.Rengine;

public class RengineTester {

	public static void main(String[] args) {

		Rengine rengine = getRengine();

		checkRengine(rengine);

		executeRCode(rengine, "static/RCode.txt", "C:/R");

	}

	private static Rengine getRengine() {
		Rengine rengine = new Rengine(null, false, null);
		return rengine;
	}

	private static void checkRengine(Rengine rengine) {
		if (!rengine.waitForR()) {
			System.out.println("ERROR: rengine.waitForR()");
			System.exit(1);
		}
	}

	private static void executeRCode(Rengine rengine, String inputPath, String outputPath) {
        
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			File data = new File(inputPath);
			fr = new FileReader(data);
			br = new BufferedReader(fr);
			String line;
			while ( (line = br.readLine()) != null) {
				
				// 코드 치환
				if (line.indexOf("{{outputPath}}") > -1) {
					line = line.replace("{{outputPath}}", outputPath);
				}
				if (line.indexOf("{{now}}") > -1) {
					line = line.replace("{{now}}", getNow());
				}
				
				// execute
				rengine.eval(line);
				System.out.println(line);
				
				if (line.isEmpty()) {
					rengine.end();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
				if (fr != null) fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}

	private static String getNow() {
		Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss");
        String now = sdf.format(date);
		return now;
	}
	
}
