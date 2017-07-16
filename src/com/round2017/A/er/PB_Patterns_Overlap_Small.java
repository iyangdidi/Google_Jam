package com.round2017.A.er;

import java.io.*;
import java.util.*;

public class PB_Patterns_Overlap_Small {
	public void handler() throws IOException{
		
		Scanner sc = new Scanner(new BufferedReader(new FileReader("D:\\e-workspace\\Google\\src\\com\\round2017\\A\\io\\B-small-practice.in")));
		FileWriter out = new FileWriter("D:\\e-workspace\\Google\\src\\com\\round2017\\A\\io\\B-small-practice.out");
		
		int T = sc.nextInt();//cases
		for(int k=1; k<=T; k++) {
			//TODO
			String a = sc.next();
			String b = sc.next();
			
			
		}
				
		sc.close();
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) {
		PB_Patterns_Overlap_Small m = new PB_Patterns_Overlap_Small();
		try {
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
