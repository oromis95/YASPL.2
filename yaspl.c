#include<stdio.h>
#include <stdbool.h>
bool b,a1,a2,c,f;

int main(){a1 = true;
a2 = false;
b = a1||a2;
c = 10 > 5;
f = c&&b;
printf("%d\n",f) ;return 0;}
