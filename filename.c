#include<stdio.h>
#include <stdbool.h>
void addInt(int*);
void addDouble(double*);
void subtractionInt(int*);
void subtractionDouble(double*);
void moltiplicationInt(int*);
void moltiplicationDouble(double*);
void divisionInt(int*);
void divisionDouble(double*);
int choice,intResult;
double doubleResult;
int operativeChoice;
void addInt(int* intSumOUT)
{
int intAdded,intSum;
intAdded = -99999;
intSum = 0;
printf("Somma di interi " );
printf("Inserisca un numero. " );
scanf("%d" ,&intAdded) ;

while (!(intAdded == 0) )
{
intSum = intSum + intAdded;
printf("Inserisca un altro numero, inserisca zero se vuole finire " );
scanf("%d" ,&intAdded) ;


}
*intSumOUT=intSum;

}
void addDouble(double* doubleSumOUT)
{
double doubleAdded,doubleSum;
doubleAdded = -99999;
doubleSum = 0;
printf("Somma di double " );
printf("Inserisca un numero. " );
scanf("%lf" ,&doubleAdded) ;

while (!(doubleAdded == 0) )
{
doubleSum = doubleSum + doubleAdded;
printf("Inserisca un altro numero, inserisca zero se vuole finire " );
scanf("%lf" ,&doubleAdded) ;


}
*doubleSumOUT=doubleSum;

}
void subtractionInt(int* intRemainderOUT)
{
int intAmount,intRemainder;
intAmount = -99999;
intRemainder = 0;
printf("Sottrazione di interi " );
printf("Inserisca un numero. " );
scanf("%d" ,&intAmount) ;

while (!(intAmount == 0) )
{
intRemainder = intRemainder - intAmount;
printf("Inserisca un altro numero, inserisca zero se vuole finire " );
scanf("%d" ,&intAmount) ;


}
*intRemainderOUT=intRemainder;

}
void subtractionDouble(double* doubleRemainderOUT)
{
double doubleAmount,doubleRemainder;
doubleAmount = -99999;
doubleRemainder = 0;
printf("Sottrazione di Double " );
printf("Inserisca un numero. " );
scanf("%lf" ,&doubleAmount) ;

while (!(doubleAmount == 0) )
{
doubleRemainder = doubleRemainder - doubleAmount;
printf("Inserisca un altro numero, inserisca zero se vuole finire " );
scanf("%lf" ,&doubleAmount) ;


}
*doubleRemainderOUT=doubleRemainder;

}
void moltiplicationInt(int* intProductOUT)
{
int intMoltiplicator,intProduct;
intMoltiplicator = -99999;
intProduct = 1;
printf("Moltiplicazione di interi " );
printf("Inserisca un numero. " );
scanf("%d" ,&intMoltiplicator) ;

while (!(intMoltiplicator == 0) )
{
intProduct = intProduct * intMoltiplicator;
printf("Inserisca un altro numero, inserisca zero se vuole finire " );
scanf("%d" ,&intMoltiplicator) ;


}
*intProductOUT=intProduct;

}
void moltiplicationDouble(double* doubleProductOUT)
{
double doubleMoltiplicator,doubleProduct;
doubleMoltiplicator = -99999;
doubleProduct = 1;
printf("Moltiplicazione di double " );
printf("Inserisca un numero. " );
scanf("%lf" ,&doubleMoltiplicator) ;

while (!(doubleMoltiplicator == 0) )
{
doubleProduct = doubleProduct * doubleMoltiplicator;
printf("Inserisca un altro numero, inserisca zero se vuole finire " );
scanf("%lf" ,&doubleMoltiplicator) ;


}
*doubleProductOUT=doubleProduct;

}
void divisionInt(int* intQuotientOUT)
{
int intDivider,intQuotient;
intDivider = -99999;
intQuotient = 1;
printf("Divisione di interi " );
printf("Inserisca un numero. " );
scanf("%d" ,&intDivider) ;

while (!(intDivider == 0) )
{
intQuotient = intQuotient / intDivider;
printf("Inserisca un altro numero, inserisca zero se vuole finire " );
scanf("%d" ,&intDivider) ;


}
*intQuotientOUT=intQuotient;

}
void divisionDouble(double* doubleQuotientOUT)
{
double doubleDivider,doubleQuotient;
doubleDivider = -99999;
doubleQuotient = 1;
printf("Divisione di Double " );
printf("Inserisca un numero. " );
scanf("%lf" ,&doubleDivider) ;

while (!(doubleDivider == 0) )
{
doubleQuotient = doubleQuotient / doubleDivider;
printf("Inserisca un altro numero, inserisca zero se vuole finire " );
scanf("%lf" ,&doubleDivider) ;


}
*doubleQuotientOUT=doubleQuotient;

}

int main(){choice = 0;
while (!(choice == -1) )
{
printf("Scrivi il simbolo per effetture l'operazione decisa  I simboli possibili sono :  0 Addizione 1 Sottrazione 2 Moltiplicazione 3 Divisione Inserica -1 per terminare " );
scanf("%d" ,&choice) ;

if(choice == 0)
{printf("Vuoi lavorare con interi o double? 0 per interi 1 per double " );
scanf("%d" ,&operativeChoice) ;

if(operativeChoice == 0)
{addInt(&intResult);
printf("Risultato " );
printf("%d",intResult) ;} else{if(operativeChoice == 1)
{addDouble(&doubleResult);
printf("Risultato " );
printf("%f",doubleResult) ;} else{printf("Comando non riconosciuto " );
} 
} 
} else{if(choice == 1)
{printf("Vuoi lavorare con interi o double? INTERI per interi DOUBLE per double " );
scanf("%d" ,&operativeChoice) ;

if(operativeChoice == 0)
{subtractionInt(&intResult);
printf("Risultato " );
printf("%d",intResult) ;} else{if(operativeChoice == 1)
{subtractionDouble(&doubleResult);
printf("Risultato " );
printf("%f",doubleResult) ;} else{printf("Comando non riconosciuto " );
} 
} 
} else{if(choice == 2)
{printf("Vuoi lavorare con interi o double? INTERI per interi DOUBLE per double " );
scanf("%d" ,&operativeChoice) ;

if(operativeChoice == 0)
{moltiplicationInt(&intResult);
printf("Risultato " );
printf("%d",intResult) ;} else{if(operativeChoice == 1)
{moltiplicationDouble(&doubleResult);
printf("Risultato " );
printf("%f",doubleResult) ;} else{printf("Comando non riconosciuto " );
} 
} 
} else{if(choice == 3)
{printf("Vuoi lavorare con interi o double? INTERI per interi DOUBLE per double " );
scanf("%d" ,&operativeChoice) ;

if(operativeChoice == 0)
{divisionInt(&intResult);
printf("Risultato " );
printf("%d",intResult) ;} else{if(operativeChoice == 1)
{divisionDouble(&doubleResult);
printf("Risultato " );
printf("%f",doubleResult) ;} else{printf("Comando non riconosciuto " );
} 
} 
} else{if(choice == -1)
{printf("finito" );
} else{printf("Comando non riconosciuto " );
} 
} 
} 
} 
} 

}
return 0;}
