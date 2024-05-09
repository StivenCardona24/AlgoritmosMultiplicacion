package DivideVenceras;

public class DV {

	public static int[] dv1(int arreglo1[],int arreglo2[],int n)
	{
		int x[],y[],z[],w[],s[],t[],u[],resultado1[],resultado2[],resultado3[],respuesta[],auxr[],auxs[],auxt[],auxu[], r[];


		if(n==2)  //Caso trivial, donde llamamos el algoritmo clasico
		{  
			respuesta = new int[n+1];
			respuesta = Alg(arreglo1,n,arreglo2,n);
			return respuesta;
		}
		else
		{
			x=new int[n/2];
			y=new int[n/2];
			z=new int[n/2];
			w=new int[n/2];

			for(int i=0; i<n/2; i++)
			{  
				w[i] = arreglo1[i];        //w[0]=1				     
				x[i] = arreglo1[i+(n/2)];  //x[0]=3	
				y[i] = arreglo2[i];        //y[0]=3
				z[i] = arreglo2[i+(n/2)];  //z[0]=2
			}
			r = new int [2*n];    
			auxr = new int [n];			       
			iniceros(r,2*n);	  
			auxr = dv1(w,y,n/2); 
			
			for(int i=0;i<n;i++)
			{
				r[i]=auxr[i];
			}		   

			s = new int[n+(n/2)];//s guarda la multiplicacion de los vectores "w" y "z"
			auxs = new int[n+(n/2)];
			iniceros(s,n+(n/2));//inicializamos s con ceros garantizando los ceros de
			auxs = dv1(w,z,n/2);  //la formula

			for(int i=0; i<n; i++)
			{
				s[i] = auxs[i];
			}

			t = new int[(n/2)+n]; //t guarda la multiplicacion de los vectores "x" y "y"
			auxt = new int[n];
			iniceros(t,(n/2)+n);
			auxt = dv1(x,y,n/2);

			for(int i=0; i<n; i++)
			{
				t[i] = auxt[i];
			}

			u = new int[n];//u guarda la multiplicacion de los vectores "x" y "z"
			iniceros(u,n);
			u = dv1(x,z,n/2);					  

			resultado1 = new int[2*n];
			iniceros(resultado1,2*n);
			resultado1 = suma(r,2*n,s,n+(n/2));//el vector res guarda la suma de "r" y "s"

			resultado2 = new int[(n/2)+n];
			iniceros(resultado2,(n/2)+n);
			resultado2 = suma(t,n+(n/2),u,n);//el vector res2 guarda la suma de "t" y "u"

			resultado3 = new int[2*n];
			iniceros(resultado3,2*n);
			resultado3 = suma(resultado1,2*n,resultado2,(n/2)+n);
			//el vector res3 guarda la suma de "res" y "res2"
			return resultado3;
		}
	}
	//Este es el algoritmo clasico de la multiplicacion		
	public static int[] Alg(int Num[],int tam1,int Num2[],int tam2){


		int  l=tam1+tam2-1,pos=tam1+tam2-1;;
		int res[]= new int[tam1+tam2];


		for(int y=0;y<=tam1+tam2-1;y++){
			res[y]=0;
		}


		//---------------------Algoritmo clasico de la multiplicacion---Inicio--------------------
		for( int  i=tam1-1;i>=0;i--){

			for( int  j=tam2-1;j>=0;j--){

				res[l]+=Num[i]*Num2[j];  //Multiplica cada posicion de los dos vectores
				if(res[l]>9){			   //teniendo en cuenta el orden.
					res[l-1]+=res[l]/10;
					res[l]=res[l]%10;
				}
				l--;
			}
			l=pos;
			pos--;
			l--;
		}
		//---------------------Algoritmo clasico de la multiplicacion--fin--------------------
		return res;

	}
	static void iniceros(int arre[],int tam)
	{

		for(int i=0; i<tam; i++)
		{
			arre[i]=0;
		}
	} 
	public static int[] suma(int vec1[],int n,int vec2[],int m ){
		int resu[];
		int k,p,r,s,i,j,l,aux,aux2,tam;

		if(n>m||n==m)
		{ aux=m;
		aux2=n;
		}
		else{ aux=n;
		aux2=m;
		}

		resu=new int[aux2];
		iniceros(resu,aux2);
		k=aux2-1;
		for(i=aux-1,l=aux2-1;i>=0;i--,l--)
		{ p=vec1[l]+vec2[i];
		if(p>9)
		{ r=p%10;
		s=p/10;
		resu[k]+=r;

		resu[k-1]+=s;
		}
		else{
			resu[k]+=p;
			if(resu[k]>9)
			{
				r=resu[k]%10;
				s=resu[k]/10;
				resu[k]=r;
				resu[k-1]+=s;
			}

		}
		k--;
		}
		if(n!=m)
			for(i=l;i>=0&&l>=0;i--,l--)
			{ 
				if(n>m) resu[i]+=vec1[l];
				else resu[i]+=vec2[l]; 
			}


		return resu;
	}			


}
