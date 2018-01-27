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
while (!(intAdded == 0) )
{
printf("Inserisca un altro numero, inserisca zero se vuole finire" );
scanf("%d" ,&intAdded) ;

intSum = intSum + intAdded;

}
*intSumOUT=intSum;

}
void addDouble(double* doubleSumOUT)
{
double doubleAdded,doubleSum;
doubleAdded = -99999;
doubleSum = 0;
while (!(doubleAdded == 0) )
{
printf("Inserisca un altro numero, inserisca zero se vuole finire" );
scanf("%lf" ,&doubleAdded) ;

doubleSum = doubleSum + doubleAdded;

}
*doubleSumOUT=doubleSum;

}
void subtractionInt(int* intRemainderOUT)
{
int intAmount,intRemainder;
intAmount = -99999;
intRemainder = 0;
while (!(intAmount == 0) )
{
printf("Inserisca un altro numero, inserisca zero se vuole finire" );
scanf("%d" ,&intAmount) ;

intRemainder = intRemainder - intAmount;

}
*intRemainderOUT=intRemainder;

}
void subtractionDouble(double* doubleRemainderOUT)
{
double doubleAmount,doubleRemainder;
doubleAmount = -99999;
doubleRemainder = 0;
while (!(doubleAmount == 0) )
{
printf("Inserisca un altro numero, inserisca zero se vuole finire" );
scanf("%lf" ,&doubleAmount) ;

doubleRemainder = doubleRemainder - doubleAmount;

}
*doubleRemainderOUT=doubleRemainder;

}
void moltiplicationInt(int* intProductOUT)
{
int intMoltiplicator,intProduct;
intMoltiplicator = -99999;
intProduct = 1;
while (!(intMoltiplicator == 0) )
{
printf("Inserisca un altro numero, inserisca zero se vuole finire" );
scanf("%d" ,&intMoltiplicator) ;

intProduct = intProduct * intMoltiplicator;

}
*intProductOUT=intProduct;

}
void moltiplicationDouble(double* doubleProductOUT)
{
double doubleMoltiplicator,doubleProduct;
doubleMoltiplicator = -99999;
doubleProduct = 1;
while (!(doubleMoltiplicator == 0) )
{
printf("Inserisca un altro numero, inserisca zero se vuole finire" );
scanf("%lf" ,&doubleMoltiplicator) ;

doubleProduct = doubleProduct * doubleMoltiplicator;

}
*doubleProductOUT=doubleProduct;

}
void divisionInt(int* intQuotientOUT)
{
int intDivider,intQuotient;
intDivider = -99999;
intQuotient = 1;
while (!(intDivider == 0) )
{
printf("Inserisca un altro numero, inserisca zero se vuole finire" );
scanf("%d" ,&intDivider) ;

intQuotient = intQuotient / intDivider;

}
*intQuotientOUT=intQuotient;

}
void divisionDouble(double* doubleQuotientOUT)
{
double doubleDivider,doubleQuotient;
doubleDivider = -99999;
doubleQuotient = 1;
while (!(doubleDivider == 0) )
{
printf("Inserisca un altro numero, inserisca zero se vuole finire" );
scanf("%lf" ,&doubleDivider) ;

doubleQuotient = doubleQuotient / doubleDivider;

}
*doubleQuotientOUT=doubleQuotient;

}

int main(){printf("Scrivi il simbolo per effetture l'operazione decisa  I simboli possibili sono :  0 Addizione 1 Sottrazione 2 Moltiplicazione 3 Divisione Inserica -1 per terminare" );
scanf("%d" ,&choice) ;

while (true)
{
if(choice == 0)
{printf("Vuoi lavorare con interi o double? 0 per interi 1 per double" );
scanf("%d" ,&operativeChoice) ;

if(operativeChoice == 0)
{addInt(&intResult);
} else{if(operativeChoice == 1)
{addDouble(&doubleResult);
} else{printf("Comando non riconosciuto" );
} 
} 
} else{if(choice == 1)
{printf("Vuoi lavorare con interi o double? INTERI per interi DOUBLE per double" );
scanf("%d" ,&operativeChoice) ;

if(operativeChoice == 0)
{subtractionInt(&intResult);
} else{if(operativeChoice == 1)
{subtractionDouble(&doubleResult);
} else{printf("Comando non riconosciuto" );
} 
} 
} else{if(choice == 2)
{printf("Vuoi lavorare con interi o double? INTERI per interi DOUBLE per double" );
scanf("%d" ,&operativeChoice) ;

if(operativeChoice == 0)
{moltiplicationInt(&intResult);
} else{if(operativeChoice == 1)
{moltiplicationDouble(&doubleResult);
} else{printf("Comando non riconosciuto" );
} 
} 
} else{if(choice == 3)
{printf("Vuoi lavorare con interi o double? INTERI per interi DOUBLE per double" );
scanf("%d" ,&operativeChoice) ;

if(operativeChoice == 0)
{divisionInt(&intResult);
} else{if(operativeChoice == 1)
{divisionDouble(&doubleResult);
} else{printf("Comando non riconosciuto" );
} 
} 
} else{if(choice == -1)
{printf("finito" );
} 
} 
} 
} 
} 

}
return 0;}
