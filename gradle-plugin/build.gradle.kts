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
}

dependencies {
    implementation(project(":gladys"))
}
