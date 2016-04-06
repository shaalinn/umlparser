package umlparser;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

@SuppressWarnings("rawtypes")
public class InterfaceChecker extends VoidVisitorAdapter {
public void visit(ClassOrInterfaceDeclaration n, Object arg){
		
		
	umlparser.flag = n.isInterface();
		
	}
}
