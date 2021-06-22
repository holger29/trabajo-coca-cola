import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;


public class Principal extends JFrame{
 //atributos
 private JPanel JP;
 private JMenuBar menuB;
 private JMenu menu1,submenu1,menu2,menu3;
 private JMenuItem submenuitem1,submenuitem2,submenuitem3,menu1Item1,menu1Item2,
 itemMenu2,itemMenu3;
 private JLabel lb1,lb2,lb3,lbNombre,lbApellido1,lbApellido2,lbDepartamento,lbAntiguedad,
 lbResultado;
 private JTextField fieldNombre, fieldApellido1,fieldApellido2;
 private JComboBox comboDepartamento,comboAntiguedad;
 private JScrollPane scrollResultado;
 private JTextArea areaResultado;
 private Font miFuente1,miFuente2;
 private String miArray[]={"","1 año de servicio","2 a 6 años de servicio","7 o mas años de servicio"};
 private String datos[]={"Software creado por:","Holger Edud Angul Castillo","holgereduardo777@gmail.com","www.holgersoftware.com.org"};
 //para la fuente de la letra
 
 //para el color
 Coke coke=new Coke("titulo",7,7);
 private ImageIcon cocacolaBlanco;
 

 //constructor
 public Principal(){
  JP=new JPanel();getContentPane().add(JP);
  JP.setLayout(null);
  JP.setBackground(coke.redcolor);
  setBounds(0,0,640,535);
  setLocationRelativeTo(null);
  setResizable(false);
  setVisible(true);
  miFuente1=new Font("arial",1,30);miFuente2=new Font("arial",0,20);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setIconImage(coke.cokeicon);
  init();
 }
 private void init(){
  menuB=new JMenuBar();menuB.setBackground(coke.redcolor);
  setJMenuBar(menuB);
  menu1=new JMenu("OPCIONES");submenu1=new JMenu("Color De Fondo"); 
  menu2=new JMenu("CALCULAR");
  menu3=new JMenu("ACERCA DE");
  menuB.add(menu1); menuB.add(menu2);menuB.add(menu3);menu1.add(submenu1);
  submenuitem1=new JMenuItem("Rojo");submenuitem2=new JMenuItem("Negro");
  submenuitem3=new JMenuItem("Morado");
  //eventos para los items rojo, negro y morado
  
  submenuitem1.addActionListener(cambiodeFomdo);
  submenuitem2.addActionListener(cambiodeFomdo);
  submenuitem3.addActionListener(cambiodeFomdo);
  submenu1.add(submenuitem1);submenu1.add(submenuitem2);
  submenu1.add(submenuitem3);
  
  menu1Item1=new JMenuItem("Nuevo");menu1Item2=new JMenuItem("Salir");
  menu1.add(menu1Item1);menu1.add(menu1Item2);
  
  itemMenu2=new JMenuItem("Vacaciones");menu2.add(itemMenu2);
  itemMenu3=new JMenuItem("El creador");menu3.add(itemMenu3);
  //funciones del menu
  menu1Item1.addActionListener(miFuncion);
  menu1Item2.addActionListener(miFuncion);
  itemMenu2.addActionListener(miFuncion);
  itemMenu3.addActionListener(miFuncion);
  
 
  //color de fuente
  menu1.setForeground(coke.whitecolor);menu2.setForeground(coke.whitecolor);
  menu3.setForeground(coke.whitecolor);
  //label tipo imagen
  cocacolaBlanco=new ImageIcon("images/logo-coca.png");
  lb1=new JLabel();lb1.setIcon(cocacolaBlanco);
  lb1.setBounds(-15,-15,300,150);JP.add(lb1);
  
  lb2=new JLabel("Bienvenido (a)");lb2.setForeground(coke.whitecolor);
  lb2.setFont(miFuente1);lb2.setBounds(300,40,250,30);JP.add(lb2);
  lb3=new JLabel("Datos del trabajador para el calculo de vacaciones");
  lb3.setForeground(coke.whitecolor);lb3.setFont(miFuente2);
  lb3.setBounds(80,150,580,30);JP.add(lb3);

  //campos a llenar
  lbNombre=new JLabel("Nombre completo"); lbApellido1=new JLabel("Primer apellido");
  lbApellido2=new JLabel("Segundo apellido");lbDepartamento=new JLabel("Selecciona el departamento");lbAntiguedad=new JLabel("Selecciona la antiguedad");
  lbResultado=new JLabel("Resultado del calculo");

  fieldNombre=new JTextField(); fieldApellido1=new JTextField();
  fieldApellido2=new JTextField(); comboDepartamento=new JComboBox();comboAntiguedad=new JComboBox();
  areaResultado=new JTextArea();areaResultado.setForeground(coke.redcolor);scrollResultado=new JScrollPane(areaResultado);
  JP.add(lbNombre);lbNombre.setBounds(20,190,200,20);JP.add(fieldNombre);fieldNombre.setBounds(20,  220,200,30);
  JP.add(lbApellido1);lbApellido1.setBounds(20,260,200,20);JP.add(fieldApellido1);fieldApellido1.setBounds(20,290,200,30);
  JP.add(lbApellido2);lbApellido2.setBounds(20,330,200,20);JP.add(fieldApellido2);fieldApellido2.setBounds(20,360,200,30);

  JP.add(lbDepartamento);lbDepartamento.setBounds(240,190,200,20);JP.add(comboDepartamento);comboDepartamento.setBounds(240,220,200,30);
  JP.add(lbAntiguedad);lbAntiguedad.setBounds(240,260,200,20);JP.add(comboAntiguedad);comboAntiguedad.setBounds(240,290,200,30);
  //agregar items a los comboBox
  comboDepartamento.addItem("");
  comboDepartamento.addItem("Atencion al cliente");
  comboDepartamento.addItem("Departamento de Logistica");
  comboDepartamento.addItem("Departamento de Gerencia");
  
  /*comboAntiguedad.addItem("");
  comboAntiguedad.addItem("1 ao de servicio");
  comboAntiguedad.addItem("2 a 6 años de servicio");
  comboAntiguedad.addItem("7 o mas años de servicio");*/
  
  for(String miArray: miArray){comboAntiguedad.addItem(miArray);}
  //for(int i =0;i< miArray.length;i++){comboAntiguedad.addItem(miArray[i]);}
  
  //color de fuente para los comboBox
  comboDepartamento.setForeground(coke.redcolor);
  comboAntiguedad.setForeground(coke.redcolor);
  //color de fuente para los JTextField
  fieldNombre.setForeground(coke.redcolor);
  fieldApellido1.setForeground(coke.redcolor);
  fieldApellido2.setForeground(coke.redcolor);
  JP.add(lbResultado);lbResultado.setBounds(240,330,200,20); JP.add(scrollResultado);scrollResultado.setBounds(240,360,300,70);
  //darle color a los demas labels
  lbNombre.setForeground(coke.whitecolor);lbApellido1.setForeground(coke.whitecolor);
  lbApellido2.setForeground(coke.whitecolor);

  lbDepartamento.setForeground(coke.whitecolor);lbAntiguedad.setForeground(coke.whitecolor);
  lbResultado.setForeground(coke.whitecolor);

  
  coke.lb4.setText("\u00a9 2021 Todos los derechos reservados. Coca-Cola Company.");

  coke.lb4.setBounds(140,440,360,20);
  JP.add(coke.lb4);
  fuentes();
 }
 public void fuentes(){
     menu1.setFont(coke.Bold);
     submenu1.setFont(coke.Bold);submenu1.setForeground(coke.redcolor);menu2.setFont(coke.Bold);menu3.setFont(coke.Bold);

     fieldNombre.setFont(coke.Bold);
     fieldApellido1.setFont(coke.Bold);
     fieldApellido2.setFont(coke.Bold);
     //areaResultado.setFont(coke.Bold);

     submenuitem1.setForeground(coke.redcolor);
     submenuitem2.setForeground(coke.redcolor);
     submenuitem3.setForeground(coke.redcolor);

     menu1Item1.setForeground(coke.redcolor);menu1Item2.setForeground(coke.redcolor);
     itemMenu2.setForeground(coke.redcolor);itemMenu3.    setForeground(coke.redcolor);
 }
     //evento para cambiar el fondo a la interfaz
     ActionListener cambiodeFomdo=new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent colorFondo){
            if(colorFondo.getSource()==submenuitem1){JP.setBackground(coke.redcolor);}
            else if(colorFondo.getSource()==submenuitem2){JP.setBackground(coke.blackcolor);}
            else if(colorFondo.getSource()==submenuitem3){JP.setBackground(coke.purplecolor);}

         }

     };
     //de aqui de pende el calculo de las vacaciones de los trabajadores 
     ActionListener miFuncion=new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            if(e.getSource()==menu1Item1/**nuevo */){fieldNombre.setText("");fieldNombre.setText("");fieldApellido1.setText("");fieldApellido2.setText("");areaResultado.setText("");comboDepartamento.setSelectedIndex(0);comboAntiguedad.setSelectedIndex(0);}
            if(e.getSource()==menu1Item2/**salir */){System.exit(0);}
            if(e.getSource()==itemMenu3/*el creador*/){JOptionPane.showMessageDialog(JP,datos[0]+"\n"+datos[1]+"\nContacto: "+datos[2]+"\nSitio web: "+datos[3],"INFO DEL CREADOR.", JOptionPane.PLAIN_MESSAGE);}
            /**las variables que tenddran el contenido de los campos de textos */
            String nombre=fieldNombre.getText();
            String apellido1=fieldApellido1.getText();
            String apellido2=fieldApellido2.getText();
            String departamento=comboDepartamento.getSelectedItem().toString();
            String antiguedad=comboAntiguedad.getSelectedItem().toString();
            int diasV,antiguo;
            if(e.getSource()==itemMenu2/**vacasiones*/){
            if(nombre.equals("")==true || apellido1.equals("")==true || apellido2.equals("")==true|| comboAntiguedad.getSelectedItem().toString()=="" || comboDepartamento.getSelectedItem().toString()=="") {JOptionPane.showMessageDialog(JP,"Debes llenartodos los campos","LLENA LOS CAMPOS VACIOS",JOptionPane.PLAIN_MESSAGE);}else{

            if(antiguedad.equals(miArray[1])==true){diasV=15;antiguo=1;areaResultado.setText("Trabajador(ra) "+nombre+" "+apellido1+" "+apellido2+" quien labora en\nel departamento de "+departamento +" con la\nantiguedad de "+antiguo+" año de servicio "+"recibe "+diasV+" dias\nde Vacasiones.");}
                    /** */
            if(antiguedad.equals(miArray[2])==true){diasV=30;antiguo=2;areaResultado.setText("Trabajador(ra) "+nombre+" "+apellido1+" "+apellido2+" quien labora en\n"+departamento+" con la antiguedad de "+antiguo+"\naños o mas de servicio recibe "+diasV+" dias\nde Vacasiones.");}
            /**/
            if(antiguedad.equals(miArray[3])==true){diasV=45;antiguo=7;areaResultado.setText("Trabajador(ra) "+nombre+" "+apellido1+" "+apellido2+" quien labora en\n"+departamento+" "+" con la antiguedad de \n"+antiguo+" años o mas de servicio recibe "+diasV+" dias \nde Vacasiones.");}
  
                }
            }
        }};
 public static void main(String[] holger){
  //Principal principal=new Principal();
 }
}