package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Controller.AddBoardControl;
import com.yedam.Controller.AddFormControl;
import com.yedam.Controller.AddMemberControl;
import com.yedam.Controller.AjaxControl;
import com.yedam.Controller.ApiControl;
import com.yedam.Controller.BoardControl;
import com.yedam.Controller.BoardListControl;
import com.yedam.Controller.CalanderControl;
import com.yedam.Controller.CharFormControl;
import com.yedam.Controller.Control;
import com.yedam.Controller.CreateDate;
import com.yedam.Controller.DataControl;
import com.yedam.Controller.DataTableControl;
import com.yedam.Controller.DeleteBoardControl;
import com.yedam.Controller.DeleteDate;
import com.yedam.Controller.FullData;
import com.yedam.Controller.LogOutControl;
import com.yedam.Controller.LoginControl;
import com.yedam.Controller.MainControl;
import com.yedam.Controller.MapControl;
import com.yedam.Controller.MemberListControl;
import com.yedam.Controller.ModifyBoardControl;
import com.yedam.Controller.ModifyFormControl;
import com.yedam.Controller.RemoveMemberContorl;
import com.yedam.Controller.ReplyAddControl;
import com.yedam.Controller.ReplyCountControl;
import com.yedam.Controller.ReplyFormControl;
import com.yedam.Controller.ReplyRemoveControl;
import com.yedam.kakao.KakaoControl;
import com.yedam.kakao.KakaoForm;


/*
 * MVC 패턴에서의 Control역활.
 * url요청 -> 서블릿.
 * 
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet{
	// Map<String, Control> map; Map<String, 인터페이스명> map
	Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>(); // map 필드의 초기화.
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
//		map.put("url", "servlet"); // addStudent.do 요청이 들어오면 AddStudentServlet
		map.put("/main.do", new MainControl());
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
		map.put("/addForm.do",new AddFormControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
		map.put("/deleteControl.do", new DeleteBoardControl());
		
		//로그인
		map.put("/loginForm.do", new LoginControl());
		map.put("/login.do", new LoginControl());
		map.put("/logOut.do", new LogOutControl());
		
		//어드민 전용
		map.put("/memberList.do", new MemberListControl());
		map.put("/testAjax.do", new AjaxControl());
		map.put("/testData.do", new DataControl());
		map.put("/removeMember.do", new RemoveMemberContorl());
		map.put("/addMember.do", new AddMemberControl());
		
		//댓글관련
		map.put("/replyList.do", new ReplyFormControl());
		map.put("/addReply.do", new ReplyAddControl());
		map.put("/replyRemove.do", new ReplyRemoveControl());
		map.put("/totalReply.do", new ReplyCountControl());
		map.put("/chart.do", new CharFormControl());
		map.put("/datatable.do", new DataTableControl());
		
		
		//캘린더
		map.put("/full.do", new CalanderControl());
		map.put("/fullData.do", new FullData());
		map.put("/insertData.do", new CreateDate());
		map.put("/deleteCal.do", new DeleteDate());
		
		//학원에서 배우는 api
		map.put("/map.do", new MapControl());
		map.put("/api.do", new ApiControl());
		
		//카카오
		map.put("/kakaoForm.do", new KakaoForm());
		map.put("/kakaoControl.do", new KakaoControl());
		
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  http://localhost:8080/BoardWeb/addStudent.do = url
		//  /BoardWeb/addStudent.do => uri
		String uri = req.getRequestURI(); // "/BoardWeb/addStudent.do"
		String context = req.getContextPath(); // "/BoardWeb"
		// substring= 정해진 문자열에서부터 자름. uri - context = page (.do)나옴 
		String page = uri.substring(context.length());
		
		System.out.println(page);
		// page에는 /주소.do가 반환됨.
		// map컬렉션에서 key를 입력하면 val반환.
		Control control = map.get(page);
		control.exec(req, resp);
	}
}
