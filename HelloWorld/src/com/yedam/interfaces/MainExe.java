package com.yedam.interfaces;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/*
 * 사원관리   App v.1
 * 실행클래스: MainExe
 * 인터페이스 활용.(배열, 컬렉션)
 * Employee, EmpAryExe,EmpListExe, EmpDAO(인터페이스)
 */
public class MainExe {
	 public static void main(String[] args) {
		//스캐너, run,
		 Scanner scn = new Scanner(System.in);
		 boolean run = true;
		 
		 
		//배열, 컬렉션
		 EmpDAO dao = new EmpListExe();
		 
		
		 while(run) {
			 System.out.println("1.등록 2.수정 3.삭제 4.조회 9.종료");
			 int menu = Integer.parseInt(scn.nextLine());
			 switch(menu) {
			 	case 1:
			 		System.out.println("사원번호를 입력하세요");
			 		int empNo = Integer.parseInt(scn.nextLine());
			 		System.out.println("이름을 입력하세요");
			 		String empName = scn.nextLine();
			 		System.out.println("전화번호를 입력하세요");
			 		String empTel = scn.nextLine();
			 		
			 		if(dao.registerEmp(new Employee(empNo,empName,empTel))) {
			 			System.out.println("등록이 완료되었습니다.");
			 		}else{
			 			System.out.println("등록이 실패하였습니다.");
			 		};
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
			 		if(salString.equals("")) {
			 			salString="0";
			 		}
			 		int sal = Integer.parseInt(salString);
			 		if(hireDate.equals("")) {
			 			hireDate="1900-01-01";
			 		}
			 		if(dao.modifyEmp(new Employee(empNo,"",empTel,hireDate,sal))) {
			 			System.out.println("수정완료");
			 		};
			 		break;
			 	case 3:
			 		System.out.println("사원번호를 입력하세요");
			 		empNo = Integer.parseInt(scn.nextLine());
			 		if(dao.removeEmp(empNo)) {
			 			System.out.println("삭제완료");
			 		}else{
			 			System.out.println("찾는 사원번호가 없습니다.");
			 		};
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
			 		Employee[] emp = dao.search(empSal);
			 		for(int i = 0; i<emp.length; i++) {
			 			if(emp[i]!=null) {
			 			System.out.println("이름: " + emp[i].getEmpName() +
			 					           " 사원번호: "+ emp[i].getEmpNo()+
			 					           " 전화번호: "+ emp[i].getTelNo()+
			 					           " 입사일자: "+ sdf.format(emp[i].getHireDate())+
			 					           " 급여: "+emp[i].getSalary());
			 			}
			 		}
			 		break;
			 	case 9:
			 		System.out.println("종료하였습니다.");
			 		run=false;
			 		break;
			 	default:
			 		System.out.println("메뉴를 확인하세요");
			 }
		 }
		 System.out.println("end of prog");
	}// end of main.
}// end of class.
