public class Rational{
  private int p;  // instance vars numerator
  private int q;  // instance vars denominator
  
  public Rational (){  // default constuctor
    p = 0;
    q = 1;
  }
  
  public Rational (int n, int d){   // overload constructor with inputs
    if (d == 0){
      System.out.println("denominator invalid");
    }
    p = n;
    q = d;
  }
  
  public String toString(){   // tostring that reurns your rational num
    String retstr = "" + p + "/" + q ;
    return retstr;
  }
  
  public double floatValue(){
    double f = p/q;
    return f;
  }

  public int getNum(){
    return p;
  }
  
  public int getDen(){
    return q;
  }
  
  public void multiply (Rational r){
    p = p * r.getNum();
    q = q * r.getDen();
  }
  
  public void divide (Rational r){
    p = p * r.getDen();
    q = q * r.getNum();
  }
  
  public void add (Rational r){
    int t = p;
    int b = q;
    p = (p * r.getDen()) + (r.getNum() * b); 
    q = (q * r.getDen()); 
  }
  
  public void subtract (Rational r){
    int t = p;
    int b = q;
    p = (p * r.getDen()) - (r.getNum() * b); 
    q = (q * r.getDen()); 
  }
  
  public static int max(int a, int b){
		int max = b;
		if (a > b) {
			max = a;
		}
		return max;
	}
  public int gcd (){
		int gcd = 1;
		if (q > p){
		  int t = q;
		  int b = p;
		}
		int t = p;
		int b = q;
		while ( gcd <= (max(t,b))){
			if((t % gcd == 0) && (b % gcd == 0)){
			gcd += 1;
			}
		}
		return gcd;
	}
	
	public void reduce (){
	  p = p/gcd();
	  q = q/gcd();
	}
	 
	public static int gcd (int n, int d){
		int gcd = 1;
		if (d > n){
		  int t = d;
		  int b = n;
		}
		int t = n;
		int b = d;
		while ( gcd <= (max(t,b))){
			if((t % gcd == 0) && (b % gcd == 0)){
			gcd += 1;
			}
		}
		return gcd;
	}
	 
	public int toCompare(Rational r){
	  if (floatValue() == r.floatValue()){
	    return 0;
	  }
	  if (floatValue() > r.floatValue()){
	    return 1;
	  }
	  return -1;
	}
	public static void main ( String [] args){
    Rational r = new Rational (2,3);
    Rational s = new Rational (4,5);
    System.out.println("r:" + r);
    System.out.println("s:" + s);
    r.multiply(s);
    System.out.println("r:" + r);
    r.divide(s);
    System.out.println("r:" + r);
    r.add(s);
    System.out.println("r:" + r);
    r.subtract(s);
    System.out.println("r:" + r);
    Rational t = new Rational (4,18);
    t.reduce();
    System.out.println("t:" + t);
  }
}
