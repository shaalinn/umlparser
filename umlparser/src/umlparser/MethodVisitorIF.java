package umlparser;
import java.util.ArrayList;
import java.util.List;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.type.Type;
import japa.parser.ast.visitor.VoidVisitorAdapter;
@SuppressWarnings("rawtypes")
public class MethodVisitorIF extends VoidVisitorAdapter {
		public static List<String> methodi_modifier = new ArrayList<String>();
		public static List<String> methodi_name = new ArrayList<String>();
		public static List<String> methodi_type = new ArrayList<String>();
		public static List<List<String>> parametersi_name = new ArrayList<List<String>>();
		public static List<List<String>> parametersi_type = new ArrayList<List<String>>();
		public static int pri=0;
		@Override
	    public void visit(MethodDeclaration n, Object arg) {
			if(n.getModifiers() != 2){
				
			methodi_name.add(n.getName());
			int modifiers = n.getModifiers();
			switch(modifiers){
				case 1:
					methodi_modifier.add("public");
				break;
				case 2:
					methodi_modifier.add("private");
				break;
				case 4:
					methodi_modifier.add("protected");
				break;
				default:
					methodi_modifier.add("default");
			}
			Type type = n.getType();
			methodi_type.add(type.toString());
			try{
				List<String> Partype = new ArrayList<String>();
				List<String> Parname = new ArrayList<String>();
				List<Parameter> parList = n.getParameters();
				for(Parameter partemp : parList){
					Type ptype = partemp.getType();
					Partype.add(ptype.toString());
					Parname.add(partemp.getId().getName());
				}
				parametersi_type.add(Partype);
				parametersi_name.add(Parname);
				}
			catch(Exception e){
			}
			
		}
	  }
}
