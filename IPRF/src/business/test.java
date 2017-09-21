package business;

public class test 
{

	public static void main(String[] args) 
	{
		PessoaSimples p = new  PessoaSimples("aaa","111",10000.0,25000.0);
		System.out.println(p.calculaImposto());
		
		PessoaCompleta p2 = new  PessoaCompleta ("aa", "11",22,10000,12000, 1);
		System.out.println(p2.calculaImposto());
	}

}
