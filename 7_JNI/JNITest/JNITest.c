#include <stdio.h>
#include "JNITest.h"

JNIEXPORT void JNICALL Java_JNITest_print(JNIEnv *, jobject) {
printf("Hello world");
return;
}