public class Main {
    static void main(String[] args) {
        System.out.println("Pruebas de inventario:");

        Producto prod1 = new Producto("001","HP 200",450,Categoria.LAPTOP,10);
        Producto prod2 = new Producto("002","MacBook Air",900,Categoria.LAPTOP,0);
        Producto prod3 = new Producto("003","iPhone 15 Pro",1400,Categoria.SMARTPHONE,5);
        Producto prod4 = new Producto("004","Xiaomi 12 Pro",700,Categoria.SMARTPHONE,15);
        Producto prod5 = new Producto("005","Samsung S22+",1000,Categoria.SMARTPHONE,0);
        Producto prod6 = new Producto("006","iPad mini",400,Categoria.TABLET,10);
        Producto prod7 = new Producto("007","Google A400",200,Categoria.TABLET,20);
        Producto prod8 = new Producto("008","Samsung Watch8",350,Categoria.SMARTWATCH,15);
        Producto prod9 = new Producto("009","Apple Watch 3",600,Categoria.SMARTWATCH,5);

        InventarioTienda objInventario = new InventarioTienda("Inventario Misael");
        objInventario.agregarProducto(prod1);
        objInventario.agregarProducto(prod2);
        objInventario.agregarProducto(prod3);
        objInventario.agregarProducto(prod4);
        objInventario.agregarProducto(prod5);
        objInventario.agregarProducto(prod6);
        objInventario.agregarProducto(prod7);
        objInventario.agregarProducto(prod8);
        objInventario.agregarProducto(prod9);

        objInventario.agregarStock(prod2,5);
        objInventario.venderProducto(prod3,10);
        System.out.println("Valor total del inventario: " + objInventario.valorTotal());
    }
}