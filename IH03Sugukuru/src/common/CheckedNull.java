package common;

public class CheckedNull {

	public boolean checked(String str){
		
		boolean flg  = false;
		
		if(!str.equals("")){
			flg = true;
		}
		
		return flg;
	}
}
