package sistema_inventario;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * Clase VGenerarReporte con extensi�n JFrame e implementacI�n de un ActionListener
 * Dentro de esta clase se encuentra la ventana que permite generar un reporte
 * general de todos los art�culos ingresados en el inventario de la ferretera.
 * @author David Alvarez Garay
 * @author Christian Eduardo Rodriguez Perez
 * @author alvarezgaraydavid28@gmail.com
 * @version 2.0 16/04/2020
 */
public class VGenerarReporte extends JFrame implements ActionListener{

	/** Bot�n generar. */
	private JButton btn_generar;
	
	/** Etiquetas de nombre y mensaje. 
	 * La etiqueta de nombre corresponde a la indicaci�n de ingresar el nombre.
	 * La etiqueta de mensaje muestra si el resultado de la creaci�n del documento
	 * fue exitoso o si no puedo ser completada la operaci�n
	 */
	private JLabel lbl_nombre, lbl_mensaje;
	
	/** Campo de texto nombre.
	 * Dentro del TextField el usuario debe ingresar el nombre que desea dar al
	 * documento que ser� creado
	 */
	private JTextField tf_nombre;
	
	/** Arreglo de tipo Articulo[]. */
	private Articulo[] articulo;
	
	/** Declaraci�n del indice*/
	private Indice indice;
	
	/** Declaraci�n de la variable i_buscar. */
	private int i_buscar;
	
	/** Declaraci�n de la variable cantidad de tipo Cantidad */
	private Cantidad cantidad;
	//
	
	/**
	 * M�TODO CONSTRUCTOR VGenerarReporte.
	 *
	 * @param articulo
	 * @param indice
	 * @param cantidad
	 */
	public  VGenerarReporte(Articulo[] articulo, Indice indice, Cantidad cantidad) {
		super();
		setTitle("GENERAR REPORTE");
		setSize(500, 100);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btn_generar = new JButton("IMPRIMIR ARCHIVO");
		btn_generar.addActionListener(this);
		lbl_nombre = new JLabel("Ingrese nombre");
		lbl_mensaje = new JLabel("");
		tf_nombre = new JTextField(25);
		add(lbl_nombre);
		add(tf_nombre);
		add(btn_generar);
		add(lbl_mensaje);
		
		setVisible(true);
		
		this.articulo = articulo;
		this.indice = indice;
		this.cantidad = cantidad;
		
	} // FIN DEL M�TODO CONSTRUCTOR
	
	/**
	 * M�TODO generar.
	 * Dentro de este m�todo se encuentran las diferentes instrucciones que hacen posible
	 * la generaci�n del documento Word con los diferentes registros de los art�culos.
	 *
	 * @return true, en caso de que la operaci�n sea exitosa
	 */
	public boolean generar() {
		
		XWPFDocument documento;
		XWPFParagraph titulo_doc;
		XWPFParagraph parrafo;
		
		XWPFRun r_titulo, r_parrafo;
		
		OutputStream word;
		
		String t_titulo = "FERRETERIA DACH";
		String t_documento = "REPORTE GENERAL DE EXISTENCIAS";
		boolean respuesta = false;
		
		documento = new XWPFDocument();
		titulo_doc = documento.createParagraph();
		titulo_doc.setAlignment(ParagraphAlignment.CENTER);
		titulo_doc.setVerticalAlignment(TextAlignment.TOP);
		
		parrafo = documento.createParagraph();
		parrafo.setAlignment(ParagraphAlignment.BOTH);
		
		r_titulo = titulo_doc.createRun();
		r_titulo.setBold(true);
		r_titulo.setText(t_titulo);
		r_titulo.addCarriageReturn();
		r_titulo.setText(t_documento);
		r_titulo.setFontFamily("Arial");
		r_titulo.setFontSize(14);
		r_titulo.setTextPosition(10);
		
		/* Impresi�n de los diferentes registros del arreglo utilizando un ciclo for
		 * Dependiendo de la cantidad de art�culos que hayan sido ingresados ser� la
		 * cantidad de veces que el ciclo se ejecute.
		 * */
		for(int i = 0; i < cantidad.getCantidad() ;i++) {
			r_parrafo = parrafo.createRun();
			r_parrafo.setText("ID DEL ARTICULO:   " + articulo[i].getId_articulo().toString());
			r_parrafo.addCarriageReturn();
			r_parrafo.setText("NOMBRE DEL ART�CULO:   " + articulo[i].getArt_nombre().toString());
			r_parrafo.addCarriageReturn();
			r_parrafo.setText("CANTIDAD DISPONIBLE:   " + articulo[i].getCant_disponible().toString());
			r_parrafo.addCarriageReturn();
			r_parrafo.setText("DESCRICPI�N:   " + articulo[i].getDescripcion().toString());
			r_parrafo.addCarriageReturn();
			r_parrafo.setText("PROVEEDOR:   " + articulo[i].getProveedor().toString());
			r_parrafo.addCarriageReturn();
			r_parrafo.addCarriageReturn();

			r_parrafo.setFontSize(12);
			
		}

		try {
			word = new FileOutputStream(tf_nombre.getText() + ".docx");
			documento.write(word);
			word.close();
			documento.close();
			respuesta = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return respuesta;
	
	}
	
	/**
	 * M�TODO Action performed.
	 *
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/*Acciones del bot�n btn_generar*/
		if(e.getSource() == btn_generar) {
			if(generar()) {
				lbl_mensaje.setText("Archivo generado");
			} else {
				lbl_mensaje.setText("El mensaje no se gener�");
			}
		}
		
	} // CIERRE DEL M�TODO actionPerformed
	
} // CIERRE DE LA CLASE VGenerarReporte