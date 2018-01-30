package com.oromis;


class Driver {
	public final static String INPUT="input.txt";
	public static void main(String[] args) throws Exception {
		Parser parser = new Parser();
		parser.parse();
        Process p = Runtime.getRuntime().exec("bash -c script.bat");
    }
	
}