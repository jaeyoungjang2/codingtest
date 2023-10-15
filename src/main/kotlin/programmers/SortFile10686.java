package programmers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SortFile10686 {
	public static void main(String[] args) {
//		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String[] answer = new String[files.length];
		int index = 0;
		HashMap<String, List<String>> map = new HashMap<>();



//		String fileName = "img12.png";

		// 정규표현식 패턴: "문자" + "숫자" + ".문자"
		Pattern pattern = Pattern.compile("(\\D+)(\\d+)(\\D+)");

		for (String file : files) {
			Matcher matcher = pattern.matcher(file);

			if (matcher.find()) {
				// 그룹 1: "문자" 부분
				// 그룹 2: "숫자" 부분
				// 그룹 3: ".문자" 부분
				String headPart = matcher.group(1);
				String numberPart = matcher.group(2);
				String extensionPart = matcher.group(3);

				map.putIfAbsent(headPart, new ArrayList<>());
				List<String> list = map.get(headPart);
				list.add(headPart);
			}


		}

		// 헤드 파트 정렬 완료
		List<String> collect = map.keySet().stream().sorted().collect(Collectors.toList());

		HashMap<String, List<String>> numbersMap = new HashMap<>();
		List<String> numbersList = new ArrayList<>();

		for (int i = 0; i < collect.size(); i++) {
			// 넘버 파트 정렬
			List<String> numbers = map.get(collect.get(i));
			if (numbers.size() == 1) {
				answer[index] = numbers.get(0);
				index ++;
				continue;
			}


			for (String number : numbers) {
				System.out.println("number = " + number);
				Matcher matcher = pattern.matcher(number);

				if (matcher.find()) {
					// 그룹 1: "문자" 부분
					// 그룹 2: "숫자" 부분
					// 그룹 3: ".문자" 부분
					String headPart = matcher.group(1);
					String numberPart = matcher.group(2);
					String extensionPart = matcher.group(3);

					numbersMap.putIfAbsent(headPart, new ArrayList<>());
					List<String> list = numbersMap.get(headPart);
					list.add(headPart);
				}
			}
		}

		// 넘버 파트 정렬 완료
		List<String> numbersCollect = numbersMap.keySet().stream().sorted().collect(Collectors.toList());
		HashMap<String, List<String>> tailMap = new HashMap<>();
		List<String> tailList = new ArrayList<>();

		for (int i = 0; i < numbersCollect.size(); i++) {
			// 넘버 파트 정렬
			List<String> tails = numbersMap.get(numbersCollect.get(i));
			if (tails.size() == 1) {
				System.out.println("tails = " + tails);
				answer[index] = tails.get(0);
				index ++;
				continue;
			}

			for (String tail : tails) {
				Matcher matcher = pattern.matcher(tail);

				if (matcher.find()) {
					// 그룹 1: "문자" 부분
					// 그룹 2: "숫자" 부분
					// 그룹 3: ".문자" 부분
					String headPart = matcher.group(1);
					String numberPart = matcher.group(2);
					String extensionPart = matcher.group(3);

					numbersMap.putIfAbsent(headPart, new ArrayList<>());
					List<String> list = numbersMap.get(headPart);
					list.add(headPart);
				}
			}
		}

		List<String> tailsCollect = tailMap.keySet().stream().sorted().collect(Collectors.toList());
		for (String s : tailsCollect) {
			List<String> strings = tailMap.get(s);
			for (String string : strings) {
				System.out.println("string = " + string);
				answer[index] = string;
				index++;
			}

		}

		for (String s : answer) {
			System.out.println("s = " + s);
		}
		// HEAD 순서대로 정렬
		// HEAD가 같으면  > NUMBER 순서대로 정렬


	}
}
