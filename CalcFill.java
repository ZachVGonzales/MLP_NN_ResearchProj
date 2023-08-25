public class CalcFill {
    public static void main(String[] args) {
        int[] expResult = new int[250];
        String expValues = "";

        for(int i = 0; i < Calc.CL.length; i++) {
            if(Calc.CL[i] > Calc.OP[i])
                expResult[i] = 1;
            else
                expResult[i] = 0;
        }

        for(int i = 0; i < expResult.length; i++) {
            expValues += expResult[i] + ", ";
        }

        System.out.println(expValues);
        System.out.println(expResult.length);

		/* double[] OBVList = new double[250];
		String OBVValues = "";
		OBVList[0] = 0;

		for(int i = 1; i < 250; i++ ) {
			OBVList[i] = Calc.onBalanceVolume(i);
			Calc.OBV[i] = OBVList[i];
		}

		for(int i = 0; i < OBVList.length; i++) {
			OBVValues += OBVList[i] + ", ";
		}

		System.out.println(OBVValues);
		System.out.println(OBVList.length); */




		/* double[] ACDList = new double[250];
		String ACDValues = "";
		ACDList[0] = 0;

		for(int i = 1; i < 250; i++ ) {
			ACDList[i] = Calc.accumulationDistribution(i);
			Calc.ACD[i] = ACDList[i];
		}

		for(int i = 0; i < ACDList.length; i++) {
			ACDValues += ACDList[i] + ", ";
		}

		System.out.println(ACDValues);
		System.out.println(ACDList.length); */




		/* double[] VPTList = new double[250];
		String VPTValues = "";
		VPTList[0] = 0;

		for(int i = 1; i < 250; i++ ) {
			VPTList[i] = Calc.volumePriceTrend(i);
			Calc.VPT[i] = VPTList[i];
		}

		for(int i = 0; i < VPTList.length; i++) {
			VPTValues += VPTList[i] + ", ";
		}

		System.out.println(VPTValues);
		System.out.println(VPTList.length);*/


		/*		double[] EMAList = new double[250];
		String EMAValues = "";
		EMAList[0] = 0;

		for(int i = 1; i < 250; i++) {
			EMAList[i] = Calc.exponentialMovingAvg(Calc.CL[i], 2, i);
			Calc.EMA[i] = EMAList[i];
		}

		for(int i = 0; i < EMAList.length; i++) {
			EMAValues += EMAList[i] + ", ";
		}

		System.out.println(EMAValues);
		System.out.println(EMAList.length);
		System.out.println("Test"); */
    }
}
