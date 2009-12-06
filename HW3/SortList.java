import java.util.*;

class SortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] number_list;
		number_list = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			number_list[i] = Integer.parseInt(args[i]);
		}
		Arrays.sort(number_list);
		int[] sorted_list = new int[number_list.length];
		System.arraycopy(number_list, 0, sorted_list, 0, number_list.length);
		System.out.println(Arrays.toString(number_list));
		for (int j = 0; j < sorted_list.length; j++) {
			System.out.print(sorted_list[j]);
			System.out.println();
		}
	}
	
}
