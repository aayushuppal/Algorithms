/*
 ============================================================================
 Name        : proj1.c
 Author      : hellsapphire
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>


int main()
{
	int inp;
    scanf("%d",&inp);
	int NUM = inp+1;
	signed long pow[NUM],val[NUM],x,num,ten;
	    int i,j,count;
	    for(num=NUM-1; num<NUM; num++)
	    {
	        for(i=0; i<NUM; pow[i++]=0);
	        count=0;
	        for(ten=1,x=1; x<NUM; x++)
	        {
	            val[x]=ten;

	            for(j=0; j<NUM; j++){
	            	if(pow[j]&&!pow[(j+ten)%num]&&pow[j]!=x)
	            		pow[(j+ten)%num]=x;
	            }
	            if(!pow[ten]){
	            	pow[ten]=x;
	            }
	            ten=(10*ten)%num;
	            if(pow[0]){
	            	break;
	            }
	        }

	        x=num;
	        //printf("%ld\tdivides\t",x=num);
	        printf(pow[0]+"--aa--\n");
	        if(pow[0])
	        {printf(x+"--bb--\n");
	            while(x)
	            {
	                while(--count>pow[x%num]-1)if(num==inp)printf("0");
	                count=pow[x%num]-1;
	                if(num==inp)printf("1");
	                x=(num+x-val[pow[x%num]])%num;
	            }
	            while(count-->0)if(num==inp)printf("0");
	        }

}

}



