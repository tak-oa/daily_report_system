<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.AttributeConst" %>

<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<fmt:parseDate value="${report.reportDate}" pattern="yyyy-MM-dd" var="reportDay" type="date" />
<label for="${AttributeConst.REP_DATE.getValue()}">日付</label><br />
<input type="date" name="${AttributeConst.REP_DATE.getValue()}" value="<fmt:formatDate value='${reportDay}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="name">氏名</label><br />
<c:out value="${sessionScope.login_employee.name}" />
<br /><br />

<label for="${AttributeConst.REP_TITLE.getValue()}">タイトル</label><br />
<input type="text" name="${AttributeConst.REP_TITLE.getValue()}" value="${report.title}" />
<br /><br />

<label for="${AttributeConst.REP_CONTENT.getValue()}">内容</label><br />
<textarea name="${AttributeConst.REP_CONTENT.getValue()}" rows="10" cols="50">${report.content}</textarea>
<br /><br />

<label for="${AttributeConst.REP_COMPANY.getValue()}">取引先企業</label><br />
<input type="text" name="${AttributeConst.REP_COMPANY.getValue()}" value="${report.company}" />
<br /><br />

<label for="${AttributeConst.REP_CLIENT.getValue()}">取引先相手</label><br />
<input type="text" name="${AttributeConst.REP_CLIENT.getValue()}" value="${report.client}" />
<br /><br />

<label for="${AttributeConst.REP_MAIL.getValue()}">メールアドレス</label><br />
<input type="text" name="${AttributeConst.REP_MAIL}" value="${report.mail}" />
<br /><br />

<label for="${AttributeConst.REP_TELEPHONE.getValue()}">電話番号</label><br />
<input type="text" name="${AttributeConst.REP_TELEPHONE}" value="${report.telephone}" />
<br /><br />

<form>
    <select name="progress" required>
        <option value="">進捗状況を選択</option>
        <option value="new">新規</option>
        <option value="working">着手</option>
        <option value="waiting">未着手</option>
        <option value="pending">保留</option>
        <option value="postponed">延期</option>
        <option value="completed">完了</option>
        <option value="discontinued">中止</option>
    </select>
</form>
<br /><br />

<input type="hidden" name="${AttributeConst.REP_ID.getValue()}" value="${report.id}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">投稿</button>