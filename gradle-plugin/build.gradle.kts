plugins {
    `java-gradle-plugin`
    `maven-publish`
    id("com.gradleup.shadow") version "9.0.1"
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
    maven("https://maven.msrandom.net/repository/root/")
    maven("https://maven.msrandom.net/repository/cloche/")
}

dependencies {
    shadow(project(":gladys"))

    compileOnly("fabric-loom:fabric-loom.gradle.plugin:1.11-SNAPSHOT")
    compileOnly("earth.terrarium:cloche:0.11.20")
}

tasks {
    shadowJar {
        dependsOn(":gladys:build")
        from(project(":gladys").sourceSets.main.get().output)

        exclude("kotlin/**")
    }
}

publishing {
    repositories {
        mavenLocal()
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.harleylizard"
            artifactId = "snail"
            version = "1.0-SNAPSHOT"

            artifact(tasks.shadowJar.get()) {
                classifier = ""
            }
        }
    }
}
