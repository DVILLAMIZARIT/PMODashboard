<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%-- ALMACENAMOS LOS PAR�METROS QUE RECIBE --%>
<%-- m�ximo n�mero de elementos por p�gina (si no nos llegase ponemos un valor por defecto) --%>
<c:set var="MAX_ELEMENTS" scope="page" value="${! empty param['maxElements'] ? requestScope.maxElements : 10}"/>
<%-- total de elementos que cumplen con las condiciones --%>  
<c:set var="TOTAL_ELEMENTS" scope="page" value="${param['totalElements']}"/>	
<%-- la p�gina actual por la que vamos (si no nos llegase ponemos un valor por defecto) --%>
<c:set var="CURRENT_PAGE" scope="page" value="${! empty param['offset'] ? param['offset'] : 1 }"/>
<%-- m�ximo n�mero de p�ginas mostradas en el paginador --%>
<c:set var="MAX_PAGES_DISPLAYED" scope="page" value="${! empty param['maxPagesDisplayed'] ? param['maxPagesDisplayed'] : 7 }"/>
 
<div class="paginator">
 
    <c:choose>
        <c:when test="${! empty pageScope.TOTAL_ELEMENTS && pageScope.TOTAL_ELEMENTS > 0}">
         
            <span class="elements_found">
                <%-- Este ser� el mensaje del tipo: 358 elementos encontrados. Mostrando desde el 121 al 130 --%>
                
                <b><c:out value="${pageScope.TOTAL_ELEMENTS}"/></b> elementos encontrados. Mostrando del <c:out value="${(pageScope.CURRENT_PAGE - 1) * pageScope.MAX_ELEMENTS + 1}"/> al <c:out value="${pageScope.CURRENT_PAGE * pageScope.MAX_ELEMENTS >= pageScope.TOTAL_ELEMENTS ? pageScope.TOTAL_ELEMENTS : pageScope.CURRENT_PAGE * pageScope.MAX_ELEMENTS}"/>             
            </span>
 
            <%-- Definimos el n�mero total de p�ginas que deber�an salir. Ej: si hay 257 elementos y el m�ximo de elementos por p�gina son 10, saldr�an 26 p�ginas (25 con 10 elementos y una con 7) --%>
            <c:choose>
                <c:when test="${pageScope.TOTAL_ELEMENTS mod pageScope.MAX_ELEMENTS != 0}">
                    <c:set var="TOTAL_PAGES" value="${1 + ((pageScope.TOTAL_ELEMENTS - (pageScope.TOTAL_ELEMENTS mod pageScope.MAX_ELEMENTS)) div pageScope.MAX_ELEMENTS)}" scope="page" />
                </c:when>
                <c:otherwise>
                    <c:set var="TOTAL_PAGES" value="${pageScope.TOTAL_ELEMENTS div pageScope.MAX_ELEMENTS}"/>
                </c:otherwise>
            </c:choose>
 
            <%-- si hay varias p�ginas --%>           
            <c:if test="${pageScope.TOTAL_PAGES > 1}">
 
                <%-- obtenemos la primera p�gina que mostrar� el paginador y la �ltima --%>
                <c:choose>
                    <%-- Si el total de p�ginas a mostrar no es superior al total de p�ginas --%>
                    <c:when test="${pageScope.TOTAL_PAGES <= pageScope.MAX_PAGES_DISPLAYED}">
                        <c:set var="firstPageDisplayed" value="1" scope="page"/> <%-- la primera p�gina del paginador ser� la �ltima --%>
                        <c:set var="lastPageDisplayed" value="${pageScope.TOTAL_PAGES}" scope="page"/> <%-- la �ltima ser� la equivalente al total de p�ginas que salieron --%>
                    </c:when>
                     
                    <%-- 
                        En caso de que el total de p�ginas que salen sea superior al m�ximo de p�ginas que deseamos mostrar en el paginador. 
                        Ej: si hay 28 p�ginas (277 elementos en p�ginas de 10 como m�ximo) pero solo deseamos que el paginador muestre 7 
                    --%>
                    <c:otherwise>
             
            <%-- 
                Comprobamos qu� p�ginas mostrar. Se mostrar�n de la siguiente forma (imaginemos que queremos que solo aparezcan 7 p�ginas): 
                Si la p�gina actual es la 12 de 27, se mostrar�n 7 p�ginas de forma que la p�gina actual quede en el centro. En este ejemplo mostrar�a 9 10 11 12 13 14 15.
                En caso de que la p�gina actual sea la 2 se mostrar�an 1 2 3 4 5 6 7
                Si la p�gina actual fuese la 27 de 27 se mostrar�a 21 22 23 24 25 26 27
            --%>
                        <c:set var="firstPageDisplayed" value="${pageScope.CURRENT_PAGE - (pageScope.MAX_PAGES_DISPLAYED div 2 - (pageScope.MAX_PAGES_DISPLAYED mod 2) / 2)}" scope="page"/>
                        <c:set var="lastPageDisplayed" value="${pageScope.firstPageDisplayed + pageScope.MAX_PAGES_DISPLAYED - 1}" scope="page"/>
             
                        <c:choose>              
                            <c:when test="${pageScope.firstPageDisplayed < 1}">
                                <c:set var="firstPageDisplayed" value="1" scope="page"/>
                                <c:set var="lastPageDisplayed" value="${pageScope.MAX_PAGES_DISPLAYED}" scope="page"/>
                            </c:when>
                            <c:when test="${pageScope.lastPageDisplayed > pageScope.TOTAL_PAGES}">
                                <c:set var="firstPageDisplayed" value="${pageScope.TOTAL_PAGES - pageScope.MAX_PAGES_DISPLAYED + 1}" scope="page"/>
                                <c:set var="lastPageDisplayed" value="${pageScope.TOTAL_PAGES}" scope="page"/>
                            </c:when>
                        </c:choose>                             
             
                    </c:otherwise>
                     
                </c:choose>
                 
                <%-- "pintamos" las p�ginas --%>
                <span class="pages">
                    <%-- Pintamos los enlaces de ir a la p�gina inicial y a la anterior --%>
                    <span class="navigation${pageScope.firstPageDisplayed > 1 ? '' : ' invisible' }">
                        <a href="javascript:find(0)">Inicio</a> <a href="javascript:find(${pageScope.CURRENT_PAGE-2})">Ant.</a>
                    </span>         
                    <c:forEach begin="${pageScope.firstPageDisplayed}" end="${pageScope.lastPageDisplayed}" var="counter">
                        <c:choose>
                            <c:when test="${counter eq pageScope.CURRENT_PAGE}">
                                <span class="currentPage"><c:out value="${counter}"/></span>
                            </c:when>
                            <c:otherwise>
                                <!-- <a href="javascript:find(${counter - 1})"><c:out value="${counter}"/></a> -->
                                <a href="javascript:find(${counter})"><c:out value="${counter}"/></a>
                            </c:otherwise>
                        </c:choose>     
                    </c:forEach>        
                    <%-- Pintamos los enlaces de ir a la p�gina siguiente y a la final --%>
                    <span class="navigation${pageScope.lastPageDisplayed < pageScope.TOTAL_PAGES ? '' : ' invisible'}">
                        <a href="javascript:find(${pageScope.CURRENT_PAGE})">Sig.</a> <a href="javascript:find(${pageScope.TOTAL_PAGES - 1})">Fin</a>
                    </span>
                </span>
                <%-- fin de pintar las p�ginas --%>
                 
            </c:if> <%-- fin if paginas > 1 --%>               
         
        </c:when>
        <c:otherwise>
            No se encontraron elementos
        </c:otherwise>
    </c:choose> 
     
</div>