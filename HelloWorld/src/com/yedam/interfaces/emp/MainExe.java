package com.yedam.interfaces.emp;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.yedam.interfaces.Employee;

/*
 * 사원관리   App v.1
 * 실행클래스: MainExe
 * 인터페이스 활용.(배열, 컬렉션)
 * Employee, EmpAryExe,EmpListExe, EmpDAO(인터페이스)
 */
public class MainExe {

	// 스캐너, run,
	static EmpDAO dao = new EmpDBExe();
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		boolean run = true;

		// 배열, 컬렉션

		while (run) {
			System.out.println("1.등록 2.수정 3.삭제 4.조회 9.종료");
			int menu = 0;

			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("정확하게 값을 입력하세요");
				continue;
			}

			switch (menu) {
			case 1:
				int empNo = 0;
				while (true) {
					System.out.println("사원번호를 입력하세요");
					try {
						empNo = Integer.parseInt(scn.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("정상적인 값을 입력하세요");
						continue;
					}
					break;
				}

				System.out.println("이름을 입력하세요");
				String empName = scn.nextLine();
				System.out.println("전화번호를 입력하세요");
				String empTel = scn.nextLine();

				if (dao.registerEmp(new Employee(empNo, empName, empTel))) {
					System.out.println("등록이 완료되었습니다.");
				} else {
					System.out.println("등록이 실패하였습니다.");
				}
				;
				break;
			case 2:
				System.out.println("사원번호를 입력하세요");
				empNo = Integer.parseInt(scn.nextLine());
				System.out.println("전화번호를 입력하세요");
				empTel = scn.nextLine();
				System.out.println("입사일자 입력하세요");
				String hireDate = scn.nextLine();
				System.out.println("급여 입력하세요");
				String salString = scn.nextLine();
				if (salString.equals("")) {
					salString = "0";
				}
				int sal = Integer.parseInt(salString);
				if (hireDate.equals("")) {
					hireDate = "1900-01-01";
				}
				if (dao.modifyEmp(new Employee(empNo, "", empTel, hireDate, sal))) {
					System.out.println("수정완료");
				} else {
					System.out.println("수정실패");
				};
			
				break;
			case 3:
				while (true) {
					try {
						remove();
						break;
					} catch (NumberFormatException e) {
						System.out.println("사원번호를 올바르게 기입하세요");
					}
				}
				break;
			case 4:
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println("급여를 입력하세요");
				sal = Integer.parseInt(scn.nextLine());
				System.out.println("이름을 입력하세요");
				String eName = scn.nextLine();
				Employee empSal = new Employee();
				empSal.setSalary(sal);
				empSal.setEmpName(eName);
				List<Employee> emp = dao.search(empSal);
				for (Employee emps : emp) {
					System.out.println(
							"이름: " + emps.getEmpName() + " 사원번호: " + emps.getEmpNo() + " 전화번호: " + emps.getTelNo()
									+ " 입사일자: " + sdf.format(emps.getHireDate()) + " 급여: " + emps.getSalary());
				}
				break;
			case 9:
				System.out.println("종료하였습니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 확인하세요");
			}
		}
		System.out.println("end of prog");
	}// end of main.

	static void remove() throws NumberFormatException {

		System.out.println("사원번호를 입력하세요");
		int empNo = Integer.parseInt(scn.nextLine());
		if (dao.removeEmp(empNo)) {
			System.out.println("삭제완료");
		} else {
			System.out.println("찾는 사원번호가 없습니다.");
		}
		;
	}// end of remove
}// end of class.
