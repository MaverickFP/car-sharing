<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Car2Go - Guida</title>
<link rel="stylesheet" type="css" href="<s:url value="/resources/autumn05.css"/>" />
</head>
<body>
<div id="container">
  <div id="navarea">
    <ul id="nav">
	  <li><c:url value="goUserHome" var="somevar" /><a href="${somevar}">Home</a></li>    			
      <li><c:url value="/utente/user/prenota" var="prenota" /> <a href="${prenota}">Prenota</a></li>      
      <li><c:url value="/utente/user/logout" var="logout" /> <a href="${logout}">Logout</a></li>      
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
      <p> <c:url value="goUserHome" var="somevar" /><a href="${somevar}">Home</a><br />
        <c:url value="/utente/user/prenota" var="prenota" /> <a href="${prenota}">Prenota Auto</a><br />
		<c:url value="/utente/user/storico" var="storico" /> <a href="${storico}">Storico Prenotazioni</a><br />
		<c:url value="/utente/user/costi" var="costi" /> <a href="${costi}">Costo Totale</a><br />
		<c:url value="/utente/user/logout" var="logout" /> <a href="${logout}">Logout</a><br />
      </p>
      <br />
    </div>
  </div>
  <div id="maincol">
  
    
    
    
    
    <div class="rule">
      <h1>Guida Auto</h1>
    </div>
    
    <p><strong>Prenotazione effettuata</strong></p>
	<h2>Riepilogo</h2>
	<p>L'utente ${utente.nome} ${utente.cognome} ha effettuato la prenotazione di una macchina.</p>
	<h2>Dettaglio Macchina:</h2>
	<ul>
		<li><strong>Macchina</strong>: ${macchina.tipo}</li>
		<li><strong>Benzina</strong>: ${macchina.serbatoio} %</li>
	</ul>

<form action="doguida" name="datiMacchinaForm" method="post">
	<input type="hidden" value="${macchina.idMacchina}" name="idMacchina"/>
	<input type="hidden" value="${idPrenotazione}" name="idPrenotazione"/>
	<input type="hidden" value="yes" name="guida"/>
	<legend>Stato pulizia Interna della macchina:</legend> 
    <select name="interno" >
   		<option value="1" selected="selected">Ottimo</option>
    	<option value="2">Buono</option>
   		<option value="3">Sporco</option>
  	</select>
  	<legend>Stato Esterno della macchina:</legend> 
    <select name="esterno" >
   		<option value="1" selected="selected">Ottimo</option>
    	<option value="2">Buono</option>
   		<option value="3">Non Sufficiente</option>
  	</select>
  	<br/>
	Inserire note particolari sullo stato della macchina: <br/>
	<textarea id="datiMacchinaForm" class="text" cols="86" rows ="20" name="note">
	${macchina.note}
	</textarea>
	<br/>
	Invia i dati e guida
	<input type="submit" value="Guida" />
</form>

<div class="rule">
      <h1>Annulla Prenotazione!</h1>
    </div>
<p>E' possibile annullare la guida e la prenotazione.<br/>
 Vuoi annullare la prenotazione?</p>


<form action="delguida" method="post">
	<input type="hidden" value="${macchina.idMacchina}" name="idMacchina"/>
	<input type="hidden" value="${idPrenotazione}" name="idPrenotazione"/>
	<input type="submit" value="Si, Elimina Prenotazione Macchina ${macchina.tipo}" />
</form>
    
    <br/>
    <br/>
   
    
    
 
    
    
  
  
  
  
  <div id="bttmbar"> <span id="copyright"> Copyright &copy; 2014. Francesco Paris - Matricola 453908.</span>
    <ul id="bttmnav">
      <li><c:url value="goUserHome" var="somevar" /><a href="${somevar}">Home</a></li>
      <li><c:url value="/utente/user/prenota" var="prenota" /> <a href="${prenota}">Prenota</a></li>      
      <li><c:url value="/utente/user/logout" var="logout" /> <a href="${logout}">Logout</a></li> 
    </ul>
  </div>
</div>
</body>
</html>
