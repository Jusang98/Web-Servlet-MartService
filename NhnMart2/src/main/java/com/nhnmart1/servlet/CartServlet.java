package com.nhnmart1.servlet;

import com.nhnmart1.domain.Basket;
import com.nhnmart1.domain.Food;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CartServlet extends HttpServlet {
    Basket basket = new Basket();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        ServletContext servletContext = req.getServletContext();
        int finalPrice = (int) servletContext.getAttribute("finalPrice");

        out.println(basket.getBasket());
        out.println("총 가격은"+finalPrice+"원입니다");
        out.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        int finalPrice = 0;
        ServletContext servletContext = req.getServletContext();
        PrintWriter out = resp.getWriter();

        ArrayList<Food> foods = (ArrayList<Food>) servletContext.getAttribute("foods");
        String[] items = req.getParameterValues("items");

        for (int i =0;i<items.length;i++){
            for (int j = 0; j < foods.size(); j++) {
                if (foods.get(j).getName().equals(items[i])) {
                    basket.add(foods.get(j));
                    finalPrice += foods.get(j).getPrice();
                    foods.remove(j);
                    break;
                }
            }
        }

        servletContext.setAttribute("basket",basket);
        servletContext.setAttribute("foods", foods);
        servletContext.setAttribute("finalPrice",finalPrice);

        out.println("<br><a href='/cart'>장바구니보기</a>");

    }
}
// foods 가져오기
// req에서 내가 선택한 item들 string[]형태로 가져오기
//
// for문 1. 내 itemList의 길이만큼 처음부터 끝까지 검사
// foods를 for문으로 처음부터 끝까지 돌리면서 내가 선택한 item이 있는지 확인
// -> foods.getFood.get(i).getName() . equals (item)
// true -> foods 에서 해당하는 값 빼서 basket에 저장
// -> foods에서는 remove
// -> total가격 더해가기
// -> 이제 맞는걸 찾았으니까 다음으로 갈 필요가 없잖아 그니까 break로 2번째 포문(foods포문) 닫고 다음 item검사

// foods에 업데이트 된 foodStand 갱신시켜주고
// basket에는 내가 원하는 상품이 담겼으니까 basket을 결과창에 보내서 출력시켜주고
// totalPrice는 내가 결제할 금액이 있으니까 totalPrice도 넘겨주고

// 어디로 넘겨주는가? -> /cart (GET)