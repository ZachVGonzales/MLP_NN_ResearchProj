import java.util.ArrayList;

public class Network {

    int testDay = 0;

    static double[][] weightsInH1 = new double[10][18];
    static double[][] weightsH1H2 = new double[5][10];
    static double[][] weightsH2Out = new double[2][5];
    static double[][][] allWeights = new double[10][18][3];
    static double[] bias1 = new double[10];
    static double[] bias2 = new double[5];
    static double[] biasOut = new double[2];
    ArrayList<Neuron> inputLayer = new ArrayList<Neuron>(18);
    ArrayList<Neuron> hiddenLayer1 = new ArrayList<Neuron>(10);
    ArrayList<Neuron> hiddenLayer2 = new ArrayList<Neuron>(5);
    ArrayList<Neuron> outputLayer = new ArrayList<Neuron>(2);

    static double[] inputs = new double[18];
    double adjHI = Calc.getHI(testDay);
    double adjLO = Calc.getLO(testDay);
    double adjCL = Calc.getCL(testDay);
    double adjOP = Calc.getOP(testDay);
    double adjAD = Calc.getAD(testDay);
    double adjVO = Calc.getVO(testDay);
    double adjSENT = Calc.getAvgSent(testDay);
    static double[] expectedResult = new double[2];
    static double cost = 0;
    static double[] adjHeldOutput = new double[2];
    static double[] adjHeldL2 = new double[5];
    static double[] adjHeldL1 = new double[10];
    static double[][] changeWeightL2Out = new double[2][5];
    static double[][] changeWeightL1L2 = new double[5][10];
    static double[][] changeWeightInL1 = new double[10][18];
    static double[] gradientDecentWeight = new double[] {};
    static double[] changeBiasOut = new double[2];
    static double[] changeBiasL2 = new double[5];
    static double[] changeBiasL1 = new double[10];
    static double[] gradientDecentBias = new double[] {};
    double[] allWeightBiasVal = new double[257];
    double[] outputs = new double[2];

    //creates space in all arrayLists
    public void initLists() {
        for(int i = 0; i < 18; i++) {
            inputLayer.add(null);
        }
        for(int i = 0; i < 10; i++) {
            hiddenLayer1.add(null);
        }
        for(int i = 0; i < 5; i++) {
            hiddenLayer2.add(null);
        }
        for(int i = 0; i < 2; i++) {
            outputLayer.add(null);
        }
    }

    //creates a new network to analyze data on day n with all random weights and Bias's of 1
    public Network(int n) {
        testDay = n;
        initLists();
        setInputValues();
        setInputLayer();
        setNeuronList();
        setWeightsRand();
        setBias1();
        setExpectedResult();
    }

    //creates a new network for day n with adjusted weights and Bias's
    public Network(int n, double[] adjValues) {
        if(adjValues.length == 0) {
            testDay = n - 1;
            initLists();
            setInputValues();
            setInputLayer();
            setNeuronList();
            setWeightsRand();
            setBias1();
            setExpectedResult();
        }
        else{
            testDay = n - 1;
            initLists();
            setInputValues();
            setInputLayer();
            setNeuronList();
            setExpectedResult();
            setWeightBias(adjValues);
        }
    }

    public int getDay() {
        return testDay;
    }

    //prints the output given compared to the expected output
    public void printOutVsExpect() {
        System.out.println("given outputs are: output 1 = " + outputLayer.get(0).numHeld + ", output 2 = " + outputLayer.get(1).numHeld);
        System.out.println("expected outputs are: output 1 = " + expectedResult[0] + ", output 2 = " + expectedResult[1]);
    }

    //sets stored bias's
    public void setBias() {

    }

    //sets allWeightBiasVal to values stored
    public void setAllWeightBiasVal() {
        int count = 0;

        for(int i = 0; i < weightsInH1.length; i++) {
            for(int j = 0; j < weightsInH1[i].length; j++) {
                allWeightBiasVal[count] = weightsInH1[i][j];
                count++;
            }
        }
        for(int i = 0; i < weightsH1H2.length; i++) {
            for(int j = 0; j < weightsH1H2[i].length; j++) {
                allWeightBiasVal[count] = weightsH1H2[i][j];
                count++;
            }
        }
        for(int i = 0; i < weightsH2Out.length; i++) {
            for(int j = 0; j < weightsH2Out[i].length; j++) {
                allWeightBiasVal[count] = weightsH2Out[i][j];
                count++;
            }
        }

        for(int i = 0; i < hiddenLayer1.size(); i++) {
            allWeightBiasVal[count] = hiddenLayer1.get(i).bias;
            count++;
        }
        for(int i = 0; i < hiddenLayer2.size(); i++) {
            allWeightBiasVal[count] = hiddenLayer2.get(i).bias;
            count++;
        }
        for(int i = 0; i < outputLayer.size(); i++) {
            allWeightBiasVal[count] = outputLayer.get(i).bias;
            count++;
        }
    }

    //sets changes allWeightBiasVal by input array and return new values
    public double[] changeAllWeightBiasVal(double[] change) {
        for(int i = 0; i < change.length; i++) {
            allWeightBiasVal[i] += change[i];
        }
        return allWeightBiasVal;
    }

    //sets weights and Bias's to the new values given by the gradient decent function
    public void setWeightBias(double[] newValues) {
        int count = 0;

        for(int i = 0; i < weightsInH1.length; i++) {
            for(int j = 0; j < weightsInH1[i].length; j++) {
                weightsInH1[i][j] = newValues[count];
                count++;
            }
        }
        for(int i = 0; i < weightsH1H2.length; i++) {
            for(int j = 0; j < weightsH1H2[i].length; j++) {
                weightsH1H2[i][j] = newValues[count];
                count++;
            }
        }
        for(int i = 0; i < weightsH2Out.length; i++) {
            for(int j = 0; j < weightsH2Out[i].length; j++) {
                weightsH2Out[i][j] = newValues[count];
                count++;
            }
        }

        for(int i = 0; i < hiddenLayer1.size(); i++) {
            hiddenLayer1.get(i).bias = newValues[count];
            count++;
        }
        for(int i = 0; i < hiddenLayer2.size(); i++) {
            hiddenLayer2.get(i).bias = newValues[count];
            count++;
        }
        for(int i = 0; i < outputLayer.size(); i++) {
            outputLayer.get(i).bias = newValues[count];
            count++;
        }
    }

    //prints the all Weights and Bias's
    public void printWeightBias() {
		/*System.out.println("the weights connecting input to layer 1 are: ");
		for(int i = 0; i < weightsInH1.length; i++) {
			System.out.println("weights going to hidden Layer 1 neuron " + i + "are: ");
			for(int j = 0; j < weightsInH1[i].length; j++) {
				System.out.print(weightsInH1[i][j] + ", ");
			}
		}
		System.out.println("the weights connecting Layer 1 to layer 2 are: ");
		for(int i = 0; i < weightsH1H2.length; i++) {
			System.out.println("weights going to hidden Layer 2 neuron " + i + "are: ");
			for(int j = 0; j < weightsH1H2[i].length; j++) {
				System.out.print(weightsH1H2[i][j] + ", ");
			}
		}
		System.out.println("the weights connecting Layer 2 to output are: ");
		for(int i = 0; i < weightsH2Out.length; i++) {
			System.out.println("weights going to output Layer neuron " + i + "are: ");
			for(int j = 0; j < weightsH2Out[i].length; j++) {
				System.out.print(weightsH2Out[i][j] + ", ");
			}
		}
		System.out.println();

		System.out.println("the bias's held by layer 1 are: ");
		for(int i = 0; i < hiddenLayer1.size(); i++) {
			System.out.print(hiddenLayer1.get(i).bias + ", ");
		}
		System.out.println();
		System.out.println("the bias's held by layer 2 are: ");
		for(int i = 0; i < hiddenLayer2.size(); i++) {
			System.out.print(hiddenLayer2.get(i).bias + ", ");
		}
		System.out.println();
		System.out.println("the bias's held by the output layer are: ");
		for(int i = 0; i < outputLayer.size(); i++) {
			System.out.print(outputLayer.get(i).bias + ", ");
		}
		System.out.println();*/

        System.out.print("all weights and bias's in one single dimensional array: ");

        for(int i = 0; i < allWeightBiasVal.length; i++) {
            System.out.print(allWeightBiasVal[i] + ", ");
        }
        System.out.println();
    }

    //finds the gradient decent in terms of the the weights/biases and how much they need to change
    public double[] getGradDecent() {
        double[][][] allWeightChange = new double[3][10][18];
        double[][] allBiasChange = new double[3][10];
        double[] totalGradDecent = new double[257];

        double[][] weightCostRatL2Out = new double[2][5];
        double[][] weightCostRatL1L2 = new double[5][10];
        double[][] weightCostRatInL1 = new double[10][18];

        double[] biasCostRatOut = new double[2];
        double[] biasCostRatL2 = new double[5];
        double[] biasCostRatL1 = new double[10];

        double[] neuronCostRatL2 = new double[5];
        double[] neuronCostRatL1 = new double[10];

        for(int i = 0; i < outputLayer.size(); i++) {
            biasCostRatOut[i] = Calc.sigmoidDeriv(outputLayer.get(i).heldPrevSig) * 2*(outputLayer.get(i).numHeld - expectedResult[i]);
            //System.out.println(Calc.sigmoidDeriv(outputLayer.get(i).heldPrevSig) + " " + outputLayer.get(i).numHeld + " " + expectedResult[i]);
            //System.out.println(biasCostRatOut[i]);
        }
        //System.out.println("-----------------------");

        for(int i = 0; i < weightsH2Out.length; i++) {
            for(int j = 0; j < weightsH2Out[i].length; j++) {
                weightCostRatL2Out[i][j] = hiddenLayer2.get(j).numHeld * Calc.sigmoidDeriv(outputLayer.get(i).heldPrevSig) * 2*(outputLayer.get(i).numHeld - expectedResult[i]);
                //System.out.println(hiddenLayer2.get(j).numHeld + " " + outputLayer.get(i).heldPrevSig + " " + outputLayer.get(i).numHeld + " " + expectedResult[i]);
                //System.out.println(weightCostRatL2Out[i][j]);
            }
        }

        for(int i = 0; i < hiddenLayer2.size(); i++) {
            for(int j = 0; j < weightsH2Out.length; j++) {
                neuronCostRatL2[i] += weightsH2Out[j][i] * Calc.sigmoidDeriv(outputLayer.get(j).heldPrevSig) * 2*(outputLayer.get(j).numHeld - expectedResult[j]);
                //System.out.println(weightsH2Out[j][i] + " " + Calc.sigmoidDeriv(outputLayer.get(j).heldPrevSig) + " " + outputLayer.get(j).numHeld + " " + expectedResult[j]);
                //System.out.println(neuronCostRatL2[i]);
            }
        }
        for(int i = 0; i < hiddenLayer2.size(); i++) {
            biasCostRatL2[i] = Calc.sigmoidDeriv(hiddenLayer2.get(i).heldPrevSig) * neuronCostRatL2[i];
        }
        for(int i = 0; i < weightsH1H2.length; i++) {
            for(int j = 0; j < weightsH1H2[i].length; j++) {
                weightCostRatL1L2[i][j] = hiddenLayer1.get(j).numHeld * Calc.sigmoidDeriv(hiddenLayer2.get(i).heldPrevSig) * neuronCostRatL2[i];
            }
        }

        for(int i = 0; i < hiddenLayer1.size(); i++) {
            for(int j = 0; j < weightsH1H2.length; j++) {
                neuronCostRatL1[i] += weightsH1H2[j][i] * Calc.sigmoidDeriv(hiddenLayer2.get(j).heldPrevSig) * neuronCostRatL2[j];
            }
        }
        for(int i = 0; i < hiddenLayer1.size(); i++) {
            biasCostRatL1[i] += Calc.sigmoidDeriv(hiddenLayer1.get(i).heldPrevSig) * neuronCostRatL1[i];
        }
        for(int i = 0; i < weightsInH1.length; i++) {
            for(int j = 0; j < weightsInH1[i].length; j++) {
                weightCostRatInL1[i][j] = inputLayer.get(j).numHeld * Calc.sigmoidDeriv(hiddenLayer1.get(i).heldPrevSig) * neuronCostRatL1[i];
                //System.out.println(inputLayer.get(i).numHeld + " " + hiddenLayer1.get(i).heldPrevSig + " " + neuronCostRatL1[i]);
                //System.out.println(weightCostRatInL1[i][j]);
            }
        }

        allWeightChange[0] = weightCostRatInL1;
        allWeightChange[1] = weightCostRatL1L2;
        allWeightChange[2] = weightCostRatL2Out;

        allBiasChange[0] = biasCostRatL1;
        allBiasChange[1] = biasCostRatL2;
        allBiasChange[2] = biasCostRatOut;


        int count = 0;
        for(int k = 0; k < allWeightChange.length; k++) {
            for(int j = 0; j < allWeightChange[k].length; j++) {
                for(int i = 0; i < allWeightChange[k][j].length; i++) {
                    totalGradDecent[count] = allWeightChange[k][j][i];
                    count++;
                }
            }
        }

        int count1 = 0;
        for(int i = 0; i < allBiasChange.length; i++) {
            for(int j = 0; j < allBiasChange[i].length; j++) {
                totalGradDecent[count+count1] = allBiasChange[i][j];
                count1++;
            }
        }

		/* for(int i = 0; i < totalGradDecent.length; i++) {
			System.out.println(totalGradDecent[i] + " " +  i);
		}
		System.out.println("----------------------"); */
        return totalGradDecent;
    }

    //finds the needed adjustment for output values
    public static double[] adjNeededOut(double[] result) {
        double[] moveNeeded =new double[2];
        moveNeeded[0] = expectedResult[0] - result[0];
        moveNeeded[1] = expectedResult[1] - result[1];
        return moveNeeded;
    }

    //sets expected results for given day
    public void setExpectedResult() {
        if(Calc.getExpectedResult(testDay+1) == 0) {
            expectedResult[0] = 0;
            expectedResult[1] = 1;
        }
        else if(Calc.getExpectedResult(testDay+1) == 1) {
            expectedResult[0] = 1;
            expectedResult[1] = 0;
        }
        else
            System.out.println("unexpected input");
    }

    public double getExpectedResult(int n) {
        return expectedResult[n];
    }

    //sets the weights to random values
    public static void setWeightsRand() {
        for(int i = 0; i < weightsInH1.length; i++) {
            for(int j = 0; j < weightsInH1[0].length; j++) {
                weightsInH1[i][j] = ((Math.random()*2) - 1);
                //System.out.println(weightsInH1[i][j]);
            }
        }
        //System.out.println("1----------------------");
        for(int i = 0; i < weightsH1H2.length; i++) {
            for(int j = 0; j < weightsH1H2[0].length; j++) {
                weightsH1H2[i][j] = ((Math.random()*2) - 1);
                //System.out.println(weightsH1H2[i][j]);
            }
        }
        //System.out.println("2----------------------");
        for(int i = 0; i < weightsH2Out.length; i++) {
            for(int j = 0; j < weightsH2Out[0].length; j++) {
                weightsH2Out[i][j] = ((Math.random()*2) - 1);
                //System.out.println(weightsH2Out[i][j]);
            }
        }
        //System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
    }

    //initializes all biases to start at 1
    public void setBias1() {
        for(int i = 0; i < hiddenLayer1.size(); i++)
            hiddenLayer1.get(i).bias = 1;
        for(int i = 0; i < hiddenLayer2.size(); i++)
            hiddenLayer2.get(i).bias = 1;
        for(int i = 0; i < outputLayer.size(); i++)
            outputLayer.get(i).bias = 1;
    }

    //sets the 3d array to hold all the 2d arrays for the weights
    public static void setAllWeights() {
        allWeights[0] = weightsInH1;
        allWeights[1] = weightsH1H2;
        allWeights[2] = weightsH2Out;
    }

    //sets the weight value for a layer (0-2) to n
    public static void setWeight(int layer, int row, int col, double n) {
        if(layer == 0)
            weightsInH1[row][col] = n;
        else if(layer == 1)
            weightsH1H2[row][col] = n;
        else if(layer == 2)
            weightsH2Out[row][col] = n;
        else
            System.out.println("layer value must be from 1-3, input value was: " + layer);
    }

    //sets the input values in input array to those in Calc class(do this when values are changed)
    public void setInputValues() {
        inputs[0] = Calc.getHI(testDay);
        inputs[1] = Calc.getLO(testDay);
        inputs[2] = Calc.getOP(testDay);
        inputs[3] = Calc.getAD(testDay);
        inputs[4] = Calc.getVO(testDay);
        inputs[5] = Calc.getCL(testDay);
        inputs[6] = Calc.getAvgSent(testDay) * 10;
        inputs[7] = Calc.highest(10);
        inputs[8] = Calc.lowest(10);
        inputs[9] = Calc.accumulationDistribution(testDay);
        inputs[10] = Calc.movAvgConverDiver(testDay);
        inputs[11] = Calc.chaikinOcillator(testDay);
        inputs[12] = Calc.volumePriceTrend(testDay);
        inputs[13] = Calc.relativeStrengthIndex();
        inputs[14] = Calc.momentum(10);
        inputs[15] = Calc.priceROC(testDay);
        inputs[16] = Calc.volumeROC(testDay);
        inputs[17] = Calc.onBalanceVolume(testDay);

        for(int i = 0; i < inputs.length; i++) {
            while(Math.abs(inputs[i]) > 10)
                inputs[i] /= 10;
        }
		/*for(int i = 0; i < inputs.length; i++) {
			System.out.println(inputs[i]);
		}
		System.out.println(inputs.length);*/
    }

    //sets the held number in the input neurons to the input values
    public void setInputLayer() {
        Neuron IN1 = new Neuron(inputs[0], "I1");
        //System.out.println(IN1.numHeld + "---------------");
        Neuron IN2 = new Neuron(inputs[1], "I2");
        //System.out.println(IN1.numHeld + "---------------");
        Neuron IN3 = new Neuron(inputs[2], "I3");
        Neuron IN4 = new Neuron(inputs[3], "I4");
        Neuron IN5 = new Neuron(inputs[4], "I5");
        Neuron IN6 = new Neuron(inputs[5], "I6");
        Neuron IN7 = new Neuron(inputs[6], "I7");
        Neuron IN8 = new Neuron(inputs[7], "I8");
        Neuron IN9 = new Neuron(inputs[8], "I9");
        Neuron IN10 = new Neuron(inputs[9], "I10");
        Neuron IN11 = new Neuron(inputs[10], "I11");
        Neuron IN12 = new Neuron(inputs[11], "I12");
        Neuron IN13 = new Neuron(inputs[12], "I13");
        Neuron IN14 = new Neuron(inputs[13], "I14");
        Neuron IN15 = new Neuron(inputs[14], "I15");
        Neuron IN16 = new Neuron(inputs[15], "I16");
        Neuron IN17 = new Neuron(inputs[16], "I17");
        Neuron IN18 = new Neuron(inputs[17], "I18");

        inputLayer.set(0, IN1);
        inputLayer.set(1, IN2);
        inputLayer.set(2, IN3);
        inputLayer.set(3, IN4);
        inputLayer.set(4, IN5);
        inputLayer.set(5, IN6);
        inputLayer.set(6, IN7);
        inputLayer.set(7, IN8);
        inputLayer.set(8, IN9);
        inputLayer.set(9, IN10);
        inputLayer.set(10, IN11);
        inputLayer.set(11, IN12);
        inputLayer.set(12, IN13);
        inputLayer.set(13, IN14);
        inputLayer.set(14, IN15);
        inputLayer.set(15, IN16);
        inputLayer.set(16, IN17);
        inputLayer.set(17, IN18);
		/* for(int i = 0; i < inputLayer.size(); i++) {
			System.out.println(inputLayer.get(i).numHeld);
		}
		System.out.println(inputLayer.size());
		System.out.println(IN1.numHeld); */
    }

    //creates all neurons and put in the correct place in lists
    public void setNeuronList() {
        Neuron H1N1 = new Neuron();
        Neuron H1N2 = new Neuron();
        Neuron H1N3 = new Neuron();
        Neuron H1N4 = new Neuron();
        Neuron H1N5 = new Neuron();
        Neuron H1N6 = new Neuron();
        Neuron H1N7 = new Neuron();
        Neuron H1N8 = new Neuron();
        Neuron H1N9 = new Neuron();
        Neuron H1N10 = new Neuron();
        hiddenLayer1.set(0, H1N1);
        hiddenLayer1.set(1, H1N2);
        hiddenLayer1.set(2, H1N3);
        hiddenLayer1.set(3, H1N4);
        hiddenLayer1.set(4, H1N5);
        hiddenLayer1.set(5, H1N6);
        hiddenLayer1.set(6, H1N7);
        hiddenLayer1.set(7, H1N8);
        hiddenLayer1.set(8, H1N9);
        hiddenLayer1.set(9, H1N10);

        Neuron H2N1 = new Neuron();
        Neuron H2N2 = new Neuron();
        Neuron H2N3 = new Neuron();
        Neuron H2N4 = new Neuron();
        Neuron H2N5 = new Neuron();
        hiddenLayer2.set(0, H2N1);
        hiddenLayer2.set(1, H2N2);
        hiddenLayer2.set(2, H2N3);
        hiddenLayer2.set(3, H2N4);
        hiddenLayer2.set(4, H2N5);

        Neuron OutN1 = new Neuron();
        Neuron OutN2 = new Neuron();
        outputLayer.set(0, OutN1);
        outputLayer.set(1, OutN2);
    }

    //gets the number to input for a neuron depending on layer (l) and row of neuron in layer (r)
    public double getNeuronInput(int l, int r) {
        if(l == 0) {
            double sum = 0;
            double[] inputCalc = new double[18];
            for(int i = 0; i < inputLayer.size(); i++) {
                inputCalc[i] = inputLayer.get(i).numHeld * weightsInH1[r][i];
                //System.out.println(inputLayer.get(i).numHeld + " " + weightsInH1[r][i]);
                //System.out.println(inputCalc[i]);
            }
            for(int i = 0; i < inputCalc.length; i++) {
                sum += inputCalc[i];
            }
            return (sum + hiddenLayer1.get(r).bias);
        }
        else if(l == 1) {
            double sum = 0;
            double[] inputCalc = new double[10];
            for(int i = 0; i < hiddenLayer1.size(); i++) {
                inputCalc[i] = hiddenLayer1.get(i).numHeld * weightsH1H2[r][i];
            }
            for(int i = 0; i < inputCalc.length; i++) {
                sum += inputCalc[i];
            }
            return (sum + hiddenLayer2.get(r).bias);
        }
        else if(l == 2) {
            double sum = 0;
            double[] inputCalc = new double[5];
            for(int i = 0; i < hiddenLayer2.size(); i++) {
                inputCalc[i] = hiddenLayer2.get(i).numHeld * weightsH2Out[r][i];
            }
            for(int i = 0; i < inputCalc.length; i++) {
                sum += inputCalc[i];
            }
            return (sum + outputLayer.get(r).bias);
        }
        else {
            System.out.println("input l was out of bounds");
            return 0;
        }
    }

    //sets the expected result to either higher or lower (1 or 0)
    public static void setExpectedResult(int n) {
        if(n == 1) {
            double[] result = new double[] {1, 0};
            expectedResult = result;
        }
        else if(n == 0) {
            double[] result = new double[] {0, 1};
            expectedResult = result;
        }
        else {
            double[] result = new double[] {0, 0};
            expectedResult = result;
        }
    }


    //sets the cost based on training results
    public double getCost(double[] results) {
        double sum = 0;
        for(int i = 0; i < results.length; i++) {
            sum += Math.pow(results[i] - expectedResult[i], 2);
        }
        cost = sum;
        return sum;
    }

    //gets the accuracy using percent difference from cost
    public double getAccuracy() {
        return ((2 - cost) / 2) * 100;
    }

    //sets the test day to n
    public void setTestDay(int n) {
        testDay = n;
    }
}
