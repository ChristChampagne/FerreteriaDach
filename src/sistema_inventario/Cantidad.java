package sistema_inventario;

/**
 * Clase Cantidad
 * Dentro de esta clase se encuentran los diferentes métodos de cantidad,
 * utilizada en diferentes instancias dentro del programa.
 * @author David Alvarez Garay
 * @author Christian Eduardo Rodriguez Perez
 * @author alvarezgaraydavid28@gmail.com
 * @version 2.0 16/04/2020
 */

 class Cantidad {

	 /** Variable privada entera cantidad. */
	private int cantidad;

	/**
	 * Metodo para regresar cantidad, variable utilizada en diferentes instancias del programa.
	 *
	 * @return cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece cantidad, usado en diferentes instancias a lo largo del programa.
	 *
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * MÉTODO toString()
	 * Método que convierte una serie de variables obtenidas previamente en una
	 * cadena que puede ser invocada desde otra clase. Nótese que está sobreescrita.
	 * @return la cadena resultante (String)
	 */
	@Override
	public String toString() {
		return "Cantidad [cantidad=" + cantidad + "]";
	} // CIERRE DEL MÉTODO toString()
	
} // CIERRE DE LA CLASE Cantidad
