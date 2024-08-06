# utils
[![Release](https://jitpack.io/v/BroccoliBucket/utils.svg)](https://jitpack.io/v/BucketOfBroccoli/utils)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Versioning](https://img.shields.io/badge/semver-2.0.0-blue)](https://semver.org/)

A tiny collection of some common utilities for Java, with no dependencies.

### Features

* [NumberUtils](https://github.com/BucketOfBroccoli/utils/blob/main/src/main/java/it/aretesoftware/utils/NumberUtils.java): contains utilities for dealing with numbers
* [StringUtils](https://github.com/BucketOfBroccoli/utils/blob/main/src/main/java/it/aretesoftware/utils/StringUtils.java): contains utilities for dealing with strings
* [ArrayUtils](https://github.com/BucketOfBroccoli/utils/blob/main/src/main/java/it/aretesoftware/utils/ArrayUtils.java): contains utilities for dealing with arrays


### Install
utils is available via JitPack. Make sure you have JitPack declared as a repository in your root <code>build.gradle</code> file:

```
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```
Then add utils as dependency in your core project:
```
project(":core") {
    dependencies {
    	// ...
        implementation 'com.github.BucketOfBroccoli:utils:2.1.0'
    }
}
```

<hr>

### Contact
* This project is maintained by BucketOfBroccoli (Arete)
* https://aretesoftware.it/
* aretedev (at) protonmail.com

### License
MIT License

Copyright (c) 2023 Arete

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
