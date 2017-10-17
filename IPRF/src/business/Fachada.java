package business;

public class Fachada
{
  private PessoaCompleta oPessoaCompleta;
  private PessoaSimples oPessoaSimples;
  
  
  public double DeclaracaoSimples(String sNome, String sCPF,double dTotalRendimento,double dContruibuicaoPrevidenciari)
  {
    oPessoaSimples =  new PessoaSimples(sNome, sCPF,dTotalRendimento,dContruibuicaoPrevidenciari);
    double dRetorno = oPessoaSimples.calculaImposto();
    oPessoaSimples = null;
    return dRetorno;
  }
  
  public double DeclaracaComposto(String sNome, String sCPF,int iIdade,double dTotalRendimento, double dContruibuicaoPrevidenciaria, int iNumeroDependetes)
  {
    oPessoaCompleta = new PessoaCompleta(sNome, sCPF,iIdade,dTotalRendimento, dContruibuicaoPrevidenciaria, iNumeroDependetes);
    double dRetorno = oPessoaCompleta.calculaImposto();
    oPessoaCompleta = null;
    return dRetorno;
  }
}
