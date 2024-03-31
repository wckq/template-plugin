package me.wckq.plugin.module;

import me.wckq.api.loader.Loader;
import me.wckq.plugin.loader.CommandLoader;
import me.wckq.plugin.loader.DefaultLoader;
import me.wckq.plugin.loader.ListenerLoader;
import team.unnamed.inject.AbstractModule;

public class LoaderModule extends AbstractModule {

    @Override
    protected void configure() {
        bindLoader(DefaultLoader.class, "default-loader");
        bindLoader(CommandLoader.class, "listener-loader");
        bindLoader(ListenerLoader.class, "command-loader");
    }

    private void bindLoader(
            final Class<? extends Loader> clazz,
            final String name
    ) {
        bind(Loader.class)
                .named(name)
                .to(clazz)
                .singleton();
    }
}
