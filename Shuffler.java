import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * shuffle and select
 * @author renqing
 *
 * May 18, 2021
 */
public class Shuffler {
	
	// loop ceiling
	private final Integer loopLimit = 3;
	
	// data source after shuffle
	private List<String> source = null;
	
	// index
	private Integer currentIndex = null;
	
	// current loop count
	private Integer loop = null;

	public Shuffler(List<String> source) {
		Collections.shuffle(source);
		this.source = source;
		this.currentIndex = 0;
		this.loop = 1;
	}
	
	// can be selected
	public Boolean hasNext() {
		if (loop > loopLimit) {
			return false;
		} else if (currentIndex >= source.size()) {
			if ((loop+1) > loopLimit) {
				return false;
			} else {
				return true;
			}
		} else {			
			return true;
		}
	}
	
	// select next one
	public String next() {
		if (loop > loopLimit) {
			return null;
		} else if (currentIndex >= source.size()) {
			currentIndex = 0;
			loop ++;
			if (loop > loopLimit) {
				return null;
			}
			return returnCurrent();
		} else {
			return returnCurrent();
		}
	}

	/**
	 * @return
	 */
	private String returnCurrent() {
		String result = this.source.get(this.currentIndex);
		currentIndex ++;
		return result;
	}
	
	
	public static void main(String[] asr) {
		int size = 10;
		List<String> list = new ArrayList<String>();
		for (int i=0; i<size ; i++) {
			list.add(String.valueOf(i));
		}
		
		for (String s : list) {
			System.out.println(s);
		}
		
		System.out.println("***************************");
		
		Shuffler sf = new Shuffler(list);
		while (sf.hasNext()) {
			System.out.println(sf.next());
		}
	}

}
