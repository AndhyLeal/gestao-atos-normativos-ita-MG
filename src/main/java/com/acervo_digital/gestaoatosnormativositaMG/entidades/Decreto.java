package com.acervo_digital.gestaoatosnormativositaMG.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Decreto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
private Integer ano;
private Date data;
private String numero;
private String ementa;
private String etiqueta;
private String status;
private String palavrasChave;
private String caminhoPDF;
private String caminhoWord;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Integer getAno() {
	return ano;
}
public void setAno(Integer ano) {
	this.ano = ano;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public String getEmenta() {
	return ementa;
}
public void setEmenta(String ementa) {
	this.ementa = ementa;
}
public String getEtiqueta() {
	return etiqueta;
}
public void setEtiqueta(String etiqueta) {
	this.etiqueta = etiqueta;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getPalavrasChave() {
	return palavrasChave;
}
public void setPalavrasChave(String palavrasChave) {
	this.palavrasChave = palavrasChave;
}
public String getCaminhoPDF() {
	return caminhoPDF;
}
public void setCaminhoPDF(String caminhoPDF) {
	this.caminhoPDF = caminhoPDF;
}
public String getCaminhoWord() {
	return caminhoWord;
}
public void setCaminhoWord(String caminhoWord) {
	this.caminhoWord = caminhoWord;
}


}
