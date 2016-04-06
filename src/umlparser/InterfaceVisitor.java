package umlparser;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

@SuppressWarnings("rawtypes")
public class InterfaceVisitor extends VoidVisitorAdapter {
	public void visit(ClassOrInterfaceDeclaration n, Object arg){
		

		umlparser.VOI.add(new ValueObjectInterface());
		umlparser.VOI.get(umlparser.j).setInterface_name(n.getName());
		
	}
}