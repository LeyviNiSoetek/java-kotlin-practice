plugins {
    id("java")
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))

    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    // TODO: is these correct/necassary?
    //       Is "org.junit.jupiter:junit-jupiter" a bundle of a set of junit-jupiter dependencies?
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.3")
//    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.11.3")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}