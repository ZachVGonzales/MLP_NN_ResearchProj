public class NetworkDriver {
    public static void main(String[] args) {
        double[] startVals = new double[] {-0.7577869081051305, -0.1074559046525112, -0.8803429196247143, -0.5092017697181476, -0.70163953594206, -0.21779363972416604, 0.31549659985040424, -0.8164598686726101, -0.9203928742084511, 0.2210819991507411, -0.4420475675488282, 0.3266524398778699, 0.17690243696407076, -0.6313648701081691, -0.48567840710819404, 0.5945650047705717, 0.5094545972159137, 0.5629870940849164, -0.9572204700916281, -0.10293718602792387, -0.2760811737256339, -0.6234343056015537, 0.7796207712297758, -0.313239140999192, 0.7003140277821537, 0.8161609520527698, 0.5969639460179665, 0.07070973163610061, -1.0691446676602592, 0.7059899781681015, 0.803047088704819, 1.0248405720743214, -0.21905156333282116, 0.1983523848890483, 0.5907359060684322, -0.18749637031984642, -0.08005420167555, 0.1617413458679636, -0.19973800996329885, -0.8029941521815505, -0.07364075278491947, -0.9222996230130409, 0.803893965488524, 0.191695336987196, 0.9857930532033194, -0.12956752196591423, -0.931097402697632, 0.5987390259970288, 0.2526636222968763, 0.689504882472656, 0.3186852287390893, -0.3278893925971904, -0.5329315323946402, 0.7127321436615538, 0.8861649476589398, -0.3433763578343768, -0.9605048540734199, 0.5600150680733215, 0.9433091924801045, 0.3898695496377393, 0.9574150603209065, 0.30909732951394503, 0.7524383190974787, 0.8271755480234831, -0.9187044342953238, 0.20096933733233951, -0.9016109108984958, 0.08436138509858421, 0.8754817093188567, 0.8003176762419614, 0.9604688116829863, 0.14684218342096017, -0.8217855510925848, -0.5591170298325873, -0.40052968786376003, -0.7853486306764271, -0.9868765313792941, -0.2013823855703796, -0.7283216323496393, 0.3580935207427769, 0.3258658459985522, -0.5418212149075669, -0.04098098878255607, -0.8580208808669609, 0.9013302097146485, 0.5510529166641861, -0.3129470130828299, -0.3150709855931227, 0.8037614243495846, 0.7005372932648333, 0.4063882910094856, -0.32144474400831713, 0.19148475209957636, -0.20336951607888687, 0.556205002040128, 0.9095750592330671, 0.5017691155030983, 0.4471420325457418, -0.9173806715766095, 0.9527610214283133, 0.6944093645515169, 0.35069255387183923, -0.10320409777876151, -0.13828034140384388, -0.5131728951749077, -0.7158554090419258, 0.5431106396685519, 0.9449560523411031, -0.671669989636052, -0.07932920262741255, 0.2220756242108546, 0.9776332649457325, 0.24123330764001602, 0.2553756669931047, 0.12712075864771308, 0.5896583908940116, -0.3832091290697209, 0.12718956455677105, -0.3107456843202709, 0.01411358680741917, -0.5130280733807473, 0.9026813893004357, -0.7893963774872546, 0.7903602128956866, 0.006941198208716904, 0.3110962830275152, 0.9320659981601658, 0.6516342030058464, 0.18062968738271773, -0.9155514386624002, -0.9663699105562997, 0.33808485878643924, -0.36912661171465155, -0.9183053376056712, -0.685828814741369, -0.04355255997731197, 0.2844647287149823, -0.4413638604980324, -0.9498276917616076, -0.10991329992267364, 0.7052347786332762, -0.9821564925187669, -0.9749149819362647, 0.5168222144535788, 0.2524608434568462, -0.5331205060414801, 0.3944112605734759, 0.25291203255089867, -0.6774491828397449, 0.8506620956755168, -0.23067888363351177, -0.7462959257659129, 0.8069692647803807, 0.6710287428199084, -0.349861498861735, 0.9248141699971258, 0.9728582533706592, -0.7667305044413245, -0.5888736178602967, -0.3565080794999046, -0.5321314770242652, -0.17420273012014964, 0.39088424240787734, 0.15175845395752852, 0.7164615636359039, -0.7551838107563594, 0.347998649627763, 0.23408228399678194, 0.9095128891738995, -0.8568642855910825, 0.22289059495011423, -0.44283274624324437, 0.77394642113473, -0.5257580937791885, -0.17092692816937294, -0.4347337880352527, 0.7314433443864471, 0.6540040995601527, 0.9401743283162165, -0.39192221679523387, -0.6665315744597955, -0.8786638128259544, -0.47833325337859534, -0.8143276675901422, 0.15338316989115147, 0.662488280657612, -0.3907310059822876, -0.08915464119733893, 0.23340534801008195, -0.12704208752079083, 0.8636629831532412, -0.47946921245203494, 0.5661906628138142, 0.12515136864859974, 0.8413537086701858, -0.256558388677544, -0.6089558896972075, -0.02728185116057369, 0.9807038796323063, -0.32097416525524597, 0.20401611526036853, 0.2740794864459487, 0.2792442257732133, 0.7526937769829386, -0.14864568148866952, -0.8399882779933654, 0.1393640623249036, -0.694094102123357, -0.3767674489217683, -0.9058558298218464, -0.061442000488254794, 0.805256606200543, 0.20857362857048775, -0.841838523642755, -0.6053838658945396, -0.19836837223469822, 0.4313346771093118, 0.2630064868616258, -0.3016269895142314, -0.8617674932053956, -0.3054637101599051, -0.04821153264447088, -0.16380439771111605, 0.07441220897902563, 0.44767855421150804, 0.29981483458325875, 0.12641861427959183, -0.31491058978080927, -0.4472416801536462, 0.8906732568685592, 0.6164733874276535, -0.3719521924750322, 0.7009346516059984, 0.6353584837607966, 0.46293365755111127, -0.9275318899877171, -1.1233601477924764, 0.21247811792567, 0.007625807576267613, 0.019041142080577535, 1.0000035087201187, 0.9852109508930692, 0.9993595531288764, 0.9996613251779167, 0.9999998354083076, 1.0000950519130647, 1.0011984637448472, 1.0020353596203606, 0.9960624824868408, 1.0024211531058362, 0.9926165533308657, 1.0185370059847005, 0.9423168019875185, 0.9547355018483665, 0.9768544350048557, 0.7374284900559224, 0.8689680918033106};
        int startDay = 1;
        Network network = new Network(1);
        double[][] allChanges = new double[10][257];
        double[][] allOutputs = new double[10][2];
        double[][] expectedOut = new double[10][2];
        double[] avgChange = new double[257];
        double[] allCost = new double[10];
        double[] allAccuracy = new double[10];
        double[] prevWeightBias = new double[257];
        double avgAccuracy = 0;
        double avgAbsAcy = 0;
        prevWeightBias[0] = 0;

        for(int n = 0; n < 10; n++) {
            int day = startDay + n;
            if(n == 0)
                prevWeightBias = startVals;
            Network networkTemp = new Network(day, prevWeightBias);
            //System.out.println(networkTemp.getDay());
            networkTemp.setInputValues();
            networkTemp.setInputLayer();
            networkTemp.setExpectedResult();
			/* for(int i = 0 ; i < network.inputLayer.size(); i++) {
				System.out.println(network.inputLayer.get(i).getNumHeld());
			} */

            //feed through the layers of the network
            for(int i = 0; i < networkTemp.hiddenLayer1.size(); i++) {
                networkTemp.hiddenLayer1.get(i).heldPrevSig = (networkTemp.getNeuronInput(0, i));
                //System.out.println(networkTemp.getNeuronInput(0, i));
                networkTemp.hiddenLayer1.get(i).numHeld = Calc.sigmoid(networkTemp.hiddenLayer1.get(i).heldPrevSig);
                //System.out.println(Calc.sigmoid(networkTemp.getNeuronInput(0, i)));
            }
            //System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            for(int i = 0; i < networkTemp.hiddenLayer2.size(); i++) {
                networkTemp.hiddenLayer2.get(i).heldPrevSig = (networkTemp.getNeuronInput(1, i));
                //System.out.println(network.hiddenLayer2.get(i).heldPrevSig);
                networkTemp.hiddenLayer2.get(i).numHeld = Calc.sigmoid(networkTemp.hiddenLayer2.get(i).heldPrevSig);
                //System.out.println(network.hiddenLayer2.get(i).numHeld);
            }
            //System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            for(int i = 0; i < networkTemp.outputLayer.size(); i++) {
                networkTemp.outputLayer.get(i).heldPrevSig = (networkTemp.getNeuronInput(2, i));
                //System.out.println(network.outputLayer.get(i).heldPrevSig);
                networkTemp.outputLayer.get(i).numHeld = Calc.sigmoid(networkTemp.outputLayer.get(i).heldPrevSig);
                //System.out.println(network.outputLayer.get(i).numHeld);
            }

            //gets the gradient decent for the current day n and stores this in the allChanges array
            allChanges[n] = networkTemp.getGradDecent();

            //gets the average accuracy for the current day and stores in allAccuracy array
            networkTemp.outputs[0] = networkTemp.outputLayer.get(0).numHeld;
            networkTemp.outputs[1] = networkTemp.outputLayer.get(1).numHeld;
            allCost[n] = networkTemp.getCost(networkTemp.outputs);
            allAccuracy[n] = networkTemp.getAccuracy();

            //gets the outputs given for the current day and stores in allOutputs array
            allOutputs[n][0] = networkTemp.outputLayer.get(0).numHeld;
            allOutputs[n][1] = networkTemp.outputLayer.get(1).numHeld;
            expectedOut[n][0] = networkTemp.getExpectedResult(0);
            expectedOut[n][1] = networkTemp.getExpectedResult(1);

            networkTemp.setAllWeightBiasVal();
            prevWeightBias = networkTemp.allWeightBiasVal;
        }

        network.setWeightBias(prevWeightBias);

        //finds the average gradient decent of all examples
        for(int i = 0; i < allChanges.length; i++) {
            for(int j = 0; j < allChanges[i].length; j++) {
                avgChange[j] += allChanges[i][j];
            }
        }
        for(int i = 0; i < avgChange.length; i++) {
            avgChange[i] /= 10;
            //System.out.println(avgChange[i]);
        }
        for(int i = 0; i < avgChange.length; i++) {
            avgChange[i] *= -1;
        }

        //finds the accuracy of all the trials combined
        for(int i = 0; i < allAccuracy.length; i++) {
            avgAccuracy += allAccuracy[i];
        }
        avgAccuracy /= 10;

        //finds the mean absolute error of the trial set
        double meanAbsError = 0;
        for(int i = 0; i < allCost.length; i++) {
            meanAbsError += allCost[i];
        }
        meanAbsError /= allCost.length;

        //prints out all the values of the weights and bias's before they are changed
        network.setAllWeightBiasVal();
        network.printWeightBias();

        //applies the changes to values of weights and bias's based on average gradient decent
        network.setAllWeightBiasVal();
        network.setWeightBias(network.changeAllWeightBiasVal(avgChange));

        //prints out all the values of the weights and bias's
        network.printWeightBias();

        //prints the cost of each trial
        String costs = "";
        for(int i = 0; i < allCost.length; i++) {
            costs += allCost[i] + ", ";
        }
        System.out.println("the individual cost of each trial: " + costs);

        //prints the accuracy's of each individual trial
        String acy = "";
        for(int i = 0; i < allAccuracy.length; i++) {
            acy += allAccuracy[i] + ", ";
        }
        System.out.println("the individual accuracy of each trial: " + acy);

        //prints weather the networks guess was correct or not
        String absAcy = "";
        for(int i = 0; i < allOutputs.length; i++) {
            double n1 = Math.abs(1 - allOutputs[i][0]);
            double n2 = Math.abs(1 - allOutputs[i][1]);
            //System.out.println(n1 + ", " + n2);
            if((expectedOut[i][0] == 1) && (n1 < n2)) {
                absAcy += 1 + ", ";
                avgAbsAcy++;
            }
            else if ((expectedOut[i][1] == 1) && (n2 < n1)) {
                absAcy += 1 + ", ";
                avgAbsAcy++;
            }
            else {
                absAcy += 0 + ", ";
            }
        }
        System.out.println("the absolute correctness of each trial: " + absAcy);

        //prints the accuracy of all trials int the set
        System.out.println("the accuracy of all trials related to the cost of the trial: " + avgAccuracy);

        //prints the absolute accuracy of all trials in the set
        System.out.println("the accuracy of all trials related to the absolute accuracy of each trial: " + avgAbsAcy);

        //prints the mean absolute error of the trials
        System.out.println("the mean abolute error of the trial set is: " + meanAbsError);

        //prints the outcome vs expected results for each trial
		/*for(int i = 0; i < 10; i++) {
			System.out.println("for trial " + i + ":");
			System.out.println("given outputs are: output1 = " + allOutputs[i][0] + ", output2 = " + allOutputs[i][1]);
			System.out.println("expected outputs are: output1 = " + expectedOut[i][0] + ", output2 = " + expectedOut[i][1]);
		}*/
    }
}
