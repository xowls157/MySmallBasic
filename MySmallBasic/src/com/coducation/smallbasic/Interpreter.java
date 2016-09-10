package com.coducation.smallbasic;

import java.util.ArrayList;

public class Interpreter {
	public Interpreter(Nonterminal tree){
		Tree = tree;
		env = new Env();
	}
	
	public void Interpreting(){
		try {
				BlockStmt stmt = (BlockStmt)Tree.getTree();
				stmt.evalStmt(env);
			
		} catch (Exception e) {
			//TODO : 사용 X, 제거예정.
			String labelname = e.getMessage();
			Env tempEnv = env;
			BlockStmt stmt = (BlockStmt)Tree.getTree();	
			ArrayList<Stmt> arr = stmt.getAL();	//전체 트리
			
			//전체 트리에서 label이 나올때 까지 하나씩 확인함.
			for(int i = 0; i < arr.size(); i++){
				if(arr.get(i) instanceof WhileStmt || arr.get(i) instanceof ForStmt){ //재귀로?
				
					BlockStmt bs = (BlockStmt)(arr.get(i)).getStmt();
					
					for(;i < bs.getAL().size();i++){
						
					}
				}
				else if(arr.get(i) instanceof IfStmt){
					
				}
				else{
					
				}
			}
		}
	}
	
//	private int atoi(String a)
//	{
//		int result = 0;
//		for(int i = 0; i < a.length(); i++)
//		{
//			result = result * 10;
//			result = result + (a.charAt(i) - '0');
//		}
//		return result;	
//	}
	
	public static void push(Stmt stmt){
		stack.add(stmt);
	}
	
	public static Stmt pop(int index){
		Stmt stmt = stack.get(index);
		stack.remove(index);
		return stmt;
	}
	
	public static ArrayList<Stmt> getStack(){
		return stack;
	}
	
	public static int getStackSize(){
		return stack.size();
	}
	
	public static void stackInit(){
		stack = new ArrayList<Stmt>();
	}
	
	public static boolean isNum(String str) throws NumberFormatException {
		if(str==null) return false;
		try{
			double d = Double.parseDouble(str);
		}
		catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
	
	public static boolean parsetoBoolean(String str){
		String _true = "true";
		
		if ( _true.equals(str.toLowerCase()) ){
			return true;
		}
		else {
			return false;
		}
	}
	private static ArrayList<Stmt> stack;
	private Nonterminal Tree;
	private Env env;
}
