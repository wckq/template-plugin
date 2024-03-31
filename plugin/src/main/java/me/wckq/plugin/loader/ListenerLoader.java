package me.wckq.plugin.loader;

import me.wckq.api.loader.Loader;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import team.unnamed.inject.InjectAll;

@InjectAll
public class ListenerLoader implements Loader {

    private Plugin plugin;

    @Override
    public void load() {
        this.registerListeners();
    }

    private void registerListeners(final Listener... listeners) {
        for (final Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this.plugin);
        }
    }
}
