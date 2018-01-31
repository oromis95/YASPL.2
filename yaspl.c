#include<stdio.h>
#include <stdbool.h>
void addInt(int,int,int*);
void moltiplicationInt(int,int,int*);
void divisionInt(int,int,int*);
void powFunc(int,int,int*);
void fibonacci(int,int*);
int choice,intResult;
int num1,num2;
void addInt(int intAdded1,int intAdded2,int* intSumOUT)
{
int intSum;
intSum = intAdded1 + intAdded2;
*intSumOUT=intSum;

}
void moltiplicationInt(int intMoltiplicator1,int intMoltiplicator2,int* intProductOUT)
{
int intProduct,count;
intProduct = 0;
count = 0;
while (!(count == intMoltiplicator2) )
{
addInt(intProduct,intMoltiplicator1,&intProduct);
count = count + 1;

}
*intProductOUT=intProduct;

}
void divisionInt(int div1,int div2,int* intQuotientOUT)
{
int intQuotient;
intQuotient = div1 / div2;
*intQuotientOUT=intQuotient;

}
void powFunc(int base,int exponent,int* intPowOUT)
{
int intPow,count,temp;
count = 0;
intPow = 1;
while (!(count == exponent) )
{
moltiplicationInt(intPow,base,&intPow);
count = count + 1;

}
*intPowOUT=intPow;

}
void fibonacci(int end,int* resultOUT)
{
int a,b,temp,count;
a = 1;
b = 1;
count = 0;
while (!(count == end) )
{
temp = a + b;
b = a;
a = temp;
printf("%d\n",a) ;printf(" \n" );
count = count + 1;

}
result = 4;
*resultOUT=result;

}

int main(){choice = 0;
while (!(choice == -1) )
{
printf("  0 Addizione 1  Moltiplicazione 2 Divisione 3 Potenza \n" );
scanf("%d" ,&choice) ;

if(choice == 0)
{printf("Inserisci i due numeri : \n" );
scanf("%d" ,&num1) ;

scanf("%d" ,&num2) ;

addInt(num1,num2,&intResult);
printf("Risultato \n" );
printf("%d\n",intResult) ;} else{if(choice == 1)
{printf("Inserisci i due numeri : \n" );
scanf("%d" ,&num1) ;

scanf("%d" ,&num2) ;

moltiplicationInt(num1,num2,&intResult);
printf("Risultato \n" );
printf("%d\n",intResult) ;} else{if(choice == 2)
{printf("Inserisci i due numeri : \n" );
scanf("%d" ,&num1) ;

scanf("%d" ,&num2) ;

divisionInt(num1,num2,&intResult);
printf("Risultato \n" );
printf("%d\n",intResult) ;} else{if(choice == 3)
{printf("Inserisci prima la base poi l'esponente \n" );
scanf("%d" ,&num1) ;

scanf("%d" ,&num2) ;

powFunc(num1,num2,&intResult);
printf("Risultato \n" );
printf("%d\n",intResult) ;} else{if(choice == 4)
{printf("Inserisca quanti numeri di fibonacci vuole \n" );
scanf("%d" ,&num1) ;

fibonacci(num1,&intResult);
} 
} 
} 
} 
} 

}
return 0;}
