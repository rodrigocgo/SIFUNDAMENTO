package uinterface;

import business.Bar;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsultaCadastro extends JFrame
{

  private JPanel contentPane;
  private JTextField txtEntradaCPF;
  private JPanel pnlDevolveConsulta;
  private JLabel lblAchou;
  
  /**
   * Launch the application.
   */
  public static void main(String[] args, Bar oBar)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          TelaConsultaCadastro frame = new TelaConsultaCadastro(oBar);
          frame.setVisible(true);
        } catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public TelaConsultaCadastro(Bar oBar)
  {
    setType(Type.UTILITY);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 373, 253);
    contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    this.setDefaultCloseOperation(TelaConsultaCadastro.HIDE_ON_CLOSE);
    
    txtEntradaCPF = new JTextField();
    txtEntradaCPF.setBounds(10, 57, 336, 20);
    contentPane.add(txtEntradaCPF);
    txtEntradaCPF.setColumns(10);
    
    JLabel lblEntraCPF = new JLabel("DIGITE O CPF DO CLIENTE");
    lblEntraCPF.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
    lblEntraCPF.setBounds(10, 39, 223, 14);
    contentPane.add(lblEntraCPF);
    
    pnlDevolveConsulta = new JPanel();
    pnlDevolveConsulta.setBackground(Color.WHITE);
    pnlDevolveConsulta.setForeground(Color.WHITE);
    pnlDevolveConsulta.setBounds(0, 139, 357, 75);
    contentPane.add(pnlDevolveConsulta);
    pnlDevolveConsulta.setLayout(null);
    
    JButton btnPesquisar = new JButton("Procurar");
     
    btnPesquisar.setBounds(10, 88, 113, 23);
    contentPane.add(btnPesquisar);
    
    JButton btnSair = new JButton("Sair");
    
    btnSair.setBounds(133, 88, 113, 23);
    contentPane.add(btnSair);   
    
    lblAchou = new JLabel("CLIENTE EST\u00C1 NO BAR");
    lblAchou.setForeground(Color.WHITE);
    lblAchou.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
    lblAchou.setBounds(73, 25, 251, 26);
    pnlDevolveConsulta.add(lblAchou);
    
    btnPesquisar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) 
      {
        boolean bClienteEsta = false;
        String sValor = txtEntradaCPF.getText();
        bClienteEsta = oBar.ClienteNoBarCPF(sValor);
        
        if (bClienteEsta == true)
        {
          pnlDevolveConsulta.setBackground(Color.GREEN);
          lblAchou.setText("CLIENTE ESTÁ NO BAR");
          lblAchou.setBackground(Color.BLACK);     
        }
        else
        {          
          pnlDevolveConsulta.setBackground(Color.RED);
          lblAchou.setText("CLIENTE NÃO ENCONTRADO");
          lblAchou.setBackground(Color.BLACK);     
        }
      }
      });
   
    btnSair.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) 
      {
        setVisible(false);
      }
    });
 
  }
  
  public void RetornaEstadOriginal()
  {
    pnlDevolveConsulta.setBackground(Color.WHITE);
    lblAchou.setBackground(Color.WHITE);
    txtEntradaCPF.setText("");
  }
}
