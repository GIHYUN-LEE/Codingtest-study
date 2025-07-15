package view;

import java.util.ArrayList;

import model.domain.Employee;

//web 수업시간에 jsp로 개발 및 보기좋은 화면으로 구성 예정
public class SuccessView {

	public static void print(String successMsg, ArrayList<Employee> datas) {
		System.out.println(successMsg);
		System.out.println("사원번호\t사원명\t부서번호");
		
		for(Employee emp : datas) {
			System.out.println(emp);//emp.toString()
		}
	}

	public static void printMsg(String message) {

		System.out.println(message);
	}

}