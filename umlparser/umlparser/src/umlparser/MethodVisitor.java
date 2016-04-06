package umlparser;
import java.util.ArrayList;
import java.util.List;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.type.Type;
import japa.parser.ast.visitor.VoidVisitorAdapter;
@SuppressWarnings("rawtypes")
public class MethodVisitor extends VoidVisitorAdapter {
		public static List<String> Method_Modifiers = new ArrayList<String>();
		public static List<String> Class1_methods = new ArrayList<String>();
		public static List<String> types1m = new ArrayList<String>();
		public static List<List<String>> parameters_name = new ArrayList<List<String>>();
		public static List<List<String>> parameters_type = new ArrayList<List<String>>();
		public static List<List<String>> statements = new ArrayList<List<String>>();
		public static int pr=0;
		public static String getsetflag=null;
		@Override
		public void visit(MethodDeclaration n, Object arg) {
			if(n.getModifiers()!=2){
				
				if((n.getName().substring(0, 3).equals("get") || n.getName().substring(0, 3).equals("set")) && MethodVisitor.getsetflag==null){
				MethodVisitor.getsetflag=n.getName();
				}
				else if((n.getName().substring(0, 3).equals("get") || n.getName().substring(0, 3).equals("set")) && MethodVisitor.getsetflag!=null){
					try{
						umlparser.VO.get(umlparser.i).getVariable_modifier().set(umlparser.VO.get(umlparser.i).getVaribale_name().indexOf(n.getName().substring(3)), "public");
						
						
						
					}
					catch(Exception e){
						
					}
					MethodVisitor.getsetflag=null;
				
			   }
			   else{
				   Class1_methods.add(n.getName());
				   int modifiers = n.getModifiers();
				   switch(modifiers){
				   	case 1:
					Method_Modifiers.add("public");
					break;
				   	case 2:
					Method_Modifiers.add("private");
					break;
				   	case 4:
					Method_Modifiers.add("protected");
					break;
				   	default:
					Method_Modifiers.add("default");
				   }
			Type type = n.getType();
			types1m.add(type.toString());
			try{
				List<String> Partype = new ArrayList<String>();
				List<String> Parname = new ArrayList<String>();
				List<Parameter> parList = n.getParameters();
				for(Parameter partemp : parList){
					Type ptype = partemp.getType();
					Partype.add(ptype.toString());
					Parname.add(partemp.getId().getName());
				}
				parameters_type.add(Partype);
				parameters_name.add(Parname);
			}
			catch(Exception e){
			}
			try{
				List<String> mst = new ArrayList<String>();
				List<Statement> tsm = new ArrayList<Statement>();
				tsm = n.getBody().getStmts();
				for(Statement st : tsm ){
					mst.add(st.toString());
				}
				statements.add(mst);
				}
				catch(Exception e){
				}
			}
		}
    }    	
}
