<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CarSharing- Home Admin</title>
<link rel="stylesheet" type="css" href="<s:url value="/resources/autumn05.css"/>" />
</head>
<body>
<div id="container">
  <div id="navarea">
    <ul id="nav">
	  <li><c:url value="goAdminHome" var="somevar" /><a href="${somevar}">Home</a></li>    			
      <li><c:url value="/utente/admin/creamacchina" var="creaauto" /> <a href="#">CreaMacchina</a></li>      
      <li><c:url value="/utente/admin/logout" var="logout" /> <a href="${logout}">Logout</a></li>      
    </ul>
  </div>
  <div id="hdr"> <span id="sitetitle">Car-Sharing</span> <br />
    <span id="subtitle">Prenota la tua auto</span></div>
  <div id="lftcol">
    <div class="leftcolbox">
      <div class="leftcolboxtop"></div>
      <h2>CarSharing</h2>
      <p>Progetto per la Tesi di Laurea Magistrale in Ingegneria Informatica. Francesco Paris. Matricola: 453908</p>
    </div>
    <div class="leftcolbox">
      <div class="leftcolboxtop"></div>
      <h2>Menu':</h2>
      <p> <c:url value="goAdminHome" var="somevar" /><a href="${somevar}">Home</a><br />
        <c:url value="/utente/admin/abilitautente" var="abilita" /> <a href="#">Abilita Utente</a><br />
        <c:url value="/utente/admin/creamacchina" var="creaauto" /> <a href="#">Crea Macchina</a><br />
        <c:url value="/utente/admin/rifornisci" var="rifornisciMacchina" /> <a href="#">Rifornisci Macchina</a><br/>
        <c:url value="/utente/admin/pulisci" var="pulisciMacchina" /> <a href="#">Pulisci Macchina</a><br/>
        <c:url value="/utente/admin/ripara" var="riparaMacchina" /> <a href="#">Ripara Macchina</a><br/>
        <c:url value="/utente/admin/logout" var="logout" /> <a href="${logout}">Logout</a><br/>
      </p>
      <br />
    </div>
  </div>
  <div id="maincol">
  
    
    
    
    
    <div class="rule">
      <h1>Home Admin!</h1>
    </div>
    <p><img src="<s:url value="/resources/images/admin.png"/>"  align="left" /></p>
    <p><strong>${message}</strong><p>
    <p>Home page del pannello di Amministrazione</p>
    <p>Qui e' possibile gestire tutta l'applicazione.</p>
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
