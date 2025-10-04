import java.util.Scanner;
public class Main {
    static void main(String[] args) {
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

        int option;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menú de pruebas: ");
            System.out.println("1. Añadir producto.");
            System.out.println("2. Agregar stock.");
            System.out.println("3. Vender stock.");
            System.out.println("4. Ver valor (€) de un producto.");
            System.out.println("5. Ver valor (€) total.");
            System.out.println("6. Ver stock total.");
            System.out.println("7. Mostrar productos por categoría.");
            System.out.println("8. Mostrar todos los productos.");
            System.out.println("9. SALIR");
            System.out.println(" ");

            System.out.println("¿Qué quieres hacer?: ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Código del nuevo producto: ");
                    String prodCodigo = sc.nextLine();
                    System.out.println("Nombre del nuevo producto: ");
                    String prodNombre = sc.nextLine();
                    System.out.println("Precio del nuevo producto: ");
                    Double prodPrecio = Double.parseDouble(sc.nextLine());
                    System.out.println("Categoría del nuevo producto: ");
                    String str_prodCategoria = sc.nextLine().toUpperCase();

                    Categoria prodCategoria = null;
                    try {
                        prodCategoria = Categoria.valueOf(str_prodCategoria);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Categoría no válida.");
                    }

                    System.out.println("Stock del nuevo producto: ");
                    Integer prodStock = Integer.parseInt(sc.nextLine());

                    if (prodCategoria != null) {
                        Producto newProducto = new Producto(prodCodigo,prodNombre,prodPrecio,prodCategoria,prodStock);
                        objInventario.agregarProducto(newProducto);
                    }
                    break;
                case 2:
                    System.out.println("Stock a añadir: ");
                    int cantidad = Integer.parseInt(sc.nextLine());
                    System.out.println("Producto del que quiéres añadir stock: ");
                    String producto_agregar = sc.nextLine();
                    objInventario.agregarStock(producto_agregar,cantidad);
                    break;
                case 3:
                    System.out.println("Stock a vender: ");
                    int cantVender = Integer.parseInt(sc.nextLine());
                    System.out.println("Producto del que quieres vender stock: ");
                    String producto_vender = sc.nextLine();
                    objInventario.venderProducto(producto_vender,cantVender);
                    break;
                case 4:
                    System.out.println("Producto del que quieres ver el valor: ");
                    String producto_ver_valor = sc.nextLine();
                    objInventario.verValorProducto(producto_ver_valor);
                    break;
                case 5:
                    System.out.println("El valor total del inventario es " + objInventario.valorTotal() + "€.");
                    break;
                case 6:
                    System.out.println("EL stock total del inventario es " + objInventario.stockTotal() + "ud de productos.");
                    break;
                case 7:
                    System.out.println("Categoría que buscar: ");
                    String str_categoria = sc.nextLine().toUpperCase();

                    Categoria categoria = null;
                    try {
                        categoria = Categoria.valueOf(str_categoria);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Categoría no válida.");
                    }

                    if (categoria != null) {
                        objInventario.mostrarProductosPorCategoria(categoria);
                    }
                    break;
                case 8:
                    objInventario.imprimirProductos();
                    break;
                case 9:
                    System.out.println("CERRANDO MENÚ...");
                    break;
                default:
                    System.out.println("Introduce un valor válido:");
                    break;
            }

        } while (option != 9);
        sc.close();

//        objInventario.agregarStock(prod2,5);
//        objInventario.venderProducto(prod3,10);
//        System.out.println("Valor total del inventario: " + objInventario.valorTotal());
//
//        objInventario.imprimirProductos();
//
//        System.out.println(objInventario.mostrarProductosPorCategoria(Categoria.SMARTPHONE));
    }
}