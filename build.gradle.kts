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

dependencies {
    implementation(libs.fabric)
    implementation(project(":iul"))
    implementation(files("example.jar"))
}