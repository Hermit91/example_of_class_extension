plugins {
    java
    id("io.qameta.allure") version "2.9.6"
}

repositories {
    mavenCentral()
}

group "io.qameta.examples"
version "1.0.0"

val allureVersion = "2.19.0"

tasks.compileJava {
    sourceCompatibility = "${JavaVersion.VERSION_1_8}"
    targetCompatibility = "${JavaVersion.VERSION_1_8}"
    options.encoding = "UTF-8"
}

allure {
    report {
        version.set(allureVersion)
    }
    adapter {
        frameworks {
            junit5 {
                adapterVersion.set(allureVersion)
            }
        }

    }
}

tasks.test {
    ignoreFailures = false
    useJUnitPlatform {
    }
    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
    systemProperty("junit.jupiter.execution.parallel.config.strategy", "dynamic")
    systemProperty("junit.jupiter.extensions.autodetection.enabled", "true")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation("io.qameta.allure:allure-java-commons:2.19.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
}