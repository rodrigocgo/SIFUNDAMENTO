package uinterface;
import business.Bar;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class MainForm
{

  private JFrame frame;  
  private JLabel lblPessoasCad;
  private JLabel lblPessoasnoBar;
  Bar oBar;
   

  /**
   * Launch the application.
   */
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          MainForm window = new MainForm();
          window.frame.setVisible(true);
        } catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public MainForm()
  {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void ChamaTelaRelatorio()
  {
    DialogRelatorio dlgRelatorio = new DialogRelatorio();
    dlgRelatorio.ReferenciaObjetoBar(oBar);
    dlgRelatorio.setVisible(true);
  }
  
  private void ChamaTelaCadastro()
  {
    DialogCadastro dlgCadastro = new DialogCadastro();
    dlgCadastro.ReferenciaObjetoBar(oBar);
    dlgCadastro.setVisible(true);
    AtualizaLabel();
  }
  private void ChamaTelaConsulta()
  {  
    DialogConsultaCliente dlgConsultaModal = new DialogConsultaCliente();
    dlgConsultaModal.ReferenciaObjetoBar(oBar);
    dlgConsultaModal.setVisible(true);
    
    
  }
  public void AtualizaLabel()
  {
    lblPessoasCad.setText(Integer.toString(oBar.RetornaTotalPessoasCadastradas()));
    lblPessoasnoBar.setText(Integer.toString(oBar.RetornaTotalPessoasNoBar()));
  }
  private void ChamaTelaEntradaSaida()
  {
    DialogEntradaSaida dlgEntradaSaida = new DialogEntradaSaida();
    dlgEntradaSaida.ReferenciaObjetoBar(oBar);
    dlgEntradaSaida.setVisible(true);
    AtualizaLabel();
  }
  
  private void ControlaAtalho(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_F1)
    {
      ChamaTelaCadastro();
    }
    else if (e.getKeyCode() == KeyEvent.VK_F2)
    {   
      ChamaTelaConsulta();  
    }
    else if (e.getKeyCode() == KeyEvent.VK_F3)
    {
      ChamaTelaEntradaSaida();
    }
    else if (e.getKeyCode() == KeyEvent.VK_F4)
    {
    	ChamaTelaRelatorio();
    }
    
  }
  private void initialize()
  {
    oBar = new Bar();
    frame = new JFrame();
    frame.setBounds(100, 100, 322, 393);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JLabel lblTitulo = new JLabel("Automacao Loja");
    lblTitulo.setBounds(0, 0, 306, 36);
    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 20));
    frame.getContentPane().add(lblTitulo);
    
    JButton btnFConsulta = new JButton("F2 - Consulta Cliente");
    btnFConsulta.setBounds(58, 104, 188, 25);
    
   
    btnFConsulta.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    frame.getContentPane().add(btnFConsulta);
    
    JButton btnCadastraCliente = new JButton("F1 - Cadastra Cliente");
    btnCadastraCliente.setBounds(58, 53, 188, 25);
   
    btnCadastraCliente.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    frame.getContentPane().add(btnCadastraCliente);
    
    JButton btnRegistra = new JButton("F3 - Entrada/Saida");
    btnRegistra.setBounds(58, 155, 188, 25);
    btnRegistra.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ChamaTelaEntradaSaida();
      }
    });
    
    btnRegistra.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    frame.getContentPane().add(btnRegistra);
    
    JButton btnImprimirRelatorio = new JButton("F4 -Relatorio");
    btnImprimirRelatorio.setBounds(58, 213, 188, 25);
    btnImprimirRelatorio.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    frame.getContentPane().add(btnImprimirRelatorio);
    
    JPanel pnlStatus = new JPanel();
    pnlStatus.setBounds(0, 306, 306, 49);
    frame.getContentPane().add(pnlStatus);
    pnlStatus.setLayout(null);
    
    JLabel lblTotalPessoas = new JLabel("Pessoas Cadast:");
    lblTotalPessoas.setBounds(0, 0, 95, 15);
    pnlStatus.add(lblTotalPessoas);
    lblTotalPessoas.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    
    lblPessoasCad = new JLabel("0");
    lblPessoasCad.setBounds(102, 1, 63, 14);
    pnlStatus.add(lblPessoasCad);
    
    JLabel lblPessoasNoBar = new JLabel("Pessoas no Bar:");
    lblPessoasNoBar.setBounds(3, 23, 92, 15);
    pnlStatus.add(lblPessoasNoBar);
    lblPessoasNoBar.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    
    lblPessoasnoBar = new JLabel("0");
    lblPessoasnoBar.setBounds(102, 24, 92, 14);
    pnlStatus.add(lblPessoasnoBar);

    
    btnFConsulta.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) 
      {
        ControlaAtalho(e);
      }
    });
    
    btnRegistra.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) 
      {
        ControlaAtalho(e);
      }
    });
    
    btnCadastraCliente.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) 
      {
        ControlaAtalho(e);
      }
    });
    
    btnCadastraCliente.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) 
      {    
        ChamaTelaCadastro();
   
      }
    });
    
    btnFConsulta.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) 
      {
        ChamaTelaConsulta();
      }
    });
    
    btnImprimirRelatorio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        ChamaTelaRelatorio();
      }
    });
   
  }
}