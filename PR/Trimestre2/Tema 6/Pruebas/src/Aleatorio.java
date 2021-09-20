import java.util.ArrayList;
import java.util.Random;;
public class Aleatorio {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		for(int i = 0; i < 3; i++) {
			System.out.println(al.get(aleatorio(al)));
		}
	}
	
	public static int aleatorio(ArrayList<Integer> posY) {
		int num = 0;
		if(posY.size() != 0)
			num = new Random().nextInt(posY.size());
			
		posY.remove(num);
		return num;
	}
}
