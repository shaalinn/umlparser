package umlparser;

import java.util.ArrayList;
import java.util.List;

import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.type.Type;
import japa.parser.ast.visitor.VoidVisitorAdapter;

@SuppressWarnings("rawtypes")
public class ConstructorVisitor extends VoidVisitorAdapter {
	public static List<String> const_name = new ArrayList<String>();
	public static List<String> const_modifier = new ArrayList<String>();
	public static List<List<String>> const_paramtype = new ArrayList<List<String>>();
	public static List<List<String>> const_paramname = new ArrayList<List<String>>();
	
	public void visit(ConstructorDeclaration n, Object arg){
		const_name.add(n.getName());
		int modifier = n.getModifiers();
		switch(modifier){
		case 1:
			const_modifier.add("public");
		break;
		case 2:
			const_modifier.add("private");
			break;
		case 4:
			const_modifier.add("protected");
			break;
		default:
			const_modifier.add("default");
		}
		try{
			List<String> Partype = new ArrayList<String>();
			List<String> Parname = new ArrayList<String>();
			List<Parameter> parList = n.getParameters();
			for(Parameter partemp : parList){
				Type ptype = partemp.getType();
				Partype.add(ptype.toString());
				Parname.add(partemp.getId().getName());
			}
			const_paramtype.add(Partype);
			const_paramname.add(Parname);
		}
		catch(Exception e){
		}
	}
}
