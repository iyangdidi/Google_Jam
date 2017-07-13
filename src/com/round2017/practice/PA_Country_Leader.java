package com.round2017.practice;

import java.io.*;
import java.util.*;

/**
 * 
 * @author iyang
 * 
 * Problem

The Constitution of a certain country states that the leader is the person with the name containing the greatest number of different alphabet letters. (The country uses the uppercase English alphabet from A through Z.) For example, the name GOOGLE has four different alphabet letters: E, G, L, and O. The name APAC CODE JAM has eight different letters. If the country only consists of these 2 persons, APAC CODE JAM would be the leader.

If there is a tie, the person whose name comes earliest in alphabetical order is the leader.

Given a list of names of the citizens of the country, can you determine who the leader is?
Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case starts with a line with an interger N, the number of people in the country. Then N lines follow. The i-th line represents the name of the i-th person. Each name contains at most 20 characters and contains at least one alphabet letter.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the name of the leader.
Limits

1 ¡Ü T ¡Ü 100.
1 ¡Ü N ¡Ü 100.
Small dataset

Each name consists of at most 20 characters and only consists of the uppercase English letters A through Z.

Large dataset

Each name consists of at most 20 characters and only consists of the uppercase English letters A through Z and ' '(space).
All names start and end with alphabet letters.

sample
------------------

Input  
------------------
2
3
ADAM
BOB
JOHNSON
2
A AB C
DEF

Output
------------------
Case #1: JOHNSON
Case #2: A AB C


 *
 */

//Correct
public class PA_Country_Leader {
	
	public void handler() throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\iyang\\Desktop\\Google\\Round2017.Practice\\A-large-practice.in")));
		FileWriter out = new FileWriter("C:\\Users\\iyang\\Desktop\\Google\\Round2017.Practice\\A-large-practice.out");
	
		//read data
		int T = sc.nextInt();		
		for(int k=1; k<=T; k++) {
			int n = sc.nextInt();
			String leader = "";
			sc.nextLine();//this will catch ''
			for(int i=0; i<n; i++) {
				//check whether next one will replace the "leader"
				String next =  sc.nextLine();
				leader = nameCompare(leader, next);
			}
			out.write("Case #"+k+": "+leader+"\n");
		}
		
		sc.close();
		out.flush();
		out.close();
	}
	
	public String nameCompare(String cur, String next) {
		int n_cur = countDiffAlpha(cur);
		int n_next = countDiffAlpha(next);
		if(n_cur==n_next) {
			return cur.compareTo(next)<0 ? cur : next;
		}else {
			return n_cur>n_next ? cur : next;
		}
	}
	
	public int countDiffAlpha(String s) {
		Set set = new HashSet();
		for(int i=0; i<s.length(); i++) {
			char t = s.charAt(i);
			if(t!=' ') {
				set.add(t);
			}			
		}
		
		return set.size();
	}
	
	public static void main(String[] args) {
		PA_Country_Leader m = new PA_Country_Leader();
		try {
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
