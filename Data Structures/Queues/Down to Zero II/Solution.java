/**
 * @author Oleg Cherednik
 * @since 20.04.2018
 */
public class Solution {

    public static void main(String[] args) {
//        Set<Integer> aa = new TreeSet<>();
//        Iterator<Integer> aaa = aa.iterator();
//        Scanner scan = new Scanner(System.in);
//        int q = Integer.parseInt(scan.nextLine().trim());
//
//        for (int qItr = 0; qItr < q; qItr++) {
//            int n = Integer.parseInt(scan.nextLine().trim());
//            System.out.println(downToZero(n));
//        }
//
//        scan.close();

//        System.out.println(downToZero(18));
//        System.out.println(downToZero(966514));
        System.out.println(downToZero(812849));
    }

    private static final int[] nums = new int[1000001];

    static {
        for (int i = 0; i < nums.length; ++i)
            nums[i] = -1;

        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] == -1 ? nums[i - 1] + 1 : nums[i];
            nums[i] = Math.min(nums[i], nums[i - 1] + 1);

            for (int j = 1; j <= i && j * i < nums.length; j++) {
                if (nums[j * i] == -1 || (nums[i] + 1) < nums[j * i])
                    nums[j * i] = nums[i] + 1;
            }
        }
    }

    static int downToZero(int n) {
        return nums[n];
    }

}
