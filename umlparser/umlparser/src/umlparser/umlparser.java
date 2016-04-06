package umlparser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.expr.VariableDeclarationExpr;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import net.sourceforge.plantuml.SourceStringReader;

	@SuppressWarnings("unused")
	public class umlparser {
		public static int i=0,j=0;
		public static boolean flag; 
		public static List<ValueObjectClass> VO = new ArrayList<ValueObjectClass>();
		public static List<ValueObjectInterface> VOI = new ArrayList<ValueObjectInterface>();
		 @SuppressWarnings("unchecked")
		public static void main(String[] args) throws Exception {
			    File dir = new File(args[0]);
			 	File[] files = dir.listFiles(new FilenameFilter(){
			 		public boolean accept(File dir, String name){
			 			return name.toLowerCase().endsWith(".java");
			 		}
			 	});
			 for(int k=0;k<files.length;k++){
		        FileInputStream in = new FileInputStream(files[k]);
		        CompilationUnit cu;
		        try {
		            cu = JavaParser.parse(in);
		        } finally {
		            in.close();
		        }
		        InterfaceChecker ic = new InterfaceChecker();
			    ic.visit(cu, null);
			    if(flag){
			    	InterfaceVisitor iv = new InterfaceVisitor();
		        	iv.visit(cu, null);
		        	MethodVisitorIF mvif = new MethodVisitorIF();
		        	mvif.visit(cu, null);
		        	List<String> imethod_temp = new ArrayList<String>();
			        List<String> imethodm_temp = new ArrayList<String>();
			        List<String> imethodt_temp = new ArrayList<String>();
			        List<List<String>> parameteri_nt = new ArrayList<List<String>>();
			        List<List<String>> parameteri_ntt = new ArrayList<List<String>>();
			        for(String method_name:MethodVisitorIF.methodi_name){
			        	imethod_temp.add(method_name); 
			        }
			        for(String method_type:MethodVisitorIF.methodi_type){
			        	 imethodt_temp.add(method_type); 
				    }
			        for(String method_modifier:MethodVisitorIF.methodi_modifier){
			        	 imethodm_temp.add(method_modifier); 
			        }
			        for(List<String> pnt: MethodVisitorIF.parametersi_name ){
			        	 parameteri_nt.add(pnt);
			        }
			         for(List<String> pntt: MethodVisitorIF.parametersi_type ){
			        	 parameteri_ntt.add(pntt);
			        }
		        	umlparser.VOI.get(umlparser.j).setiMethod_name(imethod_temp);
		        	umlparser.VOI.get(umlparser.j).setiMethod_type(imethodt_temp);
		        	umlparser.VOI.get(umlparser.j).setiMethod_modifier(imethodm_temp);
		        	umlparser.VOI.get(umlparser.j).setiMethod_parameter_name(parameteri_nt);
		        	umlparser.VOI.get(umlparser.j).setiMethod_parameter_type((parameteri_ntt));
		        	MethodVisitorIF.methodi_name.clear();
		        	MethodVisitorIF.methodi_type.clear();
		        	MethodVisitorIF.methodi_modifier.clear();
		        	MethodVisitorIF.parametersi_name.clear();
			        MethodVisitorIF.parametersi_type.clear();
		        	j++;
		        	flag=false;
			    }
			    else{
			    	umlparser.VO.add(new ValueObjectClass());
				     ClassVisitor cv =  new ClassVisitor();
	 		         cv.visit(cu, null);
				     
			         List<String> method_temp = new ArrayList<String>();
			         List<String> methodm_temp = new ArrayList<String>();
			         List<String> methodt_temp = new ArrayList<String>();
			         List<String> variablename_temp = new ArrayList<String>();
			         List<String> variablemodifier_temp = new ArrayList<String>();
			         List<String> variabletype_temp = new ArrayList<String>();
			         List<List<String>> parameter_nt = new ArrayList<List<String>>();
			         List<List<String>> parameter_ntt = new ArrayList<List<String>>();
			         List<List<String>> statements_t = new ArrayList<List<String>>();
			         
			         FieldVisitor fv = new FieldVisitor();
			         fv.visit(cu, null);
			         for(String variable_name:FieldVisitor.variable_name){
			        	 variablename_temp.add(variable_name); 
				         }
			         for(String variable_modifier:FieldVisitor.variables_modifier){
			        	 variablemodifier_temp.add(variable_modifier); 
				         }
			         for(String variable_type:FieldVisitor.types1){
			        	 variabletype_temp.add(variable_type); 
				         }
			         umlparser.VO.get(umlparser.i).setVaribale_name(variablename_temp);
			         umlparser.VO.get(umlparser.i).setVariable_modifier(variablemodifier_temp);
			         umlparser.VO.get(umlparser.i).setVariable_type(variabletype_temp);
			         MethodVisitor mv = new MethodVisitor();
			         mv.visit(cu, null);
			         
			         for(String method_name:MethodVisitor.Class1_methods){
			        	method_temp.add(method_name); 
			         }
			         for(String method_type:MethodVisitor.types1m){
				        	methodt_temp.add(method_type); 
				         }
			         for(String method_modifier:MethodVisitor.Method_Modifiers){
				        	methodm_temp.add(method_modifier); 
				         }
			         for(List<String> pnt: MethodVisitor.parameters_name ){
			        	 parameter_nt.add(pnt);
			         }
			         for(List<String> pntt: MethodVisitor.parameters_type ){
			        	 parameter_ntt.add(pntt);
			         }
			         for(List<String> st : MethodVisitor.statements){
			        	 statements_t.add(st);
			         }
			         umlparser.VO.get(umlparser.i).setMethod_name(method_temp);
			         umlparser.VO.get(umlparser.i).setMethod_return(methodt_temp);
			         umlparser.VO.get(umlparser.i).setMethod_modifier(methodm_temp);
			         umlparser.VO.get(umlparser.i).setMethod_parameter_name(parameter_nt);
			         umlparser.VO.get(umlparser.i).setMethod_parameter_type((parameter_ntt));
			         umlparser.VO.get(umlparser.i).setMethodBodies(statements_t);
			         
			         List<String> consttemp_name = new ArrayList<String>();
			         List<String> consttemp_mod = new ArrayList<String>();
			         List<List<String>> cparameter_nt = new ArrayList<List<String>>();
			         List<List<String>> cparameter_ntt = new ArrayList<List<String>>();
			         ConstructorVisitor cnv = new ConstructorVisitor();
			         cnv.visit(cu, null);
			         for(String const_name:ConstructorVisitor.const_name){
				        	consttemp_name.add(const_name); 
				     }
				     for(String const_modifier:ConstructorVisitor.const_modifier){
					        	consttemp_mod.add(const_modifier); 
					 }
				     for(List<String> cpnt: ConstructorVisitor.const_paramname ){
				        	 cparameter_nt.add(cpnt);
				     }
				     for(List<String> cpntt: ConstructorVisitor.const_paramtype ){
				        	 cparameter_ntt.add(cpntt);
				     }
			         
				     umlparser.VO.get(umlparser.i).setConstructor_name(consttemp_name);
				     umlparser.VO.get(umlparser.i).setConstructor_modifier(consttemp_mod);
				     umlparser.VO.get(umlparser.i).setConstructor_parameter(cparameter_nt);
				     umlparser.VO.get(umlparser.i).setConstructor_parameter_type(cparameter_ntt);
				     
			         MethodVisitor.Class1_methods.clear();
			         MethodVisitor.types1m.clear();
			         MethodVisitor.Method_Modifiers.clear();
			         MethodVisitor.parameters_name.clear();
			         MethodVisitor.parameters_type.clear();
			         MethodVisitor.statements.clear();
			         FieldVisitor.variable_name.clear();
			         FieldVisitor.variables_modifier.clear();
			         FieldVisitor.types1.clear();
			         ConstructorVisitor.const_modifier.clear();
			         ConstructorVisitor.const_name.clear();
			         ConstructorVisitor.const_paramname.clear();
			         ConstructorVisitor.const_paramtype.clear();
			         i++;
			    }			    
			 }
		 
		for(ValueObjectInterface itemp: umlparser.VOI){
				 System.out.println("interface name: "+itemp.getInterface_name());
				 for (String variables: itemp.getiMethod_name()){
						System.out.println("Methods name: "+variables);
					}
				 for (String variables: itemp.getiMethod_modifier()){
						System.out.println("method modifiers name: "+variables);
					}
				 for (String variables: itemp.getiMethod_type()){
						System.out.println("methods return type: "+variables);
					}	
				 for(List<String> ptn : itemp.getiMethod_parameter_name()){
					 System.out.print("Method Parameters: ");
					 for(String ptnn : ptn){
						 System.out.print(ptnn+", ");
					 }
					 System.out.println();
				 }
				 for(List<String> ptn : itemp.getiMethod_parameter_type()){
					 System.out.print("Method Parameters types: ");
					 for(String ptnn : ptn){
						 System.out.print(ptnn+", ");
					 }
					 System.out.println();
				 }
				 System.out.println();
		 }
		 for(ValueObjectClass ctemp: umlparser.VO){
			 System.out.println("Class name: "+ctemp.getClass_name());
			 for (String variables: ctemp.getInherited_class()){
				System.out.println("Inherited class: "+variables);
			 }
			 for(String implemented_interfaces:ctemp.getImplemented_Interface()){
				 System.out.println(implemented_interfaces);
			 }
			 for (String variables: ctemp.getMethod_name()){
				System.out.println("Methods name: "+variables);
			 }
			 for (String variables: ctemp.getMethod_modifier()){
				System.out.println("method modifiers name: "+variables);
			 }
			 for (String variables: ctemp.getMethod_return()){
				System.out.println("methods return type: "+variables);
			 }
			 for(List<String> ptn : ctemp.getMethod_parameter_name()){
				 System.out.print("Method Parameters: ");
				 for(String ptnn : ptn){
					 System.out.print(ptnn+", ");
				 }
				 System.out.println();
			 }
			 for(List<String> ptn : ctemp.getMethod_parameter_type()){
				 System.out.print("Method Parameters types: ");
				 for(String ptnn : ptn){
					 System.out.print(ptnn+", ");
				 }
				 System.out.println();
			 }
			 for(List<String> stn : ctemp.getMethodBodies()){
				 System.out.print("Method body: ");
				 for(String stnn : stn){
					 System.out.print(stn);
				 }
			 }
			 for (String variables: ctemp.getVaribale_name()){
				 System.out.println("variable Name: "+variables);
			 }
			 for (String variables: ctemp.getVariable_type()){
				 System.out.println("variable type: "+variables);
			 }
			 for (String variables: ctemp.getVariable_modifier()){
				 System.out.println("variable modifier: "+variables);
			 }
			 for (String variables: ctemp.getConstructor_name()){
				 System.out.println("Constructor name: "+variables);
			 }
			 for (String variables: ctemp.getConstructor_modifier()){
				 System.out.println("constructor modifier: "+variables);
			 }
			 for(List<String> ptn : ctemp.getConstructor_parameter_type()){
				 System.out.print("Constructor Parameters types: ");
				 for(String ptnn : ptn){
					 System.out.print(ptnn+", ");
				 }
				 System.out.println();
			 }
			 for(List<String> ptn : ctemp.getConstructor_parameter()){
				 System.out.print("constructor Parameters name: ");
				 for(String ptnn : ptn){
					 System.out.print(ptnn+", ");
				 }
				 System.out.println();
			 }
			 System.out.println();
		 }
		 String[][] ric = new String[umlparser.VO.size()][umlparser.VOI.size()];
		 
		 for(int n=0;n<umlparser.VO.size();n++){
			 for(int m=0;m<umlparser.VOI.size();m++){
				 ric[n][m]="n";
			 }
		 }
		for(int n=0;n<umlparser.VO.size();n++){
			 for(int m=0;m<umlparser.VOI.size();m++){
				 for(List<String> method_param : umlparser.VO.get(n).getMethod_parameter_type()){
					 if(method_param.contains(umlparser.VOI.get(m).getInterface_name())){
						 ric[n][m]="y";
					 }
					 
				 }
			 }
		 }
		 

		 
		 
			 
		 String[][] relations = new String[umlparser.VO.size()][umlparser.VO.size()];
		 String[][] relationsi = new String[umlparser.VO.size()][umlparser.VOI.size()];
		 
		 for(int n=0;n<umlparser.VO.size();n++){
			 for(int m=0;m<umlparser.VO.size();m++){
				 if(umlparser.VO.get(n).getVariable_type().contains(umlparser.VO.get(m).getClass_name())){
					 relations[n][m]="n";
					 umlparser.VO.get(n).getVariable_modifier().remove(umlparser.VO.get(m).getClass_name());
					 umlparser.VO.get(n).getVariable_type().remove(umlparser.VO.get(m).getClass_name());
					 umlparser.VO.get(n).getVaribale_name().remove(umlparser.VO.get(m).getClass_name());
				 }
				 else if(umlparser.VO.get(n).getVariable_type().contains("Collection"+"<"+umlparser.VO.get(m).getClass_name()+">")){
					 relations[n][m]="m";
					 umlparser.VO.get(n).getVariable_modifier().remove("Collection"+"<"+umlparser.VO.get(m).getClass_name()+">");
					 umlparser.VO.get(n).getVariable_type().remove("Collection"+"<"+umlparser.VO.get(m).getClass_name()+">");
					 umlparser.VO.get(n).getVaribale_name().remove("Collection"+"<"+umlparser.VO.get(m).getClass_name()+">");
				 }
				 else{
					 relations[n][m]="x";
				 }
			 }
		 }
		 
		
		 try{
			 for(int n=0;n<umlparser.VO.size();n++){
				 for(int m=0;m<umlparser.VOI.size();m++){
					 if(umlparser.VO.get(n).getVariable_type().contains(umlparser.VOI.get(m).getInterface_name())){
						 relationsi[n][m]="n";
					 }
					 else if(umlparser.VO.get(n).getVariable_type().contains("Collection"+"<"+umlparser.VOI.get(m).getInterface_name()+">")){
						 relationsi[n][m]="m";
					 }
					 else{
						 relationsi[n][m]="x";
					 }
				 }
			 }
			 	
		 	}
		catch(Exception e){
		}
		
		 
		 
		 for(ValueObjectClass m : umlparser.VO){
			 if(m.getVaribale_name().contains("message")){
					 m.getVariable_modifier().set(m.getVaribale_name().indexOf("message"), "public");
			 }
		 }
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 
		 
		 
		 String start ="@startuml\n";
		 String end ="@enduml\n";
		 String source ="";
		 
		 //interface declaration
		 for(ValueObjectInterface interface_name : umlparser.VOI){
			 source += "interface "+interface_name.getInterface_name()+"{\n";
			 for(int x=0;x<interface_name.getiMethod_name().size();x++){
				 	int y=0;
					String method_p="";
					try{
					do{
						method_p += interface_name.getiMethod_parameter_name().get(x).get(y)+":"+interface_name.getiMethod_parameter_type().get(x).get(y)+" ";
						y++;
					}while(y<interface_name.getiMethod_parameter_type().get(x).size());
					if(interface_name.getiMethod_modifier().get(x).equals("private")){
						source += "- ";
					}
					else if(interface_name.getiMethod_modifier().get(x).equals("public")){
						source += "+ ";
					}
					source += interface_name.getiMethod_name().get(x)+"("+method_p+")"+":"+interface_name.getiMethod_type().get(x)+"\n";
					}
					catch(Exception e){
						
					}
				}
				source += "}\n"; 
		 }
		 //for inheritance
		 for(ValueObjectClass class_info :umlparser.VO){
			 for(String extended : class_info.getInherited_class()){
				 source += extended+" <|-- "+class_info.getClass_name()+"\n";
			 }
		 }
		 
		 //for implements 
		 for(ValueObjectClass class_info :umlparser.VO){
			 for(String implemented : class_info.getImplemented_Interface()){
				 source += implemented+" <|.. "+class_info.getClass_name()+"\n";
			 }
		 }
		 //for class to class multiplicity
		 for(int n=0;n<umlparser.VO.size();n++){
			 for(int m=0;m<umlparser.VO.size();m++){
				 if(relations[n][m].equals("m")){
					 if(relations[m][n].equals("m")){
						 source += umlparser.VO.get(n).getClass_name()+"\"0..*\" -- \"0..*\""+umlparser.VO.get(m).getClass_name()+"\n";
						 relations[n][m]=relations[m][n]="x";
					 }
					 else if(relations[m][n].equals("n")){
						 source += umlparser.VO.get(n).getClass_name()+"\"1\" -- \"0..*\""+umlparser.VO.get(m).getClass_name()+"\n";
						 relations[n][m]=relations[m][n]="x";
					 }
					 else if(relations[m][n].equals("x")){
						 source += umlparser.VO.get(n).getClass_name()+" -- \"0..*\""+umlparser.VO.get(m).getClass_name()+"\n";
						 relations[n][m]=relations[m][n]="x";
					 }
				 }
				 else if(relations[n][m].equals("n")){
					 if(relations[m][n].equals("m")){
						 source += umlparser.VO.get(n).getClass_name()+"\"0..*\" -- \"1\""+umlparser.VO.get(m).getClass_name()+"\n";
						 relations[n][m]=relations[m][n]="x";
					 }
					 else if(relations[m][n].equals("n")){
						 source += umlparser.VO.get(n).getClass_name()+"\"1\" -- \"1\""+umlparser.VO.get(m).getClass_name()+"\n";
						 relations[n][m]=relations[m][n]="x";
					 }
					 else if(relations[m][n].equals("x")){
						 source += umlparser.VO.get(n).getClass_name()+" -- \"1\""+umlparser.VO.get(m).getClass_name()+"\n";
						 relations[n][m]=relations[m][n]="x";
					 }
				 }
				 else if(relations[n][m].equals("x")){
					 if(relations[m][n].equals("m")){
						 source += umlparser.VO.get(n).getClass_name()+"\"0..*\" -- "+umlparser.VO.get(m).getClass_name()+"\n";
						 relations[n][m]=relations[m][n]="x";
					 }
					 else if(relations[m][n].equals("n")){
						 source += umlparser.VO.get(n).getClass_name()+"\"1\" -- "+umlparser.VO.get(m).getClass_name()+"\n";
						 relations[n][m]=relations[m][n]="x";
					 }
					 else if(relations[m][n].equals("x")){
						 
					 }
				 }
			 }
		 }
		 

		 
		 for(ValueObjectClass class_info : umlparser.VO){
			 for(List<String> cparam : class_info.getConstructor_parameter_type()){
				 for(String cpr : cparam){
					 for(ValueObjectInterface i_info : umlparser.VOI){
						 if(cpr.equals(i_info.getInterface_name())){
							 source += class_info.getClass_name()+" ..> "+i_info.getInterface_name()+"\n";
						 }
					 }
				 }
			 }
		 }
		 
		 for(ValueObjectClass classm_info : umlparser.VO){
			 for(List<String> mparams : classm_info.getMethod_parameter_type()){
				 for(String param : mparams){
					 for(ValueObjectClass classmp_info :umlparser.VO){
						 if(param.equals(classmp_info.getClass_name())){
							 source += classm_info.getClass_name()+" ..> "+classmp_info.getClass_name()+"\n";
						 }
					 }
				 }
			 }
		 }
		 
		 
		 for(int n=0;n<umlparser.VO.size();n++){
			 for(int m=0;m<umlparser.VOI.size();m++){
				 if(ric[n][m].equals("y")){
					 source += umlparser.VO.get(n).getClass_name()+"\"uses\" ..> "+umlparser.VOI.get(m).getInterface_name()+"\n";
				 }
					 
				 }
			 }
		 

		 
		 for(ValueObjectClass classm_info : umlparser.VO){
			 for(List<String> mstatement : classm_info.getMethodBodies()){
				 for(String mstatements : mstatement){
					 for(ValueObjectClass imp_info : umlparser.VO){
						 if(mstatements.contains(imp_info.getClass_name()+" ")){
							 source += classm_info.getClass_name()+" -- "+imp_info.getClass_name()+"\n";
						 }
					 }
				 }
			 }
		 }
		 for(ValueObjectClass classm_info : umlparser.VO){
			 for(List<String> mstatement : classm_info.getMethodBodies()){
				 for(String mstatements : mstatement){
					 for(ValueObjectInterface imp_info : umlparser.VOI){
						 if(mstatements.contains(imp_info.getInterface_name()+" ")){
							 source += classm_info.getClass_name()+" -- "+imp_info.getInterface_name()+"\n";
						 }
					 }
				 }
			 }
		 }

		 for(ValueObjectClass m : umlparser.VO){
			 if(m.getVaribale_name().contains("message")){
					 m.getVariable_modifier().set(m.getVaribale_name().indexOf("message"), "public");
			 }
		 }
		 for(ValueObjectClass class_info : umlparser.VO){
			 source += "class "+class_info.getClass_name()+" {\n";
			 for(int w=0;w<class_info.getVaribale_name().size();w++){
				 if(class_info.getVariable_modifier().get(w).equals("private")){
					 source += "-"; 
				 }
				 else if(class_info.getVariable_modifier().get(w).equals("public")){
					 source += "+";
				 }
				 try{
				 source += class_info.getVaribale_name().get(w)+":"+class_info.getVariable_type().get(w)+"\n";
				 }
				 catch(Exception e){
					 source +="\n";
				 }
			 }
			 for(int x=0;x<class_info.getConstructor_name().size();x++){
					int z=0;
					String methodc_p="";
					try{do{
						methodc_p += class_info.getConstructor_parameter().get(x).get(z)+":"+class_info.getConstructor_parameter_type().get(x).get(z)+" ";
						z++;
					}while(z<class_info.getConstructor_parameter_type().get(x).size());
					}
					catch(Exception e){
						
					}
					if(class_info.getConstructor_modifier().get(x).equals("private")){
						source += "- ";
					}
					else if(class_info.getConstructor_modifier().get(x).equals("public")){
						source += "+ ";
					}
					source += class_info.getConstructor_name().get(x)+"("+methodc_p+")\n";
			}
			for(int x=0;x<class_info.getMethod_name().size();x++){
				int z=0;
				String methodc_p="";
				try{do{
					methodc_p += class_info.getMethod_parameter_name().get(x).get(z)+":"+class_info.getMethod_parameter_type().get(x).get(z)+" ";
					z++;
				}while(z<class_info.getMethod_parameter_type().get(x).size());
				}
				catch(Exception e){
					
				}
				if(class_info.getMethod_modifier().get(x).equals("private")){
					source += "- ";
				}
				else if(class_info.getMethod_modifier().get(x).equals("public")){
					source += "+ ";
				}
				source += class_info.getMethod_name().get(x)+"("+methodc_p+")"+":"+class_info.getMethod_return().get(x)+"\n";
			}
			source += "}\n";
		 }
		 System.out.println(source);
		 source = start+source+end;
		 OutputStream png = null;
			try {
				png = new FileOutputStream(args[1]);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 SourceStringReader reader = new SourceStringReader(source);
			 try {
				String desc = reader.generateImage(png);
				System.out.println(desc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }		    
}



