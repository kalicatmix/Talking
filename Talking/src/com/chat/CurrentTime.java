package com.chat;

import java.util.Date;

public class CurrentTime {
	private static Date date;
private CurrentTime() {
}
public static String currentTime() {
	date=new Date();
	String currentime="*-"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+"-*";
	return currentime;
}
}
