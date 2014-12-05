<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CarSharing</title>
<link rel="stylesheet" type="css" href="<s:url value="/resources/autumn05.css"/>" />
</head>
<body>
<div id="container">
  <div id="navarea">
    <ul id="nav">
      <li><c:url value="/home" var="home" /><a href="${home}">Home</a></li>
      <li><c:url value="utente?login" var="login" /><a href="${login}">Login</a></li>
      <li><c:url value="utente?new" var="newUtente" /><a href="${newUtente}">Registrati</a></li>      
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
      <p> <c:url value="/home" var="home" /><a href="${home}">Home</a><br />
        <c:url value="utente?login" var="login" /><a href="${login}">Login</a><br />
        <c:url value="utente?new" var="newUtente" /><a href="${newUtente}">Registrati</a><br />
      </p>
      <br />
    </div>
  </div>
  <div id="maincol">
  
    
    
    
    
    <div class="rule">
      <h1>Registrazione nuovo utente!</h1>
    </div>
    <p>In questa applicazione e' possibile gestire una flotta di auto per il <strong>car-sharing</strong>. L'applicazione è stata realizzata integrando varie tecnologie. E' possibile simulare la guida di un utente all'interno di Roma. I dati relativi a distanze e indirizzi sono ottenuti basandosi sui servizi offerti da Google Maps. E' possibile iniziare ad interagire con l'applicazione registrandosi.</p>
    <p>
    <strong>Completa il modulo sottostante per registrarti:</strong>
    </p>
    
   <p> 
   <sf:form method="POST" modelAttribute="utente">
	
	<label for="nome">Nome:</label>	
	<sf:input path="nome" size="15"/>
	<sf:errors path="nome" cssClass="error"/>
	<br/>
	<label for="cognome">Cognome:</label>	
	<sf:input path="cognome" size="15"/>
	<sf:errors path="cognome" cssClass="error"/>
	<br/>
	<label for="nazione">Nazione:</label>	
	<sf:input path="nazione" size="15"/>
	<br/>
	<label for="username">Username:</label>	
	<sf:input path="username" size="15"/>
	<sf:errors path="username" cssClass="error"/>
	<br/>
	<label for="password">Password:</label>	
	<sf:input path="password" size="15"/>
	<sf:errors path="password" cssClass="error"/>
	<br/>
	<label for="mail">Mail:</label>	
	<sf:input path="mail" size="15"/>
	<sf:errors path="mail" cssClass="error"/>
	<br/>
	<label for="pin">Pin:</label>	
	<sf:input path="pin" size="4" maxlength="4"/>
	
	<br/>
	<input type="submit" value="Invia"/>
	<br/>
</sf:form>
</p>    
    
   
    
  
  
  
  
  <div id="bttmbar"> <span id="copyright"> Copyright &copy; 2014. Francesco Paris - Matricola 453908.</span>
    <ul id="bttmnav">
      <li><c:url value="/home" var="home" /><a href="${home}">Home</a></li>
      <li><c:url value="utente?login" var="login" /><a href="${login}">Login</a></li>
      <li><c:url value="utente?new" var="newUtente" /><a href="${newUtente}">Registrati</a></li> 
      <li><a href="" title="contact">contact</a></li>
      <li><a href="" title="links">links</a></li>
    </ul>
  </div>
</div>
</body>
</html>
