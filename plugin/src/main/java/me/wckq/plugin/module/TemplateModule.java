package me.wckq.plugin.module;

import org.bukkit.plugin.Plugin;
import team.unnamed.inject.AbstractModule;

public class TemplateModule extends AbstractModule {

    private final Plugin plugin;

    public TemplateModule(final Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(Plugin.class).toInstance(plugin);

        install(new LoaderModule());
    }
}
