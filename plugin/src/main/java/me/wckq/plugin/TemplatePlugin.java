package me.wckq.plugin;

import me.wckq.api.loader.Loader;
import me.wckq.plugin.module.TemplateModule;
import org.bukkit.plugin.java.JavaPlugin;
import team.unnamed.inject.Inject;
import team.unnamed.inject.Injector;
import team.unnamed.inject.Named;

public class TemplatePlugin extends JavaPlugin {

    @Inject
    @Named("default-loader")
    private Loader loader;

    @Override
    public void onEnable() {
        Injector.create(new TemplateModule(this))
                .injectMembers(this);

        this.loader.load();
    }

    @Override
    public void onDisable() {
        this.loader.unload();
    }
}
