//package firstproyect;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import javax.swing.ImageIcon;

public class Terminos extends JFrame{
 private JPanel CP; 
 private JLabel lb1,lb2;
 private JTextArea area;
 private JScrollPane scroll;
 private JCheckBox check;
 private JButton btn1,btn2;
 Coke coke=new Coke("titulo",3,4);
 
 public Terminos(){
  CP=new JPanel();getContentPane().add(CP);
  //propiedades
  setTitle("Terminos");
  setBounds(0,0,600,360);
  setLocationRelativeTo(null);
  setResizable(false);
  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setIconImage(coke.cokeicon);/*ereda el icono de laclase Coke*/
  init();
 }
  private void init(){
   CP.setLayout(null);
   lb1=new JLabel("TERMINOS Y CONDICIONES");
   lb1.setBounds(230,5,170,30);
   CP.add(lb1);
   area=new JTextArea();
   
   area.setText("\n  Terminos y condiciones"
   +"\n  1. Prohivido la venta o distribucion sin autorizacion del propietario de la empresa"
   +"\n  2. Prohivido la alteracion del codigo fuente de las interfaces graficas"
   +"\n  3. La empresa no se hace responsable del mal uso de este software."
   +"\n\n  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quam lectus, porta non risus"
   +"\n  maximus sed sem in sodales. Aenean purus elit, fringilla sed felis a, consequat congue ligula. Donec"
   +"\n  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quam lectus, porta non risus"
   +"\n  leo elit rhoncus massa, sed consectetur erat ipsum sit amet orci. Phasellus euismod pulvinar mi in."
   +"\n\n  Para mayor informacion contactenos a nuestro Email: holgereduardo777@outlook.com"
    );
   
   area.setEditable(false);
   scroll=new JScrollPane(area);
   scroll.setBounds(10,40,565,200);
   CP.add(scroll);
   check= new JCheckBox("Yo "+Coke.nom.toUpperCase()+" Acepto");
   check.setBounds(10,250,200,20);CP.add(check);
   check.addChangeListener(myChange);
   btn1=new JButton("Continuar");
   btn2=new JButton("No Acepto");
   btn1.setBounds(10,280,100,30);btn2.setBounds(120,280,100,30);
   btn1.setEnabled(false);btn2.setEnabled(true);
   btn1.addActionListener(continuar);btn2.addActionListener(principal);
   CP.add(btn1);CP.add(btn2);
   ImageIcon cocacola=new ImageIcon("images/coca-cola.png");
   lb2=new JLabel();
   lb2.setIcon(cocacola);
   lb2.setBounds(290,240,270,80);
   CP.add(lb2);
  
  }
   ChangeListener myChange=new ChangeListener(){
    @Override
    public void stateChanged(ChangeEvent e){
     if(check.isSelected()==true){btn1.setEnabled(true);btn2.setEnabled(false);}
     else{btn1.setEnabled(false);btn2.setEnabled(true);}
    }
   };

    ActionListener continuar=new ActionListener(){
     @Override
     public void actionPerformed(ActionEvent e){
       Principal first=new Principal();setVisible(false);
     }
    };
    
    ActionListener principal=new ActionListener(){
     @Override
     public void actionPerformed(ActionEvent ev){
      if(ev.getSource()==btn2){Coke coke=new Coke("Welcome",350,450);
      coke.setVisible(true);setVisible(false);}
     }
    };
   
   /*public static void main(String[] holger){
     Terminos terminos=new Terminos();
    }*/
 
}