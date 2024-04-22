package examen;

public class Fraccion {
	private int num;
	private int den;
	
	
	//Constructor por defecto
	
	public Fraccion() { //debe generar el valor neutro que es 0/1
		num=0;
		den=1;
		
	}
	
	//Constructor con par�metros
	public Fraccion (int num,int den) {
		//debo evitar crear fracciones con 0 en el divisor
		this.num=num;
		if(den==0) {
			den=1;}
		this.den=den;
		//devuelvo la fracci�n simplificada
		simplificar();
	}
	
	//getters y setters
	
	public void setNum(int num) {
		this.num=num;
		
	}
	
	public int getNum() {
		return num;
		
	}
	
	public void setDen(int den) {
		this.den=den;
	}
	public int getDen() {
		return den;
	}
	
	 //C�lculo del m�ximo com�n divisor por el algoritmo de Euclides                                               
    private int maximoComunDivisor() {
        int maximo = Math.max(Math.abs(num), Math.abs(den));
        int minimo = Math.min(Math.abs(num), Math.abs(den));
        int resto = maximo % minimo;
        
        while(resto != 0) {
        	maximo = minimo;
        	minimo = resto;
        	resto = maximo % minimo;
        } 
        
        return minimo;
    }
    
    //m�todo para simplificar fracciones
    public void simplificar() {
    	int n=maximoComunDivisor();
    	num=num/n;
    	den=den/n;
    }
    
    //M�todo toString
    
    public String toString() {
    	return num+ "/"+den;
    	
    }
    
    
    //Sumar fracciones
    
    public Fraccion sumarFraccion(Fraccion fraccion) {
    	Fraccion aux= new Fraccion();
    	int cruce1 = num*fraccion.den;
		int cruce2 = den*fraccion.num;
		aux.num=cruce1+cruce2;
    	aux.den=den*fraccion.den;
    	aux.simplificar();
    	return aux;
    	
    }
    
    //Restar fracciones
    
    public Fraccion restar(Fraccion f) {
    	Fraccion aux=new Fraccion();
    	int cruce1 = num*f.den;
		int cruce2 = den*f.num;
		aux.num=cruce1-cruce2;
    	aux.den=den*f.den;
    	aux.simplificar();
    	return aux;
    	
    	
    }
    
//Multiplicar fracciones
    
    public Fraccion multiplicarFraccion(Fraccion f) {
    	Fraccion aux=new Fraccion();
    	aux.num=num*f.num;
    	aux.den=den*f.den;
    	aux.simplificar();
    	return aux;
    	
    }
    
//Dividir fracciones
    
    public Fraccion dividirFraccion(Fraccion fraccion) {
    	Fraccion aux=new Fraccion();
    	aux.num=num*fraccion.den;
    	aux.den=den*fraccion.num;
    	aux.simplificar();
    	return aux;
    	
    }
    

}
