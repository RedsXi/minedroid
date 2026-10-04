plugins {
    java
    alias(libs.plugins.kotlin)
}

repositories {
    mavenCentral()
}

group = "org.redsxi"
version = "0.0.1"

dependencies {
    implementation(libs.asm)
}