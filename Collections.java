import java.util.*;

public class Collections {

    static String outgoing;
    static ArrayList<String> finalSet = new ArrayList<String>();

    static void combinationUtil(int arr[], int n, int r, int index, int data[], int i) {
        if (index == r) {
            outgoing += "{";
            for (int j = 0; j < r; j++) {
                if (j != r - 1) {
                    outgoing += data[j] + ",";
                } else {
                    outgoing += data[j];
                }
            }
            outgoing += "}";
            finalSet.add(outgoing);
            outgoing = "";
            return;
        }
        if (i >= n)
            return;
        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1, data, i + 1);
        combinationUtil(arr, n, r, index, data, i + 1);
    }

    static void printCombination(int arr[], int n, int r) {
        int data[] = new int[r];
        combinationUtil(arr, n, r, 0, data, 0);
    }

    public static void Finding_Subset(int[] arr1, int[] arr2) {
        for (int i = 0; i <= arr1.length; i++) {
            printCombination(arr1, arr1.length, i);
        }
        ArrayList<String> firstSubsets = new ArrayList<String>(finalSet);
        finalSet.removeAll(finalSet);
        for (int i = 0; i <= arr2.length; i++) {
            printCombination(arr2, arr2.length, i);
        }
        ArrayList<String> secondSubsets = new ArrayList<String>(finalSet);
        finalSet.removeAll(finalSet);

        firstSubsets.set(0, "{}");
        System.out.print("A -> ");
        for (int i = 0; i < firstSubsets.size(); i++) {
            System.out.print(firstSubsets.get(i));
            if (i != firstSubsets.size() - 1) {
                System.out.print(" , ");
            }
        }
        System.out.println();
        System.out.print("B -> ");
        for (int i = 0; i < secondSubsets.size(); i++) {
            System.out.print(secondSubsets.get(i));
            if (i != secondSubsets.size() - 1) {
                System.out.print(" , ");
            }
        }
        System.out.println();
    }

    public static Integer[] getUnion(int[] arr1, int[] arr2) {

        System.out.print("A⋃B:{");

        Set<Integer> SetsOfSum = new TreeSet<Integer>();
        for (Integer k : arr1) {
            SetsOfSum.add(k);
        }
        for (Integer h : arr2) {
            SetsOfSum.add(h);
        }

        Integer[] union = new Integer[SetsOfSum.size()];
        SetsOfSum.toArray(union);
        for (int i = 0; i < SetsOfSum.size(); i++) {
            System.out.print(union[i]);
            if (i != SetsOfSum.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
        return union;
    }

    public static void getIntersection(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    list.add(arr1[i]);
                }
            }
        }
        System.out.print("A⋂B:{");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    public static void subtraction(int[] arr1, int[] arr2) {
        ArrayList<Integer> AB = new ArrayList<Integer>();
        for (Integer i : arr1) {
            AB.add(i);
        }

        for (Integer i : arr2) {
            AB.remove(i);
        }

        System.out.print("A-B:{");
        Integer[] sub = new Integer[AB.size()];
        AB.toArray(sub);
        for (int i = 0; i < AB.size(); i++) {
            System.out.print(sub[i]);
            if (i != AB.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    static boolean ifContains(int a[], int m) {
        for (int i : a) {
            if (i == m) {
                return true;
            }
        }
        return false;
    }

    public static void delta(int[] arr1, int[] arr2) {
        Set<Integer> SetsOfSum = new TreeSet<Integer>();
        for (Integer k : arr1) {
            SetsOfSum.add(k);
        }
        for (Integer h : arr2) {
            SetsOfSum.add(h);
        }

        Integer[] sum = new Integer[SetsOfSum.size()];
        SetsOfSum.toArray(sum);

        ArrayList<Integer> intersection = new ArrayList<Integer>();
        for (Integer i : sum) {
            if (ifContains(arr1, i) && ifContains(arr2, i)) {
                intersection.add(i);
            }
        }

        for (Integer i : intersection) {
            SetsOfSum.remove(i);
        }
        System.out.print("A△B:{");
        Integer[] delta = new Integer[SetsOfSum.size()];
        SetsOfSum.toArray(delta);
        for (int i = 0; i < SetsOfSum.size(); i++) {
            System.out.print(delta[i]);
            if (i != SetsOfSum.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int[] elemnts = new int[size];
        for (int i = 0; i < elemnts.length; i++) {
            elemnts[i] = in.nextInt();
        }

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < elemnts.length; i++) {
            set.add(elemnts[i]);
        }

        int[] el = new int[set.size()];
        int k1 = 0;
        for (Integer i : set) {
            el[k1] = i;
            k1++;
        }

        int size2 = in.nextInt();
        int[] elemnts2 = new int[size2];
        for (int i = 0; i < elemnts2.length; i++) {
            elemnts2[i] = in.nextInt();
        }

        Set<Integer> set2 = new TreeSet<>();
        for (int i = 0; i < elemnts2.length; i++) {
            set2.add(elemnts2[i]);
        }

        int[] el2 = new int[set2.size()];
        int k2 = 0;
        for (Integer i : set2) {
            el2[k2] = i;
            k2++;
        }

        Finding_Subset(el, el2);
        getUnion(el, el2);
        getIntersection(el, el2);
        subtraction(el, el2);
        delta(el, el2);
    }

}