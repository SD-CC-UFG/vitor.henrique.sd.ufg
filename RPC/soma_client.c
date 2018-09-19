#include "soma.h"	

float adicao(CLIENT *clnt, float valor1, float valor2){
	valores numero;
	float *result;

	numero.valor1 = valor1;
	numero.valor2 = valor2;

	result = adicao_100(&numero,clnt);
	//vai referenciar da struct valores, e chamar o cliente.

	if(result==NULL) {
		fprintf(stderr,"Problema na chamada RPC\n");
		exit(0);
	}
	return *result;
 
}//fim da funcao soma.


float main(int argc, char *argv[]){
	CLIENT *clnt; //referencia cliente
	float valor1,valor2;
	
	printf("Informe o Valor1: ");
	scanf("%f",&valor1);

	printf("Informe o Valor2: ");
	scanf("%f",&valor2);


	//comunicacao cria o cliente, referencia o argv[1],nome do programa, versao
	clnt = clnt_create (argv[1], Soma, VERSAO, "udp");
	if (clnt == (CLIENT *)NULL) {
		clnt_pcreateerror (argv[1]);
		exit (0); //o programa termina se o cliente for null
	}

	printf("O Servidor Retornou como resultado: \n");
	printf("%.2f\n",adicao(clnt,valor1,valor2)); //funcao definida la emcima, puxou informacao
	
	return 0;
}
	


