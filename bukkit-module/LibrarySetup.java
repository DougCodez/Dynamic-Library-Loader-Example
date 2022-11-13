package server.fn;

import common.fn.library.AbstractLibraryLoader;
import common.fn.library.LibraryConfig;
import common.fn.library.LibraryObject;
import net.byteflux.libby.BukkitLibraryManager;
import net.byteflux.libby.Library;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LibrarySetup extends AbstractLibraryLoader<Library, BukkitLibraryManager> {


    private BukkitLibraryManager bukkitLibraryManager = new BukkitLibraryManager(FNMain.getPlugin(FNMain.class));

    @Override
    public List<Library> initLibraries() {
        return Arrays.asList(createLibrary(LibraryConfig.MYSQL_CONNECTOR), createLibrary(LibraryConfig.HIKARI), createLibrary(LibraryConfig.MONGODB));
    }

    @Override
    public void loadLibrary() {
        bukkitLibraryManager.addMavenCentral();
        initLibraries().forEach(library -> bukkitLibraryManager.loadLibrary(library));
    }

    @Override
    public BukkitLibraryManager getLibraryManager() {
        return bukkitLibraryManager;
    }

    public Library createLibrary(LibraryObject libraryObject) {
        return Library.builder().groupId(libraryObject.groupID()).artifactId(libraryObject.artifactID()).version(libraryObject.version()).id(libraryObject.id()).relocate(libraryObject.oldRelocation(), libraryObject.newRelocation()).build();
    }
}
