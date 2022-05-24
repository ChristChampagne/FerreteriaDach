package sistema_inventario;

/**
 * Clase Indice
 * Dentro de esta clase se encuentra el �ndice que es utilizado en diferentes instancias
 * en conjunto con nuestro arreglo Articulo[].
 * @author David Alvarez Garay
 * @author Christian Eduardo Rodriguez Perez
 * @author alvarezgaraydavid28@gmail.com
 * @version 2.0 16/04/2020
 */

public class Indice {

	/** Variable privada entera indice. */
	private int indice;

	/**
	 * Metodo para regresar el �ndice que es usado en diversas instancias del programa.
	 *
	 * @return indice
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * Establece el �ndice, usado en diferentes instancias a lo largo del programa.
	 *
	 * @param indice
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}

	/**
	 * M�TODO toString()
	 * M�todo que convierte una serie de variables obtenidas previamente en una
	 * cadena que puede ser invocada desde otra clase. N�tese que est� sobreescrita.
	 * @return la cadena resultante (String)
	 */
	public String toString() {
		return "Indice [indice=" + indice + "]";
	} // CIERRE DEL M�TODO toString()
	
	
} // CIERRE DE LA CLASE Indice
