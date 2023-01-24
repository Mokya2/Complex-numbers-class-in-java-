public class Complex{
    /**
     *{@value}<i>i</i> equals the value of √-1
     */
    final static Complex I=new Complex(0,1);
    private double real;
    private double imag;
    /**
     * @return the real part of the complex number
     */
    public double Re(){
        return real;
    }

    /**
     * @return the imaginary part of the complex number
     */
    public double Im(){
        return imag;
    }
    Complex(double r,double i){
        real=r;
        imag=i;
    }
    Complex(){}
    Complex(Complex z){
        this.real=z.real;
        this.imag=z.imag;
    }
    public String toString(){
        String val="";
        val+=(this.real!=0? this.real:"");
        val+=((imag>=0 && this.real!=0) || (this.imag!=this.imag)? "+":"");
        if(this.imag==1)
            val+="i";
        else if(this.imag==-1)
            val+="-i";
        else val+=this.imag+"i";
        return val;
    }
    /**
     * @param 
     * @return the square root of the given Complex number
     */
    public static Complex sqrt(Complex z){
        if(z.imag==0){
            if(z.real>=0){
                return new Complex(Math.sqrt(z.real),0);
            }
            return new Complex(0,Math.sqrt(-z.real));
        }
        return new Complex(Math.sqrt((mod(z)+z.real)/2),(z.imag/Math.abs(z.imag))*Math.sqrt((mod(z)-z.real)/2));
    }

    /**
     * @param z Complex number
     * @return the distance of the point on the argand plane representing the Complex number z from the origin
     */
    public static double mod(Complex z){
        return Math.sqrt(z.real*z.real+z.imag*z.imag);
    }
    /**
     * 
     * @param z Complex number
     * @return conjugate of given Complex number z
     */
    public static  Complex conjg(Complex z){
        return new Complex(z.real,-z.imag);
    }
    public Complex add(Complex z){
        return new Complex(this.real+z.real,this.imag+z.imag);
    }
    public static Complex add(Complex z,Complex z2){
        return new Complex(z.real+z2.real,z.imag+z2.imag);
    }
    public Complex multiply(Complex z){
        return new Complex((this.real*z.real)-(this.imag*z.imag),(this.real*z.imag)+(this.imag*z.real));
    }
    public static Complex multiply(Complex z,Complex z2){
        return new Complex((z2.real*z.real)-(z2.imag*z.imag),(z2.real*z.imag)+(z2.imag*z.real));
    }
    public Complex div(Complex z) {
        return new Complex((this.real*z.real+this.imag*z.imag)/(z.real*z.real+z.imag*z.imag),(this.imag*z.real-this.real*z.imag)/(z.real*z.real+z.imag*z.imag));
    }
    public static Complex div(Complex z2,Complex z) {
        return new Complex((z2.real*z.real+z2.imag*z.imag)/(z.real*z.real+z.imag*z.imag),(z2.imag*z.real-z2.real*z.imag)/(z.real*z.real+z.imag*z.imag));
    }
    public Complex subtract(Complex z){
        return new Complex(this.real-z.real,this.imag-z.imag);
    }
    public static Complex subtract(Complex z ,Complex z2){
        return new Complex(z.real-z2.real,z.imag-z2.imag);
    }
    /**
     * @return the real part of the complex number
     */
    public static double Re(Complex z) {
        return z.real;
    }
    /**
     * @return the imaginary part of the complex number
     */
    public static double Im(Complex z) {
        return z.imag;
    }
    public boolean isEqual(Complex z) {
        return (this.real==z.real && this.imag==z.imag);
    }
    /**
     * @param z
     * @return Returns Euler's number <i>e</i> raised to the power of a Complex value
     */
    public static Complex exp(Complex z) {
        return new Complex(Math.exp(z.real)*Math.cos(z.imag),Math.exp(z.real)*Math.sin(z.imag));
    }
    public static Complex neg(Complex z) {
        return new Complex(-z.real,-z.imag);
    }
    /**
     * @param z
     * @return  the squared magnitude of complex number
     */
    public static Double norm(Complex z) {
        return Math.round( ((Math.sqrt(z.real*z.real+z.imag*z.imag)*Math.sqrt(z.real*z.real+z.imag*z.imag)))*1000000)/1000000.0;
    }
    /**
     * @param z
     * @return the phase angle of z
     */
    public static double arg(Complex z) {
        return  Math.atan2(z.imag, z.real);
    }
    // public static Complex pow(Complex z,double base) {
    //     Complex ans=exp(Complex.I.multiply(new Complex(base,0).multiply(new Complex(arg(z),0))));
    //     double r=Math.pow(mod(z), base);
    //     return new Complex(ans.real*r,ans.imag*r);
    // }
    public static Complex log(Complex z) {
        return new Complex(Math.log(mod(z)),arg(z));
    }
    public static Complex log10(Complex z) {
        Complex ans=log(z).div(log(new Complex(10,0)));
        return new Complex(ans.real, ans.imag);
    }
}