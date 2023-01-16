package Controllers;

public interface InterfacePersonas<Personas> {

    public Personas obtenerdni(String dni);

    public void agregar();

    void consultar();

    void actualizar();

    void eliminar();
}