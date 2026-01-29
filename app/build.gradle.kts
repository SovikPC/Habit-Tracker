plugins {
    alias(libs.plugins.android.application)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.compose.compiler)
    id("com.google.gms.google-services")
}

android {
    namespace = "ru.habit.tracker"
    compileSdk {
        version = release(36)
    }

    buildFeatures {
        compose = true
    }

    defaultConfig {
        applicationId = "ru.habit.tracker"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:34.8.0"))
    implementation("com.google.firebase:firebase-analytics")

    //Paging 3
    val paging_version = "3.3.6"
    implementation("androidx.paging:paging-runtime:$paging_version")
    implementation("androidx.paging:paging-compose:3.4.0-rc01")
    testImplementation("androidx.paging:paging-common:${paging_version}")

    //Jetpack Compose
    val composeBom = platform("androidx.compose:compose-bom:2025.12.00")
    implementation(composeBom)
    implementation("androidx.compose.material:material-icons-core")
    implementation("androidx.compose.material:material-icons-extended")
    androidTestImplementation(composeBom)
    //Jetpack Compose android studio preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    // Optional - Integration with activities
    implementation("androidx.activity:activity-compose:1.11.0")
    // Optional - Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.5")

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.adaptive.navigation.suite)

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.59")
    ksp("com.google.dagger:hilt-android-compiler:2.59")

    //Room
    implementation("androidx.room:room-runtime:2.8.4")
    ksp("androidx.room:room-compiler:2.8.4")
    implementation("androidx.room:room-ktx:2.8.4")
    testImplementation("androidx.room:room-testing:2.8.4")
    implementation("androidx.room:room-paging:2.8.4")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}