import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("plugin.spring") version "1.8.0"

    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
}

group = "com.ksetoue"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

extra["springCloudVersion"] = "2021.0.5"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.13")
    implementation("io.opentracing.contrib:opentracing-spring-jaeger-cloud-starter:3.3.1")
    implementation("io.opentracing.contrib:opentracing-spring-cloud-starter:0.5.9")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

/*
* This configuration sets the jar name to "app"
* */
kotlin {
    jvmToolchain {
        archivesName.set("app")
    }
}
/*
*  Set specific lint rules here
* */
ktlint {
    disabledRules.set(
        setOf(
            "no-wildcard-imports"
        )
    )
}
