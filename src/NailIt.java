import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class NailIt {

	static HashMap<Integer,Integer> woods=new HashMap();
	static ArrayList<Integer> lengths=new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readInput();
		Collections.sort(lengths);
		int maxFenceLength=0;
		int count=0;
		for (int h=lengths.get(0)*2;h<=lengths.get(lengths.size()-1)*2;h++) {
			int fenceLength=getFenceLength(h);
			if (fenceLength>maxFenceLength) {
				maxFenceLength=fenceLength;
				count=1;
			} else if (fenceLength==maxFenceLength) {
				count++;
			}
		}
		
		System.out.println(maxFenceLength+" "+count);
	}
	private static int getFenceLength(int h) {
		// TODO Auto-generated method stub
		int fenceLength=0;
		for (int i=0;i<lengths.size()-1;i++) {
			int length=lengths.get(i);
			if (length*2>h) {
				break;
			} else if (length*2==h) {
				if (woods.containsKey(length))
					fenceLength+=woods.get(length)/2;
			} else {
				if (woods.containsKey(length) && woods.containsKey(h-length)) {
					fenceLength+=Math.min(woods.get(length), woods.get(h-length));
				}
			}
		}
		return fenceLength;
	}

}
