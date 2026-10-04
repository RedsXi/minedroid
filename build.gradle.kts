plugins {
    java
    alias(libs.plugins.kotlin)
}

repositories {
    mavenCentral()
    maven {
        name = "Fabric"
        url = uri("https://maven.fabricmc.net")    
    }
}

group = "org.redsxi.mc"
version = "0.0.1"

dependencies {
    implementation(libs.fabric)
    implementation(project(":iul"))
}