plugins {
    `java-gradle-plugin`
}

group = "com.harleylizard"
version = "1.0-SNAPSHOT"

gradlePlugin {
    plugins {
        create("snail") {
            id = "com.harleylizard.snail"
            implementationClass = "com.harleylizard.snail.Snail"
        }
    }
}

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    implementation(project(":gladys"))

    compileOnly("fabric-loom:fabric-loom.gradle.plugin:1.11-SNAPSHOT")
}
