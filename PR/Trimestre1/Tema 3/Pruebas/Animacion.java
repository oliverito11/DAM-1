

class Animacion{
	public static void main(String[] args){
		String espacios = "";
		int cont = 0;
		int limit = 20;
		while(true)
		{
			try{
				if (cont > limit)
				{
					cont = 0;
					espacios = "";
					limit--;
				}
				else
				{
					System.out.print(espacios + "|" + "\r");
					espacios += " ";
					cont++;
					Thread.sleep(50);
				}
			}catch(Exception e){}
		}		
	}
}
