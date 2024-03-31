import xyz.jpenilla.runpaper.task.RunServer

plugins {
    id("xyz.jpenilla.run-paper") version "2.2.2"
    id("net.minecrell.plugin-yml.paper") version "0.6.0"
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")

    implementation("team.unnamed:inject:2.0.1")
    implementation("me.fixeddev:commandflow-bukkit:0.6.0")

    implementation("team.unnamed:gui-menu-api:3.4.0-SNAPSHOT")
    implementation("team.unnamed:gui-menu-adapt-v1_20_R3:3.4.0-SNAPSHOT") // Libreria subida en Maven Local

    implementation(project(":api"))
}

tasks {
    runServer {
        minecraftVersion("1.20.4")
    }
}

paper {
    main = "me.wckq.plugin.TemplatePlugin"
    version = project.version.toString()
    apiVersion = "1.20"
    authors = listOf("4z4el")
}