class Section1Problem1 {

    static double f(double x) {
        return (49.0/30.0)*Math.pow(Math.cos(x),2)*(1+Math.sin(x)-0.5*Math.cos(x))-1;
    }

    static void bisection(double a, double b, double TOL) {
        double x = a;
        while (!(Math.abs(b - a) < TOL)) {
            x = (a + b) / 2.0;
            if (f(x) * f(a) < 0) b = x;
            else a = x;
        }
        System.out.println("The value of A is : " + x);
    }

    public static void main(String[] args) {
        bisection(0, 2*Math.PI, Math.pow(10, -6));
    }
}