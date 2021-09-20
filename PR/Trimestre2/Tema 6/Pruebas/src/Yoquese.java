
public class Yoquese {
	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("AFSASF");
		System.out.println(a);
		actualiza(a);
		System.out.println(a);
	}
	
	public static void actualiza(StringBuffer a) {
		a.delete(0, a.length());
		a.append("A.");
	}
}
