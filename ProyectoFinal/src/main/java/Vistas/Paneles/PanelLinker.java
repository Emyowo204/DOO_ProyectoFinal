package Vistas.Paneles;

/** Un Singleton para interconectar paneles de la vista del zoológico
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */
public class PanelLinker {

    /** Instancia del PanelLinker */
    private static PanelLinker panelLinker;

    /** Instancia del PanelPrincipal */
    private static PanelPrincipal panelPrincipal;

    /** Instancia del PanelZoo */
    private static PanelZoologico panelZoo;

    /** Instancia del PanelMenu */
    private static PanelMenu panelMenu;

    /** Constructor de PanelLinker */
    private PanelLinker(PanelPrincipal panelPrincipal, PanelZoologico panelZoo, PanelMenu panelMenu) {
        PanelLinker.panelPrincipal = panelPrincipal;
        PanelLinker.panelZoo = panelZoo;
        PanelLinker.panelMenu = panelMenu;
    }

    /** Método para obtener la instancia de PanelLinker */
    public static void newLinker(PanelPrincipal panelPrincipal, PanelZoologico panelZoo ,PanelMenu panelMenu){
        if(panelLinker == null){
            panelLinker = new PanelLinker(panelPrincipal, panelZoo, panelMenu);
        }
    }

    /** Método para obtener PanelPrincipal
     * @return PanelPrincipal */
    public static PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }

    /** Método para obtener PanelMenu
     * @return PanelMenu */
    public static PanelMenu getPanelMenu() {
        return panelMenu;
    }


    /** Método para obtener PanelZoologico
     * @return PanelZoologico */
    public static PanelZoologico getPanelZoo() {
        return panelZoo;
    }
}
