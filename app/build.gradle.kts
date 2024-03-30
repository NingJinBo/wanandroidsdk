plugins {
    id("com.android.library")
    id("maven-publish")
}
subprojects {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {
                // Applies the component for the release build variant.\
                afterEvaluate {
                    from(components["release"])
                }
                // You can then customize attributes of the publication as shown below.
                groupId = "om.example.wanandroidsdk"
                artifactId = "wanandroidsdk"
                version = "1.0"

            }
        }
    }
}

android {
    namespace = "com.example.wanandroidsdk"
    compileSdk = 33

    defaultConfig {
        //applicationId = "com.example.wanandroidsdk"
        minSdk = 24
        targetSdk = 33
        //versionCode = 1
       // versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}