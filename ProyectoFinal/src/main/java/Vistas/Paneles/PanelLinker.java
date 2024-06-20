package Vistas.Paneles;


import Modelos.Utils.Zoologico;
import Vistas.Utils.ImageLoader;

public class PanelLinker {
    private static PanelLinker panelLinker;
    private static PanelPrincipal panelPrincipal;
    private static PanelZoologico panelZoo;
    private static PanelMenu panelMenu;

    private PanelLinker(PanelPrincipal panelPrincipal, PanelZoologico panelZoo, PanelMenu panelMenu) {
        this.panelPrincipal = panelPrincipal;
        this.panelZoo = panelZoo;
        this.panelMenu = panelMenu;
    }

    public static void newLinker(PanelPrincipal panelPrincipal, PanelZoologico panelZoo ,PanelMenu panelMenu){
        if(panelLinker == null){
            panelLinker = new PanelLinker(panelPrincipal, panelZoo, panelMenu);
        }
    }

    public static PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }
    public static PanelMenu getPanelMenu() {
        return panelMenu;
    }

    public static PanelZoologico getPanelZoo() {
        return panelZoo;
    }
}
