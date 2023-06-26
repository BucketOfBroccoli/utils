# couscous
[![Release](https://jitpack.io/v/AreteS0ftware/couscous.svg)](https://jitpack.io/v/AreteS0ftware/couscous)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Versioning](https://img.shields.io/badge/semver-2.0.0-blue)](https://semver.org/)

A tiny collection of utilities I use for <strong>my <a href="https://github.com/libgdx/libgdx">libGDX</a> games</strong>; you probably won't find much use in this.

## Install
couscous is available via JitPack. Make sure you have JitPack declared as a repository in your root <code>build.gradle</code> file:

```
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```
Then add couscous as dependency in your core project:
```
project(":core") {
    dependencies {
    	// ...
        implementation 'com.github.AreteS0ftware:couscous:0.1.0'
    }
}
```
