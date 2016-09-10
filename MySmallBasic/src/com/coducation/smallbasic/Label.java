package com.coducation.smallbasic;

import java.util.ArrayList;
import java.util.Iterator;

public class Label extends Stmt
{
		public Label(String label)
		{
			super();
			this.label = label;
			this.Stack_stmt = new ArrayList<Stmt>();
			this.etc_stmt = new ArrayList<Stmt>();
		} // Builder
		
		public Result evalStmt(Env env){
			if(etc_stmt.size() != 0 ){	//이미채워져 있을경우 이미 한번 실행한 Label.
				return new Result(env);
			}
			
			Iterator<Stmt> it = Interpreter.getStack().iterator();
			while(it.hasNext()){
				Stack_stmt.add(it.next());	//Interpreter->Stack의 값 복사.
			}
			
			Stack_stmt.remove(Stack_stmt.size()-1);	
			Stmt upper_stmt = Stack_stmt.get(Stack_stmt.size()-1);
			
			if(upper_stmt instanceof WhileStmt){
				BlockStmt bs = (BlockStmt)((WhileStmt) upper_stmt).getStmt();	//while의 blockStmt를 얻음.
				ArrayList<Stmt> bs_Stmt = bs.getAL();							//blockStmt의 stmtList를 얻음.
				
				//label이 확인 될때, 그아래  Stmt list들을 저장.
				for(int i = 0; i < bs_Stmt.size(); i++){
					if(bs_Stmt.get(i) == this){
						i++;
						while(i<bs_Stmt.size()){ 
							etc_stmt.add(bs_Stmt.get(i++));
						}
					}
				}
			}
			
			env.PutStmt(label, this);
			
			return new Result(env);
		}
		
		public ArrayList<Stmt> getStack(){return Stack_stmt;}
		public ArrayList<Stmt> getEtc(){return etc_stmt;}
		
		private String label;
		private ArrayList<Stmt> Stack_stmt;	//순환되는 구조가 필요.
		private ArrayList<Stmt> etc_stmt;	//하위 stmt.
}
