# offline-todo-app
sell data will be offlined when fetched from the buy api call is happend.
dependencies {
    implementation 'com.google.firebase:firebase-crashlytics-buildtools:2.9.4'

    implementation 'androidx.core:core-ktx:1.9.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.8.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'com.google.firebase:firebase-messaging:23.1.2'
    testImplementation 'junit:junit:4.13.2'
//    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.google.code.gson:gson:2.9.1'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.9.3'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    implementation 'com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava'
    implementation 'com.google.guava:guava:24.1-jre'

    implementation platform('com.google.firebase:firebase-bom:31.1.1')
    implementation 'com.google.firebase:firebase-perf'

    implementation 'com.google.firebase:firebase-crashlytics'
    implementation 'com.google.firebase:firebase-analytics'

//    implementation 'com.github.bumptech.glide:glide:4.14.2'
//    kapt 'com.github.bumptech.glide:compiler:4.14.2'

    implementation "androidx.room:room-runtime:2.5.1"
    kapt "androidx.room:room-compiler:2.5.1"
    implementation "androidx.room:room-ktx:2.5.1"

    implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
    implementation "androidx.lifecycle:lifecycle-common-java8:2.5.1"
//    implementation 'de.hdodenhof:circleimageview:3.1.0'
//
//    implementation 'com.intuit.sdp:sdp-android:1.1.0'
//    implementation 'com.intuit.ssp:ssp-android:1.1.0'


    // navigation Components
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.2'
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.2'

    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1"
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    implementation "androidx.activity:activity-ktx:1.7.2"

    implementation 'androidx.fragment:fragment-ktx:1.6.0'

    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'

    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4'

}

