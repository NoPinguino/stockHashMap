import java.util.HashMap;

public class InventarioTienda {
    private String nombreEmpresa;
    private HashMap<String, Producto> inventario = new HashMap<String, Producto>();

    /*CONSTRUCTOR*/
    public InventarioTienda(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.inventario = new HashMap<String, Producto>();
    }

    public void mostrarProductos() {
        for (Producto objProducto : inventario.values()) {
            System.out.println(objProducto.toString());
        }
    }

    public void agregarProducto(Producto objProducto) {
        if (inventario.containsKey(objProducto.getCodigo())) {
            /*Creo un nuevo elemento en el HashMap, siendo la clave el código y el valor la instancia del objeto*/
            inventario.put(objProducto.getCodigo(), objProducto);
        } else {
            System.out.println("No existe el producto con el codigo: " + objProducto.getCodigo());
        }
    }

    public void actualizarStock(Producto objProducto, int newStock) {

    }
}
