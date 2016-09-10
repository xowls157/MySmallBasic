package com.coducation.smallbasic;

public class WhileStmt extends Stmt
{
		public WhileStmt(CondExpr cond, Stmt block)
		{
			super();
			this.cond = cond;
			this.block = block;
		} // Builder
		
		public Result evalStmt(Env env){
			Result res = new Result(env);
			
			while(true){
				if( ((StrV)((cond.evalExpr(env)).getValue())).getValue() == "true"){					
					res = block.evalStmt(env);
				}
				else
					break;
			}
			
			return res;
		}
		
		public Stmt getStmt(){
			return block;
		}
		
		private CondExpr cond;
		private Stmt block;
}
