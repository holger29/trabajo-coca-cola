//package firstproyect;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coke extends JFrame{
 //atributos
 
 private JPanel CP;
 private JLabel lb1,lb2,lb3;
 public JLabel lb4;
 public static JTextField myfield1;
 public static String nom="";
 private JButton btn1;
 public Color redcolor,whitecolor,purplecolor,blackcolor;
 public Image cokeicon;
 public ImageIcon cokeimage;
 public Font Bold;

 //constructor
 public Coke(String titulo,int x, int y){
  setTitle(titulo);setSize(x,y);
  CP=new JPanel();
  //CP.setOpaque(false);
  getContentPane().add(CP);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  redcolor=new Color(240,0,0);whitecolor=new Color(255,255,255);
  purplecolor=new Color(128, 0, 128);blackcolor=new Color(0, 0, 0);
  Bold=new Font("Andale Mono",1,14);
  //logo
  cokeicon=Toolkit.getDefaultToolkit().getImage(getClass().getResource    ("images/icon.png"));
   setIconImage(cokeicon);
  init();
 }

  private void init(){
  CP.setLayout(null);
  CP.setBackground(redcolor);
   
   lb1=new JLabel();
   lb1.setIcon(new ImageIcon("images/logo-coca.png"));
   lb1.setBounds(15,15,300,150);
   CP.add(lb1);
   lb2=new JLabel("Sistema de Control Vacacional");
   lb2.setFont(new Font("arial",3,20));
   lb2.setBounds(15,170,300,18);
   lb2.setForeground(whitecolor);
   CP.add(lb2);
   /**/
   lb3=new JLabel("Ingrese su nombre");
   lb3.setFont(new Font("arial",0,14));
   lb3.setBounds(15,220,300,16);
   lb3.setForeground(whitecolor);
   CP.add(lb3);
   /** */
   myfield1=new JTextField();
   myfield1.setBounds(15,240,300,30);
   myfield1.setForeground(redcolor);
   CP.add(myfield1);
   /**/
   btn1=new JButton("Entrar");
   btn1.setFont(new Font("arial",3,14));
   btn1.setBounds(125,290,100,30);
   btn1.setForeground(redcolor);
   btn1.addActionListener(terminos);
   CP.add(btn1);
   lb4=new JLabel("\u00a9 2021 the Coca Cola Company");
   lb4.setBounds(80,380,200,20);
   lb4.setForeground(whitecolor);
   CP.add(lb4);
  }
  
  ActionListener terminos = new ActionListener(){
    @Override
    public void  actionPerformed(ActionEvent e){
      nom=myfield1.getText().trim();
      if(nom.equals("")){
       JOptionPane.showMessageDialog(CP,"Debes ingresar tu nombre");
       }else{Terminos terminos=new Terminos();setVisible(false);}

    }
  };
}