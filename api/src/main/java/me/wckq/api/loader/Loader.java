package me.wckq.api.loader;

public interface Loader {
    void load();

    default void unload() {}
}
