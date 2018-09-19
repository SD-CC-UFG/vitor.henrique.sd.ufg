#include "soma.h"

float *
adicao_100_svc(valores *argp, struct svc_req *rqstp)
{
	static float  result;
		
	printf("............................\n");		
	printf("Desenvolvido Por Vitor e Breno(o Breno Burro)\n");
	printf("............................\n");
	printf("          Servidor RPC      \n");	
	printf("............................\n");
	printf("O Cliente Solicita: \n");
	printf("Operacao de adicao para %.2f + %.2f\n",argp->valor1, argp->valor2);
	result = argp->valor1+argp->valor2;
	printf("Resultado = %.2f\n\n",result);


	return &result;
}
