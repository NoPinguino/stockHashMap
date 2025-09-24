public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private Categoria categoria;
    private int stock;

    public Producto(String codigo, String nombre, double precio, Categoria categoria, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    /*GETTERS: todos los atributos.*/

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getStock() {
        return stock;
    }

    /*SETTERS: precio y stock.*/

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /*MÉTODOS*/

    //Big O(1)
    public double valorDelStock() {
        return getPrecio() * getStock();
    }

    @Override
    public String toString() {
        return
                "Código: " + codigo + '\n' +
                "Nombre: " + nombre + '\n' +
                "Precio: " + precio + "€" + '\n' +
                "Categoria: " + categoria + '\n' +
                "Stock: " + stock + '\n';
    }
}