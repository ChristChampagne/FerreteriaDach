package sistema_inventario;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Clase VMenuModificar con extensión JFrame e implementacIón de un ActionListener
 * Dentro de esta clase se encuentra la ventana de modificar los registros que se
 * encuentran dentro del inventario de la empresa "Ferreteria DACH".
 * @author David Alvarez Garay
 * @author Christian Eduardo Rodriguez Perez
 * @author alvarezgaraydavid28@gmail.com
 * @version 2.0 16/04/2020
 */

public class VMenuModificar extends JFrame implements ActionListener {
	
	private JLabel lbl_id_articulo, lbl_art_nombre, lbl_cant_disponible, lbl_mensaje, lbl_descripcion, lbl_proveedor;
	/** Campos de texto*/
	private JTextField tf_id_articulo, tf_art_nombre, tf_cant_disponible, tf_descripcion, tf_proveedor;
	/** Botones*/
	private JButton btn_buscar, btn_modificar, btn_borrar, btn_imprimir;
	
	private Articulo[] articulo;
	private Indice indice;
	private int i_buscar;
	//private int agregados, buscar;
	private Cantidad cantidad;
	
	public VMenuModificar(Articulo[] articulo, Indice indice, Cantidad cantidad) {
super();
		
		setTitle("MODIFICAR REGISTRO");
		setSize(500, 200);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lbl_id_articulo = new JLabel("CÓDIGO: ");
		lbl_art_nombre = new JLabel("NOMBRE: ");
		lbl_cant_disponible = new JLabel("CANT. DISPONIBLE: ");
		lbl_descripcion = new JLabel("DESCRIPCIÓN: ");
		lbl_proveedor = new JLabel("PROVEEDOR: ");
		lbl_mensaje = new JLabel("");
		
		tf_id_articulo = new JTextField(10);
		tf_art_nombre = new JTextField(20);
		tf_cant_disponible = new JTextField(30);
		tf_descripcion = new JTextField(30);
		tf_proveedor = new JTextField(30);
	
		
		btn_buscar = new JButton("BUSCAR");
		btn_buscar.addActionListener(this);
		btn_modificar = new JButton("MODIFICAR");
		btn_modificar.addActionListener(this);
		btn_modificar.setEnabled(false);
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
		add(btn_borrar);
		add(btn_imprimir);
		add(lbl_mensaje);
		add(btn_buscar);
		add(btn_modificar);
		add(btn_borrar);
		add(btn_imprimir);
		add(lbl_mensaje);
		setVisible(true);
		
		this.articulo = articulo;
		this.indice = indice;
		this.cantidad = cantidad;
		i_buscar = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* Acciones del botón buscar*/
		if(e.getSource() == btn_buscar) {
			i_buscar = -1;
			String a_buscar = "";
			a_buscar = tf_id_articulo.getText().toString();
			for(int i = 0; i < cantidad.getCantidad() ;i++) {
			if(articulo[i].getId_articulo().equals(a_buscar)) {
				i_buscar = i;
				}	
			}
			if(i_buscar == -1) {
				lbl_mensaje.setText("NO SE ENCONTRÓ LA MATRÍCULA");
				} else {
					tf_id_articulo.setText(articulo[i_buscar].getId_articulo());
					tf_art_nombre.setText(articulo[i_buscar].getArt_nombre());
					tf_cant_disponible.setText(articulo[i_buscar].getCant_disponible());
					tf_descripcion.setText(articulo[i_buscar].getDescripcion());
					tf_proveedor.setText(articulo[i_buscar].getProveedor());;

					btn_modificar.setEnabled(true);				
				}
		}
		/** Acciones del botón modificar*/
		if(e.getSource() == btn_modificar) {
			btn_modificar.setEnabled(false);
			articulo[i_buscar].setId_articulo(tf_id_articulo.getText().toString());
			articulo[i_buscar].setArt_nombre(tf_art_nombre.getText().toString());
			articulo[i_buscar].setCant_disponible(tf_cant_disponible.getText().toString());
			articulo[i_buscar].setDescripcion(tf_descripcion.getText().toString());
			articulo[i_buscar].setProveedor(tf_proveedor.getText().toString());;
			
			lbl_mensaje.setText("ALUMNO MODIFICADO");
			
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
	}	
}