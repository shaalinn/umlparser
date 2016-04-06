package umlparser;

import java.util.ArrayList;
import java.util.List;

public class ValueObjectInterface {
	
	private String Interface_name;
	private List<String> iMethod_name = new ArrayList<String>();
	private List<String> iMethod_type = new ArrayList<String>();
	private List<String> iMethod_modifier = new ArrayList<String>();
	private List<List<String>> iMethod_parameter_name = new ArrayList<List<String>>();
	private List<List<String>> iMethod_parameter_type = new ArrayList<List<String>>();
	
	public String getInterface_name() {
		return this.Interface_name;
	}
	public void setInterface_name(String interface_name) {
		this.Interface_name = interface_name;
	}
	
	public List<String> getiMethod_name() {
		return this.iMethod_name;
	}
	public void setiMethod_name(List<String> iMethod_name) {
		this.iMethod_name = iMethod_name;
	}
	
	public List<String> getiMethod_type() {
		return this.iMethod_type;
	}
	public void setiMethod_type(List<String> iMethod_type) {
		this.iMethod_type = iMethod_type;
	}
	
	public List<String> getiMethod_modifier() {
		return this.iMethod_modifier;
	}
	public void setiMethod_modifier(List<String> iMethod_modifier) {
		this.iMethod_modifier = iMethod_modifier;
	}
	////
	public List<List<String>> getiMethod_parameter_name() {
		return this.iMethod_parameter_name;
	}
	public void setiMethod_parameter_name(List<List<String>> iMethod_parameter_name) {
		this.iMethod_parameter_name = iMethod_parameter_name;
	}
	public List<List<String>> getiMethod_parameter_type() {
		return this.iMethod_parameter_type;
	}
	public void setiMethod_parameter_type(List<List<String>> iMethod_parameter_type) {
		this.iMethod_parameter_type = iMethod_parameter_type;
	}
	
	
}
