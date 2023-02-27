<%@page import="bean.Cine"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="ISO-8859-1"%>
<br/><h1>Nuestros Cines</h1><br/>
<%List<Cine> cines = (List<Cine>) session.getAttribute("data");
	for (Cine cine : cines){
%>
	<div class="contenido-cine">
	    <img src="img/cine/1.1.jpg" width="227" height="170"/>
   	   	<div class="datos-cine">
		   	<h4>Excelsior</h4><br/>
       		<span>Jirón de la Unión 780 - Lima<br/><br/>Teléfono: 714-1865 anexo 865</span>
       	</div>
       	<br/>
       	<a href="http://www.cinestar.com.pe/multicines/cine/Cinestar-Excelsior">
       		<img src="img/varios/ico-info2.png" width="150" height="40"/>
       	</a>
	</div>
	<%}%>