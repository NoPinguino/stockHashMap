public enum Categoria {
    LAPTOP("Laptop"),
    TABLET("Tablet"),
    SMARTPHONE("Smartphone"),
    SMARTWATCH("Smartwatch");

    private final String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    /*
        values
        ValueOf(nombre)
    */
}
