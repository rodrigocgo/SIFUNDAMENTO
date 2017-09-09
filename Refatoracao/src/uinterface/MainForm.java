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

public class MainForm
{

  private JFrame frame;  
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
  private void ChamaTelaConsulta()
  {
    TelaConsultaCadastro.main(null, oBar);
  }
  
  private void ControlaAtalho(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_F1)
    {
   
    }
    else if (e.getKeyCode() == KeyEvent.VK_F2)
    {
      ChamaTelaConsulta();
    }
    else if (e.getKeyCode() == KeyEvent.VK_F3)
    {
      
    }
    else if (e.getKeyCode() == KeyEvent.VK_F4)
    {
      
    }
  }
  private void initialize()
  {
    oBar = new Bar();
    frame = new JFrame();
    frame.setBounds(100, 100, 294, 366);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SpringLayout springLayout = new SpringLayout();
    frame.getContentPane().setLayout(springLayout);
    
    JLabel lblTitulo = new JLabel("Automa\u00E7\u00E3o Loja");
    springLayout.putConstraint(SpringLayout.NORTH, lblTitulo, 10, SpringLayout.NORTH, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.WEST, lblTitulo, 58, SpringLayout.WEST, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.EAST, lblTitulo, -47, SpringLayout.EAST, frame.getContentPane());
    lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 20));
    frame.getContentPane().add(lblTitulo);
    
    JButton btnFConsulta = new JButton("F2 - Consulta Cliente");
    
   
    btnFConsulta.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    springLayout.putConstraint(SpringLayout.WEST, btnFConsulta, 0, SpringLayout.WEST, lblTitulo);
    frame.getContentPane().add(btnFConsulta);
    
    JButton btnCadastraCliente = new JButton("F1 - Cadastra Cliente");
   
    btnCadastraCliente.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    springLayout.putConstraint(SpringLayout.NORTH, btnFConsulta, 17, SpringLayout.SOUTH, btnCadastraCliente);
    springLayout.putConstraint(SpringLayout.EAST, btnFConsulta, 0, SpringLayout.EAST, btnCadastraCliente);
    springLayout.putConstraint(SpringLayout.WEST, btnCadastraCliente, 58, SpringLayout.WEST, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.SOUTH, btnCadastraCliente, -234, SpringLayout.SOUTH, frame.getContentPane());
    springLayout.putConstraint(SpringLayout.EAST, btnCadastraCliente, -80, SpringLayout.EAST, frame.getContentPane());
    frame.getContentPane().add(btnCadastraCliente);
    
    JButton btnRegistra = new JButton("F3 - Entrada CPF");
    
    btnRegistra.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    springLayout.putConstraint(SpringLayout.NORTH, btnRegistra, 21, SpringLayout.SOUTH, btnFConsulta);
    springLayout.putConstraint(SpringLayout.WEST, btnRegistra, 0, SpringLayout.WEST, lblTitulo);
    springLayout.putConstraint(SpringLayout.EAST, btnRegistra, 0, SpringLayout.EAST, btnFConsulta);
    frame.getContentPane().add(btnRegistra);
    
    JButton btnSaida = new JButton("F4 - Saida CPF");
    
    btnSaida.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
    springLayout.putConstraint(SpringLayout.NORTH, btnSaida, 21, SpringLayout.SOUTH, btnRegistra);
    springLayout.putConstraint(SpringLayout.WEST, btnSaida, 0, SpringLayout.WEST, lblTitulo);
    springLayout.putConstraint(SpringLayout.EAST, btnSaida, 0, SpringLayout.EAST, btnFConsulta);
    frame.getContentPane().add(btnSaida);

    
    btnFConsulta.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) 
      {
        ControlaAtalho(e);
      }
    });
    
    btnSaida.addKeyListener(new KeyAdapter() {
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
       
      }
    });
    
    btnFConsulta.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) 
      {
        ChamaTelaConsulta();
      }
    });
  }
}