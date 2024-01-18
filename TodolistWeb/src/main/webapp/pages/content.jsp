<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*" %>


<%-- Condition pour déterminer le contenu spécifique à inclure --%>
<%
String pg = request.getParameter("pg");
String type = request.getParameter("type");

if (pg != null) {
    switch (pg) {
        case "list":
            if ("task".equals(type)) {
                %><%@ include file="/task/list.jsp"%><%
            } else if ("todo".equals(type)) {
                %><%@ include file="/todo/list.jsp"%><%
            }
            break;
        case "edit":
            if ("task".equals(type)) {
                %><%@ include file="/task/edit.jsp"%><%
            } else if ("todo".equals(type)) {
                %><%@ include file="/todo/edit.jsp"%><%
            }
            break;
        case "add":
            if ("task".equals(type)) {
                %><%@ include file="/task/add.jsp"%><%
            } else if ("todo".equals(type)) {
                %><%@ include file="/todo/add.jsp"%><%
            }
            break;
        case "view":
            if ("task".equals(type)) {
                %><%@ include file="/task/view.jsp"%><%
            } else if ("todo".equals(type)) {
                %><%@ include file="/todo/view.jsp"%><%
            }
            break;
        default:
            %><%@ include file="/pages/main.jsp"%><%
    }
} else {
    %><%@ include file="/pages/main.jsp"%><%
}
%>
