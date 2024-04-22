package fracciones;
/**
 * la clase fraccion guardara todos los metodos relaciondo con las funciones que pueden
 * hacer las fracciones 
 * 
 * @author josem.martin
 * 
 */

public class Fraccion {
	/**
	 * numerador de la fraccion
	 */
	private int num;
	/**
	 * denominador de la fraccion
	 */
	private int den;
	
	
	//Constructor por defecto
	/**
	 * es el contructor por defecto que genera valores neutros 
	 */
	
	public Fraccion() { //debe generar el valor neutro que es 0/1
		num=0;
		den=1;
		
	}
	
	//Constructor con par�metros
	/**
	 * aqui tenemos el constructor por parametros que recibiá
	 * @param num
	 * @param den
	 */
	public Fraccion (int num,int den) {
		//debo evitar crear fracciones con 0 en el divisor
		this.num=num;
		if(den==0)
			den=1;
		this.den=den;
		//devuelvo la fracci�n simplificada
		simplificar();
	}
	
	//getters y setters
	/**
	 * a continuacion vienen los set para comprobar los nummeros son correctos
	 * @param num
	 */
	
	public void setNum(int num) {
		this.num=num;
		
	}
	/**
	 * aqui encontramos el set con el numero ya correcto
	 * 
	 * @return num
	 */
	public int getNum() {
		return num;
		
	}
	/**
	 * ahora encontramos los mismos pero con los num del denominador
	 * 
	 * @param den
	 */
	public void setDen(int den) {
		this.den=den;
	}
	/**
	 * al igual que con los numeradores devuelve ya el denominador bien
	 * 
	 * @return den
	 */
	public int getDen() {
		return den;
	}
	
	 //C�lculo del m�ximo com�n divisor por el algoritmo de Euclides  
	/**
	 * calcula el mcd por el algoritmo de Euclides 
	 * 
	 * @return minimo
	 */
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
    
    //m�todo para simplificar fracciones
    /**
     * este metodo sirve para simplificar las fracciones 
     */
    public void simplificar() {
    	int n=mcd();
    	num=num/n;
    	den=den/n;
    }
    
    //M�todo toString
    /**
     * en este metodo imprimiremos ya la fraccion 
     * 
     * @return mensaje
     */
    public String toString() {
    	String mensaje = num+ "/"+den;
    	return mensaje;
    	
    }
    
    
    //Sumar fracciones
    /**
     * este metodo sirve para sumar fracciones 
     * 
     * @param f
     * @return aux
     */
    
    public Fraccion sumar(Fraccion f) {
    	Fraccion aux= new Fraccion();
    	aux.num=num*f.den+den*f.num;
    	aux.den=den*f.den;
    	aux.simplificar();
    	return aux;
    	
    }
    
    //Restar fracciones
    /**
     * este metodo sirve para restar fracciones
     * 
     * @param f
     * @return aux
     */
    
    public Fraccion restar(Fraccion f) {
    	Fraccion aux=new Fraccion();
    	aux.num=num*f.den-den*f.num;
    	aux.den=den*f.den;
    	aux.simplificar();
    	return aux;
    	
    	
    }
    
//Multiplicar fracciones
    /**
     * este metodo sirfe para multiplicar fracciones 
     * 
     * @param f
     * @return aux
     */
    public Fraccion multiplicar(Fraccion f) {
    	Fraccion aux=new Fraccion();
    	aux.num=num*f.num;
    	aux.den=den*f.den;
    	aux.simplificar();
    	return aux;
    	
    }
    
//Dividir fracciones
    /**
     * este metodo te realiza la division de las fracciones 
     * 
     * @param f
     * @return aux
     */
    
    public Fraccion dividir(Fraccion f) {
    	Fraccion aux=new Fraccion();
    	aux.num=num*f.den;
    	aux.den=den*f.num;
    	aux.simplificar();
    	return aux;
    	
    }
    

}
