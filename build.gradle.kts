plugins {
    kotlin("jvm") version "2.0.10"
    id("com.gradleup.shadow") version "8.3.6"
}

group = "com.kashiuno"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.kashiuno.WebServerKt"
    }
}

tasks.named("compileKotlin", org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask::class.java) {
    compilerOptions {
        freeCompilerArgs.add("-Xdebug")
    }
}

tasks.test {
    useJUnitPlatform()
}