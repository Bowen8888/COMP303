package UnitVisitorDesignPattern;

public interface Unit extends Iterable<Unit>, Visitable
{
	String name();
	void print(String pPrefix);
}
