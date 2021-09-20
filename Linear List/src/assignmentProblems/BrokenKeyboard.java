package assignmentProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class BrokenKeyboard {
	public static void main(String[] args) {
		var inputString = args[0];
		var home = '[';
		var end = ']';
		boolean addFirst = false;
		boolean addLast = false;
		int i = 0;
		var text_dll = new DListImpl();
		for (var s : inputString.toCharArray()) {
			//text_dll.display();
			if (s == home) {
				addFirst = true;
				addLast = false;
				i = 0;
				continue;
			} else if (s == end) {
				addLast = true;
				addFirst = false;
				continue;
			}
			if (addFirst) {
				if (i == 0)
					text_dll.addFirst(s);
				else
					text_dll.add(i, s);

				++i;
				continue;
			}
			if (addLast) {
				text_dll.addLast(s);
				continue;
			}
			text_dll.addLast(s);
		}

		System.out.println(inputString);
		text_dll.display();
//		StringBuilder outputString = new StringBuilder();
//		outputString.append(inputString);
//		System.out.println(inputString);
//		System.out.println(outputString);
//		for (var s : inputString.toCharArray()) {
//			System.out.print(s);
//		}
//		CharacterList imp = new CharacterListImpl();
		// imp.displayCharacterList();
		IList key = new DListImpl();
		for (int j = 0; j < 5; ++j) {
			key.addFirst(j + 1);
			key.display();
		}
		IList sList = new SListImpl();
		for (int j = 0; j < 5; ++j) {
			sList.addFirst(j + 1);
			sList.addLast(j + 6);
			//sList.display();
		}
		sList.add(5, 0);
		sList.display();
		sList.add(5, -10);
		sList.display();
		sList.remove(5);
		sList.display();
	}
}
