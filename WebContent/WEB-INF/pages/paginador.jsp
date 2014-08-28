<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%-- ALMACENAMOS LOS PARÁMETROS QUE RECIBE --%>
<%-- máximo número de elementos por página (si no nos llegase ponemos un valor por defecto) --%>
<c:set var="MAX_ELEMENTS" scope="page" value="${! empty param['maxElements'] ? requestScope.maxElements : 10}"/>
<%-- total de elementos que cumplen con las condiciones --%>  
<c:set var="TOTAL_ELEMENTS" scope="page" value="${param['totalElements']}"/>	
<%-- la página actual por la que vamos (si no nos llegase ponemos un valor por defecto) --%>
<c:set var="CURRENT_PAGE" scope="page" value="${! empty param['offset'] ? param['offset'] : 1 }"/>
<%-- máximo número de páginas mostradas en el paginador --%>
<c:set var="MAX_PAGES_DISPLAYED" scope="page" value="${! empty param['maxPagesDisplayed'] ? param['maxPagesDisplayed'] : 7 }"/>
 
<div class="paginator">
 
    <c:choose>
        <c:when test="${! empty pageScope.TOTAL_ELEMENTS && pageScope.TOTAL_ELEMENTS > 0}">
         
            <span class="elements_found">
                <%-- Este será el mensaje del tipo: 358 elementos encontrados. Mostrando desde el 121 al 130 --%>
                
                <b><c:out value="${pageScope.TOTAL_ELEMENTS}"/></b> elementos encontrados. Mostrando del <c:out value="${(pageScope.CURRENT_PAGE - 1) * pageScope.MAX_ELEMENTS + 1}"/> al <c:out value="${pageScope.CURRENT_PAGE * pageScope.MAX_ELEMENTS >= pageScope.TOTAL_ELEMENTS ? pageScope.TOTAL_ELEMENTS : pageScope.CURRENT_PAGE * pageScope.MAX_ELEMENTS}"/>             
            </span>
 
            <%-- Definimos el número total de páginas que deberían salir. Ej: si hay 257 elementos y el máximo de elementos por página son 10, saldrían 26 páginas (25 con 10 elementos y una con 7) --%>
            <c:choose>
                <c:when test="${pageScope.TOTAL_ELEMENTS mod pageScope.MAX_ELEMENTS != 0}">
                    <c:set var="TOTAL_PAGES" value="${1 + ((pageScope.TOTAL_ELEMENTS - (pageScope.TOTAL_ELEMENTS mod pageScope.MAX_ELEMENTS)) div pageScope.MAX_ELEMENTS)}" scope="page" />
                </c:when>
                <c:otherwise>
                    <c:set var="TOTAL_PAGES" value="${pageScope.TOTAL_ELEMENTS div pageScope.MAX_ELEMENTS}"/>
                </c:otherwise>
            </c:choose>
 
            <%-- si hay varias páginas --%>           
            <c:if test="${pageScope.TOTAL_PAGES > 1}">
 
                <%-- obtenemos la primera página que mostrará el paginador y la última --%>
                <c:choose>
                    <%-- Si el total de páginas a mostrar no es superior al total de páginas --%>
                    <c:when test="${pageScope.TOTAL_PAGES <= pageScope.MAX_PAGES_DISPLAYED}">
                        <c:set var="firstPageDisplayed" value="1" scope="page"/> <%-- la primera página del paginador será la última --%>
                        <c:set var="lastPageDisplayed" value="${pageScope.TOTAL_PAGES}" scope="page"/> <%-- la última será la equivalente al total de páginas que salieron --%>
                    </c:when>
                     
                    <%-- 
                        En caso de que el total de páginas que salen sea superior al máximo de páginas que deseamos mostrar en el paginador. 
                        Ej: si hay 28 páginas (277 elementos en páginas de 10 como máximo) pero solo deseamos que el paginador muestre 7 
                    --%>
                    <c:otherwise>
             
            <%-- 
                Comprobamos qué páginas mostrar. Se mostrarán de la siguiente forma (imaginemos que queremos que solo aparezcan 7 páginas): 
                Si la página actual es la 12 de 27, se mostrarán 7 páginas de forma que la página actual quede en el centro. En este ejemplo mostraría 9 10 11 12 13 14 15.
                En caso de que la página actual sea la 2 se mostrarían 1 2 3 4 5 6 7
                Si la página actual fuese la 27 de 27 se mostraría 21 22 23 24 25 26 27
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
                 
                <%-- "pintamos" las páginas --%>
                <span class="pages">
                    <%-- Pintamos los enlaces de ir a la página inicial y a la anterior --%>
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
                    <%-- Pintamos los enlaces de ir a la página siguiente y a la final --%>
                    <span class="navigation${pageScope.lastPageDisplayed < pageScope.TOTAL_PAGES ? '' : ' invisible'}">
                        <a href="javascript:find(${pageScope.CURRENT_PAGE})">Sig.</a> <a href="javascript:find(${pageScope.TOTAL_PAGES - 1})">Fin</a>
                    </span>
                </span>
                <%-- fin de pintar las páginas --%>
                 
            </c:if> <%-- fin if paginas > 1 --%>               
         
        </c:when>
        <c:otherwise>
            No se encontraron elementos
        </c:otherwise>
    </c:choose> 
     
</div>