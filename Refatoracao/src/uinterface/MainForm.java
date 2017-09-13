package uinterface;
import business.Bar;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
      
    }
    
  }
  private void initialize()
  {
    oBar = new Bar();
    frame = new JFrame();
    frame.setBounds(100, 100, 322, 393);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SpringLayout springLayout = new SpringLayout();
    frame.getContentPane().setLayout(springLayout);
    
    JLabel lblTitulo = new JLabel("Automacao Loja");
    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    springLayout.putConstraint(SpringLayout.NORTH, lblTitulo, 0, SpringLayout.NORTH, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.WEST, lblTitulo, 0, SpringLayout.WEST, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.SOUTH, lblTitulo, 36, SpringLayout.NORTH, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.EAST, lblTitulo, 0, SpringLayout.EAST, frame.getContentPane());
    lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 20));
    frame.getContentPane().add(lblTitulo);
    
    JButton btnFConsulta = new JButton("F2 - Consulta Cliente");
    springLayout.putConstraint(SpringLayout.EAST, btnFConsulta, -60, SpringLayout.EAST, frame.getContentPane());
    
   
    btnFConsulta.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    frame.getContentPane().add(btnFConsulta);
    
    JButton btnCadastraCliente = new JButton("F1 - Cadastra Cliente");
    springLayout.putConstraint(SpringLayout.WEST, btnCadastraCliente, 58, SpringLayout.WEST, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.EAST, btnCadastraCliente, -60, SpringLayout.EAST, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.NORTH, btnFConsulta, 26, SpringLayout.SOUTH, btnCadastraCliente);
    springLayout.putConstraint(SpringLayout.WEST, btnFConsulta, 0, SpringLayout.WEST, btnCadastraCliente);
    springLayout.putConstraint(SpringLayout.NORTH, btnCadastraCliente, 17, SpringLayout.SOUTH, lblTitulo);
   
    btnCadastraCliente.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    frame.getContentPane().add(btnCadastraCliente);
    
    JButton btnRegistra = new JButton("F3 - Entrada/Saida");
    springLayout.putConstraint(SpringLayout.NORTH, btnRegistra, 26, SpringLayout.SOUTH, btnFConsulta);
    springLayout.putConstraint(SpringLayout.WEST, btnRegistra, 0, SpringLayout.WEST, btnFConsulta);
    springLayout.putConstraint(SpringLayout.EAST, btnRegistra, -60, SpringLayout.EAST, frame.getContentPane());
    btnRegistra.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ChamaTelaEntradaSaida();
      }
    });
    
    btnRegistra.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    frame.getContentPane().add(btnRegistra);
    
    JButton btnImprimirRelatorio = new JButton("F4 -Relatorio");
    springLayout.putConstraint(SpringLayout.NORTH, btnImprimirRelatorio, 33, SpringLayout.SOUTH, btnRegistra);
    springLayout.putConstraint(SpringLayout.WEST, btnImprimirRelatorio, 58, SpringLayout.WEST, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.EAST, btnImprimirRelatorio, 0, SpringLayout.EAST, btnFConsulta);
    btnImprimirRelatorio.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    frame.getContentPane().add(btnImprimirRelatorio);
    
    JLabel lblTotalPessoas = new JLabel("Pessoas Cadast.:");
    springLayout.putConstraint(SpringLayout.NORTH, lblTotalPessoas, 307, SpringLayout.NORTH, frame.getContentPane());
    lblTotalPessoas.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    frame.getContentPane().add(lblTotalPessoas);
    
    JLabel lblPessoasNoBar = new JLabel("Pessoas no Bar.:");
    springLayout.putConstraint(SpringLayout.NORTH, lblPessoasNoBar, 326, SpringLayout.NORTH, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.EAST, lblTotalPessoas, 0, SpringLayout.EAST, lblPessoasNoBar);
    springLayout.putConstraint(SpringLayout.WEST, lblPessoasNoBar, 10, SpringLayout.WEST, frame.getContentPane());
    lblPessoasNoBar.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    frame.getContentPane().add(lblPessoasNoBar);
    
    lblPessoasnoBar = new JLabel("0");
    springLayout.putConstraint(SpringLayout.NORTH, lblPessoasnoBar, 326, SpringLayout.NORTH, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.WEST, lblPessoasnoBar, 8, SpringLayout.EAST, lblPessoasNoBar);
    frame.getContentPane().add(lblPessoasnoBar);
    
    lblPessoasCad = new JLabel("0");
    springLayout.putConstraint(SpringLayout.WEST, lblPessoasCad, 8, SpringLayout.EAST, lblTotalPessoas);
    springLayout.putConstraint(SpringLayout.SOUTH, lblPessoasCad, -33, SpringLayout.SOUTH, frame.getContentPane());
    frame.getContentPane().add(lblPessoasCad);

    
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