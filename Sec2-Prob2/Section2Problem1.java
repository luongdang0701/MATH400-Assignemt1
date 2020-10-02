class Section2Problem1 {

    //For part A
    static String printFunction(int i) { // recursive function used
        if (i == 0) return "1"; // when it becomes 0 it returns 1
        if (i == 1) return "x"; // when it becomes 1, it returns x
        //T6(x)= 2x(2x(2xT3(x)-T2(x))-(2xT2(x)-T1(x)))-(2x(2xT2(x)-T1(x))-(2xT1(x)-T0(x)))
        return "(2x*"+printFunction(i-1)+"-"+printFunction(i-2)+")"; // if doesn't fall within if conditions
        // above, will return
    }
    //For part B
    static double func(int i, double x) { // recursive function used, does the same thing but with real values
        if (i == 0) return 1; // when it becomes 0, it will return 1
        if (i == 1) return x; // when it becomes 1, it will return x
        return 2 * x * func(i-1,x) - func(i-2,x); // if doesn't fall within if conditions above, will return
    }
    //For part B
    static double derivFunc(double x) { // derivative for newtons
        return 192 * Math.pow(x, 5) - 192 * Math.pow(x, 3) + 36 * x;
    }
    //For part B
    static void newton(double x, double TOL) { // newtons methods - preferred method to find root
        double c = func(6,x) / derivFunc(x);
        while (Math.abs(c) >= TOL) {
            c = func(6,x) / derivFunc(x);
            x = x - c;
        }
        System.out.println("A root of T_6(x) is: " + x); // prints out the root
    }

    public static void main(String[] args) {
        System.out.println("=========== PART A ==========="); // to print out format - for part A
        System.out.println("Function: " + printFunction(6)); // use of recurrence relation
        System.out.println("Simplified: 32x^6 - 48x^4 + 18x^2 -1\n"); //prints out simplified function at root 6

        // By ploting fuction, we find the roots near 1,-1,0.7,-0.7,0.3,-0.3 Initial
        // values assumed
        //For part B
        System.out.println("=========== PART B ==========="); // to print out format
        double TOL = Math.pow(10, -6); // defining what tol is
        // initial values needed for newtons
        newton(1, TOL); // prints value at 1
        newton(-1, TOL); // prints value at -1
        newton(0.7, TOL); // prints value at 0.7
        newton(-0.7, TOL); // prints value at -0.7
        newton(0.3, TOL); // prints value at 0.3
        newton(-0.3, TOL); // prints value at -0.3
        //above corresponds to given graph in slides and report
    }
}// for part b plots, found 6 roots and use newtons methods