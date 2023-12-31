plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.myvirtusizetestapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.myvirtusizetestapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        android.buildFeatures.buildConfig = true
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://product-recommendation.virtusize.jp/\"")
        }
        release {
            buildConfigField("String", "BASE_URL", "\"https://product-recommendation.virtusize.jp/\"")
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
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures{
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.test.espresso:espresso-contrib:3.5.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val coroutinesFlowVersion = "1.6.4"
    val coilVersion = "2.0.0-rc03"
    val daggerHiltVersion = "2.48"
    val hiltCompilerVersion = "1.0.0"
    val lifecycleViewModelKTXVersion="2.6.1"
    val sdpVersion = "1.0.6"
    val sspVersion = "1.0.6"
    val retrofitVersion = "2.9.0"
    val okhttpVersion = "4.9.3"
    val kotlinVersion = "1.8.20"

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    //Coroutines & Flow
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesFlowVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesFlowVersion")

    //For using "by viewModels()"
    implementation("androidx.fragment:fragment-ktx:1.6.1")

    //Coil
    implementation("io.coil-kt:coil:$coilVersion")

    //hilt
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-compiler:$daggerHiltVersion")
    kapt("androidx.hilt:hilt-compiler:$hiltCompilerVersion")

    //Lifecycle related
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleViewModelKTXVersion")

    //For using kotlin extensions of LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    //SDP and SSP for responsive design
    implementation("com.intuit.sdp:sdp-android:$sdpVersion")
    implementation("com.intuit.ssp:ssp-android:$sspVersion")

    //Retrofit & okhttp
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
}