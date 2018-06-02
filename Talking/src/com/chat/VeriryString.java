package com.chat;

public class VeriryString {
  private VeriryString() {
	  
  }
  public static String  verifyString(String string) {
	  for(int i=0;i<50-string.length();i++) {
		  string+=" ";
	  }
	  return string;
  }
}
