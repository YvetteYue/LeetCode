/**
 * 
 */
package Array.easy;

import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yvette
 *
 */
public class NO830PositionsofLargeGroups {

	public static void main(String[] args) {
		String s = "abbxxxxzzy";
		System.out.println(largeGroupPositions(s));
	}

	public static List<List<Integer>> largeGroupPositions(String S) {
		int len=S.length();
		List<List<Integer>> list=new ArrayList<>();
		
		int i=0;
		while(i<len){
			char a=S.charAt(i);
			int start=i;
			int k=0;
			while(i<len&&S.charAt(i)==a){
				i++;
				k++;
			}
			if(k>=3){
				List<Integer> data=new ArrayList<>();
				data.add(start);
				data.add(i-1);
				list.add(data);
			}
		}
		return list;
	}
}
