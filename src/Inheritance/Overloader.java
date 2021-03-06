package Inheritance;

public class Overloader {
	public static void main(String[] pArgs)
	{
		System.out.println("1 " + new Overloader().doit("Foo"));
		System.out.println("2 " +new Overloader().doit(12));
		System.out.println("3 " +new Overloader().doit(12.3));
		System.out.println("4 " +new Overloader().doit(new Manager("Alice",12000,2000)));
		System.out.println("5 " +new Overloader().doit(new double[10]));
		System.out.println("6 " +new Overloader().doit(Long.MAX_VALUE));
		System.out.println("7 " +new Overloader().doit(new Employee("AMO",1200)));
		
		String foo = "Foo";
		new Overloader().redirector(foo);
		new Overloader().redirector(12);
		
		new Overloader(null);
		
		double x = 100 ;
		int y = (int) x;
		double z = y;
		System.out.println("8 " +new Overloader().doit(y));

		System.out.println("9 " +new Overloader().doit(z));
	}
	
	public void redirector(Object p){
		System.out.println(new Overloader().doit(p));
	}
	
	public String doit(int p){
		return "Int";
	}
	
	public String doit(long p){
		return "long";
	}
	
	public String doit(double p){
		return "double";
	}
	
	public String doit(Employee p){
		return "Employee";
	}
	
	public String doit(Manager p){
		return "Manager";
	}
	
	public String doit(String p)
	{
		return "String";
	}

	public String doit(Object p)
	{
		return "Object";
	}
	
	public Overloader()
	{
		
	}
	
	public Overloader(Object p)
	{
		System.out.println("Object");

	}
	
	public Overloader(double[] p)
	{
		System.out.println("Double Array");
	}
	/*This causes the new Overloader(null); in main to be ambiguous.
	public Overloader(int[] p)
	{
		System.out.println("Int Array");
	}*/
			
}

