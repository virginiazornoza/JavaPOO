package org.ch25.util.mibanco;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import org.ch25.util.Imprimible;

public abstract class Cuentacliente implements org.ch25.util.mibanco.Imprimible {
	//Los números de cuenta del banco iniciarán después de 1000
	private static int consecutivo=1000; 
	protected double saldo;
	private int numeroCuenta; 
	private String numeroCliente;
	private Date fechaApertura;

	public Cuentacliente(String nomCli) {
		this.nomCli = nomCli;
	}

	private String nomCli;

	
	public Cuentacliente(double saldo, String numeroCliente, Date fechaApertura,
						 String nomCli) {
	    this.saldo = saldo;
	    Cuentacliente.consecutivo++;
	    this.numeroCuenta = Cuentacliente.consecutivo;
	    this.setNombreCliente(nomCli);
		this.numeroCliente = numeroCliente;
		if (numeroCliente.equals("0")){ //Se genera un número de cliente aleatorio
			this.numeroCliente =Integer.toString(getAbs());
	    }//if numCliente.equals
		this.fechaApertura = fechaApertura;
	}//constructor

	private static int getAbs() {
		return Math.abs(new Random().nextInt());
	}

	public Cuentacliente(double saldo) {
		this.saldo=saldo;
	}//constructor
	//Los métodos abstract deben ser implementados en la clase que hereda
	public abstract double retiro(double cantidad); 
	public abstract double deposito(double cantidad);
	public abstract double getSaldo();
	
	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}//setSaldo
	
	public static int getConsecutivo() {
		return consecutivo;
	}//getConsecutivo

	public int getNumeroCuenta() {
		return numeroCuenta;
	}//getNumeroCuenta

	public String getNumeroCliente() {
		return numeroCliente;
	}//getNumeroCliente

	public String getFechaApertura() {
		DateFormat format = 
				       DateFormat.getDateInstance(DateFormat.SHORT);
		return format.format(fechaApertura);
	}//getFechaApertura


	public String toString() {
		return "Saldo=" + saldo + ", Número de Cuenta=" + getNumeroCuenta()
				+ ", Número del Cliente=" + getNumeroCliente()
				+ ", Fecha de Apertura=" + getFechaApertura()
				+ ", Nombre del Cliente=" + getNombreCliente();
	}//toString

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
}//class









