package inheritance;

public class ChildClass extends ParentClass{
	
	public static void main(String args[])
	{
		ParentClass p = new ChildClass();
		p.read();
	}
	
	public void read()
	
	{
		System.out.println("Hi this is child class method");
	}
	
}
