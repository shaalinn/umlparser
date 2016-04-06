package umlparser;

import java.io.FileInputStream;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;

public class umlparser {
	public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("C:/Users/shali/Desktop/usecase1");

        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        // prints the resulting compilation unit to default system output
        System.out.println(cu.toString());
    }
}
