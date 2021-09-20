class TiposDatos{
	public static void main(String[] args){
		byte numB = (byte)(Math.pow(2, 7) - 1);		//127
		short numS = (short)(Math.pow(2, 15) - 1);	//32767
		int numI = (int)(Math.pow(2, 31) - 1);		//2147483647
		long numL = (long)(Math.pow(2, 63) - 1);	//9223372036854775807
		
		float numF = (float)(Math.pow(2, 31) - 1);
		double numD = Math.pow(2, 63) - 1;
		
		System.out.println("\t\t===============");
		System.out.println("\t\tVALORES MAXIMOS");
		System.out.println("\t\t===============");
		
		System.out.println("\n\n");
		
		System.out.println("byte\t->\t" + numB);
		System.out.println("short\t->\t" + numS);
		System.out.println("int\t->\t" + numI);
		System.out.println("long\t->\t" + numL);
		System.out.println("float\t->\t" + numF);
		System.out.println("double\t->\t" + numD);
	}
}
