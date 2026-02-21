plugins {
    id("java")
}

group = "com.bsoliveira"
version = "0.0.1"

repositories {
    mavenCentral()
    maven {
        name = "hytale"
        url = uri("https://maven.hytale.com/release")
    }
}

dependencies {
    implementation("com.hypixel.hytale:Server:+")
}

tasks.test {
    useJUnitPlatform()
}