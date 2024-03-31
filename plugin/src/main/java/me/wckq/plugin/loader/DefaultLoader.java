package me.wckq.plugin.loader;

import me.wckq.api.loader.Loader;
import team.unnamed.inject.InjectAll;
import team.unnamed.inject.Named;

@InjectAll
public class DefaultLoader implements Loader {

    @Named("command-loader")
    private Loader commandLoader;

    @Named("listener-loader")
    private Loader listenerLoader;

    @Override
    public void load() {
        this.commandLoader.load();
        this.listenerLoader.load();
    }
}
