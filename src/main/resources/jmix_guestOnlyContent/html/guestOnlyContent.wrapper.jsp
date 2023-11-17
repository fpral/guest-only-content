<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${renderContext.editMode}">
    <em>This content is only visible to non-authenticated users:</em>
</c:if>

<c:if test="${!renderContext.loggedIn or renderContext.editMode or (renderContext.previewMode and renderContext.request.getParameter('alias') == 'guest')}">
    ${wrappedContent}
</c:if>
