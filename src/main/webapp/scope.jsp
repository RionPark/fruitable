<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
pageContext.setAttribute("user", "아아아아");
%>

${user}
<c:if test="${empty user}">
user는 비었다.
</c:if>

<c:if test="${not empty user}">
user는 안 비었다.
</c:if>