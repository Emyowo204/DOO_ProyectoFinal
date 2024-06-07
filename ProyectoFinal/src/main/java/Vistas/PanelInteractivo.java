package Vistas;

public class PanelInteractivo {

    private boolean visible;

    public PanelInteractivo() {}

    public void togglePanel() {
        visible = !visible;
    }

    public boolean getVisible() { return visible; }
}
