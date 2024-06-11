package Vistas;


public class PanelLinker {

    private static PanelLinker panelLinker;
    private static PanelPrincipal panelPrincipal;

    private PanelLinker() {
        panelLinker = this;
        panelPrincipal = null;
    }

    public static void newPanelLinker() {
        if(panelLinker == null) {
            panelLinker = new PanelLinker();
        }
    }

    public static PanelPrincipal getPanelPrincipal() {
        if(panelPrincipal==null)
            panelPrincipal = new PanelPrincipal();
        return panelPrincipal;
    }
}
