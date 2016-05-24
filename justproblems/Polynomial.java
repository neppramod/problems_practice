class Polynomial
{
    static class Equation
    {
	int power;
	int constant;
	boolean negative;
    }
    
    static Equation derivativePolynomial(Equation equation)
    {
	Equation eq = new Equation();
	
	if (equation.power == 0) {
	    eq.power = 0;
	    eq.constant = 0;
	} else {
	    eq.power = equation.power - 1;
	    eq.constant = equation.power * equation.constant;
	}

	eq.negative = equation.negative;
	
	return eq;
    }

    static void print(Equation equation)
    {
	System.out.print((equation.negative ? " -" : "+") + equation.constant + (equation.power > 0 ? "X^" + equation.power + " " : " "));
    }

    public static void main(String[] args)
    {
	Polynomial.Equation[] eqs = new Polynomial.Equation[3];

	eqs[0] = new Polynomial.Equation();
	eqs[0].power = 3;
	eqs[0].constant = 6;

	eqs[1] = new Polynomial.Equation();
	eqs[1].power = 2;
	eqs[1].constant = 3;
	eqs[1].negative = true;

	eqs[2] = new Polynomial.Equation();
	eqs[2].power = 0;
	eqs[2].constant = 2;
	
	
	for (Equation e : eqs) {
	    Equation de = derivativePolynomial(e);
	    print(de);
	}
	
	System.out.println();
    }
}
