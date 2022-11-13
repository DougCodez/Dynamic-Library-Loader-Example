package common.fn.library;

import java.util.List;

public abstract class AbstractLibraryLoader<Library, LibraryManager> {

    public abstract List<Library> initLibraries();

    public abstract void loadLibraries();

    public abstract LibraryManager getLibraryManager();

    public abstract Library createLibrary(LibraryObject libraryObject);
}
