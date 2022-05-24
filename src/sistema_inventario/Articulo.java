package sistema_inventario;

/**
 * Clase Articulo
 * @author David Alvarez Garay
 * @author Christian Eduardo Rodriguez Perez
 * @author alvarezgaraydavid28@gmail.com
 * @version 2.0 16/04/2020
 */
public class Articulo {
	
	private String id_articulo, art_nombre, cant_disponible, descripcion, proveedor;

	/**
	 * Metodo para regresar el código identificador del artículo.
	 *
	 * @return id_articulo
	 */
	public String getId_articulo() {
		return id_articulo;
	}

	/**
	 * Establece el código identificador del artículo.
	 *
	 * @param id_articulo
	 */
	public void setId_articulo(String id_articulo) {
		this.id_articulo = id_articulo;
	}

	/**
	 * Metodo para regresar el nombre del artículo.
	 *
	 * @return art_nombre
	 */
	public String getArt_nombre() {
		return art_nombre;
	}

	/**
	 * Establece el nombre del artículo.
	 *
	 * @param art_nombre
	 */
	public void setArt_nombre(String art_nombre) {
		this.art_nombre = art_nombre;
	}

	/**
	 * Metodo para regresar el código identificador del artículo.
	 *
	 * @return cant_disponible
	 */
	public String getCant_disponible() {
		return cant_disponible;
	}

	/**
	 * Establece la cantidad de artículos disponibles en el inventario.
	 *
	 * @param cant_disponible
	 */
	public void setCant_disponible(String cant_disponible) {
		this.cant_disponible = cant_disponible;
	}

	/**
	 * Metodo para regresar la descripción del artículo ingresado.
	 *
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del artículo.
	 *
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodo para regresar el nombre del proveedor del artículo.
	 *
	 * @return proveedor
	 */
	public String getProveedor() {
		return proveedor;
	}

	/**
	 * Establece el nombre del proveedor del artículo.
	 *
	 * @param proveedor
	 */
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * MÉTODO toString()
	 * Método que convierte una serie de variables obtenidas previamente en una
	 * cadena que puede ser invocada desde otra clase. Nótese que está sobreescrita.
	 * @return la cadena resultante (String)
	 */
	@Override
	public String toString() {
		return "Articulo [id_articulo=" + id_articulo + ", art_nombre=" + art_nombre + ", cant_disponible="
				+ cant_disponible + ", descripcion=" + descripcion + ", proveedor=" + proveedor + "]";
	} // CIERRE DEL MÉTODO toString()

} // CIERRE DE LA CLASE Articulo
