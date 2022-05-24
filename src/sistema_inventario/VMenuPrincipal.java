package sistema_inventario;

/** Improtaci�n de las diferentes librer�as de Java necesarias*/
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Clase principal con extensi�n JFrame e implementacI�n de un ActionListener
 * Dentro de esta clase se encuentra el men� principal que cuenta con
 * diversas opciones para llevar el control del inventario de la empresa
 * "Ferreter�a DACH".
 * @author David Alvarez Garay
 * @author Christian Eduardo Rodriguez Perez
 * @author alvarezgaraydavid28@gmail.com
 * @version 2.0 16/04/2020
 */
public class VMenuPrincipal extends JFrame implements ActionListener{

	/** Declaraci�n de JMenuBar.
	 *  Utilizado para la barra de herramientas o men� de la ventana
	 */
	private JMenuBar JMenuBar;
	/** 
	 * Declaraci�n de los diferentes JMenu. 
	 */
	private JMenu JMenuArchivo, JMenuEditar, JMenuSalir;
	/** 
	 * Declaraci�n de los diferentes JMenuItem. 
	 */
	private JMenuItem JMenuItemAgregar, JMenuItemEliminar,JMenuItemModificar,JMenuItemConsultar,JMenuItemImprimir;
	private JMenuItem JMenuItemSalir;
	
	Articulo[] articulo;
	private Indice indice;
	private Cantidad cantidad;
	/**
	 *  Constructor  de la clase VMenuPrincipal
	 *  El constructor es de tipo p�blico y contiene los objetos inicializados que son parte
	 *  de la ventana y contiene las caracter�sticas que corresponden a nuestra ventana.
	 */
	public VMenuPrincipal() {
	
	/*
	 * Definici�n de las caracteristicas de la ventana 	
	 */
		super();
		setTitle ("FERRETERIA DACH");
		setSize (600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		/*
		 * Creacion de objeto JMenuBar
		 */
		JMenuBar = new JMenuBar ();
		
		/*
		 * Creacion de objetos JMenu los cuales dan opci�n de:
		 * -Archivo
		 * -Editar
		 * -Salir
		 */
		 JMenuArchivo = new JMenu ("ARCHIVO");
		 JMenuEditar = new JMenu ("EDITAR");
		 JMenuSalir = new JMenu ("SALIR");
		 
		 	/*	
			* Creacion de objetos JMenuItem
			* Adici�n del m�todo ActionListener a los botones.
			*/
		 JMenuItemAgregar = new JMenuItem("Agregar");
		 JMenuItemAgregar.addActionListener(this);
		 JMenuItemEliminar = new JMenuItem ("Eliminar");
		 JMenuItemEliminar.addActionListener(this);
		 JMenuItemModificar = new JMenuItem("Modficar");
		 JMenuItemModificar.addActionListener(this);
		 JMenuItemConsultar = new JMenuItem("Consultar");
		 JMenuItemConsultar.addActionListener(this);
		 JMenuItemImprimir = new JMenuItem ("Imprimir");
		 JMenuItemImprimir.addActionListener(this);
		 JMenuItemSalir = new JMenuItem ("Salir");
		 JMenuItemSalir.addActionListener(this);
		 
		 /*
		 * Se a�ade los JItemes a JMenuArchivo
		 */
		JMenuArchivo.add(JMenuItemAgregar);
		JMenuArchivo.add(JMenuItemEliminar);
		JMenuArchivo.add(JMenuItemModificar);
		JMenuArchivo.add(JMenuItemConsultar);
		JMenuArchivo.add(JMenuItemImprimir);
		
		/*
		 * Se a�ade los JItemeSalir a JMenuSalir
		 */
		JMenuSalir.add(JMenuItemSalir);
		
		/*
		 * Adici�n de los componentes (JMenuBar) a la ventana
		 * en orden de aparici�n (FlowLayout).
		 */
		JMenuBar.add(JMenuArchivo);
		JMenuBar.add(JMenuEditar);
		JMenuBar.add(JMenuSalir);
		
		/*
		 * Implementaci�n de JMenuBar dentro de la ventana
		 */
		setJMenuBar(JMenuBar);
		
		// Habilitaci�n del modo visible de la ventana
		setVisible (true);
		
		articulo = new Articulo[6];
		indice = new Indice();
		indice.setIndice(0);
		cantidad = new Cantidad();
		cantidad.setCantidad(0);
		
	} // CIERRE DEL CONSTRUCTOR
	
	/**M�TODO main
	 * M�todo main de la clase para inicializar la ventana al momento de ejecutar
	 * el programa.
	 * @param args  El par�metro args define los argumentos que recibe el m�todo main.
	 */
	public static void main(String[] args) {
		VMenuPrincipal p = new VMenuPrincipal();
	} // CIERRE DEL M�TODO main	
	
	/**M�TODO actionPerformed()
	 * M�todo que mediante un actionListener permite que se notifique al programa
	 * las acciones que realiza el usuario a trav�s del uso de los botones que est�n
	 * dentro de la ventana.
	 * @param ActionEvent e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == JMenuItemAgregar) {
			VMenuAgregar vaa = new VMenuAgregar(articulo, indice, cantidad);
		}
		
		if(e.getSource() == JMenuItemEliminar) {
			VMenuEliminar vae = new VMenuEliminar(articulo, indice, cantidad);
		}
		
		if(e.getSource() == JMenuItemSalir) {
			System.exit(0);
		}
		
		if(e.getSource() == JMenuItemConsultar) {
			VMenuConsultar vac = new VMenuConsultar(articulo, indice, cantidad);
		}
		
		if(e.getSource() == JMenuItemModificar) {
			VMenuModificar vam = new VMenuModificar(articulo, indice, cantidad);
		}
		if(e.getSource() == JMenuItemImprimir) {
			VGenerarReporte ew = new VGenerarReporte(articulo, indice, cantidad);
		}
		
	} // CIERRE DEL M�TODO ActionPerformed()
} // CIERRE DE LA CLASE VMenuPrincipal