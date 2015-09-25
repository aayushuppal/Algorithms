package interQ;

import java.util.*;

/**
 * Created by hellsapphire on 9/23/2015.
 */
public class DataCenter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfDC = in.nextInt();

        Map<Integer, Integer> dataSetToCenterMap = new HashMap<Integer, Integer>();
        List<HashSet<Integer>> dataCenterToDataSetList = new ArrayList<HashSet<Integer>>(numOfDC + 1);
        for (int i = 0; i <= numOfDC; i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            dataCenterToDataSetList.add(i, set);
        }
        in.nextLine();
        for (int i = 1; i <= numOfDC; i++) {
            String temp = in.nextLine();
            String[] tempArr = temp.split(" ");

            for (int j = 0; j < tempArr.length; j++) {
                int dataSet = Integer.parseInt(tempArr[j]);
                if (!dataSetToCenterMap.containsKey(dataSet)) {
                    dataSetToCenterMap.put(dataSet, i);
                }
                dataCenterToDataSetList.get(i).add(dataSet);
            }
        }
        in.close();

        for (Integer dataSet : dataSetToCenterMap.keySet()){
            for (int i=1; i<=numOfDC; i++){
                if(!dataCenterToDataSetList.get(i).contains(dataSet)){
                    System.out.println(dataSet+" "+dataSetToCenterMap.get(dataSet)+" "+i);
                }
            }
        }
        System.out.println("done");
    }


}
