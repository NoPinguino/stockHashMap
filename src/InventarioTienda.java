import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InventarioTienda {
    private String nombreEmpresa;
    private HashMap<String, Producto> inventario = new HashMap<String, Producto>();

    /*CONSTRUCTOR*/
    public InventarioTienda(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.inventario = new HashMap<String, Producto>();
    }

    //Big O(1)
    public void agregarProducto(Producto objProducto) {
        inventario.put(objProducto.getCodigo(), objProducto);
    }

    //Big 0(1)
    public void venderProducto(String producto, int cantVendida) {
        boolean existe = false;
        for (Producto objProducto :inventario.values()) {
            if (objProducto.getNombre().equals(producto)) {
                existe = true;
                if (objProducto.getStock() >= cantVendida) {
                    objProducto.setStock(objProducto.getStock() - cantVendida);
                    System.out.println("Stock vendido con éxito.");
                    System.out.println("Se ha vendido " + cantVendida + " " + producto + " con valor de " + cantVendida * objProducto.getPrecio() + ".");
                } else {
                    System.out.println("Stock insuficiente en el inventario.");
                }
            }
        }
        if (!existe) {
            System.out.println("No existe el producto con el nombre " + producto + ".");
            System.out.println("Para ver el producto existente usa la opción 'Mostrar todos los productos'.");
        }
    }

    //Big O(1)
    public void agregarStock(String producto, int cantAgregada) {
        boolean existe = false;
        for (Producto objProducto : inventario.values()) {
            if (objProducto.getNombre().equals(producto)) {
                objProducto.setStock(objProducto.getStock() + cantAgregada);
                System.out.println("Stock añadido. Nuevo stock " + objProducto.getStock() + ".");
                existe = true;
            }
        }
        if (!existe) {
            System.out.println("No existe el producto con el nombre " + producto + ".");
            System.out.println("Para ver el producto existente usa la opción 'Mostrar todos los productos'.");
        }
    }

    //Big O(n)
    public Double valorTotal() {
        Double valorTotal = 0.0;
        for (Producto objProducto : inventario.values()) {
            valorTotal += objProducto.getStock() * objProducto.getPrecio();
        }
        return valorTotal;
    }

    //Big O(n)
    public int stockTotal() {
        int stockTotal = 0;
        for (Producto objProducto : inventario.values()) {
            stockTotal += objProducto.getStock();
        }
        return stockTotal;
    }

    //Big O(n)
    public List<Producto> mostrarProductosPorCategoria(Categoria categoria) {
        List<Producto> productosPorCategoria = new ArrayList<>();
        for (Producto objProducto : inventario.values()) {
            if (categoria.equals(objProducto.getCategoria())) {
                productosPorCategoria.add(objProducto);
            }
        }
        return productosPorCategoria;
    }

    //Bij 0(n)
    public void imprimirProductos() {
        for (Producto objProducto : inventario.values()) {
            System.out.println(objProducto.toString());
        }
    }

    public void verValorProducto(String producto) {
        boolean existe = false;
        for (Producto objProducto : inventario.values()) {
            if (objProducto.getNombre().equals(producto)) {
                existe = true;
                System.out.println("Tienes " + objProducto.getStock() + " " + producto + ".");
                System.out.println("A un precio de " + objProducto.getPrecio() + " por unidad, tienes " + (objProducto.getStock() * objProducto.getPrecio()) + "€ en valor de " + producto + ".");
            }
        }
        if (!existe) {
            System.out.println("No existe el producto con el nombre " + producto + ".");
            System.out.println("Para ver el producto existente usa la opción 'Mostrar todos los productos'.");
        }
    }
}