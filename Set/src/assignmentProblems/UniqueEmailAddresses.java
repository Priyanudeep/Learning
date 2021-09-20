package assignmentProblems;

import java.util.HashSet;

public class UniqueEmailAddresses {

	private static int numUniqueEmails(String[] emails) {
		HashSet<String> uniqueEmailSet = new HashSet<String>();
		for (String email : emails) {
			String localName = email.split("@")[0];
			String domainName = email.split("@")[1];
			localName = localName.split("\\+")[0];
			localName = localName.replace(".", "");
			email = localName + "@" + domainName;
			uniqueEmailSet.add(email);
		}
		return uniqueEmailSet.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numUniqueEmails(args));
	}
}
