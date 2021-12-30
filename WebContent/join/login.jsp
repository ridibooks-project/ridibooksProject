<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 - 리디북스</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<div class="login_wrap">
        <form action="/ridibooksProject/member/controller" method="post">
            <div class="ip_box">
                <label class="ip_label" for="">
                    <input class="idpw_ip id_ip" name="login_id" type="text" maxlength="20" placeholder="아이디">
                </label>
                <label class="ip_label" for="">
                    <input class="idpw_ip pw_ip" name="login_pw" type="password" maxlength="25" placeholder="비밀번호">
                </label>
                <div class="ip_btn_box">
                    <div class="ch_wrap">
                        <input class="ch_ip" type="checkbox" name="stay_login">
                        <span>로그인 상태 유지</span>
                    </div>
                    <div class="findidpw_box">
                        <a class="fd_id" href="#">아이디 찾기</a>
                        <a class="fd_pw" href="#">비밀번호 재설정</a>
                    </div>
                </div>
            </div>
            <div class="msg_box">
                <span>! 아이디 또는 비밀번호를 확인해주세요.</span>
            </div>
            <div class="login_btn_box">
                <input class="login_btn btn_ap" type="submit" value="로그인">
            </div>
            <div class="join_btn_box">
                <input class="join_btn btn_ap" type="button" value="회원가입">
            </div>
        </form>
    </div>
    
    <!-- 검증코드 자바스크립트로? -->
</body>
</html>