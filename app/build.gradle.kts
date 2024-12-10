import dev.trindadedev.anemo.build.BuildConfig
import dev.trindadedev.anemo.build.VersionUtils

plugins {
  alias(libs.plugins.anemo.application)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = BuildConfig.packageName
  
  defaultConfig {
    applicationId = namespace
    versionCode = VersionUtils.versionCode
    versionName = VersionUtils.versionName
    
    vectorDrawables.useSupportLibrary = true
  }
    
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
    
  signingConfigs {
    create("release") {
      // temporary keystore
      storeFile = file(layout.buildDirectory.dir("../release_key.jks"))
      storePassword = "release_temp"
      keyAlias = "release_temp"
      keyPassword = "release_temp"
    }
    getByName("debug") {
      storeFile = file(layout.buildDirectory.dir("../testkey.keystore"))
      storePassword = "testkey"
      keyAlias = "testkey"
      keyPassword = "testkey"
    }
  }
    
  buildTypes {
    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      signingConfig = signingConfigs.getByName("release")
    }
  }
}

dependencies {
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.core.splashscreen)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.apppcompat)
  implementation(libs.material)
}