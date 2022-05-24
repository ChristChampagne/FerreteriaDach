package sistema_inventario;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Clase VMenuEliminar con extensión JFrame e implementacIón de un ActionListener
 * Dentro de esta clase se encuentra la ventana que permite eliminar los registros
 * que se encuentran dentro del inventario de la empresa "Ferreteria DACH".
 * @author David Alvarez Garay
 * @author Christian Eduardo Rodriguez Perez
 * @author alvarezgaraydavid28@gmail.com
 * @version 2.0 16/04/2020
 */

public class VMenuEliminar extends JFrame implements ActionListener {
	
	private JLabel lbl_id_articulo, lbl_art_nombre, lbl_descripcion, lbl_cant_disponible, lbl_proveedor, lbl_mensaje;
	/** Campos de texto*/
	private JTextField tf_id_articulo, tf_art_nombre, tf_descripcion, tf_cant_disponible, tf_proveedor;
	/** Botones*/
	private JButton btn_eliminar, btn_borrar,btn_imprimir;
	
	private Articulo[] articulo;
	private Indice indice;
	//private int cantidad;
	
	private Cantidad cantidad;
	
	//private int cantidad;
	public VMenuEliminar(Articulo[] articulo, Indice indice, Cantidad cantidad) {
super();
		
		setTitle("ELIMINAR ARTÍCULO");
		setSize(500, 200);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lbl_id_articulo = new JLabel("CÓDIGO: ");
		lbl_art_nombre = new JLabel("NOMBRE: ");
		lbl_descripcion = new JLabel("DESCRIPCIÓN: ");
		lbl_cant_disponible = new JLabel("CANTIDAD: ");
		lbl_proveedor = new JLabel("PROVEEDOR: ");
		lbl_mensaje = new JLabel("");
		
		tf_id_articulo = new JTextField(10);
		tf_art_nombre = new JTextField(20);
		tf_cant_disponible = new JTextField(30);
		tf_descripcion = new JTextField(30);
		tf_proveedor = new JTextField(30);
		
		btn_eliminar = new JButton("Eliminar");
		btn_eliminar.addActionListener(this);
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
		add(btn_eliminar);
		add(btn_borrar);
		add(btn_imprimir);
		add(lbl_mensaje);
		setVisible(true);
		
		this.articulo = articulo;
		this.indice = indice;
		this.cantidad = cantidad;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/*Acciones del botón eliminar*/
		if(e.getSource() == btn_eliminar) {
			int i_borrar = -1;
			String a_borrar = "";
			a_borrar = tf_id_articulo.getText().toString();
			for(int i = 0; i < cantidad.getCantidad() ;i++) {
				if(articulo[i].getId_articulo().equals(a_borrar)) {
					i_borrar = i;
					}
			}
			if(i_borrar == -1) {
				lbl_mensaje.setText("NO SE ENCONTRÓ EL CÓDIGO DEL PRODUCTO");
			} else {
				for(int i = i_borrar; i < (cantidad.getCantidad()-1); i++) {
					articulo[i] = articulo[i+1];
				}
				indice.setIndice(indice.getIndice()-1);
				lbl_mensaje.setText("ALUMNO ELIMINADO");
				cantidad.setCantidad(cantidad.getCantidad()-1);
			}
		}
		
		/*Accion del botón imprimir*/
		if(e.getSource() == btn_imprimir) {
		for(int i=0;i<cantidad.getCantidad();i++) {
			System.out.println(articulo[i].toString());
			}
		
		}
		/*Acciones del botón borrar*/
		if(e.getSource() == btn_borrar) {
			tf_id_articulo.setText("");
			tf_art_nombre.setText("");
			tf_descripcion.setText("");
			tf_cant_disponible.setText("");
			tf_proveedor.setText("");
			lbl_mensaje.setText("");
		}
		
		
	}	
}