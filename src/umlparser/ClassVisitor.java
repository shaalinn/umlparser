package umlparser;
import java.util.ArrayList;
import java.util.List;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;
@SuppressWarnings("rawtypes")
public class ClassVisitor extends VoidVisitorAdapter {
	public void visit (ClassOrInterfaceDeclaration n, Object arg){
		if(!n.isInterface()){	
			umlparser.VO.get(umlparser.i).setClass_name(n.getName());
			try{
				List<ClassOrInterfaceType> inheritances =new ArrayList<ClassOrInterfaceType>();
				inheritances=n.getExtends();
				List<String> Class1_inheritances = new ArrayList<String>();
				for(ClassOrInterfaceType inheritance :inheritances){
				Class1_inheritances.add(inheritance.getName());	
				}
				umlparser.VO.get(umlparser.i).setInherited_class(Class1_inheritances);
			}
			catch(Exception e){
			}
			List<ClassOrInterfaceType> interfaces =n.getImplements();
			List<String> Class1_interfaces = new ArrayList<String>();
			try{
				for(ClassOrInterfaceType interfac :interfaces){
					Class1_interfaces.add(interfac.getName());	
				}
				umlparser.VO.get(umlparser.i).setImplemented_Interface(Class1_interfaces);
			}
			catch(Exception e){
			}
			}
		}
}