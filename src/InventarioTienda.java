import java.util.HashMap;
import java.util.Scanner;

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
        inventario.put(objProducto.getCodigo(), objProducto);
    }

    public void venderProducto(Producto objProducto, int cantVendida) {
        if (objProducto.getStock() > cantVendida) {
            objProducto.setStock(objProducto.getStock() - cantVendida);
            System.out.println("Se ha vendido " + cantVendida + " de " + objProducto.getNombre() + ".");
            System.out.println("Ese stock ha costado " +  objProducto.getStock() * objProducto.getStock() + ".");
        }
    }

    public void agregarStock(Producto objProducto, int cantAgregada) {
        if (inventario.containsKey(objProducto.getCodigo())) {
            objProducto.setStock(objProducto.getStock() + cantAgregada);
            System.out.println("Stock añadido. Nuevo stock " + objProducto.getStock() + ".");
        }
    }

    public Double valorTotal() {
        Double valorTotal = 0.0;
        for (Producto objProducto : inventario.values()) {
            valorTotal += objProducto.getStock() * objProducto.getPrecio();
        }
        return valorTotal;
    }

    public int stockTotal() {
        int stockTotal = 0;
        for (Producto objProducto : inventario.values()) {
            stockTotal += objProducto.getStock();
        }
        return stockTotal;
    }

    public void imprimirProductos() {
        for (Producto objProducto : inventario.values()) {
            System.out.println(objProducto.toString());
        }
    }
}
