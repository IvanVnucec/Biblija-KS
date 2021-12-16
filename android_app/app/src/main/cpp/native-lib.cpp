#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_biblija_1ks_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */,
        jstring str) {
    return str;
}