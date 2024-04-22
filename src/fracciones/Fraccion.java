package fracciones;

public class Fraccion {
	private int num;
	private int den;
	
	
	//Constructor por defecto
	
	public Fraccion() { //debe generar el valor neutro que es 0/1
		num=0;
		den=1;
		
	}
	
	//Constructor con parámetros
	public Fraccion (int num,int den) {
		//debo evitar crear fracciones con 0 en el divisor
		this.num=num;
		if(den==0)
			den=1;
		this.den=den;
		//devuelvo la fracción simplificada
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
	
	 //Cálculo del máximo común divisor por el algoritmo de Euclides                                               
    private int mcd() {
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
    
    //método para simplificar fracciones
    public void simplificar() {
    	int n=mcd();
    	num=num/n;
    	den=den/n;
    }
    
    //Método toString
    
    public String toString() {
    	String mensaje = num+ "/"+den;
    	return mensaje;
    	
    }
    
    
    //Sumar fracciones
    
    public Fraccion sumar(Fraccion f) {
    	Fraccion aux= new Fraccion();
    	aux.num=num*f.den+den*f.num;
    	aux.den=den*f.den;
    	aux.simplificar();
    	return aux;
    	
    }
    
    //Restar fracciones
    
    public Fraccion restar(Fraccion f) {
    	Fraccion aux=new Fraccion();
    	aux.num=num*f.den-den*f.num;
    	aux.den=den*f.den;
    	aux.simplificar();
    	return aux;
    	
    	
    }
    
//Multiplicar fracciones
    
    public Fraccion multiplicar(Fraccion f) {
    	Fraccion aux=new Fraccion();
    	aux.num=num*f.num;
    	aux.den=den*f.den;
    	aux.simplificar();
    	return aux;
    	
    }
    
//Dividir fracciones
    
    public Fraccion dividir(Fraccion f) {
    	Fraccion aux=new Fraccion();
    	aux.num=num*f.den;
    	aux.den=den*f.num;
    	aux.simplificar();
    	return aux;
    	
    }
    

}
