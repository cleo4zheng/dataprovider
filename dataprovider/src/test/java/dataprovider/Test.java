package dataprovider;

public class Test {

	public static void main(String[] args) {
		
		test1();

	}
	
	
	public static void test1(){
		test();
	}
	
	public static void test(){
		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		//System.out.println(stack[stack.length-1].getMethodName());
		//System.out.println(stack[stack.length-1].getClassName());
		System.out.println(stack[stack.length-1].getFileName());
		for(StackTraceElement s : stack){
			System.out.println(s);
		}
		
	}

}
