package umlparser;
import java.util.ArrayList;
import java.util.List;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.type.Type;
import japa.parser.ast.visitor.VoidVisitorAdapter;
@SuppressWarnings("rawtypes")
public class FieldVisitor extends VoidVisitorAdapter {
	public static	List<String> variable_name = new ArrayList<String>();
	public static   List<String> variables_modifier = new ArrayList<String>();
	public static   List<String> types1 = new ArrayList<String>();
	public void visit(FieldDeclaration n, Object arg) {
		if(n.getModifiers()!=4 && n.getModifiers()!=0){
				if(!(umlparser.flag)){
				List <VariableDeclarator> myVars = n.getVariables();
				for (VariableDeclarator vars: myVars){
					variable_name.add(vars.getId().getName());
				}
				int modifiers = n.getModifiers();
				System.out.println(n.getModifiers());
				switch(modifiers){
					case 1:
						variables_modifier.add("public");
					break;
					case 2:
						variables_modifier.add("private");
					break;
					case 4:
						variables_modifier.add("protected");
					break;
					default:
						variables_modifier.add("default");
				}
				Type type = n.getType();
				types1.add(type.toString());
			}
		}
	}
}