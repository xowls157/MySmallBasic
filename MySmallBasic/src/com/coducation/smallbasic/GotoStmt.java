package com.coducation.smallbasic;

import java.util.ArrayList;

public class GotoStmt extends Stmt
{
		public GotoStmt(String targetLabel)
		{
			super();
			this.targetLabel = targetLabel;
		} // Builder
		
		public Result evalStmt(Env env){
			Label target = env.getLabels(targetLabel);
			ArrayList<Stmt> etc = target.getEtc();
			ArrayList<Stmt> Stack = target.getStack();
			
			for(int i = 0; i < etc.size(); i++){
				(etc.get(i)).evalStmt(env);
			}
			for(int i = Stack.size()-1; i >= 0 ; i--){
				(Stack.get(i)).evalStmt(env);
			}
			
			//TODO:여기까지 진행후 GOTO "labelname" 다시 실행해야됨.
			
			return new Result(env);
		}
		
		private String targetLabel;
}
