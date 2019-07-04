<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <title>Note List</title>
  </head>
  <body>
		<div>
			<h1>Добавить заметку:</h1>
			<form action="<c:url value="/addNote"/>" method="post">
				<input type="text" name="title" placeholder="Введите заголовок">
				<input type="text" name="note" placeholder="Введите заметку">

				<input type="submit" value="Добавить">
			</form>
        </div>
    <h1>Список заметок:</h1>
    <div>
        <form action="<c:url value="/filter"/>" method="post">
            <input type="text" name="filter">
            <input type="submit" value="Поиск">
        </form>
                <table>
                    <c:forEach items="${notes}" var="item">
                                <c:if test="${item.title == null || item.title.isEmpty()}">
                                    <tr>
                                        <td>
                                            ${item.note}
                                        </td>
                                        <td>
                                            <a href="<c:url value="/remove/"/>${item.id}">Удалить?</a>
                                        </td>
                                    </tr>
                                </c:if>
                                <c:if test="${item.note != null && item.title != null && !item.note.isEmpty() && !item.title.isEmpty()}">
                                    <tr>
                                        <td>
                                            ${item.title}
                                        </td>
                                        <td>
                                            <a href="<c:url value="/remove/"/>${item.id}">Удалить?</a>
                                        </td>
                                    </tr>
                                </c:if>
                    </c:forEach>
                </table>
            </div>
    </div>


   <%--${textB}--%>
   </body>
</html>