package com;

import java.io.*;
import java.util.*;

public class Tmp {
	public void handler() throws IOException{
		String path = Tmp.class.getResource("").getPath();
		path = path.substring(1, path.length());
		Scanner sc = new Scanner(new BufferedReader(new FileReader(path+"io//B-small-practice.in")));
		FileWriter out = new FileWriter(path+"io//B-small-practice.out");
		
		int T = sc.nextInt();//cases
		for(int k=1; k<=T; k++) {
			//TODO
		}
				
		sc.close();
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) {
		Tmp m = new Tmp();
		try {
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
