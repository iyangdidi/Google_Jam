package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tmp {
	public void handler() throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\iyang\\Desktop\\Google\\Round2017.Practice\\A-large-practice.in")));
		FileWriter out = new FileWriter("C:\\Users\\iyang\\Desktop\\Google\\Round2017.Practice\\A-large-practice.out");
	
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
