/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc= new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String str3 = sc.nextLine();
		
		int[] strNum = new int[3];
		strNum[0] = check(str1);
		strNum[1] = check(str2);
		strNum[2] = check(str3);

        //System.out.println("strNum[0]: " + strNum[0] + "strNum[1]: " + strNum[1] + "strNum[2]: " + strNum[2]);
		
		int idx = 0;
		
		for(int i=0; i<strNum.length; i++) {
			if(strNum[i] == -1) continue;
			else {
				if(i > idx)  {
					idx = i;
				}
			}
		}
		
		int res = 0;

        //System.out.println("idx: " + idx);
		
		switch (idx) {
			case 0 : res = strNum[idx] + 3; break;
			case 1 : res = strNum[idx] + 2; break;
			case 2 : res = strNum[idx] + 1; break;
		}
		
		if(res%3 == 0 && res%5==0) System.out.println("FizzBuzz");
		else if(res%3 == 0 && res%5!=0) System.out.println("Fizz");
		else if(res%3 != 0 && res%5==0) System.out.println("Buzz");
		else System.out.println(res);
		
	}
	
	public static int check(String str) {
		if(str.equals("Fizz") || str.equals("Buzz") || str.equals("FizzBuzz")) {
			return -1;
		}
		
		else {
			return Integer.valueOf(str);	
		}
		
	}
}