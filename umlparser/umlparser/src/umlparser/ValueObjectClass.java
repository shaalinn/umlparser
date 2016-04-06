package umlparser;
import java.util.ArrayList;
import java.util.List;
public class ValueObjectClass {
	private String class_name;
	private List<String> Inherited_class = new ArrayList<String>();
	private List<String> Implemented_Interface = new ArrayList<String>();
	private List<String> Method_name = new ArrayList<String>();
	private List<String> Method_return = new ArrayList<String>();
	private List<String> Method_modifier = new ArrayList<String>();
	private List<String> Varibale_name = new ArrayList<String>();
	private List<String> Variable_type = new ArrayList<String>();
	private List<String> Variable_modifier = new ArrayList<String>();
	private List<List<String>> Method_parameter_name = new ArrayList<List<String>>();
	private List<List<String>> Method_parameter_type = new ArrayList<List<String>>();
	private List<String> constructor_name = new ArrayList<String>();
	private List<String> constructor_modifier = new ArrayList<String>();
	private List<List<String>> constructor_parameter = new ArrayList<List<String>>();
	private List<List<String>> constructor_parameter_type = new ArrayList<List<String>>();
	private List<List<String>> MethodBodies = new ArrayList<List<String>>();
	
	public String getClass_name() {
		return this.class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public List<String> getInherited_class() {
		return this.Inherited_class;
	}
	public void setInherited_class(List<String> inherited_class) {
		this.Inherited_class = inherited_class;
	}
	public List<String> getImplemented_Interface() {
		return this.Implemented_Interface;
	}
	public void setImplemented_Interface(List<String> implemented_Interface) {
		this.Implemented_Interface = implemented_Interface;
	}
	public List<String> getMethod_name() {
		return this.Method_name;
	}
	public void setMethod_name(List<String> method_name) {
		this.Method_name = method_name;
	}
	public List<String> getMethod_return() {
		return this.Method_return;
	}
	public void setMethod_return(List<String> method_return) {
		this.Method_return = method_return;
	}
	public List<String> getMethod_modifier() {
		return this.Method_modifier;
	}
	public void setMethod_modifier(List<String> method_modifier) {
		this.Method_modifier = method_modifier;
	}
	public List<String> getVaribale_name() {
		return this.Varibale_name;
	}
	public void setVaribale_name(List<String> varibale_name) {
		this.Varibale_name = varibale_name;
	}
	public List<String> getVariable_type() {
		return this.Variable_type;
	}
	public void setVariable_type(List<String> variable_type) {
		this.Variable_type = variable_type;
	}
	public List<String> getVariable_modifier() {
		return this.Variable_modifier;
	}
	public void setVariable_modifier(List<String> variable_modifier) {
		this.Variable_modifier = variable_modifier;
	}
	public List<List<String>> getMethod_parameter_name() {
		return this.Method_parameter_name;
	}
	public void setMethod_parameter_name(List<List<String>> method_parameter_name) {
		this.Method_parameter_name = method_parameter_name;
	}
	public List<List<String>> getMethod_parameter_type() {
		return this.Method_parameter_type;
	}
	public void setMethod_parameter_type(List<List<String>> method_parameter_type) {
		this.Method_parameter_type = method_parameter_type;
	}
	public List<String> getConstructor_name() {
		return this.constructor_name;
	}
	public void setConstructor_name(List<String> constructor_name) {
		this.constructor_name = constructor_name;
	}
	public List<String> getConstructor_modifier() {
		return this.constructor_modifier;
	}
	public void setConstructor_modifier(List<String> constructor_modifier) {
		this.constructor_modifier = constructor_modifier;
	}
	public List<List<String>> getConstructor_parameter() {
		return this.constructor_parameter;
	}
	public void setConstructor_parameter(List<List<String>> constructor_parameter) {
		this.constructor_parameter = constructor_parameter;
	}
	public List<List<String>> getConstructor_parameter_type() {
		return this.constructor_parameter_type;
	}
	public void setConstructor_parameter_type(List<List<String>> constructor_parameter_type) {
		this.constructor_parameter_type = constructor_parameter_type;
	}
	public List<List<String>> getMethodBodies() {
		return this.MethodBodies;
	}
	public void setMethodBodies(List<List<String>> methodBodies) {
		this.MethodBodies = methodBodies;
	}
	
	
	
}
