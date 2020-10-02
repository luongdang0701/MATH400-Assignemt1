class Section1Problem1 {

    static double f(double x) { // to be used for bisection method
        return (49.0/30.0)*Math.pow(Math.cos(x),2)*(1+Math.sin(x)-0.5*Math.cos(x))-1;
    }

    static void bisection(double a, double b, double TOL) { // bisection to find the value
        double x = a;
        while (!(Math.abs(b - a) < TOL)) { // for bisection to find a
            x = (a + b) / 2.0;
            if (f(x) * f(a) < 0) b = x;
            else a = x;
        }
        System.out.print("The value of A is : " + x); //prints out message
    }

    public static void main(String[] args) {
        bisection(0, 2*Math.PI, Math.pow(10, -6)); // calls bisection between 0 2pi with tolerance to 10 and -6
    }
}
