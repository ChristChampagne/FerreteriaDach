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




//______________________________________________________________________________________________
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Clase VMenuImprimir con extensión JFrame e implementacIón de un ActionListener
 * Dentro de esta clase se encuentra la ventana que imprime los registros individuales
 * que se encuentran ingresados dentro del inventario de la empresa "Ferreteria DACH".
 * @author David Alvarez Garay
 * @author Christian Eduardo Rodriguez Perez
 * @author alvarezgaraydavid28@gmail.com
 * @version 2.0 16/04/2020
 */

public class VMenuImprimir extends JFrame implements ActionListener {
	private JButton btn_generar;
	private JLabel lbl_nombre, lbl_mensaje;
	private JTextField tf_nombre;
	
	private Articulo[] articulo;
	private Indice indice;
	private int i_buscar;
	private Cantidad cantidad;

	private JButton btn_generar_archivo;
	
	public VMenuImprimir(Articulo[] articulo, Indice indice, Cantidad cantidad, int i_buscar){
		super();
		setTitle("IMPRIMIR REGISTRO");
		setSize(500, 100);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btn_generar = new JButton("IMPRIMIR REGISTRO");
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
		this.i_buscar = i_buscar;
		
		setVisible(true);
	}
public boolean generar() {
		
		XWPFDocument documento;
		XWPFParagraph titulo_doc;
		XWPFParagraph parrafo;
		
		XWPFRun r_titulo, r_parrafo;
		
		OutputStream word;
		
		String t_titulo = "FERRETERIA DACH";
		String t_documento = "REPORTE INDIVIDUAL DE EXISTENCIAS";
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
		
			r_parrafo = parrafo.createRun();
			r_parrafo.setText("ID DEL ARTICULO:   " + articulo[i_buscar].getId_articulo().toString());
			r_parrafo.addCarriageReturn();
			r_parrafo.setText("NOMBRE DEL ARTÍCULO:   " + articulo[i_buscar].getArt_nombre().toString());
			r_parrafo.addCarriageReturn();
			r_parrafo.setText("CANTIDAD DISPONIBLE:   " + articulo[i_buscar].getCant_disponible().toString());
			r_parrafo.addCarriageReturn();
			r_parrafo.setText("DESCRICPIÓN:   " + articulo[i_buscar].getDescripcion().toString());
			r_parrafo.addCarriageReturn();
			r_parrafo.setText("PROVEEDOR:   " + articulo[i_buscar].getProveedor().toString());
			r_parrafo.addCarriageReturn();
			r_parrafo.setFontSize(12);
			
			
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
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_generar) {
			if(generar()) {
				lbl_mensaje.setText("Archivo generado");
			} else {
				lbl_mensaje.setText("El mensaje no se generó");
			}
		}
	
	} // CIERRE DEL MÉTDO actionPerformed
} // CIERRE DE LA CLASE VMenuImprimir