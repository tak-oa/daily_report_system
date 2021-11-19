<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdt" value="${ForwardConst.CMD_EDIT.getValue()}" />
<c:set var="commSucessApp" value="${ForwardConst.CMD_APPROVAL.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>日報 詳細ページ</h2>

        <table>
            <tbody>
                <tr>
                    <th>氏名</th>
                    <td><c:out value="${report.employee.name}" /></td>
                </tr>
                <tr>
                    <th>日付</th>
                    <fmt:parseDate value="${report.reportDate}" pattern="yyyy-MM-dd" var="reportDay" type="date" />
                    <td><fmt:formatDate value='${reportDay}' pattern='yyyy-MM-dd' /></td>
                </tr>
                <tr>
                    <th>内容</th>
                    <td><pre><c:out value="${report.content}" /></pre></td>
                </tr>
                <tr>
                    <th>取引先企業</th>
                    <td><c:out value="${report.company}" /></td>
                </tr>
                <tr>
                    <th>取引先相手</th>
                    <td><c:out value="${report.client}" /></td>
                </tr>
                <tr>
                    <th>メールアドレス</th>
                    <td><c:out value="${report.mail}" /></td>
                </tr>
                <tr>
                    <th>電話番号</th>
                    <td><c:out value="${report.telephone}" /></td>
                </tr>
                <tr>
                    <th>商談状況</th>
                    <td><pre><c:out value="${report.status}" /></pre></td>
                </tr>
                <tr>
                    <th>登録日時</th>
                    <fmt:parseDate value="${report.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="createDay" type="date" />
                    <td><fmt:formatDate value="${createDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
                <tr>
                    <th>更新日時</th>
                    <fmt:parseDate value="${report.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updateDay" type="date" />
                    <td><fmt:formatDate value="${updateDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </tbody>
        </table>

        <c:if test="${sessionScope.login_employee.id == report.employee.id}">
            <p>
                 <a href="<c:url value='?action=${actRep}&command=${commEdt}&id=${report.id}' />">この日報を編集する</a>
            <p>
        </c:if>
        <c:if test="${sessionScope.login_employee.approvalFlag == AttributeConst.ROLE_MANAGER.getIntegerValue()
                        || sessionScope.login_employee.approvalFlag == AttributeConst.ROLE_DIRECTOR.getIntegerValue()}">
            <div style="display:inline-flex">
        <form method="POST" action="<c:url value='?action=${actRep}&command=${commSucessApp}' />">
        <input type="hidden" name="${AttributeConst.REP_ID.getValue()}" value="${report.id}" />
        <button type="submit">承認</button>
        </form>
            <button type="submit" onclick="location.href='./approvalIndex.jsp'" value="承認しない"></button>
            </div>
        </c:if>

        <p>
            <a href="<c:url value='?action=${actRep}&command=${commIdx}' />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>
