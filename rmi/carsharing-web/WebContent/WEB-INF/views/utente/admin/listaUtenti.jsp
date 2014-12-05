<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Car2Go - Home Admin</title>
<link rel="stylesheet" type="css" href="<s:url value="/resources/autumn05.css"/>" />
</head>
<body>
<div id="container">
  <div id="navarea">
    <ul id="nav">
	  <li><c:url value="goAdminHome" var="somevar" /><a href="${somevar}">Home</a></li>    			
      <li><c:url value="/utente/admin/creamacchina" var="creaauto" /> <a href="${creaauto}">CreaMacchina</a></li>      
      <li><c:url value="/utente/admin/logout" var="logout" /> <a href="${logout}">Logout</a></li>      
    </ul>
  </div>
  <div id="hdr"> <span id="sitetitle">Car 2 Go</span> <br />
    <span id="subtitle">Prenota la tua auto</span></div>
  <div id="lftcol">
    <div class="leftcolbox">
      <div class="leftcolboxtop"></div>
      <h2>Car2Go</h2>
      <p>Progetto per la Tesi di Laurea Magistrale in Ingegneria Informatica. Francesco Paris. Matricola: 453908</p>
    </div>
    <div class="leftcolbox">
      <div class="leftcolboxtop"></div>
      <h2>Menu':</h2>
      <p> <c:url value="goAdminHome" var="somevar" /><a href="${somevar}">Home</a><br />
        <c:url value="/utente/admin/abilitautente" var="abilita" /> <a href="${abilita}">Abilita Utente</a><br />
        <c:url value="/utente/admin/creamacchina" var="creaauto" /> <a href="${creaauto}">Crea Macchina</a><br />
        <c:url value="/utente/admin/rifornisci" var="rifornisciMacchina" /> <a href="${rifornisciMacchina}">Rifornisci Macchina</a><br/>
        <c:url value="/utente/admin/pulisci" var="pulisciMacchina" /> <a href="${pulisciMacchina}">Pulisci Macchina</a><br/>
        <c:url value="/utente/admin/ripara" var="riparaMacchina" /> <a href="${riparaMacchina}">Ripara Macchina</a><br/>
        <c:url value="/utente/admin/logout" var="logout" /> <a href="${logout}">Logout</a><br/>
      </p>
      <br />
    </div>
  </div>
  <div id="maincol">
  
    
    
    
    
    <div class="rule">
      <h1>Lista Utenti</h1>
    </div>   
    
    <p><img src="<s:url value="/resources/images/user_group.png"/>"  width="200" /></p>
    <p>Elenco degli utenti registrati al sistema. <br/>Cliccando su abilita e' possibile rendere l'utente amministratore.</p>
	
	<ul>
		<c:forEach var="utente" items="${utenti}">
		
			<li>Utente:  ${utente.nome}  ${utente.cognome}  	
				
				<form action="doabilita" method="post">
					<input type="hidden" name="idUtente" value="${utente.idUtente}"/>
					<input type="submit" value="Abilita"/>
				</form> 
				
				
			</li>
			
		</c:forEach>
	
</ul>
	
    <br/>
    <br/>
   
    
    
 
    
    
  
  
  
  
  <div id="bttmbar"> <span id="copyright"> Copyright &copy; 2014. Francesco Paris - Matricola 453908.</span>
    <ul id="bttmnav">
      <li><c:url value="goAdminHome" var="somevar" /><a href="${somevar}">Home</a></li>    			
      <li><c:url value="/utente/admin/creamacchina" var="creaauto" /> <a href="${creaauto}">Crea Macchina</a></li>      
      <li><c:url value="/utente/admin/logout" var="logout" /> <a href="${logout}">Logout</a></li>      
    </ul>
  </div>
</div>
</body>
</html>
