package compiler;


class Driver {
    public static String INPUT = "input2.yaspl2";

    public static void main(String[] args) throws Exception {
        Driver.INPUT = args[0];
        Parser parser = new Parser();
        parser.parse();
    }

}