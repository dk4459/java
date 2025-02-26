package com.yedam.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.ReplyDAO;

public class CharFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReplyDAO rdao = new ReplyDAO();
		List<Map<String,Object>> list = rdao.chartData();
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		req.setAttribute("list",json);
		req.getRequestDispatcher("chart/chart.tiles").forward(req, resp);
		
	}

}
