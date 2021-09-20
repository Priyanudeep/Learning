package practiceProblems;

public class FirstBadVersion {
	
	static int target;
	// function definition is handled by leetcode compiler and is not accessible
	private static boolean isBadVersion(int version) {
		return version == target;
	}

	//Runtime: 12 ms, faster than 98.16% of Java online submissions for First Bad Version.
	//Memory Usage: 35.5 MB, less than 81.66% of Java online submissions for First Bad Version.
	private static int solution1(int n) {
		if(n == 1)return n;
        int good = 1, bad = n, k;
        while(good <= bad){
            k  = good + ((bad - good) / 2);
            if(isBadVersion(k))
                bad = k - 1;
            else
                good = k + 1;
        }
        return good;
	}
	public static void main(String[] args) {
		target = 4;
		System.out.println(solution1(5));
	}

}
