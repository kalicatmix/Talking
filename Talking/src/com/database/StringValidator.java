package com.database;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdk.nashorn.internal.runtime.regexp.joni.MatcherFactory;

public class StringValidator {
private StringValidator() {
}
public static boolean verify(String s) {
	Pattern pattern=Pattern.compile("[\\w]+");
	Matcher matcher=pattern.matcher(s);
	if(matcher.matches())return true;
	return false;
}
public static boolean  verifyName(String name) {
	if(name.length()>5)return false;
    if(!verify(name))return false;
	return true;
}
public static boolean  verifyPwd(String pwd) {
	if(pwd.length()!=6)return false;
	if(!verify(pwd))return false;
	return true;
}

}
