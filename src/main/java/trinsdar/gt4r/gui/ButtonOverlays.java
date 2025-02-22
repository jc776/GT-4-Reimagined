package trinsdar.gt4r.gui;

import muramasa.antimatter.gui.ButtonBody;
import muramasa.antimatter.gui.ButtonOverlay;
import org.lwjgl.system.CallbackI;

public class ButtonOverlays {
    public static ButtonBody NO_OVERLAY = new ButtonBody("no_overlay", 80, 0, 0, 0, 16, 16);
    public static ButtonBody EXPORT = new ButtonBody("export", 48, 16,0,0, 16, 16);
    public static ButtonBody IMPORT = new ButtonBody("import", 64, 16,0,0, 16, 16);
    public static ButtonBody EXPORT_CONDITIONAL = new ButtonBody("export_conditional", 32, 80, 0, 0,16, 16);
    public static ButtonBody IMPORT_CONDITIONAL = new ButtonBody("import_conditional", 48, 80, 0, 0,16, 16);
    public static ButtonBody EXPORT_INVERT_CONDITIONAL = new ButtonBody("export_invert_conditional", 0, 80, 0, 0,16, 16);
    public static ButtonBody IMPORT_INVERT_CONDITIONAL = new ButtonBody("import_invert_conditional", 16, 80, 0, 0,16, 16);
    public static ButtonBody EXPORT_IMPORT = new ButtonBody("export_import", 64, 80, 0, 0,16, 16);
    public static ButtonBody IMPORT_EXPORT = new ButtonBody("import_export", 80, 80, 0, 0,16, 16);
    public static ButtonBody EXPORT_IMPORT_CONDITIONAL = new ButtonBody("export_import_conditional", 128, 80, 0, 0,16, 16);
    public static ButtonBody IMPORT_EXPORT_CONDITIONAL = new ButtonBody("import_export_conditional", 144, 80, 0, 0,16, 16);
    public static ButtonBody EXPORT_IMPORT_INVERT_CONDITIONAL = new ButtonBody("export_import_invert_conditional", 96, 80, 0, 0,16, 16);
    public static ButtonBody IMPORT_EXPORT_INVERT_CONDITIONAL = new ButtonBody("import_export_invert_conditional", 112, 80, 0, 0,16, 16);
}
