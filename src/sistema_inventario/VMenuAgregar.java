package sistema_inventario;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Clase VMenuAgregar con extensión JFrame e implementacIón de un ActionListener
 * Dentro de esta clase se encuentra la ventana que permite agregar registros al
 * inventario de la empresa "Ferreteria DACH".
 * @author David Alvarez Garay
 * @author Christian Eduardo Rodriguez Perez
 * @author alvarezgaraydavid28@gmail.com
 * @version 2.0 16/04/2020
 */

public class VMenuAgregar extends JFrame implements ActionListener {
	/*Etiquetas*/
	private JLabel lbl_id_articulo, lbl_art_nombre, lbl_cant_disponible, lbl_mensaje, lbl_descripcion, lbl_proveedor;
	/** Campos de texto*/
	private JTextField tf_id_articulo, tf_art_nombre, tf_cant_disponible, tf_descripcion, tf_proveedor;
	/** Botones*/
	private JButton btn_aceptar, btn_borrar,btn_imprimir;
	
	private Articulo[] articulo;
	private Indice indice;
	private int i_buscar;
	private Cantidad cantidad;
	
	// MÉTODO CONSTRUCTOR
	public VMenuAgregar(Articulo[] articulo, Indice indice, Cantidad cantidad) {
		super();
		
		setTitle("AGREGAR ARTÍCULO");
		setSize(500, 200);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lbl_id_articulo = new JLabel("CÓDIGO: ");
		lbl_art_nombre = new JLabel("NOMBRE: ");
		lbl_cant_disponible = new JLabel("CANT. DISPONIBLE: ");
		lbl_descripcion = new JLabel("DESCRIPCIÓN: ");
		lbl_proveedor = new JLabel("PROVEEDOR:");
		lbl_mensaje = new JLabel("");
		
		tf_id_articulo = new JTextField(10);
		tf_art_nombre = new JTextField(20);
		tf_cant_disponible = new JTextField(30);
		tf_descripcion = new JTextField(30);
		tf_proveedor = new JTextField(30);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.addActionListener(this);
		btn_borrar = new JButton("Borrar");
		btn_borrar.addActionListener(this);
		btn_imprimir=new JButton("Imprimir");
		btn_imprimir.addActionListener(this);
		
		// Adición de los distintos componentes a la ventana
		add(lbl_id_articulo);
		add(tf_id_articulo);
		add(lbl_art_nombre);
		add(tf_art_nombre);
		add(lbl_cant_disponible);
		add(tf_cant_disponible);
		add(lbl_descripcion);
		add(tf_descripcion);
		add(lbl_proveedor);
		add(tf_proveedor);
		add(btn_aceptar);
		add(btn_borrar);
		add(btn_imprimir);
		add(lbl_mensaje);
		setVisible(true);
		
		this.articulo = articulo;
		this.indice = indice;
		this.cantidad = cantidad;
		i_buscar = 0;
	} // CIERRE DEL MÉTODO CONSTRUCTOR

	@Override
	public void actionPerformed(ActionEvent e) {	
		/*Acciones del botón aceptar*/
		if(e.getSource() == btn_aceptar) {
			i_buscar = -1;
			String a_buscar = "";
			a_buscar = tf_id_articulo.getText().toString();
			for(int i = 0; i < cantidad.getCantidad() ;i++) {
			if(articulo[i].getId_articulo().equals(a_buscar)) {
				i_buscar = i;
				//linea_imp = i_buscar;
				}	
			}
			if(i_buscar == -1) {
				articulo[indice.getIndice()]=new Articulo();
			articulo[indice.getIndice()].setId_articulo(tf_id_articulo.getText().toString());
			articulo[indice.getIndice()].setArt_nombre(tf_art_nombre.getText().toString());
			articulo[indice.getIndice()].setCant_disponible(tf_cant_disponible.getText().toString());
			articulo[indice.getIndice()].setDescripcion(tf_descripcion.getText().toString());
			articulo[indice.getIndice()].setProveedor(tf_proveedor.getText().toString());

			indice.setIndice(indice.getIndice()+1);;
			lbl_mensaje.setText("ALUMNO AGREGADO");
			cantidad.setCantidad(cantidad.getCantidad()+1);
				} else {
				lbl_mensaje.setText("EL CÓDIGO INGRESADO YA SE ENCUENTRA EN USO");
			
				}
		}
		/** Acciones del botón imprimir*/
		if(e.getSource() == btn_imprimir) {
		for(int i=0;i<cantidad.getCantidad();i++) {
			System.out.println(articulo[i].toString());
			}
		
		}
		/* Acciones del botón borrar*/
		if(e.getSource() == btn_borrar) {
			tf_id_articulo.setText("");
			tf_art_nombre.setText("");
			tf_cant_disponible.setText("");
			tf_descripcion.setText("");
			tf_proveedor.setText("");
			lbl_mensaje.setText("");
			
		}
	}	// CIERRE DEL MÉTODO actionPerformed
} //CIERRE DE LA CLASE VMenuAgregar