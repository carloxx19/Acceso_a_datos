package Controllers;

public interface InterfacePersonas<Personas> {

    Personas obtenerdni(String dni);

    void agregar();

    void consultar();

    void actualizar();

    void eliminar();
}