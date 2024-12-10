plugins {
  `kotlin-dsl`
}

dependencies {
  compileOnly(libs.android.gradle)
  compileOnly(libs.compose.gradle)
  compileOnly(libs.kotlin.gradle)
  compileOnly(libs.ksp.gradle)
}

gradlePlugin {
  plugins {
    register("anemo.application") {
      id = "anemo.application"
      implementationClass = "ApplicationConventionPlugin"
    }
    
    register("anemo.library") {
      id = "anemo.library"
      implementationClass = "LibraryConventionPlugin"
    }
    
    register("anemo.compose") {
      id = "anemo.compose"
      implementationClass = "ComposeConventionPlugin"
    }
  }
}