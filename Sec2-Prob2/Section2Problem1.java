class Section2Problem1 {

    static String printFunction(int i) {
        if (i == 0) return "1";
        if (i == 1) return "x";
        return "(2x*" + printFunction(i - 1) + "-" + printFunction(i - 2) + ")";
    }

    static double func(int i, double x) {
        if (i == 0) return 1;
        if (i == 1) return x;
        return 2 * x * func(i - 1, x) - func(i - 2, x);
    }

    static double derivFunc(double x) {
        return 192 * Math.pow(x, 5) - 192 * Math.pow(x, 3) + 36 * x;
    }

    static void newton(double x, double TOL) {
        double c = func(6, x) / derivFunc(x);
        while (Math.abs(c) >= TOL) {
            c = func(6, x) / derivFunc(x);
            x = x - c;
        }
        System.out.println("A root of T_6(x) is: " + x);
    }

    public static void main(String[] args) {
        System.out.println("=========== PART A ===========");
        System.out.println("Function: " + printFunction(6));
        System.out.println("Simplified: 32x^6 - 48x^4 + 18x^2 -1\n");

        // By ploting fuction, we find the roots near 1,-1,0.7,-0.7,0.3,-0.3 Initial
        // values assumed
        System.out.println("=========== PART B ===========");
        double TOL = Math.pow(10, -6);
        newton(1, TOL);
        newton(-1, TOL);
        newton(0.7, TOL);
        newton(-0.7, TOL);
        newton(0.3, TOL);
        newton(-0.3, TOL);
    }
}