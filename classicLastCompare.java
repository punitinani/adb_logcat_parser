import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author p_unit
 */
public class classicLastCompare {

    static Formatter forr;

    public static void main(String[] args) {

        try {

            File oriInput;  //input original

            File oriProcessing;  // original ProcessingFile

            Formatter filter; // filter out the comman from input on the basic of the processing file

            oriInput = new File("input.txt");
            Scanner scanFromInput = new Scanner(oriInput);

            oriProcessing = new File("processing.txt");
            Scanner scanFromProcessing = new Scanner(oriProcessing);
            Formatter ffil = new Formatter("scanedFilter.txt");
            int finder = 1;
            String store[] = new String[100];

            // Formatter fff = new Formatter("filter.txt");
            String getbysfp = ""; //getBy the scanFrom Processing sfp
            String getbysfi = "";//getBy the scanFrom Input (sfi)
            char[] seq;
            int occuringOfcomman = 0;//ooccuringOfcomman fields in the input file  by processing .txt
            int sets = 0;
            int line = 1;
            int flag = 0;
            int filterLines = 0;
            String temp1 = "";
            String temp2 = "";
            String create[] = new String[500];

            int indexLb = 0, indexRb = 0;
            //int oring[] = new int[100];

            int a, b, c;
            a = b = c = 0;
            String arguement = "";
            int index = 1;
            // int ccc = 0;

            int yii = 0;

            int flag2[] = new int[1000];

            int incflag2 = 0;
            int onceagain = 0;
            String tempclone = "";

            String create3[] = new String[1000];
            String crteat2[] = new String[1000];

            while (scanFromProcessing.hasNextLine()) {
                //filter.close();
                flag = 0;

                flag2[incflag2] = 0;
                getbysfp = "";
                getbysfi = "";
                getbysfp = scanFromProcessing.nextLine();
                occuringOfcomman = 0;
                temp1 = getbysfp;

                indexLb = 0;
                indexRb = 0;
                tempclone = getbysfp;

                while (scanFromInput.hasNextLine()) {

                    System.out.flush();
                    getbysfi = scanFromInput.nextLine();

                    if (getbysfi.contains(getbysfp)) {

                        occuringOfcomman++;
                        line++;
                        filterLines++;
                        flag = 1;
                        temp1 = "";

                        getbysfi = getbysfi.replaceAll(" ", "");

                        seq = getbysfi.toCharArray();

                        for (int i = 0; i < seq.length; i++) {

                            if (seq[i] == '(') {

                                indexLb = i;

                            } else if (seq[i] == ')') {

                                indexRb = i;
                            } else if (seq[i] == '|') {

                                flag2[incflag2] = i;

                                //System.out.println(incflag2);
                                //System.out.println(flag2[incflag2]);
                                //  System.out.println(getbysfi.charAt(flag2[incflag2]));
                                incflag2++;

                            }

                            System.out.flush();

                        }

                        /// System.out.println(incflag2);
                        // System.out.println("this is incflag 2" + incflag2);
                        //System.out.println("Arguement   " + temp1);
                        temp1 = getbysfi.substring(indexLb + 1, indexRb);

                        int clonep = 0;
                        int start = indexLb + 1;
                        int end = flag2[0];

                        // System.out.println("\n\n\n\n");
                        if (incflag2 > 0) {

                            // System.out.println("kjhfauhrzsu uzsygys"+getbysfi);
                            for (int p = 0; p <= incflag2; p++) {

                                if (p == incflag2) {

                                    end = flag2[p - 1];

                                    //  System.out.println("askdjfhkjasd" + end);
                                    //System.out.println(getbysfp + "    " + getbysfi.substring(end + 1, indexRb));
                                    create3[yii] = getbysfp + "\t\t\t" + getbysfi.substring(end + 1, indexRb);

                                    onceagain = yii;
                                    yii++;

                                } else {
                                    end = flag2[p] - 1;
//                                    System.out.println(start + " end" + end);

                                    // System.out.println(getbysfp + "    " + getbysfi.substring(start, end + 1));
                                    create3[yii] = getbysfp + "\t\t\t" + getbysfi.substring(start, end + 1);

                                    onceagain = yii;
                                    yii++;

                                    start = flag2[p] + 1;
                                    end = flag2[p + 1];

                                }

                            }
                            incflag2 = 0;
                        }

                        if (temp1.length() == 0) {

                            create3[yii] = tempclone + "\t\t\tWith Blank Arguements\t\t\t" + temp1;

                            onceagain = yii;

                            create[c] = temp1;
                            store[line] = getbysfp;

                            crteat2[c] = temp1;
                            c++;

                            System.out.flush();
                            yii++;

                        } else {

                            create3[yii] = tempclone + "\t\t\t" + temp1;

                            onceagain = yii;

                            create[c] = temp1;
                            store[line] = getbysfp;

                            crteat2[c] = temp1;
                            c++;

                            System.out.flush();
                            yii++;
                        }
                    }

                }

                if (flag == 1) {

                    //    System.out.println();
                    // System.out.println("Line number : " + finder + "  " + store[line]);
                    // ffil.format("%s \n", create3[yii]);
                    index++;
                }

                //  fff.format("%s: %d\n", getbysfi, line);
                System.out.flush();

                scanFromInput.close();

                scanFromInput = new Scanner(oriInput);
                a++;
                finder++;
            }

            ffil.close();

            int inccounter = 0;

            String[] cloneCreate3 = new String[100];

            for (int i = 0; i < 100; i++) {
                if ((create3[i] != null)) {
                    if (!create3[i].contains("|")) {
                        cloneCreate3[inccounter] = create3[i];
                        System.out.flush();
                        // System.out.println(create3[i]);
                        inccounter++;
                    } else {

                    }

                } else {
                    //  break;
                }

            }

            // System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            for (int i = 0; i < inccounter; i++) {

                //System.out.println(cloneCreate3[i]);
            }

            // System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            List<String> list = new ArrayList<String>();

            for (int i = 0; i < inccounter; i++) {

                list.add(cloneCreate3[i]);

            }

            for (int i = 0; i < inccounter; i++) {

                // System.out.println(list.get(i));
            }
            list.sort(null);
            String[] sorted = new String[inccounter];

            // System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            for (int i = 0; i < inccounter; i++) {

                sorted[i] = list.get(i);
                // System.out.println(list.get(i));

            }

            List<String> list1 = list;

            //  System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            for (int i = 0; i < inccounter; i++) {

                // System.out.println(list1.get(i));
                // System.out.println(Collections.frequency(list, list1.get(i)));
            }
            list.retainAll(list1);

            // System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            // System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            // System.out.println(Collections.frequency(list, list1.get(0)));
            // System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            forr = new Formatter("deep.txt");
            File unit = new File("deep.txt");
            unit = new File("deep.txt");
            forr.format(" Api Name\t\t\t\t\t  Arguement \t\t\t:->>>>>> : Frequency \n");

            forr.format("--------------------------------------------------------------------------\n");
            System.out.println("  Api Name\t\t\t\t\t  Arguement \t\t\t:->>>>>> : Frequency ");
            System.out.println("-------------------------------------------------------------------\n");

            String punit1 = "";
            int inc = 0;

            int counter = 1;

            int anotherCounter = 1;
            try {
                for (int apple = 0; apple <= list.size() - 1; apple++) {

                    flag = 0;
                    counter = 1;
                    punit1 = list.get(apple);

                    //while (punit1.equals(list.get(apple + 1))) {
                    for (int kk = apple + 1; kk < list.size(); kk++) {
                        if (punit1.equals(list.get(kk))) {
                            counter++;
                            apple++;
                        }
                    }

                    anotherCounter++;

                    System.out.flush();
                    forr.format("%s\t\t\t%d\n", punit1, counter);

                    //   System.out.println("inserted");
                    System.out.println(punit1 + "\t\t\t " + counter);

                }

                forr.format("-------------------------------------------------------------------------------\n");
                System.out.println();
                System.out.println("------------------------------------------------------------------------\n");
                forr.close();

            } catch (Exception e) {
                forr.close();
                Logger.getLogger(classicLastCompare.class.getName()).log(Level.SEVERE, null, e);

            }
        } catch (Exception ex) {

            // forr.close();
            Logger.getLogger(classicLastCompare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
