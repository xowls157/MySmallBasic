package com.coducation.smallbasic;

import java.util.HashMap;

public class Env {
	public Env(){
		vars = new HashMap<String,Value>();
		labels = new HashMap<String,Label>();
	}
	
	public void PutValue(String str, Value val ){
		vars.put(str, val);
	}
	
	public void PutStmt(String str, Label label){
		labels.put(str, label);
	}
	
	public Value getValue(String str){
		return vars.get(str);
	}
	
	public Label getLabels(String str){
		return labels.get(str);
	}
	
    private HashMap<String,Value> vars; 		// variables { var |-> Value }
    private HashMap<String,Label> labels; 	// labels  { label |-> BlockStmt }
}
