package com.round2017.D.er;

import java.io.*;
import java.util.*;

public class PB {
	public void handler() throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new FileReader("D:\\e-workspace\\Google\\src\\com\\round2017\\A\\io\\A-small-practice.in")));
		FileWriter out = new FileWriter("D:\\e-workspace\\Google\\src\\com\\round2017\\A\\io\\A-small-practice.out");
		
		int T = sc.nextInt();//cases
		for(int k=1; k<=T; k++) {
			//TODO
		}
				
		sc.close();
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) {
		PB m = new PB();
		try {
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
