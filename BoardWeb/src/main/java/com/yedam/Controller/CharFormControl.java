package com.yedam.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.dao.ReplyDAO;
import com.yedam.mapper.ReplyMapper;

public class CharFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
//		ReplyDAO rdao = new ReplyDAO();
		List<Map<String,Object>> list = mapper.chartData();
	    System.out.println(list);
		Gson gson = new GsonBuilder().create();
	
		String json = gson.toJson(list);
		System.out.println(json);
		req.setAttribute("list",json);
		req.getRequestDispatcher("chart/chart.tiles").forward(req, resp);
		
	}

}
