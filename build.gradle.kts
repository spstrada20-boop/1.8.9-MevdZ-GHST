plugins {
    idea
    java
    id("gg.essential.loom") version "0.10.0.+"
    id("dev.architectury.architectury-pack200") version "0.1.3"
}

group = "com.mevdz.ghst"
version = "1.0-beta"

base {
    archivesName.set("MevdZGHSTBeta")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

loom {
    runConfigs {
        remove(getByName("server"))
    }
    forge {
        pack200Provider.set(dev.architectury.pack200.java.Pack200Adapter())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:1.8.9")
    mappings("de.oceanlabs.mcp:mcp_stable:22-1.8.9")
    forge("net.minecraftforge:forge:1.8.9-11.15.1.2318-1.8.9")
}

tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("mcversion", "1.8.9")
    filesMatching("mcmod.info") {
        expand(mapOf("version" to project.version, "mcversion" to "1.8.9"))
    }
}
