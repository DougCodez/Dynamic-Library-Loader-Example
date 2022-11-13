package server.fn;

import org.bukkit.plugin.java.JavaPlugin;

public class FNMain extends JavaPlugin {

    private LibrarySetup librarySetup;

    public void onEnable() {
        librarySetup = new LibrarySetup();
        librarySetup.loadLibraries();   
    }

    public void onDisable() {

    }
}
