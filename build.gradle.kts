plugins {
    id("java")
}

group = "com.naianzin.leetcode"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation ("com.auth0:java-jwt:4.0.0")

    // add junit 4
    testImplementation("junit:junit:4.13.2")

}

tasks.test {
    useJUnitPlatform()
}