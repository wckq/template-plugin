package me.wckq.plugin.loader;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.builder.AnnotatedCommandBuilderImpl;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import me.wckq.api.loader.Loader;
import team.unnamed.inject.InjectAll;
import team.unnamed.inject.Injector;

@InjectAll
public class CommandLoader implements Loader {

    private Injector injector;

    @Override
    public void load() {
        this.registerCommands();
    }

    private void registerCommands(CommandClass... commandClasses) {
        final PartInjector partInjector = PartInjector.create();
        partInjector.install(new DefaultsModule());
        partInjector.install(new BukkitModule());

        final AnnotatedCommandTreeBuilder treeBuilder = AnnotatedCommandTreeBuilder.create(
                new AnnotatedCommandBuilderImpl(partInjector),
                ((clazz, parent) -> this.injector.getInstance(clazz))
        );

        final CommandManager commandManager = new BukkitCommandManager("template-plugin");

        for (final CommandClass commandClass : commandClasses) {
            commandManager.registerCommands(treeBuilder.fromClass(commandClass));
        }
    }
}
